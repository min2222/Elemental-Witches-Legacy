package com.min01.ewlegacy.entity.witch;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;

public class EntityEarthMinionGood extends PathfinderMob
{
    public EntityEarthMinionGood(EntityType<? extends PathfinderMob> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.2));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.2, 32.0F));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Slime.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 10.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.2)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 5.0);
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.STONE_BREAK;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
    	if(source.isBypassInvul())
    	{
    		return super.hurt(source, damage);
    	}
        return source.getEntity() instanceof Player && ((Player)source.getEntity()).getMainHandItem().getItem() instanceof PickaxeItem && super.hurt(source, damage);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    protected void doPush(Entity p_20971_)
    {
    	if(p_20971_ instanceof Enemy && this.getRandom().nextInt(20) == 0)
    	{
    		this.setTarget((LivingEntity) p_20971_);
    	}
    	super.doPush(p_20971_);
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        this.level.broadcastEntityEvent(this, (byte)4);
        return target.hurt(DamageSource.mobAttack(this), 2.0F);
    }
    
    @Override
    public void aiStep() 
    {
        if(this.getTarget() instanceof EntityEarthMinionGood) 
        {
            this.setTarget(null);
        }
        if(this.tickCount >= 330)
        {
            this.discard();
        }
        super.aiStep();
    }
}
