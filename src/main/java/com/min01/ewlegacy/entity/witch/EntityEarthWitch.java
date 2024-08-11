package com.min01.ewlegacy.entity.witch;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityEarthEgg;
import com.min01.ewlegacy.entity.projectile.EntityEarthShoot;
import com.min01.ewlegacy.entity.skill.EntityBlock;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class EntityEarthWitch extends Raider implements RangedAttackMob
{
    public int blockSuffo = 300;
    public int summonGolem = 600;
    public boolean healContainer = false;
    
    public EntityEarthWitch(EntityType<? extends Raider> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        if(EWConfig.elementalsVsWitches.get())
        {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Witch.class, true));
        }
    }
    
    @Override
    public void applyRaidBuffs(int p_37844_, boolean p_37845_) 
    {
    	
    }
    
    @Override
    public SoundEvent getCelebrateSound() 
    {
    	return SoundEvents.WITCH_CELEBRATE;
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
    			.add(Attributes.MAX_HEALTH, 80.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public void aiStep()
    {
        ElementalWitchesLegacy.PROXY.spawnParticles("earth_big", this);
        if(this.summonGolem != 0 && this.getTarget() != null)
        {
            --this.summonGolem;
        }
        if(this.blockSuffo != 0 && this.getTarget() != null)
        {
            --this.blockSuffo;
        }
        if(this.getTarget() != null && !this.level.isClientSide) 
        {
            if(this.getHealth() <= 30.0F)
            {
                if(this.tickCount % 20 == 0) 
                {
                    this.heal(4.0F);
                }
                if(!this.healContainer) 
                {
                    this.setDeltaMovement(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z + 1);
                    BlockState block = Blocks.STONE.defaultBlockState();
                    int xx = (int)this.getX();
                    int yy = (int)this.getY();
                    int zz = (int)this.getZ();
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 2, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 2, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 2, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 2, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 2, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 2, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 1, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy + 1, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 1, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 1, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 1, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 1, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx, yy, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy, zz + 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy, zz - 2), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz + 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz - 1), block);
                    this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz + 1), block);
                    for(int i = 0; i < 20; ++i)
                    {
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(5);
                        EntityEarthMinion entity = new EntityEarthMinion(EWEntities.EARTH_MINION.get(), this.level);
                        entity.setOwner(this);
                        if(randomNumber == 1) 
                        {
                            entity.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 4.0, 0.0F, 0.0F);
                            entity.setTarget(this.getTarget());
                            EWUtil.spawnInWorld(this.level, entity);
                        }
                        else if(randomNumber == 2)
                        {
                            entity.moveTo(this.getX() - 5.0, this.getY(), this.getZ() + 4.0, 0.0F, 0.0F);
                            entity.setTarget(this.getTarget());
                            EWUtil.spawnInWorld(this.level, entity);
                        }
                        else if(randomNumber == 3) 
                        {
                            entity.moveTo(this.getX() + 5.0, this.getY(), this.getZ() - 5.0, 0.0F, 0.0F);
                            entity.setTarget(this.getTarget());
                            EWUtil.spawnInWorld(this.level, entity);
                        }
                        else if(randomNumber == 4) 
                        {
                            entity.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 5.0, 0.0F, 0.0F);
                            entity.setTarget(this.getTarget());
                            EWUtil.spawnInWorld(this.level, entity);
                        }
                    }
                    this.healContainer = true;
                }
            }
            if(this.summonGolem == 0) 
            {
                this.setDeltaMovement(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z + 2.0);
                BlockState block = Blocks.STONE.defaultBlockState();
                int xx = (int)this.getTarget().getX();
                int yy = (int)this.getTarget().getY();
                int zz = (int)this.getTarget().getZ();
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 3, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 3, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 3, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy - 1, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy - 1, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy - 1, zz + 1), block);
                EntityEarthMinion entitywitherskull1 = new EntityEarthMinion(EWEntities.EARTH_MINION.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo((double)xx, (double)yy, (double)zz, this.getYRot(), 0.0F);
                entitywitherskull1.setTarget(this.getTarget());
                EntityEarthMinion entitywitherskull2 = new EntityEarthMinion(EWEntities.EARTH_MINION.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo((double)xx, (double)yy, (double)zz, this.getYRot(), 0.0F);
                entitywitherskull2.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 2, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 2, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 2, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 2, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 2, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 2, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 2, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 2, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 1, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy + 1, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 1, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 1, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy + 1, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy + 1, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy + 1, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy + 1, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx, yy, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy, zz + 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 1, yy, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 1, yy, zz - 2), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx + 2, yy, zz + 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz - 1), block);
                this.level.setBlockAndUpdate(new BlockPos(xx - 2, yy, zz + 1), block);
                this.summonGolem = 600;
            }
            if(this.blockSuffo == 0) 
            {
                int xx2 = (int)Math.floor(this.getTarget().getX());
                int yy2 = (int)Math.floor(this.getTarget().getY());
                int zz2 = (int)Math.floor(this.getTarget().getZ());
                EntityBlock entitywitherskull3 = new EntityBlock(this.level, xx2, yy2 + 4, zz2, Blocks.STONE);
                EntityBlock entitywitherskull4 = new EntityBlock(this.level, xx2, yy2 + 4, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskull5 = new EntityBlock(this.level, xx2, yy2 + 4, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskull6 = new EntityBlock(this.level, xx2 + 1, yy2 + 4, zz2, Blocks.STONE);
                EntityBlock entitywitherskul13 = new EntityBlock(this.level, xx2 - 1, yy2 + 4, zz2, Blocks.STONE);
                EntityBlock entitywitherskul14 = new EntityBlock(this.level, xx2 - 1, yy2 + 4, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskul15 = new EntityBlock(this.level, xx2 - 1, yy2 + 4, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskul16 = new EntityBlock(this.level, xx2 + 1, yy2 + 4, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskul17 = new EntityBlock(this.level, xx2 + 1, yy2 + 4, zz2 - 1, Blocks.STONE);
                this.level.addFreshEntity(entitywitherskull3);
                this.level.addFreshEntity(entitywitherskull4);
                this.level.addFreshEntity(entitywitherskull5);
                this.level.addFreshEntity(entitywitherskull6);
                this.level.addFreshEntity(entitywitherskul13);
                this.level.addFreshEntity(entitywitherskul14);
                this.level.addFreshEntity(entitywitherskul15);
                this.level.addFreshEntity(entitywitherskul16);
                this.level.addFreshEntity(entitywitherskul17);
                EntityBlock entitywitherskull7 = new EntityBlock(this.level, xx2, yy2 + 5, zz2, Blocks.STONE);
                EntityBlock entitywitherskull8 = new EntityBlock(this.level, xx2, yy2 + 5, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskull9 = new EntityBlock(this.level, xx2, yy2 + 5, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskull10 = new EntityBlock(this.level, xx2 + 1, yy2 + 5, zz2, Blocks.STONE);
                EntityBlock entitywitherskul18 = new EntityBlock(this.level, xx2 - 1, yy2 + 5, zz2, Blocks.STONE);
                EntityBlock entitywitherskul19 = new EntityBlock(this.level, xx2 - 1, yy2 + 5, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskul20 = new EntityBlock(this.level, xx2 - 1, yy2 + 5, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskul21 = new EntityBlock(this.level, xx2 + 1, yy2 + 5, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskul22 = new EntityBlock(this.level, xx2 + 1, yy2 + 5, zz2 - 1, Blocks.STONE);
                this.level.addFreshEntity(entitywitherskull7);
                this.level.addFreshEntity(entitywitherskull8);
                this.level.addFreshEntity(entitywitherskull9);
                this.level.addFreshEntity(entitywitherskull10);
                this.level.addFreshEntity(entitywitherskul18);
                this.level.addFreshEntity(entitywitherskul19);
                this.level.addFreshEntity(entitywitherskul20);
                this.level.addFreshEntity(entitywitherskul21);
                this.level.addFreshEntity(entitywitherskul22);
                EntityBlock entitywitherskull11 = new EntityBlock(this.level, xx2, yy2 + 6, zz2, Blocks.STONE);
                EntityBlock entitywitherskull12 = new EntityBlock(this.level, xx2, yy2 + 6, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskull13 = new EntityBlock(this.level, xx2, yy2 + 6, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskull14 = new EntityBlock(this.level, xx2 + 1, yy2 + 6, zz2, Blocks.STONE);
                EntityBlock entitywitherskull15 = new EntityBlock(this.level, xx2 - 1, yy2 + 6, zz2, Blocks.STONE);
                EntityBlock entitywitherskull16 = new EntityBlock(this.level, xx2 - 1, yy2 + 6, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskull17 = new EntityBlock(this.level, xx2 - 1, yy2 + 6, zz2 - 1, Blocks.STONE);
                EntityBlock entitywitherskull18 = new EntityBlock(this.level, xx2 + 1, yy2 + 6, zz2 + 1, Blocks.STONE);
                EntityBlock entitywitherskull19 = new EntityBlock(this.level, xx2 + 1, yy2 + 6, zz2 - 1, Blocks.STONE);
                this.level.addFreshEntity(entitywitherskull11);
                this.level.addFreshEntity(entitywitherskull12);
                this.level.addFreshEntity(entitywitherskull13);
                this.level.addFreshEntity(entitywitherskull14);
                this.level.addFreshEntity(entitywitherskull15);
                this.level.addFreshEntity(entitywitherskull16);
                this.level.addFreshEntity(entitywitherskull17);
                this.level.addFreshEntity(entitywitherskull18);
                this.level.addFreshEntity(entitywitherskull19);
                this.blockSuffo = 300;
            }
        }
        if(this.random.nextFloat() < 7.5E-4F) 
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        super.aiStep();
    }
    
    public boolean isArmored()
    {
        return this.getHealth() <= 50.0F;
    }
    
    private double getHeadX(int par1)
    {
        if(par1 <= 0) 
        {
            return this.getX();
        }
        float f = (this.yBodyRot + 180 * (par1 - 1)) / 180.0F * 3.1415927F;
        float f2 = Mth.cos(f);
        return this.getX() + f2 * 1.3;
    }
    
    private double getHeadY(int par1)
    {
        return (par1 <= 0) ? (this.getY() + 0.5) : (this.getY() + 0.5);
    }
    
    private double getHeadZ(int par1)
    {
        if(par1 <= 0) 
        {
            return this.getZ();
        }
        float f = (this.yBodyRot + 180 * (par1 - 1)) / 180.0F * 3.1415927F;
        float f2 = Mth.sin(f);
        return this.getZ() + f2 * 1.3;
    }
    
    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_)
    {
        for(int i = 0; i < 5; ++i)
        {
            this.performRangedAttack(0, p_33317_);
        }
    }
    
    private void performRangedAttack(int par1, LivingEntity living)
    {
        this.performRangedAttack(par1, living.getX(), living.getY() + living.getEyeHeight() * 0.5, living.getZ(), par1 == 0 && this.random.nextFloat() < 0.001F);
    }
    
    private void performRangedAttack(int par1, double par2, double par4, double par6, boolean par8) 
    {
        double d3 = this.getHeadX(par1);
        double d4 = this.getHeadY(par1);
        double d5 = this.getHeadZ(par1);
        double d6 = par2 - d3;
        double d7 = par4 - d4;
        double d8 = par6 - d5;
        EntityEarthShoot entitywitherskull = new EntityEarthShoot(this.level, this, d6, d7, d8);
        entitywitherskull.setPos(d3, d4 + 0.5, d5);
        EWUtil.spawnInWorld(this.level, entitywitherskull);
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source.getEntity() instanceof FallingBlockEntity || source.getEntity() instanceof EntityBlock || source == DamageSource.IN_WALL || source == DamageSource.FALLING_BLOCK || source.getEntity() instanceof EntityEarthShoot) 
        {
            return false;
        }
        if(this.isArmored())
        {
            Entity entity = source.getDirectEntity();
            if(entity instanceof AbstractArrow) 
            {
                return false;
            }
        }
        return super.hurt(source, damage);
    }
    
    @Override
    public void remove(RemovalReason p_146834_)
    {
    	super.remove(p_146834_);
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 10.0, 10.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof Player)
            {
            	//TODO
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killearthwitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchBlockSuffo", this.blockSuffo);
        compound.putInt("WitchMinionSummon", this.summonGolem);
        compound.putBoolean("WitchHealContainer", this.healContainer);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.blockSuffo = compound.getInt("WitchBlockSuffo");
        this.summonGolem = compound.getInt("WitchMinionSummon");
        this.healContainer = compound.getBoolean("WitchHealContainer");
    }
    
    protected Item getDropItem() 
    {
        return EWItems.EARTH_SHARD.get();
    }
    
    @Override
    public boolean removeWhenFarAway(double p_37894_) 
    {
    	return false;
    }
    
    @Override
    protected InteractionResult mobInteract(Player p_21472_, InteractionHand p_21473_)
    {
        ItemStack stack = p_21472_.getItemInHand(p_21473_);
        if(stack.getItem() == EWItems.EMPTY_EGG.get() && this.getHealth() <= 13.0F && this.random.nextInt(1000) <= 10)
        {
        	stack.shrink(1);
        	EntityEarthEgg mob = new EntityEarthEgg(EWEntities.EARTH_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.earthpet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
