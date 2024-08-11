package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityFireEgg;
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
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class EntityFireDragon extends TamableAnimal
{
    public int deathTicks;
    public int involveTimer = 0;
    
    public EntityFireDragon(EntityType<? extends TamableAnimal> type, Level level)
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityFireDragon.class));
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
    public void aiStep()
    {
        ElementalWitchesLegacy.PROXY.spawnParticles("fire_main", this);
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 1.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath()
    {
        ++this.deathTicks;
        if(this.deathTicks >= 0 && this.deathTicks <= 140)
        {
        	ElementalWitchesLegacy.PROXY.spawnParticles("fire_tornado_small", this);
        }
        if(this.deathTicks == 140) 
        {
            EntityFireEgg mob = new EntityFireEgg(EWEntities.FIRE_EGG.get(), this.level);
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
    public boolean doHurtTarget(Entity target)
    {
        Random rand = new Random();
        int form = rand.nextInt(100);
        if(form <= 5) 
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
        	target.level.explode(this, this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 1.0F, true, explosion$blockinteraction);
        	target.hurt(DamageSource.mobAttack(this), 1.0F);
            return true;
        }
        target.setSecondsOnFire(10);
        return target.hurt(DamageSource.mobAttack(this), 2.0F);
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof PrimedTnt) && super.hurt(source, damage);
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityFireDragon) 
            {
                EntityFireDragon entitywolf = (EntityFireDragon) target;
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
            if(p_27584_.isHolding(EWItems.FIRE_SHARD.get()))
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
                    EntityFireDragon2 mob = new EntityFireDragon2(EWEntities.FIRE_DRAGON_2.get(), this.level);
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
                        	//((Player)this.getOwner()).awardStat(MWAWAchievementsRegistry.firepet3, 1);
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
        compound.putInt("PetInvolveTimerFire", this.involveTimer);
        compound.putInt("PetDeathTicks", this.deathTicks);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.involveTimer = compound.getInt("PetInvolveTimerFire");
        this.deathTicks = compound.getInt("PetDeathTicks");
        this.deathTicks = compound.getInt("PetDeathTicks");
    }
}
