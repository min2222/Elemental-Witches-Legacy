package com.min01.ewlegacy.entity.skill;

import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityNatureWitch;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class EntitySwiftEnt extends AbstractOwnableMonster<EntityNatureWitch>
{
    public float floatingRotation;
    private boolean setfire = false;
    
    public EntitySwiftEnt(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.2));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.2, 32.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    @Override
    public float getStepHeight()
    {
    	return 1.0F;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 5.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 2.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.5)
    			.add(Attributes.ATTACK_DAMAGE, 2.0);
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        boolean flag = target.hurt(DamageSource.mobAttack(this), 1.0F);
        if(target instanceof LivingEntity) 
        {
            ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.POISON, 50, 1));
        }
        return flag;
    }
    
    @Override
    public void aiStep() 
    {
        super.aiStep();
        this.floatingRotation += 0.02F;
        if(this.isInWater())
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("leaf_normal", this);
        if(this.isOnFire() && !this.setfire) 
        {
            this.setSecondsOnFire(100000000);
            this.setfire = true;
        }
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
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) 
    {
    	this.playSound(SoundEvents.WOOD_STEP, 0.15F, 1.0F);
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
    }
    
    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_)
    {
    	super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        if(randomNumber == 1) 
        {
            if(this.isOnFire() || this.setfire)
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 4), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 1);
            }
        }
        else if(randomNumber == 2) 
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 4), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 4);
            }
        }
        else if(randomNumber == 3)
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 6), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 6);
            }
        }
        else if(randomNumber == 4) 
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 2), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 2);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("EntSetFire", this.setfire);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.setfire = compound.getBoolean("EntSetFire");
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source == DamageSource.IN_WALL || source == DamageSource.DROWN || source.getEntity() instanceof EntityNatureWitch || source.getEntity() instanceof EntityRoot || source.getEntity() instanceof EntityEnt)
        {
            return false;
        }
        if(source.getEntity() instanceof LivingEntity && ((LivingEntity)source.getEntity()).getMainHandItem().getItem() instanceof AxeItem) 
        {
            return super.hurt(source, damage);
        }
        return super.hurt(source, 1.0F);
    }
    
    public float getFloatingRotation()
    {
        return -4.0F - Math.abs((float)Math.sin(this.floatingRotation) * 4.5F);
    }
}
