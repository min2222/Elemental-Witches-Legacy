package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityEarthShoot extends AbstractEWHurtingProjectile
{
    public EntityEarthShoot(EntityType<? extends AbstractEWHurtingProjectile> type, Level level)
    {
        super(type, level);
    }
    
    public EntityEarthShoot(Level level, LivingEntity living, double x, double y, double z)
    {
        super(EWEntities.EARTH_SHOOT.get(), level, living, x,  y, z);
    }
    
    public EntityEarthShoot(Level level, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        super(EWEntities.EARTH_SHOOT.get(), level, x, y, z, motionX, motionY, motionZ);
    }
    
    @Override
    protected float getInertia()
    {
        return 0.9F;
    }
    
    @Override
    protected void onHit(HitResult p_37260_) 
    {
    	super.onHit(p_37260_);
        if(!this.level.isClientSide) 
        {
            this.discard();
        }
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if(!this.level.isClientSide)
        {
            if(hitResult.getEntity() != null) 
            {
                if(this.getOwner() != null) 
                {
                    if(hitResult.getEntity().hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), 8.0f) && !hitResult.getEntity().isAlive()) 
                    {
                        ((LivingEntity) this.getOwner()).heal(3.0F);
                    }
                }
                else 
                {
                    hitResult.getEntity().hurt(DamageSource.MAGIC, 3.0F);
                }
                if(hitResult.getEntity() instanceof LivingEntity)
                {
                    ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
                }
            }
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return false;
    }
    
    @Override
    public void tick() 
    {
        if(this.tickCount >= 100)
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("earth_shoot", this);
        super.tick();
    }
}
