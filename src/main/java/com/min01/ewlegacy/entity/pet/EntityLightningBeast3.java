package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityLightningEgg;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWSounds;
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
import net.minecraft.world.entity.LightningBolt;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityLightningBeast3 extends TamableAnimal
{
    public static final float[][] RAINBOW_COLOR_TABLE = new float[][] { { 1.0F, 1.0F, 1.0F }, { 0.85F, 0.5F, 0.2F }, { 0.7F, 0.3F, 0.85F }, { 0.4F, 0.6F, 0.85F }, { 0.9F, 0.9F, 0.2F }, { 0.5F, 0.8F, 0.1F }, { 0.95F, 0.5F, 0.65F }, { 0.3F, 0.3F, 0.3F }, { 0.6F, 0.6F, 0.6F }, { 0.3F, 0.5F, 0.6F }, { 0.5F, 0.25F, 0.7F }, { 0.2F, 0.3F, 0.7F }, { 0.4F, 0.3F, 0.2F }, { 0.4F, 0.5F, 0.2F }, { 0.6F, 0.2F, 0.2F }, { 0.1F, 0.1F, 0.1F } };
    public int deathTicks;
    public int goldenTicks;
    public int skillTimer = 100;
    public int skill2Timer = 300;
    public boolean goldenTicksActivate = false;
    
    public EntityLightningBeast3(EntityType<? extends TamableAnimal> type, Level level) 
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityLightningBeast3.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.6);
    }
    
    @Override
    public void travel(Vec3 vec3) 
    {
        if(this.getFirstPassenger() != null && this.getFirstPassenger() instanceof Player)
        {
        	LivingEntity livingentity = (LivingEntity) this.getFirstPassenger();
            this.setYRot(livingentity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(livingentity.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.yBodyRot;
            float f = livingentity.xxa * 0.5F;
            float f1 = livingentity.zza;
            if(f1 <= 0.0F)
            {
            	f1 *= 0.25F;
            }
            if(!this.level.isClientSide) 
            {
                this.setSpeed((float)this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                super.travel(new Vec3((double)f, vec3.y, (double)f1));
            }
            this.calculateEntityAnimation(this, false);
        }
        else
        {
            this.flyingSpeed = 0.02F;
            super.travel(vec3);
        }
    }
    
    @Override
    public void aiStep() 
    {
        if(!this.onGround && this.getDeltaMovement().y < 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.9, 1));
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("lightning_normal", this);
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 3.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        if(this.skillTimer != 0 && this.getTarget() != null)
        {
            --this.skillTimer;
        }
        if(this.skill2Timer != 0 && this.getTarget() != null) 
        {
            --this.skill2Timer;
        }
        if(this.getTarget() != null)
        {
            if(this.skillTimer == 0) 
            {
                this.getTarget().addEffect(new MobEffectInstance(EWEffects.PARALYZE.get(), 40, 1));
                this.getTarget().playSound(EWSounds.LIGHTNING.get(), 2.0F, 0.6F);
                this.skillTimer = 300;
            }
            if(this.skill2Timer == 0) 
            {
                LightningBolt entitywitherskull1 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull1.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull2 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull2.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull3 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull3.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull4 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull4.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull5 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull5.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull6 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull6.moveTo(this.getTarget().getX() - 3.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull7 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull7.moveTo(this.getTarget().getX() + 3.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull8 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull8.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull9 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull9.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull10 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull10.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                LightningBolt entitywitherskull11 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull11.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull12 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull12.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull13 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull13.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull14 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull14.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull15 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull15.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() - 3.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull16 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull16.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() + 3.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull17 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull17.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull18 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull18.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull19 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull19.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull20 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull20.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull21 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull21.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull22 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull22.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull23 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull23.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull24 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull24.moveTo(this.getTarget().getX() + 3.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull25 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull25.moveTo(this.getTarget().getX() - 3.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull26 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull26.moveTo(this.getTarget().getX() + 4.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull27 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull27.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull28 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull28.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                LightningBolt entitywitherskull29 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull29.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull30 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull30.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull31 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull31.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull32 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull32.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull33 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull33.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() - 3.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull34 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull34.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() + 3.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull35 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull35.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() - 4.0, this.getYRot(), 0.0F);
                LightningBolt entitywitherskull36 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                entitywitherskull36.moveTo(this.getTarget().getX() - 4.0, this.getTarget().getY(), this.getTarget().getZ() + 4.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                EWUtil.spawnInWorld(this.level, entitywitherskull5);
                EWUtil.spawnInWorld(this.level, entitywitherskull6);
                EWUtil.spawnInWorld(this.level, entitywitherskull7);
                EWUtil.spawnInWorld(this.level, entitywitherskull10);
                EWUtil.spawnInWorld(this.level, entitywitherskull11);
                EWUtil.spawnInWorld(this.level, entitywitherskull12);
                EWUtil.spawnInWorld(this.level, entitywitherskull13);
                EWUtil.spawnInWorld(this.level, entitywitherskull14);
                EWUtil.spawnInWorld(this.level, entitywitherskull15);
                EWUtil.spawnInWorld(this.level, entitywitherskull16);
                EWUtil.spawnInWorld(this.level, entitywitherskull19);
                EWUtil.spawnInWorld(this.level, entitywitherskull20);
                EWUtil.spawnInWorld(this.level, entitywitherskull21);
                EWUtil.spawnInWorld(this.level, entitywitherskull22);
                EWUtil.spawnInWorld(this.level, entitywitherskull23);
                EWUtil.spawnInWorld(this.level, entitywitherskull24);
                EWUtil.spawnInWorld(this.level, entitywitherskull25);
                EWUtil.spawnInWorld(this.level, entitywitherskull26);
                EWUtil.spawnInWorld(this.level, entitywitherskull27);
                EWUtil.spawnInWorld(this.level, entitywitherskull28);
                EWUtil.spawnInWorld(this.level, entitywitherskull29);
                EWUtil.spawnInWorld(this.level, entitywitherskull30);
                EWUtil.spawnInWorld(this.level, entitywitherskull31);
                EWUtil.spawnInWorld(this.level, entitywitherskull32);
                EWUtil.spawnInWorld(this.level, entitywitherskull33);
                EWUtil.spawnInWorld(this.level, entitywitherskull34);
                EWUtil.spawnInWorld(this.level, entitywitherskull35);
                EWUtil.spawnInWorld(this.level, entitywitherskull36);
                EWUtil.spawnInWorld(this.level, entitywitherskull17);
                EWUtil.spawnInWorld(this.level, entitywitherskull18);
                EWUtil.spawnInWorld(this.level, entitywitherskull8);
                EWUtil.spawnInWorld(this.level, entitywitherskull9);
                this.skill2Timer = 300;
            }
        }
        if(this.goldenTicksActivate)
        {
            ++this.goldenTicks;
            List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
            if(this.goldenTicks == 1) 
            {
                this.level.getLevelData().setRaining(true);
                if(!this.level.isClientSide)
                {
                	((ServerLevel) this.level).setWeatherParameters(0, 0, true, true);
                }
            }
            if(this.goldenTicks >= 0 && this.goldenTicks <= 140)
            {
                for(int i = 0; i <= 60; ++i)
                {
                    if(i % 30 == 0) 
                    {
                        LightningBolt entitywitherskull37 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                        entitywitherskull37.moveTo(this.getX() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, this.getY(), this.getZ() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, 0.0F, 0.0F);
                        EWUtil.spawnInWorld(this.level, entitywitherskull37);
                    }
                }
                for(int i = 1; i <= 2; ++i) 
                {
                    ElementalWitchesLegacy.PROXY.spawnParticles("lightning_circle_small", this);
                }
                for(Entity entity1 : list) 
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityLightningBeast3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityLightningBeast2) && !(entity1 instanceof EntityLightningBeast))
                    {
                        if(!(entity1 instanceof EntityLightningEgg)) 
                        {
                            if(entity1 instanceof LivingEntity)
                            {
                                ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.PARALYZE.get(), 200000, 1));
                            }
                        }
                    }
                }
            }
            if(this.goldenTicks == 140)
            {
                for(Entity entity1 : list)
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityLightningBeast3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityLightningBeast2))
                    {
                        if(!(entity1 instanceof EntityLightningBeast))
                        {
                            double xx = entity1.getX();
                            double yy = entity1.getY();
                            double zz = entity1.getZ();
                            LightningBolt entitywitherskull38 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                            entitywitherskull38.moveTo(xx, yy, zz, this.getYRot(), 0.0F);
                            EWUtil.spawnInWorld(this.level, entitywitherskull38);
                        }
                    }
                }
                this.goldenTicksActivate = false;
                this.goldenTicks = 0;
            }
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath() 
    {
        ++this.deathTicks;
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(this.deathTicks == 1) 
        {
            this.level.getLevelData().setRaining(true);
            if(!this.level.isClientSide)
            {
            	((ServerLevel) this.level).setWeatherParameters(0, 0, true, true);
            }
        }
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            for(int i = 0; i <= 60; ++i)
            {
                if(i % 30 == 0)
                {
                    LightningBolt entitywitherskull = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                    entitywitherskull.moveTo(this.getX() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, this.getY(), this.getZ() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, 0.0F, 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull);
                }
            }
            for(int i = 1; i <= 2; ++i) 
            {
                ElementalWitchesLegacy.PROXY.spawnParticles("lightning_circle_small", this);
            }
            for(Entity entity1 : list) 
            {
                if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityLightningBeast3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityLightningBeast2) && !(entity1 instanceof EntityLightningBeast)) 
                {
                    if(!(entity1 instanceof EntityLightningEgg))
                    {
                        if(entity1 instanceof LivingEntity)
                        {
                            ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.PARALYZE.get(), 200000, 1));
                        }
                    }
                }
            }
        }
        if(this.deathTicks == 140)
        {
            EntityLightningEgg mob = new EntityLightningEgg(EWEntities.LIGHTNING_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            if(this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setCustomNameVisible(true);
            for(Entity entity2 : list)
            {
                if((!(entity2 instanceof Player) || !((Player)entity2).getAbilities().instabuild) && !(entity2 instanceof EntityLightningBeast3) && (!(entity2 instanceof Player) || this.getOwner() == null || entity2 != this.getOwner()) && !(entity2 instanceof EntityLightningBeast2)) 
                {
                    if(!(entity2 instanceof EntityLightningBeast)) 
                    {
                        double xx = entity2.getX();
                        double yy = entity2.getY();
                        double zz = entity2.getZ();
                        LightningBolt entitywitherskull2 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                        entitywitherskull2.moveTo(xx, yy, zz, this.getYRot(), 0.0F);
                        EWUtil.spawnInWorld(this.level, entitywitherskull2);
                    }
                }
            }
            this.discard();
        }
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        Random rand = new Random();
        int form = rand.nextInt(100);
        if(form <= 18) 
        {
            LightningBolt entity = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
            entity.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 0.0F, 0.0F);
            EWUtil.spawnInWorld(this.level, entity);
            target.hurt(DamageSource.mobAttack(this), 5.0F);
            return true;
        }
        return target.hurt(DamageSource.mobAttack(this), 8.0F);
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof LightningBolt) && super.hurt(source, damage);
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
            if(target instanceof EntityLightningBeast3) 
            {
            	EntityLightningBeast3 entitywolf = (EntityLightningBeast3) target;
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
        if(p_27584_.isShiftKeyDown())
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
            if(p_27584_.isHolding(Items.GOLDEN_APPLE) && !this.goldenTicksActivate) 
            {
                this.goldenTicksActivate = true;
                if(!p_27584_.getAbilities().instabuild)
                {
                    ItemStack getHeldItem = p_27584_.getItemInHand(p_27585_);
                    getHeldItem.shrink(1);
                }
            }
        }
        else if(this.isTame() && !this.isVehicle()) 
        {
        	p_27584_.startRiding(this);
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("PetSkillTimerLightning", this.skillTimer);
        compound.putInt("PetSkill2TimerLightning", this.skill2Timer);
        compound.putInt("PetDeathTicks", this.deathTicks);
        compound.putInt("PetGoldenTick", this.goldenTicks);
        compound.putBoolean("PetGoldenTickBoolean", this.goldenTicksActivate);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.skillTimer = compound.getInt("PetSkillTimerLightning");
        this.skill2Timer = compound.getInt("PetSkill2TimerLightning");
        this.deathTicks = compound.getInt("PetDeathTicks");
        this.goldenTicksActivate = compound.getBoolean("PetGoldenTickBoolean");
        this.goldenTicks = compound.getInt("PetGoldenTick");
    }
}
