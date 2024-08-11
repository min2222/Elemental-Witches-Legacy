package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityFireWitch;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityFireBat extends AbstractOwnableMonster<EntityFireWitch>
{
    private BlockPos spawnPosition;
    
    public EntityFireBat(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.4));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.4, 32.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.FOLLOW_RANGE, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4)
    			.add(Attributes.MAX_HEALTH, 10.0)
    			.add(Attributes.ATTACK_DAMAGE, 1.0);
    }

    @Override
    protected float getSoundVolume() 
    {
    	return 0.1F;
    }
    
    @Override
    public float getVoicePitch() 
    {
    	return super.getVoicePitch() * 0.95F;
    }
    
    @Override
    protected SoundEvent getAmbientSound()
    {
    	return SoundEvents.BAT_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.BAT_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return SoundEvents.BAT_DEATH;
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
    public MobType getMobType() 
    {
    	return MobType.UNDEAD;
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityFireWitch) && !(source.getEntity() instanceof EntityFireMeteorite) && super.hurt(source, damage);
    }
    
    @Override
    public void aiStep()
    {
        if(this.getDeltaMovement().y <= -0.2) 
        {
            this.setDeltaMovement(this.getDeltaMovement().subtract(0, 0.2, 0));
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("fire_main", this);
        if(this.getTarget() == null)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.6000000238418579, 1));
        }
        super.aiStep();
    }
    
    @Override
    protected void customServerAiStep() 
    {
        super.customServerAiStep();
        if(this.getTarget() == null)
        {
            if(this.spawnPosition != null && (!this.level.isEmptyBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) 
            {
                this.spawnPosition = null;
            }
            if(this.spawnPosition == null || this.random.nextInt(30) == 0 || this.spawnPosition.closerToCenterThan(this.position(), 4.0F)) 
            {
                this.spawnPosition = new BlockPos((int)this.getX() + this.random.nextInt(7) - this.random.nextInt(7), (int)this.getY() + this.random.nextInt(6) - 2, (int)this.getZ() + this.random.nextInt(7) - this.random.nextInt(7));
            }
            double d0 = this.spawnPosition.getX() + 0.5 - this.getX();
            double d2 = this.spawnPosition.getY() + 0.1 - this.getY();
            double d3 = this.spawnPosition.getZ() + 0.5 - this.getZ();
            this.getDeltaMovement().add((Math.signum(d0) * 0.5 - this.getDeltaMovement().x) * 0.10000000149011612, (Math.signum(d2) * 0.699999988079071 - this.getDeltaMovement().y) * 0.10000000149011612, (Math.signum(d3) * 0.5 - this.getDeltaMovement().z) * 0.10000000149011612);
            float f = (float)(Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * 180.0 / 3.141592653589793) - 90.0F;
            float f2 = Mth.wrapDegrees(f - this.getYRot());
            this.zza = 0.5F;
            this.setYRot(this.getYRot() + f2);
        }
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        if(super.doHurtTarget(target)) 
        {
            if(target instanceof LivingEntity) 
            {
            	target.setSecondsOnFire(10);
            }
            return true;
        }
        return false;
    }
}
