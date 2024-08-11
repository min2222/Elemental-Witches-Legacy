package com.min01.ewlegacy.entity.pet;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

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
import net.minecraft.world.level.Level;

public class EntityHalloweenPumpkin extends TamableAnimal
{
    public EntityHalloweenPumpkin(EntityType<? extends TamableAnimal> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.3));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityHalloweenPumpkin.class));
        this.setTame(false);
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
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 1.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        if(this.getOwner() != null) 
        {
            if(!(this.getOwner().getName().getString().equals("HoopaWolf") | this.getOwner().getName().getString().equals("DarkSoul260") | this.getOwner().getName().getString().equals("AlexWei4") | this.getOwner().getName().getString().equals("CruaverVoidDrake") | this.getOwner().getName().getString().equals("TOMMYZILLA2003") | this.getOwner().getName().getString().equals("SlipperySkater") | this.getOwner().getName().getString().equals("jbyoda") | this.getOwner().getName().getString().equals("Soul_Mask_Master") | this.getOwner().getName().getString().equals("Dragonlord7479") | this.getOwner().getName().getString().equals("aydanprice") | this.getOwner().getName().getString().equals("Darkraivoid") | this.getOwner().getName().getString().equals("Noremac_TC")))
            {
                this.discard();
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        return target.hurt(DamageSource.mobAttack(this), 2.0F);
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
            if(target instanceof EntityHalloweenPumpkin) 
            {
                EntityHalloweenPumpkin entitywolf = (EntityHalloweenPumpkin) target;
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
        if(this.isTame() && p_27584_.isShiftKeyDown())
        {
            EntityHalloweenPumpking mob = new EntityHalloweenPumpking(EWEntities.HALLOWEEN_PUMPKING.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            if (this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setTame(true);
            if(!p_27584_.getAbilities().instabuild) 
            {
            	p_27584_.setHealth(p_27584_.getHealth() - 6.5F);
            }
            EWUtil.spawnInWorld(this.level, mob);
            mob.setCustomNameVisible(true);
            p_27584_.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 0.6F);
            this.discard();
        }
        if(!p_27584_.isShiftKeyDown())
        {
            if(!this.isOrderedToSit()) 
            {
                this.setTarget(null);
                this.setOrderedToSit(true);
                return InteractionResult.SUCCESS;
            }
            else if(this.isOrderedToSit()) 
            {
                this.setOrderedToSit(false);
            }
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
}
