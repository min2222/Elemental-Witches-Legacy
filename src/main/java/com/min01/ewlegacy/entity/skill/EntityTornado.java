package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityAirShoot;
import com.min01.ewlegacy.entity.witch.EntityAirWitch;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityTornado extends AbstractOwnableMonster<EntityAirWitch>
{
    public EntityTornado(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 2.147483647E9)
    			.add(Attributes.MOVEMENT_SPEED, 0.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
    }
    
    @Override
    public boolean isPushable() 
    {
    	return false;
    }
    
    @Override
    protected void doPush(Entity p_20971_) 
    {
    	
    }
    
    @Override
    protected void pushEntities()
    {
    	
    }
    
    @Override
    public boolean isPushedByFluid() 
    {
    	return false;
    }
    
    @Override
    public boolean isPushedByFluid(FluidType type) 
    {
    	return false;
    }
    
    @Override
    public void aiStep() 
    {
        if(this.getDeltaMovement().y <= -0.2) 
        {
            this.setDeltaMovement(this.getDeltaMovement().x, -0.5, this.getDeltaMovement().z);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("air_tornado_big", this);
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 20.0, 20.0));
        for(Entity entity1 : list) 
        {
            if(!(entity1 instanceof EntityAirWitch) && !(entity1 instanceof EntityAirShoot) && !(entity1 instanceof EntityAirClone)) 
            {
                if(!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) 
                {
                    double xx = entity1.getX() - this.getX();
                    double zz = entity1.getZ() - this.getZ();
                    entity1.setDeltaMovement(-xx / (9.0F * entity1.distanceTo(this)), entity1.getDeltaMovement().y, -zz / (9.0F * entity1.distanceTo(this)));
                }
            }
            List<Entity> list2 = this.level.getEntities(this, this.getBoundingBox().expandTowards(2.0, 2.0, 2.0));
            for(Entity entity2 : list2) 
            {
                if(!(entity2 instanceof EntityAirWitch) && !(entity2 instanceof EntityAirShoot) && !(entity2 instanceof EntityAirClone))
                {
                    if(!(entity2 instanceof Player) || !((Player)entity2).getAbilities().instabuild)
                    {
                        entity2.setDeltaMovement(entity2.getDeltaMovement().x, 3.0, entity2.getDeltaMovement().z);
                    }
                }
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) 
    {
    	return p_21016_.isBypassInvul();
    }
}
