package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityAirEgg;
import com.min01.ewlegacy.entity.skill.EntityMiniTornado;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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

public class EntityAirPhoenix2 extends TamableAnimal
{
    public int deathTicks;
    int tornadoTimer = 300;
    int involveTimer = 0;
    
    public EntityAirPhoenix2(EntityType<? extends TamableAnimal> type, Level level)
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityAirPhoenix2.class));
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
    public void aiStep() 
    {
        if(!this.onGround && this.getDeltaMovement().y < 0.0) 
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.6, 1));
        }
        if(this.tornadoTimer != 0 && this.getTarget() != null) 
        {
            --this.tornadoTimer;
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.isOrderedToSit())
        {
            ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 2.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("air_normal", this);
        if(this.getTarget() != null && this.tornadoTimer == 0)
        {
            EntityMiniTornado entitywitherskull1 = new EntityMiniTornado(EWEntities.MINI_TORNADO.get(), this.level);
            entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            entitywitherskull1.startRiding(this.getTarget());
            EWUtil.spawnInWorld(this.level, entitywitherskull1);
            this.tornadoTimer = 300;
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath() 
    {
        ++this.deathTicks;
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            for(int i = 1; i <= 4; ++i)
            {
            	ElementalWitchesLegacy.PROXY.spawnParticles("air_tornado_small", this);
            }
        }
        if(this.deathTicks == 140)
        {
            EntityAirEgg mob = new EntityAirEgg(EWEntities.AIR_EGG.get(), this.level);
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
    public boolean isPushable() 
    {
        return this.deathTicks <= 0;
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
        return this.deathTicks <= 0;
    }
    
    @Override
    public boolean isPushedByFluid(FluidType type)
    {
        return this.deathTicks <= 0;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityMiniTornado) && super.hurt(source, damage);
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        Random rand = new Random();
        int form = rand.nextInt(4);
        if(form == 1)
        {
            float f4 = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
            if(f4 > 0.0F)
            {
            	target.push(this.getDeltaMovement().x * 3.0 * 0.6000000238418579 / f4, 0.1, this.getDeltaMovement().z * 3.0 * 0.6000000238418579 / f4);
            }
            target.hurt(DamageSource.mobAttack(this), 2.0F);
            return true;
        }
        if(form == 2) 
        {
        	target.hurt(DamageSource.mobAttack(this), 2.0F);
        	target.setDeltaMovement(target.getDeltaMovement().x, 1.0, target.getDeltaMovement().z);
            return true;
        }
        if(form == 3) 
        {
        	target.hurt(DamageSource.mobAttack(this), 5.0F);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
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
            if(target instanceof EntityAirPhoenix2) 
            {
            	EntityAirPhoenix2 entitywolf = (EntityAirPhoenix2) target;
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
            if(p_27584_.isHolding(EWItems.AIR_SHARD.get()))
            {
                if(this.involveTimer != 9)
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
                    EntityAirPhoenix3 mob = new EntityAirPhoenix3(EWEntities.AIR_PHOENIX_3.get(), this.level);
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
                        	//((Player)this.getOwner()).awardStat(MWAWAchievementsRegistry.airpet4, 1);
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
        compound.putInt("PetSummonMiniTornado", this.tornadoTimer);
        compound.putInt("PetInvolveTimerAir", this.involveTimer);
        compound.putInt("PetDeathTicks", this.deathTicks);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.tornadoTimer = compound.getInt("PetSummonMiniTornado");
        this.involveTimer = compound.getInt("PetInvolveTimerAir");
        this.deathTicks = compound.getInt("PetDeathTicks");
    }
}
