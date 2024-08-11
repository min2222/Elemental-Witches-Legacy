package com.min01.ewlegacy.entity.pet;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityLightEgg;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityLightAngel extends TamableAnimal
{
    public int skillTimer = 200;
    public int deathTicks;
    public int involveTimer = 0;
    public float floatingRotation;
    
    public EntityLightAngel(EntityType<? extends TamableAnimal> type, Level level)
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityLightAngel.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 30.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
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
        if(!this.onGround && this.getDeltaMovement().y < 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.9, 1));
        }
        if(this.getTarget() != null && this.skillTimer != 0) 
        {
            --this.skillTimer;
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("light_normal", this);
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 1.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        if (this.getTarget() != null && this.skillTimer == 0 && this.getOwner() != null) 
        {
            this.getOwner().addEffect(new MobEffectInstance(MobEffects.REGENERATION, 90, 1));
            this.skillTimer = 200;
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath()
    {
        ++this.deathTicks;
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            for(int i = 1; i <= 2; ++i)
            {
                ElementalWitchesLegacy.PROXY.spawnParticles("light_circle_small", this);
            }
        }
        if(this.deathTicks == 140) 
        {
            EntityLightEgg mob = new EntityLightEgg(EWEntities.LIGHT_EGG.get(), this.level);
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
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
    {
    	return false;
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        return target.hurt(DamageSource.mobAttack(this), 2.0F);
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
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_)
    {
    	return null;
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityLightAngel) 
            {
            	EntityLightAngel entitywolf = (EntityLightAngel) target;
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
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(!p_27584_.isShiftKeyDown()) 
        {
            if(p_27584_.isHolding(EWItems.LIGHT_SHARD.get()))
            {
                if(this.involveTimer != 4)
                {
                    ++this.involveTimer;
                    if(!p_27584_.getAbilities().instabuild)
                    {
                        ItemStack getHeldItem = p_27584_.getItemInHand(p_27585_);
                        getHeldItem.shrink(1);
                    }
                }
                else
                {
                    EntityLightAngel2 mob = new EntityLightAngel2(EWEntities.LIGHT_ANGEL_2.get(), this.level);
                    mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    if(this.getOwner() != null)
                    {
                        mob.setOwnerUUID(this.getOwnerUUID());
                    }
                    mob.setCustomName(this.getCustomName());
                    mob.setTame(true);
                    EWUtil.spawnInWorld(this.level, mob);
                    mob.setCustomNameVisible(true);
                    p_27584_.playSound(SoundEvents.PLAYER_LEVELUP, 2.0F, 0.6F);
                    for(Entity entity1 : list) 
                    {
                        if(entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner())
                        {
                        	//TODO
                        	//((Player)this.getOwner()).awardStat(MWAWAchievementsRegistry.lightpet3, 1);
                        }
                    }
                    this.discard();
                }
            }
            if(!this.isOrderedToSit()) 
            {
                this.setTarget(null);
                this.setOrderedToSit(true);
            }
            else if(this.isOrderedToSit()) 
            {
                this.setOrderedToSit(false);
            }
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("PetSkillLight", this.skillTimer);
        compound.putInt("PetInvolveTimerLight", this.involveTimer);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.skillTimer = compound.getInt("PetSkillLight");
        this.involveTimer = compound.getInt("PetInvolveTimerLight");
    }
    
    public float getFloatingRotation()
    {
        return 15.0F - Math.abs((float)Math.sin(this.floatingRotation) * 3.5F);
    }
}
