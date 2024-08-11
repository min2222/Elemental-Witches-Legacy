package com.min01.ewlegacy.entity.skill;

import java.util.List;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityLightShield extends TamableAnimal
{
    public EntityLightShield(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.setTame(true);
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
        if(this.tickCount >= 400)
        {
            this.discard();
        }
        if(this.getDeltaMovement().y <= 0.0 || this.getDeltaMovement().y >= 0.0) 
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.0, 1));
        }
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(3.0, 3.0, 3.0));
        for(Entity entitytargetcheck : targetList)
        {
            if(entitytargetcheck instanceof Projectile)
            {
                double xx = entitytargetcheck.getX() - this.getX();
                double zz = entitytargetcheck.getZ() - this.getZ();
                entitytargetcheck.setDeltaMovement(xx / (9.0F * entitytargetcheck.distanceTo(this)), entitytargetcheck.getDeltaMovement().y, zz / (9.0F * entitytargetcheck.distanceTo(this)));
            }
            if(entitytargetcheck instanceof Player && entitytargetcheck == this.getOwner()) 
            {
                this.moveTo(entitytargetcheck.getX(), entitytargetcheck.getY() - 1.7, entitytargetcheck.getZ(), 0.0F, 0.0F);
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
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public boolean removeWhenFarAway(double p_27598_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource p_27567_, float p_27568_) 
    {
    	return p_27567_.isBypassInvul();
    }
}
