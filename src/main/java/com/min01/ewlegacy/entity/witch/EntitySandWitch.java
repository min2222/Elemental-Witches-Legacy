package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;
import com.min01.ewlegacy.entity.skill.EntityAirClone;
import com.min01.ewlegacy.entity.skill.EntityBlock;
import com.min01.ewlegacy.entity.skill.EntityDarkSummoner;
import com.min01.ewlegacy.entity.skill.EntityFireBat;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;
import com.min01.ewlegacy.entity.skill.EntityMiniTornado;
import com.min01.ewlegacy.entity.skill.EntitySandGolem;
import com.min01.ewlegacy.entity.skill.EntitySandMark;
import com.min01.ewlegacy.entity.skill.EntityWaterSpout;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class EntitySandWitch extends Raider
{
    int summon200 = 70;
    int summon300 = 120;
    int summon600 = 150;
    boolean summoned = false;
    
    public EntitySandWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
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
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 3.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public void aiStep() 
    {
        if(this.summon600 != 0 && this.getTarget() != null) 
        {
            --this.summon600;
        }
        if(this.summon300 != 0 && this.getTarget() != null) 
        {
            --this.summon300;
        }
        if(this.summon200 != 0 && this.getTarget() != null)
        {
            --this.summon200;
        }
        if(this.getHealth() == 1.0F && !this.summoned)
        {
            EntitySandGolem entitywitherskull6 = new EntitySandGolem(EWEntities.SAND_GOLEM.get(), this.level);
            entitywitherskull6.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            entitywitherskull6.setTarget(this.getTarget());
            EWUtil.spawnInWorld(this.level, entitywitherskull6);
            this.startRiding(entitywitherskull6);
            this.summoned = true;
        }
        if(this.getTarget() != null) 
        {
            if(this.summon300 == 0) 
            {
                EntityFireBat firebat1 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                firebat1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                firebat1.setTarget(this.getTarget());
                EntityFireBat firebat2 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                firebat2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                firebat2.setTarget(this.getTarget());
                EntityFireBat firebat3 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                firebat3.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                firebat3.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, firebat1);
                EWUtil.spawnInWorld(this.level, firebat2);
                EWUtil.spawnInWorld(this.level, firebat3);
                int xx = (int)Math.floor(this.getTarget().getX());
                int yy = (int)Math.floor(this.getTarget().getY());
                int zz = (int)Math.floor(this.getTarget().getZ());
                EntityBlock block1 = new EntityBlock(this.level, xx, yy + 3, zz, Blocks.SANDSTONE);
                EntityBlock block2 = new EntityBlock(this.level, xx, yy + 3, zz + 1, Blocks.SANDSTONE);
                EntityBlock block3 = new EntityBlock(this.level, xx, yy + 3, zz - 1, Blocks.SANDSTONE);
                EntityBlock block4 = new EntityBlock(this.level, xx + 1, yy + 3, zz, Blocks.SANDSTONE);
                EntityBlock block5 = new EntityBlock(this.level, xx - 1, yy + 3, zz, Blocks.SANDSTONE);
                EntityBlock block6 = new EntityBlock(this.level, xx - 1, yy + 3, zz + 1, Blocks.SANDSTONE);
                EntityBlock block7 = new EntityBlock(this.level, xx - 1, yy + 3, zz - 1, Blocks.SANDSTONE);
                EntityBlock block8 = new EntityBlock(this.level, xx + 1, yy + 3, zz + 1, Blocks.SANDSTONE);
                EntityBlock block9 = new EntityBlock(this.level, xx + 1, yy + 3, zz - 1, Blocks.SANDSTONE);
                this.level.addFreshEntity(block1);
                this.level.addFreshEntity(block2);
                this.level.addFreshEntity(block3);
                this.level.addFreshEntity(block4);
                this.level.addFreshEntity(block5);
                this.level.addFreshEntity(block6);
                this.level.addFreshEntity(block7);
                this.level.addFreshEntity(block8);
                this.level.addFreshEntity(block9);
                EntityBlock block10 = new EntityBlock(this.level, xx, yy + 4, zz, Blocks.SANDSTONE);
                EntityBlock block11 = new EntityBlock(this.level, xx, yy + 4, zz + 1, Blocks.SANDSTONE);
                EntityBlock block12 = new EntityBlock(this.level, xx, yy + 4, zz - 1, Blocks.SANDSTONE);
                EntityBlock block13 = new EntityBlock(this.level, xx + 1, yy + 4, zz, Blocks.SANDSTONE);
                EntityBlock block14 = new EntityBlock(this.level, xx - 1, yy + 4, zz, Blocks.SANDSTONE);
                EntityBlock block15 = new EntityBlock(this.level, xx - 1, yy + 4, zz + 1, Blocks.SANDSTONE);
                EntityBlock block16 = new EntityBlock(this.level, xx - 1, yy + 4, zz - 1, Blocks.SANDSTONE);
                EntityBlock block17 = new EntityBlock(this.level, xx + 1, yy + 4, zz + 1, Blocks.SANDSTONE);
                EntityBlock block18 = new EntityBlock(this.level, xx + 1, yy + 4, zz - 1, Blocks.SANDSTONE);
                this.level.addFreshEntity(block10);
                this.level.addFreshEntity(block11);
                this.level.addFreshEntity(block12);
                this.level.addFreshEntity(block13);
                this.level.addFreshEntity(block14);
                this.level.addFreshEntity(block15);
                this.level.addFreshEntity(block16);
                this.level.addFreshEntity(block17);
                this.level.addFreshEntity(block18);
                EntityBlock block19 = new EntityBlock(this.level, xx, yy + 5, zz, Blocks.SANDSTONE);
                EntityBlock block20 = new EntityBlock(this.level, xx, yy + 5, zz + 1, Blocks.SANDSTONE);
                EntityBlock block21 = new EntityBlock(this.level, xx, yy + 5, zz - 1, Blocks.SANDSTONE);
                EntityBlock block22 = new EntityBlock(this.level, xx + 1, yy + 5, zz, Blocks.SANDSTONE);
                EntityBlock block23 = new EntityBlock(this.level, xx - 1, yy + 5, zz, Blocks.SANDSTONE);
                EntityBlock block24 = new EntityBlock(this.level, xx - 1, yy + 5, zz + 1, Blocks.SANDSTONE);
                EntityBlock block25 = new EntityBlock(this.level, xx - 1, yy + 5, zz - 1, Blocks.SANDSTONE);
                EntityBlock block26 = new EntityBlock(this.level, xx + 1, yy + 5, zz + 1, Blocks.SANDSTONE);
                EntityBlock block27 = new EntityBlock(this.level, xx + 1, yy + 5, zz - 1, Blocks.SANDSTONE);
                this.level.addFreshEntity(block19);
                this.level.addFreshEntity(block20);
                this.level.addFreshEntity(block21);
                this.level.addFreshEntity(block22);
                this.level.addFreshEntity(block23);
                this.level.addFreshEntity(block24);
                this.level.addFreshEntity(block25);
                this.level.addFreshEntity(block26);
                this.level.addFreshEntity(block27);
                EntityAirClone airClone1 = new EntityAirClone(EWEntities.AIR_CLONE.get(), this.level);
                airClone1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                EntityAirClone airClone2 = new EntityAirClone(EWEntities.AIR_CLONE.get(), this.level);
                airClone2.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                airClone1.setTarget(this.getTarget());
                airClone1.setHealth(this.getHealth());
                EWUtil.spawnInWorld(this.level, airClone1);
                airClone2.setTarget(this.getTarget());
                airClone2.setHealth(this.getHealth());
                EWUtil.spawnInWorld(this.level, airClone2);
                EntityLightningGolem lightningGolem1 = new EntityLightningGolem(EWEntities.LIGHTNING_GOLEM.get(), this.level);
                lightningGolem1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                lightningGolem1.setTarget(this.getTarget());
                EntityLightningGolem lightningGolem2 = new EntityLightningGolem(EWEntities.LIGHTNING_GOLEM.get(), this.level);
                lightningGolem2.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                lightningGolem2.setTarget(this.getTarget());
                LightningBolt lightningBolt1 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                lightningBolt1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                LightningBolt lightningBolt2 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                lightningBolt2.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, lightningGolem1);
                EWUtil.spawnInWorld(this.level, lightningGolem2);
                EWUtil.spawnInWorld(this.level, lightningBolt1);
                EWUtil.spawnInWorld(this.level, lightningBolt2);
                for(int i = 0; i <= 60; ++i)
                {
                    EntityLightArrow entitywitherskull7 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                    entitywitherskull7.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 15.0 - 10.0, this.getY() + 40.0, this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 15.0 - 10.0, 0.0F, 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull7);
                    EntityLightArrow entityLightArrow = entitywitherskull7;
                    entityLightArrow.setDeltaMovement(entityLightArrow.getDeltaMovement().subtract(0, 1, 0));
                }
                this.summon300 = 120;
            }
            if(this.summon200 == 0) 
            {
                LargeFireball entitywitherskull8 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull9 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull10 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull11 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull12 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull13 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull14 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull15 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull16 = new LargeFireball(EntityType.FIREBALL, this.level);
                entitywitherskull8.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull9.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull10.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull11.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull12.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull13.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull14.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull15.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull16.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull8);
                EWUtil.spawnInWorld(this.level, entitywitherskull9);
                EWUtil.spawnInWorld(this.level, entitywitherskull10);
                EWUtil.spawnInWorld(this.level, entitywitherskull11);
                EWUtil.spawnInWorld(this.level, entitywitherskull12);
                EWUtil.spawnInWorld(this.level, entitywitherskull13);
                EWUtil.spawnInWorld(this.level, entitywitherskull14);
                EWUtil.spawnInWorld(this.level, entitywitherskull15);
                EWUtil.spawnInWorld(this.level, entitywitherskull16);
                entitywitherskull8.setDeltaMovement(entitywitherskull8.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull9.setDeltaMovement(entitywitherskull9.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull10.setDeltaMovement(entitywitherskull10.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull11.setDeltaMovement(entitywitherskull11.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull12.setDeltaMovement(entitywitherskull12.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull13.setDeltaMovement(entitywitherskull13.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull14.setDeltaMovement(entitywitherskull14.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull15.setDeltaMovement(entitywitherskull15.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull16.setDeltaMovement(entitywitherskull16.getDeltaMovement().subtract(0, 5.0, 0));
                EntityDarkSummoner darkSummoner = new EntityDarkSummoner(EWEntities.DARK_SUMMONER.get(), this.level);
                darkSummoner.moveTo(this.getX() + this.random.nextInt(5), this.getY(), this.getZ() + this.random.nextInt(5), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, darkSummoner);
                darkSummoner.setTarget(this.getTarget());
                darkSummoner.setTarget(this.getTarget());
                this.summon200 = 70;
            }
            if(this.summon600 == 0) 
            {
            	BlockPos pos = new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() - 1, (int)this.getTarget().getZ());
                if(this.getTarget() instanceof LivingEntity && !this.level.getBlockState(pos).isAir() && this.level.getBlockState(pos) != Blocks.LAVA.defaultBlockState() && !this.getTarget().isInWater())
                {
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                }
                EntitySandMinion entitywitherskull17 = new EntitySandMinion(EWEntities.SAND_MINION.get(), this.level);
                entitywitherskull17.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull17.setTarget(this.getTarget());
                EntitySandMinion entitywitherskull18 = new EntitySandMinion(EWEntities.SAND_MINION.get(), this.level);
                entitywitherskull18.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull18.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull17);
                EWUtil.spawnInWorld(this.level, entitywitherskull18);
                EntityMiniTornado miniTornado1 = new EntityMiniTornado(EWEntities.MINI_TORNADO.get(), this.level);
                miniTornado1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                miniTornado1.startRiding(this.getTarget());
                EWUtil.spawnInWorld(this.level, miniTornado1);
                EntitySandMark darkMark = new EntitySandMark(EWEntities.SAND_MARK.get(), this.level);
                darkMark.setOwner(this);
                darkMark.moveTo(this.getX(), this.getY() + 3.0, this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, darkMark);
                darkMark.setTarget(this.getTarget());
                darkMark.setTarget(this.getTarget());
                double xx2 = this.getTarget().getX();
                double yy2 = this.getTarget().getY();
                double zz2 = this.getTarget().getZ();
                LightningBolt lightningBolt3 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                lightningBolt3.moveTo(xx2, yy2 + 1.0, zz2, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, lightningBolt3);
                if(!this.level.getBlockState(pos).isAir()) 
                {
                    EntityWaterSpout waterSpout1 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout1.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout2 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout2.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout3 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout3.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout4 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout3.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout5 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout5.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout6 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout6.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout7 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout7.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout8 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout8.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                    EntityWaterSpout waterSpout9 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                    waterSpout9.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                    EWUtil.spawnInWorld(this.level, waterSpout1);
                    EWUtil.spawnInWorld(this.level, waterSpout2);
                    EWUtil.spawnInWorld(this.level, waterSpout3);
                    EWUtil.spawnInWorld(this.level, waterSpout4);
                    EWUtil.spawnInWorld(this.level, waterSpout5);
                    EWUtil.spawnInWorld(this.level, waterSpout6);
                    EWUtil.spawnInWorld(this.level, waterSpout7);
                    EWUtil.spawnInWorld(this.level, waterSpout8);
                    EWUtil.spawnInWorld(this.level, waterSpout9);
                }
                this.summon600 = 150;
            }
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        super.aiStep();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        if(source.getEntity() instanceof LivingEntity && ((LivingEntity)source.getEntity()).getMainHandItem().getItem() instanceof ShovelItem) 
        {
            return super.hurt(source, 1.0F);
        }
    	if(source.isBypassInvul())
    	{
    		return super.hurt(source, damage);
    	}
        return super.hurt(source, 0.0F);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killsandwitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchSummon600", this.summon600);
        compound.putInt("WitchSummon300", this.summon300);
        compound.putInt("WitchSummon200", this.summon200);
        compound.putBoolean("WitchDeathSummonedSand", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summon600 = compound.getInt("WitchSummon600");
        this.summon200 = compound.getInt("WitchSummon200");
        this.summon300 = compound.getInt("WitchSummon300");
        this.summoned = compound.getBoolean("WitchDeathSummonedSand");
    }
    
    protected Item getDropItem()
    {
        return EWItems.SAND_SHARD.get();
    }
    
    @Override
    public boolean removeWhenFarAway(double p_37894_)
    {
    	return false;
    }
}
