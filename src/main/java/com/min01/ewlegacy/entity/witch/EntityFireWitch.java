package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityFireEgg;
import com.min01.ewlegacy.entity.skill.EntityFireBat;
import com.min01.ewlegacy.entity.skill.EntityFireMeteorite;
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
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class EntityFireWitch extends Raider implements RangedAttackMob
{
    int summonFireRain = 200;
    int summonFireBat = 300;
    int summonLava = 600;
    boolean deathSummon = false;
    boolean summoned = false;
    
    public EntityFireWitch(EntityType<? extends Raider> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        if(EWConfig.fireWitchVsWaterWitch.get()) 
        {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityWaterWitch.class, true));
        }
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
        if(this.summonLava != 0 && this.getTarget() != null)
        {
            --this.summonLava;
        }
        if(this.summonFireBat != 0 && this.getTarget() != null) 
        {
            --this.summonFireBat;
        }
        if(this.summonFireRain != 0 && this.getTarget() != null)
        {
            --this.summonFireRain;
        }
        if(this.getHealth() < 30.0F)
        {
            this.deathSummon = true;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("fire_main", this);
        if(this.getTarget() != null) 
        {
            if(this.summonFireBat == 0) 
            {
                EntityFireBat entitywitherskull1 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull1.setTarget(this.getTarget());
                EntityFireBat entitywitherskull2 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull2.setTarget(this.getTarget());
                EntityFireBat entitywitherskull3 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull3.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                this.summonFireBat = 300;
            }
            if(this.deathSummon && !this.summoned) 
            {
                EntityFireMeteorite entitywitherskull4 = new EntityFireMeteorite(EWEntities.FIRE_METEORITE.get(), this.level);
                entitywitherskull4.setOwner(this);
                entitywitherskull4.moveTo(this.getTarget().getX(), this.getTarget().getY() + 99.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                for(int i = 0; i < 10; ++i) 
                {
                    EntityFireBat entitywitherskull5 = new EntityFireBat(EWEntities.FIRE_BAT.get(), this.level);
                    entitywitherskull5.setOwner(this);
                    entitywitherskull5.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                    entitywitherskull5.setTarget(this.getTarget());
                    EWUtil.spawnInWorld(this.level, entitywitherskull5);
                }
                this.summoned = true;
            }
            if(this.summonFireRain == 0)
            {
                LargeFireball entitywitherskull6 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull7 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull8 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull9 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull10 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull11 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull12 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull13 = new LargeFireball(EntityType.FIREBALL, this.level);
                LargeFireball entitywitherskull14 = new LargeFireball(EntityType.FIREBALL, this.level);
                entitywitherskull6.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull7.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull8.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull9.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull10.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull11.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull12.moveTo(this.getTarget().getX() - 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull13.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull14.moveTo(this.getTarget().getX() + 1.0, this.getTarget().getY() + 20.0, this.getTarget().getZ() - 1.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull6);
                EWUtil.spawnInWorld(this.level, entitywitherskull7);
                EWUtil.spawnInWorld(this.level, entitywitherskull8);
                EWUtil.spawnInWorld(this.level, entitywitherskull9);
                EWUtil.spawnInWorld(this.level, entitywitherskull10);
                EWUtil.spawnInWorld(this.level, entitywitherskull11);
                EWUtil.spawnInWorld(this.level, entitywitherskull12);
                EWUtil.spawnInWorld(this.level, entitywitherskull13);
                EWUtil.spawnInWorld(this.level, entitywitherskull14);
                entitywitherskull6.setDeltaMovement(entitywitherskull6.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull7.setDeltaMovement(entitywitherskull7.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull8.setDeltaMovement(entitywitherskull8.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull9.setDeltaMovement(entitywitherskull9.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull10.setDeltaMovement(entitywitherskull10.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull11.setDeltaMovement(entitywitherskull11.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull12.setDeltaMovement(entitywitherskull12.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull13.setDeltaMovement(entitywitherskull13.getDeltaMovement().subtract(0, 5.0, 0));
                entitywitherskull14.setDeltaMovement(entitywitherskull14.getDeltaMovement().subtract(0, 5.0, 0));
                this.summonFireRain = 200;
            }
            if(this.summonLava == 0)
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
                this.summonLava = 600;
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
        for(int i = 0; i < 5; ++i) 
        {
            this.performRangedAttack(0, p_33317_);
            this.level.levelEvent(null, 1009, this.blockPosition(), 0);
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
        SmallFireball entitywitherskull = new SmallFireball(this.level, this, d6, d7, d8);
        entitywitherskull.setPos(d3, d4 + 0.5, d5);
        EWUtil.spawnInWorld(this.level, entitywitherskull);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killfirewitch, 1);
            }
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityFireMeteorite) && !(source.getEntity() instanceof SmallFireball) && !(source.getEntity() instanceof LargeFireball) && super.hurt(source, damage);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchSummonLava", this.summonLava);
        compound.putInt("WitchSummonFireBat", this.summonFireBat);
        compound.putInt("WitchSummonFireRain", this.summonFireRain);
        compound.putBoolean("WitchDeathSummonFire", this.deathSummon);
        compound.putBoolean("WitchDeathSummonedFire", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summonLava = compound.getInt("WitchSummonLava");
        this.summonFireRain = compound.getInt("WitchSummonFireRain");
        this.summonFireBat = compound.getInt("WitchSummonFireBat");
        this.deathSummon = compound.getBoolean("WitchDeathSummonFire");
        this.summoned = compound.getBoolean("WitchDeathSummonedFire");
    }
    
    protected Item getDropItem() 
    {
        return EWItems.FIRE_SHARD.get();
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
        	EntityFireEgg mob = new EntityFireEgg(EWEntities.FIRE_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.firepet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
