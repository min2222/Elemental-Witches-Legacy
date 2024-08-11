package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityHalloweenWitch;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityExplosivePumpkin extends AbstractOwnableMonster<EntityHalloweenWitch>
{
    public EntityExplosivePumpkin(EntityType<? extends Monster> type, Level level) 
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
        if(this.getDeltaMovement().y <= -0.2) 
        {
            this.setDeltaMovement(this.getDeltaMovement().subtract(0, 0.5, 0));
        }
        if(this.onGround && !this.level.isClientSide)
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, true, explosion$blockinteraction);
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("halloween_normal_4", this);
        super.aiStep();
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) 
    {
    	return p_21016_.getEntity() instanceof EntityExplosivePumpkin || p_21016_.isBypassInvul();
    }
}
