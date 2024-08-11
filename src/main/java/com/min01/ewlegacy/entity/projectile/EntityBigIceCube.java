package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityFrostNova;
import com.min01.ewlegacy.entity.skill.EntityIceCrystal;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntityBigIceCube extends ThrowableProjectile
{
    public EntityBigIceCube(EntityType<? extends ThrowableProjectile> type, Level level) 
    {
        super(type, level);
    }
    
    public EntityBigIceCube(Level level, LivingEntity living)
    {
        super(EWEntities.BIG_ICE_CUBE.get(), living, level);
    }
    
    public EntityBigIceCube(Level level, double x, double y, double z) 
    {
        super(EWEntities.BIG_ICE_CUBE.get(), x, y, z, level);
    }
    
	@Override
	protected void defineSynchedData()
	{
		
	}
    
    @Override
    protected float getGravity() 
    {
        return 0.02F;
    }
    
    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }
    
    @Override
    public float getPickRadius()
    {
        return 0.7F;
    }
    
    @Override
    protected void onHit(HitResult p_37260_) 
    {
    	super.onHit(p_37260_);
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_shoot", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_normal", this);
        if(this.tickCount > 500)
        {
            this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
            this.discard();
        }
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult) 
    {
        if(hitResult.getEntity() != null && !(hitResult.getEntity() instanceof EntityIceCrystal) && !(hitResult.getEntity() instanceof EntityIcicle)) 
        {
            if(!(hitResult.getEntity() instanceof EntityFrostNova)) 
            {
                if(hitResult.getEntity() instanceof LivingEntity) 
                {
                    ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 100, 2));
                    hitResult.getEntity().hurt(DamageSource.thrown(this, this), 4.0f);
                    this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
                    this.discard();
                }
            }
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source.getEntity() != null) 
        {
            Vec3 vec3 = source.getEntity().getLookAngle();
            if(vec3 != null)
            {
            	this.setDeltaMovement(vec3);
            }
            return true;
        }
        return false;
    }
}
