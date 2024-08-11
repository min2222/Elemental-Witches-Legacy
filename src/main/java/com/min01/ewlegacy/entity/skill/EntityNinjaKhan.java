package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;

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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityNinjaKhan extends TamableAnimal
{
    int teleport = 50;
    
    public EntityNinjaKhan(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityNinjaKhan.class));
        this.setTame(true);
    }
    
    @Override
    public void onAddedToWorld() 
    {
    	super.onAddedToWorld();
    	if(!this.level.isDay())
    	{
    		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1.5);
    	}
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.5)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        if(!this.level.isDay()) 
        {
            return target.hurt(DamageSource.mobAttack(this), 6.0F);
        }
        return target.hurt(DamageSource.mobAttack(this), 2.0F);
    }
    
    @Override
    public void aiStep()
    {
        if(this.teleport != 0) 
        {
            --this.teleport;
        }
        if(this.getTarget() != null && this.teleport == 0)
        {
            this.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 0.0F, 0.0F);
            this.teleport = 50;
        }
        if(this.tickCount >= 300 || this.getHealth() <= 0.0F) 
        {
            this.discard();
        }
        if(this.level.isDay())
        {
        	ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", this);
            ElementalWitchesLegacy.PROXY.spawnParticles("ninjakhan", this);
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }

    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) 
    {
    	return false;
    }
    
    @Override
    public boolean removeWhenFarAway(double p_27598_)
    {
    	return false;
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_)
    {
    	return null;
    }
}
