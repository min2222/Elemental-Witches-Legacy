package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityLightShot extends AbstractEWHurtingProjectile
{
    public EntityLightShot(EntityType<? extends AbstractEWHurtingProjectile> type, Level level) 
    {
        super(type, level);
    }
    
    public EntityLightShot(Level level, LivingEntity living, double x, double y, double z)
    {
        super(EWEntities.LIGHT_SHOT.get(), level, living, x,  y, z);
    }
    
    
    public EntityLightShot(Level level, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        super(EWEntities.LIGHT_SHOT.get(), level, x, y, z, motionX, motionY, motionZ);
    }
    
    @Override
    protected float getInertia() 
    {
        return 100.95F;
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
            if(hitResult.getEntity() != null && this.getOwner() != null)
            {
                EntityLightArrow entitywitherskull1 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull2 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull3 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull4 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull5 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull6 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull7 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull8 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                EntityLightArrow entitywitherskull9 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                entitywitherskull1.moveTo(hitResult.getEntity().getX(), hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ(), this.getYRot(), 0.0F);
                entitywitherskull2.moveTo(hitResult.getEntity().getX(), hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull3.moveTo(hitResult.getEntity().getX(), hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull4.moveTo(hitResult.getEntity().getX() + 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ(), this.getYRot(), 0.0F);
                entitywitherskull5.moveTo(hitResult.getEntity().getX() - 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ(), this.getYRot(), 0.0F);
                entitywitherskull6.moveTo(hitResult.getEntity().getX() - 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull7.moveTo(hitResult.getEntity().getX() - 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull8.moveTo(hitResult.getEntity().getX() + 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull9.moveTo(hitResult.getEntity().getX() + 1.0, hitResult.getEntity().getY() + 20.0, hitResult.getEntity().getZ() - 1.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                EWUtil.spawnInWorld(this.level, entitywitherskull5);
                EWUtil.spawnInWorld(this.level, entitywitherskull6);
                EWUtil.spawnInWorld(this.level, entitywitherskull7);
                EWUtil.spawnInWorld(this.level, entitywitherskull8);
                EWUtil.spawnInWorld(this.level, entitywitherskull9);
                entitywitherskull1.setDeltaMovement(entitywitherskull1.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull2.setDeltaMovement(entitywitherskull2.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull3.setDeltaMovement(entitywitherskull3.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull4.setDeltaMovement(entitywitherskull4.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull5.setDeltaMovement(entitywitherskull5.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull6.setDeltaMovement(entitywitherskull6.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull7.setDeltaMovement(entitywitherskull7.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull8.setDeltaMovement(entitywitherskull8.getDeltaMovement().subtract(0, 1.0, 0));
                entitywitherskull9.setDeltaMovement(entitywitherskull9.getDeltaMovement().subtract(0, 1.0, 0));
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
        if(this.tickCount >= 3)
        {
            this.discard();
        }
        super.tick();
    }
}
