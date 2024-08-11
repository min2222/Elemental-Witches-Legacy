package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
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

public class EntityIceCube extends ThrowableProjectile
{
    public EntityIceCube(EntityType<? extends ThrowableProjectile> type, Level level) 
    {
        super(type, level);
    }
    
    public EntityIceCube(Level level, LivingEntity living) 
    {
        super(EWEntities.ICE_CUBE.get(), living, level);
    }
    
    public EntityIceCube(Level level, double x, double y, double z) 
    {
        super(EWEntities.ICE_CUBE.get(), x, y, z, level);
    }
    
    @Override
    protected void defineSynchedData()
    {
    	
    }
    
    @Override
    protected float getGravity()
    {
        return 0.05F;
    }
    
    @Override
    protected void onHit(HitResult p_37260_) 
    {
    	super.onHit(p_37260_);
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_shoot", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_normal", this);
        this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
        this.discard();
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult) 
    {
        if(hitResult.getEntity() != null) 
        {
            ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 100, 2));
            hitResult.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 2.0F);
        }
    }
}
