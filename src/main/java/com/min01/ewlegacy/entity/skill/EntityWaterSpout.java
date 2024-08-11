package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityWaterShoot;
import com.min01.ewlegacy.entity.witch.EntityWaterWitch;

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

public class EntityWaterSpout extends AbstractOwnableMonster<EntityWaterWitch>
{
    public EntityWaterSpout(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
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
        if(this.getDeltaMovement().y <= 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(this.tickCount >= 400)
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("water_sprout", this);
        List<Entity> list1 = this.level.getEntities(this, this.getBoundingBox().expandTowards(1.0, 4.0, 1.0));
        for(Entity entity : list1) 
        {
            if(!(entity instanceof EntityWaterWitch) && !(entity instanceof EntityWaterShoot) && !(entity instanceof EntityWaterMinion) && !(entity instanceof EntityGiantSquid)) 
            {
                if(!(entity instanceof Player) || !((Player)entity).getAbilities().instabuild) 
                {
                    entity.setDeltaMovement(entity.getDeltaMovement().x, 1.0, entity.getDeltaMovement().z);
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
