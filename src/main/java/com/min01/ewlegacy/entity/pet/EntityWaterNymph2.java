package com.min01.ewlegacy.entity.pet;

import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityWaterEgg;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;

public class EntityWaterNymph2 extends TamableAnimal
{
    public int deathTicks;
    public int involveTimer = 0;
    public int skillTimer = 100;
    public float floatingRotation;
    
    public EntityWaterNymph2(EntityType<? extends TamableAnimal> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityWaterNymph2.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 60.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.6);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        Random rand = new Random();
        int form = rand.nextInt(50);
        if(form <= 24) 
        {
            ((LivingEntity)target).addEffect(new MobEffectInstance(EWEffects.ENDER_SKIN.get(), 300, 1));
            ((LivingEntity)target).addEffect(new MobEffectInstance(EWEffects.WATER_PULL.get(), 300, 1));
            return target.hurt(DamageSource.mobAttack(this), 3.0F);
        }
        return target.hurt(DamageSource.mobAttack(this), 5.0F);
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
        this.floatingRotation += 0.02F;
        if(this.isInWater()) 
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 2.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("water_normal", (Entity)this);
        if(this.skillTimer != 0 && this.getTarget() != null) 
        {
            --this.skillTimer;
        }
        if(this.getTarget() != null && this.skillTimer == 0) 
        {
            this.level.setBlockAndUpdate(this.getTarget().blockPosition(), Blocks.WATER.defaultBlockState());
            this.skillTimer = 100;
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath()
    {
        ++this.deathTicks;
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            for(int i = 1; i <= 3; ++i) 
            {
            	ElementalWitchesLegacy.PROXY.spawnParticles("water_circle", this);
            }
        }
        if(this.deathTicks == 140)
        {
            EntityWaterEgg mob = new EntityWaterEgg(EWEntities.WATER_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            if(this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setCustomNameVisible(true);
            this.discard();
        }
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityWaterNymph2) 
            {
            	EntityWaterNymph2 entitywolf = (EntityWaterNymph2) target;
                if(entitywolf.isTame() && entitywolf.getOwner() == owner)
                {
                    return false;
                }
            }
            return (target instanceof Player && owner instanceof Player && !((Player)owner).canAttack((Player)target)) ? false : ((!(target instanceof Horse) || !((Horse)target).isTamed()));
        }
        return false;
    }
    
    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_)
    {
        if(!this.isOrderedToSit()) 
        {
            this.setTarget(null);
            this.setOrderedToSit(true);
        }
        else if(this.isOrderedToSit()) 
        {
            this.setOrderedToSit(false);
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("PetInvolveTimerWater", this.involveTimer);
        compound.putInt("PetSkillTimerWater", this.skillTimer);
        compound.putInt("PetDeathTicks", this.deathTicks);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.involveTimer = compound.getInt("PetInvolveTimerWater");
        this.skillTimer = compound.getInt("PetSkillTimerWater");
        this.deathTicks = compound.getInt("PetDeathTicks");
    }
    
    public float getFloatingRotation()
    {
        return -2.0F - Math.abs((float)Math.sin(this.floatingRotation) * 2.5F);
    }
}
