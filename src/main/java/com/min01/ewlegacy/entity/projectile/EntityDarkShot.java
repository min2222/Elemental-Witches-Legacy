package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.entity.skill.EntityEnderHole;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityDarkShot extends AbstractEWHurtingProjectile
{
    public EntityDarkShot(EntityType<? extends AbstractEWHurtingProjectile> type, Level level)
    {
        super(type, level);
    }
    
    public EntityDarkShot(Level level, LivingEntity living, double x, double y, double z)
    {
        super(EWEntities.DARK_SHOT.get(), level, living, x,  y, z);
    }
    
    public EntityDarkShot(Level level, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        super(EWEntities.DARK_SHOT.get(), level, x, y, z, motionX, motionY, motionZ);
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
                EntityEnderHole entitywitherskull1 = new EntityEnderHole(EWEntities.ENDER_HOLE.get(), this.level);
                entitywitherskull1.moveTo(hitResult.getEntity().getX(), hitResult.getEntity().getY() + 2.0, hitResult.getEntity().getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
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
