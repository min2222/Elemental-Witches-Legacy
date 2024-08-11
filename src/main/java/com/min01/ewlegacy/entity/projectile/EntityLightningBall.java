package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;
import com.min01.ewlegacy.entity.witch.EntityLightningWitch;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityLightningBall extends AbstractEWHurtingProjectile implements ItemSupplier
{
    public EntityLightningBall(EntityType<? extends AbstractEWHurtingProjectile> type, Level level)
    {
        super(type, level);
    }
    
    public EntityLightningBall(Level level, LivingEntity living, double x, double y, double z) 
    {
        super(EWEntities.LIGHTNING_BALL.get(), level, living, x,  y, z);
    }
    
    public EntityLightningBall(Level level, double x, double y, double z, double motionX, double motionY, double motionZ)
    {
        super(EWEntities.LIGHTNING_BALL.get(), level, x, y, z, motionX, motionY, motionZ);
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult) 
    {
        if(!this.level.isClientSide && hitResult.getEntity() != null && this.getOwner() != null && hitResult.getEntity() instanceof LivingEntity && !(hitResult.getEntity() instanceof EntityLightningGolem))
        {
            if(!(hitResult.getEntity() instanceof EntityLightningWitch)) 
            {
                hitResult.getEntity().hurt(DamageSource.MAGIC, 3.0F);
                ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(EWEffects.PARALYZE.get(), 40, 1));
                this.discard();
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
        ElementalWitchesLegacy.PROXY.spawnParticles("lightning_shoot", this);
        super.tick();
    }
    
    @Override
    public ItemStack getItem() 
    {
    	return new ItemStack(EWItems.LIGHTNING_BALL.get());
    }
}
