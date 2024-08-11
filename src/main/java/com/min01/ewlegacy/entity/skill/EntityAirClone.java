package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityAirShoot;
import com.min01.ewlegacy.entity.witch.EntityAirWitch;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class EntityAirClone extends AbstractOwnableMonster<EntityAirWitch>
{
    public EntityAirClone(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.2));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.2, 32.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    @Override
    protected SoundEvent getAmbientSound() 
    {
    	return SoundEvents.WITCH_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.WITCH_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound() 
    {
    	return SoundEvents.WITCH_DEATH;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4)
    			.add(Attributes.ATTACK_DAMAGE, 0.0);
    }
    
    @Override
    public void aiStep()
    {
        if(this.getDeltaMovement().y <= -0.2)
        {
            this.setDeltaMovement(this.getDeltaMovement().subtract(0, 0.5, 0));
        }
        if(this.tickCount >= 200) 
        {
            this.discard();
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public void remove(RemovalReason p_146834_)
    {
    	super.remove(p_146834_);
        if(!this.level.isClientSide)
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, explosion$blockinteraction);
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityAirWitch) && !(source.getEntity() instanceof EntityMiniTornado) && !(source.getEntity() instanceof EntityAirShoot) && super.hurt(source, damage);
    }
}
