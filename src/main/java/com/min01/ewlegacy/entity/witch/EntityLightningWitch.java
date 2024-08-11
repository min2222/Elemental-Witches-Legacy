package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityLightningEgg;
import com.min01.ewlegacy.entity.projectile.EntityLightningBall;
import com.min01.ewlegacy.entity.projectile.EntityLightningShoot;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
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
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityLightningWitch extends Raider implements RangedAttackMob
{
    int timer = 52;
    int summonLightningBall = 200;
    int summonGolem = 300;
    int summonLightning = 600;
    
    public EntityLightningWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
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
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 80.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public void aiStep()
    {
        if(this.summonGolem != 0 && this.getTarget() != null)
        {
            --this.summonGolem;
        }
        if(this.summonLightning != 0 && this.getTarget() != null) 
        {
            --this.summonLightning;
        }
        if(this.summonLightningBall != 0 && this.getTarget() != null)
        {
            --this.summonLightningBall;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("lightning_normal", this);
        if(this.getTarget() != null)
        {
            if(this.summonGolem == 0) 
            {
                EntityLightningGolem entitywitherskull1 = new EntityLightningGolem(EWEntities.LIGHTNING_GOLEM.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull1.setTarget(this.getTarget());
                EntityLightningGolem entitywitherskull2 = new EntityLightningGolem(EWEntities.LIGHTNING_GOLEM.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull2.setTarget(this.getTarget());
                LightningBolt entitywitherskull3 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull4 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull4.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                this.summonGolem = 300;
            }
            if(this.summonLightning == 0) 
            {
                double xx = this.getTarget().getX();
                double yy = this.getTarget().getY();
                double zz = this.getTarget().getZ();
                LightningBolt entitywitherskull5 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull5.moveTo(xx, yy + 1.0, zz, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull5);
                this.summonLightning = 600;
            }
            if(!this.level.isThundering()) 
            {
                this.level.getLevelData().setRaining(true);
                if(!this.level.isClientSide)
                {
                	((ServerLevel) this.level).setWeatherParameters(0, 0, true, true);
                }
            }
            if(this.getHealth() <= 30.0F) 
            {
                --this.timer;
                if(this.timer == 50) 
                {
                    LightningBolt entitywitherskull6 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull6.moveTo(this.getX(), this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull7 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull7.moveTo(this.getX() - 1.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull8 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull8.moveTo(this.getX() + 1.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull9 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull9.moveTo(this.getX() + 2.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull10 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull10.moveTo(this.getX() + 2.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull11 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull11.moveTo(this.getX() + 2.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull12 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull6.moveTo(this.getX(), this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull13 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull7.moveTo(this.getX() - 1.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull14 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull8.moveTo(this.getX() + 1.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull15 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull15.moveTo(this.getX() - 2.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull16 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull16.moveTo(this.getX() - 2.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull17 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull17.moveTo(this.getX() - 2.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull6);
                    EWUtil.spawnInWorld(this.level, entitywitherskull7);
                    EWUtil.spawnInWorld(this.level, entitywitherskull8);
                    EWUtil.spawnInWorld(this.level, entitywitherskull9);
                    EWUtil.spawnInWorld(this.level, entitywitherskull10);
                    EWUtil.spawnInWorld(this.level, entitywitherskull11);
                    EWUtil.spawnInWorld(this.level, entitywitherskull12);
                    EWUtil.spawnInWorld(this.level, entitywitherskull13);
                    EWUtil.spawnInWorld(this.level, entitywitherskull14);
                    EWUtil.spawnInWorld(this.level, entitywitherskull15);
                    EWUtil.spawnInWorld(this.level, entitywitherskull16);
                    EWUtil.spawnInWorld(this.level, entitywitherskull17);
                }
                else if(this.timer == 25) 
                {
                    LightningBolt entitywitherskull6 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull6.moveTo(this.getX(), this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull7 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull7.moveTo(this.getX() - 1.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull8 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull8.moveTo(this.getX() + 1.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull9 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull9.moveTo(this.getX() - 2.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull10 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull10.moveTo(this.getX() + 2.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull11 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull11.moveTo(this.getX() - 3.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull12 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull12.moveTo(this.getX() + 3.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull18 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull18.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull19 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull19.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull20 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull20.moveTo(this.getX() + 4.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull21 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull21.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull22 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull22.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull23 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull23.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull24 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull24.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull25 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull25.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull26 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull26.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull27 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull27.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull28 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull28.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull29 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull29.moveTo(this.getX(), this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull30 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull30.moveTo(this.getX() - 1.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull31 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull31.moveTo(this.getX() + 1.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull32 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull32.moveTo(this.getX() + 2.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull33 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull33.moveTo(this.getX() - 2.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull34 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull34.moveTo(this.getX() + 3.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull35 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull35.moveTo(this.getX() - 3.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull36 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull36.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull37 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull37.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull38 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull38.moveTo(this.getX() - 4.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull39 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull39.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull40 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull40.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull41 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull41.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull42 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull42.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull43 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull43.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull44 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull44.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull45 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull45.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull46 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull46.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull6);
                    EWUtil.spawnInWorld(this.level, entitywitherskull7);
                    EWUtil.spawnInWorld(this.level, entitywitherskull8);
                    EWUtil.spawnInWorld(this.level, entitywitherskull9);
                    EWUtil.spawnInWorld(this.level, entitywitherskull10);
                    EWUtil.spawnInWorld(this.level, entitywitherskull11);
                    EWUtil.spawnInWorld(this.level, entitywitherskull12);
                    EWUtil.spawnInWorld(this.level, entitywitherskull20);
                    EWUtil.spawnInWorld(this.level, entitywitherskull21);
                    EWUtil.spawnInWorld(this.level, entitywitherskull22);
                    EWUtil.spawnInWorld(this.level, entitywitherskull23);
                    EWUtil.spawnInWorld(this.level, entitywitherskull24);
                    EWUtil.spawnInWorld(this.level, entitywitherskull25);
                    EWUtil.spawnInWorld(this.level, entitywitherskull26);
                    EWUtil.spawnInWorld(this.level, entitywitherskull29);
                    EWUtil.spawnInWorld(this.level, entitywitherskull30);
                    EWUtil.spawnInWorld(this.level, entitywitherskull31);
                    EWUtil.spawnInWorld(this.level, entitywitherskull32);
                    EWUtil.spawnInWorld(this.level, entitywitherskull33);
                    EWUtil.spawnInWorld(this.level, entitywitherskull34);
                    EWUtil.spawnInWorld(this.level, entitywitherskull35);
                    EWUtil.spawnInWorld(this.level, entitywitherskull36);
                    EWUtil.spawnInWorld(this.level, entitywitherskull37);
                    EWUtil.spawnInWorld(this.level, entitywitherskull38);
                    EWUtil.spawnInWorld(this.level, entitywitherskull39);
                    EWUtil.spawnInWorld(this.level, entitywitherskull40);
                    EWUtil.spawnInWorld(this.level, entitywitherskull41);
                    EWUtil.spawnInWorld(this.level, entitywitherskull42);
                    EWUtil.spawnInWorld(this.level, entitywitherskull43);
                    EWUtil.spawnInWorld(this.level, entitywitherskull44);
                    EWUtil.spawnInWorld(this.level, entitywitherskull45);
                    EWUtil.spawnInWorld(this.level, entitywitherskull46);
                    EWUtil.spawnInWorld(this.level, entitywitherskull27);
                    EWUtil.spawnInWorld(this.level, entitywitherskull28);
                    EWUtil.spawnInWorld(this.level, entitywitherskull18);
                    EWUtil.spawnInWorld(this.level, entitywitherskull19);
                }
                else if(this.timer == 0) 
                {
                    LightningBolt entitywitherskull6 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull6.moveTo(this.getX(), this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull7 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull7.moveTo(this.getX() - 1.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull8 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull8.moveTo(this.getX() + 1.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull9 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull9.moveTo(this.getX() - 2.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull10 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull10.moveTo(this.getX() + 2.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull11 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull11.moveTo(this.getX() - 3.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull12 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull12.moveTo(this.getX() + 3.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull13 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull13.moveTo(this.getX() - 4.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull14 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull14.moveTo(this.getX() + 4.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull15 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull15.moveTo(this.getX() - 5.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull16 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull16.moveTo(this.getX() + 5.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull47 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull47.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull48 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull48.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull24 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull24.moveTo(this.getX() + 6.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull25 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull25.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull26 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull26.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull49 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull49.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull50 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull50.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull51 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull51.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull52 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull52.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull53 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull53.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull54 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull54.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull55 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull55.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 5.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull56 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull56.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 5.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull57 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull57.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull58 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull58.moveTo(this.getX() + 6.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull37 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull37.moveTo(this.getX(), this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull38 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull38.moveTo(this.getX() - 1.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull39 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull39.moveTo(this.getX() + 1.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull40 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull40.moveTo(this.getX() - 2.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull41 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull41.moveTo(this.getX() + 2.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull42 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull42.moveTo(this.getX() - 3.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull43 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull43.moveTo(this.getX() + 3.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull44 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull44.moveTo(this.getX() - 4.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull45 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull45.moveTo(this.getX() + 4.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull46 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull46.moveTo(this.getX() - 5.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull59 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull59.moveTo(this.getX() + 5.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull60 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull60.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull61 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull61.moveTo(this.getX() + 6.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull62 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull62.moveTo(this.getX() - 6.0, this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull63 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull63.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull64 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull64.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull65 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull65.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull66 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull66.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 2.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull67 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull67.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull68 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull68.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 3.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull69 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull69.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull70 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull70.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 4.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull71 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull71.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 5.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull72 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull72.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 5.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull73 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull73.moveTo(this.getX() - 6.0, this.getY(), this.getZ() - 6.0, this.getYRot(), 0.0F);
                    LightningBolt entitywitherskull74 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull74.moveTo(this.getX() - 6.0, this.getY(), this.getZ() + 6.0, this.getYRot(), 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull6);
                    EWUtil.spawnInWorld(this.level, entitywitherskull7);
                    EWUtil.spawnInWorld(this.level, entitywitherskull8);
                    EWUtil.spawnInWorld(this.level, entitywitherskull9);
                    EWUtil.spawnInWorld(this.level, entitywitherskull10);
                    EWUtil.spawnInWorld(this.level, entitywitherskull11);
                    EWUtil.spawnInWorld(this.level, entitywitherskull12);
                    EWUtil.spawnInWorld(this.level, entitywitherskull13);
                    EWUtil.spawnInWorld(this.level, entitywitherskull14);
                    EWUtil.spawnInWorld(this.level, entitywitherskull15);
                    EWUtil.spawnInWorld(this.level, entitywitherskull16);
                    EWUtil.spawnInWorld(this.level, entitywitherskull24);
                    EWUtil.spawnInWorld(this.level, entitywitherskull25);
                    EWUtil.spawnInWorld(this.level, entitywitherskull26);
                    EWUtil.spawnInWorld(this.level, entitywitherskull49);
                    EWUtil.spawnInWorld(this.level, entitywitherskull50);
                    EWUtil.spawnInWorld(this.level, entitywitherskull51);
                    EWUtil.spawnInWorld(this.level, entitywitherskull52);
                    EWUtil.spawnInWorld(this.level, entitywitherskull53);
                    EWUtil.spawnInWorld(this.level, entitywitherskull54);
                    EWUtil.spawnInWorld(this.level, entitywitherskull55);
                    EWUtil.spawnInWorld(this.level, entitywitherskull56);
                    EWUtil.spawnInWorld(this.level, entitywitherskull37);
                    EWUtil.spawnInWorld(this.level, entitywitherskull38);
                    EWUtil.spawnInWorld(this.level, entitywitherskull39);
                    EWUtil.spawnInWorld(this.level, entitywitherskull40);
                    EWUtil.spawnInWorld(this.level, entitywitherskull41);
                    EWUtil.spawnInWorld(this.level, entitywitherskull42);
                    EWUtil.spawnInWorld(this.level, entitywitherskull43);
                    EWUtil.spawnInWorld(this.level, entitywitherskull44);
                    EWUtil.spawnInWorld(this.level, entitywitherskull45);
                    EWUtil.spawnInWorld(this.level, entitywitherskull46);
                    EWUtil.spawnInWorld(this.level, entitywitherskull59);
                    EWUtil.spawnInWorld(this.level, entitywitherskull63);
                    EWUtil.spawnInWorld(this.level, entitywitherskull64);
                    EWUtil.spawnInWorld(this.level, entitywitherskull65);
                    EWUtil.spawnInWorld(this.level, entitywitherskull66);
                    EWUtil.spawnInWorld(this.level, entitywitherskull67);
                    EWUtil.spawnInWorld(this.level, entitywitherskull69);
                    EWUtil.spawnInWorld(this.level, entitywitherskull70);
                    EWUtil.spawnInWorld(this.level, entitywitherskull71);
                    EWUtil.spawnInWorld(this.level, entitywitherskull72);
                    EWUtil.spawnInWorld(this.level, entitywitherskull47);
                    EWUtil.spawnInWorld(this.level, entitywitherskull48);
                    EWUtil.spawnInWorld(this.level, entitywitherskull57);
                    EWUtil.spawnInWorld(this.level, entitywitherskull58);
                    EWUtil.spawnInWorld(this.level, entitywitherskull60);
                    EWUtil.spawnInWorld(this.level, entitywitherskull61);
                    EWUtil.spawnInWorld(this.level, entitywitherskull73);
                    EWUtil.spawnInWorld(this.level, entitywitherskull74);
                    this.timer = 52;
                }
            }
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        super.aiStep();
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
        if(this.summonLightningBall != 0)
        {
            for(int i = 0; i < 5; ++i) 
            {
                this.performRangedAttack(0, p_33317_);
            }
        }
        else 
        {
            this.performRangedAttack(0, p_33317_);
            this.summonLightningBall = 300;
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
        if(this.summonLightningBall != 0) 
        {
            EntityLightningShoot entitywitherskull = new EntityLightningShoot(this.level, this, d6, d7, d8);
            entitywitherskull.setPos(d3, d4 + 0.5, d5);
            EWUtil.spawnInWorld(this.level, entitywitherskull);
        }
        else 
        {
            EntityLightningBall entitywitherskull2 = new EntityLightningBall(this.level, this, d6, d7, d8);
            entitywitherskull2.setPos(d3, d4 + 0.5, d5);
            EWUtil.spawnInWorld(this.level, entitywitherskull2);
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof LightningBolt) && !(source.getEntity() instanceof EntityLightningBall) && !(source.getEntity() instanceof EntityLightningShoot) && super.hurt(source, damage);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchLightningTimer", this.timer);
        compound.putInt("WitchLightningSummonGolem", this.summonGolem);
        compound.putInt("WitchSummonLighting", this.summonLightning);
        compound.putInt("WitchSummonLightningBall", this.summonLightningBall);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.timer = compound.getInt("WitchLightningTimer");
        this.summonGolem = compound.getInt("WitchLightningSummonGolem");
        this.summonLightning = compound.getInt("WitchSummonLighting");
        this.summonLightningBall = compound.getInt("WitchSummonLightningBall");
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killlightningwitch, 1);
            }
        }
    }
    
    protected Item getDropItem() 
    {
        return EWItems.LIGHTNING_SHARD.get();
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
        	EntityLightningEgg mob = new EntityLightningEgg(EWEntities.LIGHTNING_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.lightningpet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
