package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;
import com.min01.ewlegacy.entity.projectile.EntityLightShoot;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityLightShieldBad extends AbstractOwnableMonster<EntityLightWitch>
{
    public EntityLightShieldBad(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
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
            if(this.getOwner() != null)
            {
                this.moveTo(this.getOwner().getX(), this.getOwner().getY(), this.getOwner().getZ(), 0.0F, 0.0F);
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
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source.getEntity() instanceof EntityLightShoot || source.getEntity() instanceof EntityLightArrow || source.getEntity() instanceof LightningBolt || source.getEntity() instanceof LargeFireball) 
        {
            return false;
        }
        if(damage >= 0.0F)
        {
            if(source.getEntity() instanceof LivingEntity)
            {
                ((LivingEntity)source.getEntity()).hurt(source, damage);
            }
            return super.hurt(source, 0.0F);
        }
        return super.hurt(source, damage);
    }
}
