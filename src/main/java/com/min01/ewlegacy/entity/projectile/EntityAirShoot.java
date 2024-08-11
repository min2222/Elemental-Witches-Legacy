package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityAirShoot extends AbstractEWHurtingProjectile
{
    int form = 1;
    
    public EntityAirShoot(EntityType<? extends AbstractEWHurtingProjectile> type, Level level) 
    {
        super(type, level);
    }
    
    public EntityAirShoot(Level level, LivingEntity living, double x, double y, double z, int form) 
    {
        super(EWEntities.AIR_SHOOT.get(), level, living, x,  y, z);
        this.form = form;
    }
    
    public EntityAirShoot(Level level, double x, double y, double z, double motionX, double motionY, double motionZ) 
    {
        super(EWEntities.AIR_SHOOT.get(), level, x, y, z, motionX, motionY, motionZ);
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if(!this.level.isClientSide && hitResult.getEntity() != null && this.getOwner() != null)
        {
            if(this.form == 1) 
            {
                if(hitResult.getEntity() instanceof LivingEntity)
                {
                    float f4 = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
                    if(hitResult.getEntity() instanceof Player && this.playerHoldingSwordAndBlocking((Player)hitResult.getEntity()))
                    {
                        this.playerDamageItem((Player)hitResult.getEntity());
                        if(this.random.nextInt(100) == 10) 
                        {
                            ((Player)hitResult.getEntity()).getInventory().dropAll();
                        }
                    }
                    else if(f4 > 0.0F)
                    {
                        hitResult.getEntity().push(this.getDeltaMovement().x * 3.0 * 0.6000000238418579 / f4, 0.1, this.getDeltaMovement().z * 3.0 * 0.6000000238418579 / f4);
                    }
                    hitResult.getEntity().hurt(DamageSource.MAGIC, 1.0F);
                    this.discard();
                }
            }
            else if(this.form == 2) 
            {
                if(hitResult.getEntity() instanceof LivingEntity)
                {
                    hitResult.getEntity().hurt(DamageSource.MAGIC, 1.0F);
                    if(hitResult.getEntity() instanceof Player && this.playerHoldingSwordAndBlocking((Player)hitResult.getEntity()))
                    {
                        this.playerDamageItem((Player)hitResult.getEntity());
                        if(this.random.nextInt(100) == 10)
                        {
                            ((Player)hitResult.getEntity()).getInventory().dropAll();
                        }
                    }
                    else 
                    {
                        Entity entityHit = hitResult.getEntity();
                        entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0, 1, 0));
                    }
                    this.discard();
                }
            }
            else if(this.form == 3)
            {
                hitResult.getEntity().hurt(DamageSource.MAGIC, 3.0F);
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
        ElementalWitchesLegacy.PROXY.spawnParticles("wind_shoot", this);
        super.tick();
    }
    
    private boolean playerHoldingSwordAndBlocking(Player entity)
    {
        return entity.isBlocking();
    }
    
    private void playerDamageItem(Player entity) 
    {
        entity.getMainHandItem().setDamageValue(entity.getMainHandItem().getDamageValue() + 15);
    }
}
