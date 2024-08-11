package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityWaterEgg;
import com.min01.ewlegacy.entity.projectile.EntitySquidInkBomb;
import com.min01.ewlegacy.entity.projectile.EntityWaterShoot;
import com.min01.ewlegacy.entity.skill.EntityGiantSquid;
import com.min01.ewlegacy.entity.skill.EntityWaterMinion;
import com.min01.ewlegacy.entity.skill.EntityWaterSpout;
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
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;

public class EntityWaterWitch extends Raider implements RangedAttackMob
{
    int summonWaterMinion = 200;
    int summonWater = 300;
    int summonWaterSpout = 600;
    boolean deathSummon = false;
    boolean summoned = false;
    
    public EntityWaterWitch(EntityType<? extends Raider> type, Level level) 
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
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityFireWitch.class, true));
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
    public void aiStep()
    {
        if(this.isOnFire()) 
        {
            this.clearFire();
        }
        if(this.summonWater != 0 && this.getTarget() != null)
        {
            --this.summonWater;
        }
        if(this.summonWaterSpout != 0 && this.getTarget() != null)
        {
            --this.summonWaterSpout;
        }
        if(this.summonWaterMinion != 0 && this.getTarget() != null)
        {
            --this.summonWaterMinion;
        }
        if(this.getHealth() < 20.0f) {
            this.deathSummon = true;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("water_normal", this);
        if(this.summoned && this.isPassenger() && this.tickCount % 20 == 0 && this.getHealth() < this.getMaxHealth() && this.getHealth() >= 1.0F)
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.getTarget() != null)
        {
        	BlockPos pos = new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() - 1, (int)this.getTarget().getZ());
            if(this.summonWater == 0 && !this.level.getBlockState(pos).isAir() && this.level.getBlockState(pos) != Blocks.WATER.defaultBlockState() && !this.getTarget().isInWater())
            {
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 2, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ()), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() - 1), Blocks.WATER.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY() + 1, (int)this.getTarget().getZ() + 1), Blocks.WATER.defaultBlockState());
                this.summonWater = 300;
            }
            if(this.summonWaterSpout == 0 && !this.level.getBlockState(pos).isAir()) 
            {
                EntityWaterSpout entitywitherskull1 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull2 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull3 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull4 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull4.setOwner(this);
                entitywitherskull4.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() + 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull5 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull5.setOwner(this);
                entitywitherskull5.moveTo(this.getTarget().getX() + 2.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull6 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull6.setOwner(this);
                entitywitherskull6.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull7 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull7.setOwner(this);
                entitywitherskull7.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull8 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull8.setOwner(this);
                entitywitherskull8.moveTo(this.getTarget().getX() - 2.0, this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                EntityWaterSpout entitywitherskull9 = new EntityWaterSpout(EWEntities.WATER_SPOUT.get(), this.level);
                entitywitherskull9.setOwner(this);
                entitywitherskull9.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ() - 2.0, this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                EWUtil.spawnInWorld(this.level, entitywitherskull5);
                EWUtil.spawnInWorld(this.level, entitywitherskull6);
                EWUtil.spawnInWorld(this.level, entitywitherskull7);
                EWUtil.spawnInWorld(this.level, entitywitherskull8);
                EWUtil.spawnInWorld(this.level, entitywitherskull9);
                this.summonWaterSpout = 600;
            }
            if(this.summonWaterMinion == 0)
            {
                EntityWaterMinion entitywitherskull10 = new EntityWaterMinion(EWEntities.WATER_MINION.get(), this.level);
                entitywitherskull10.setOwner(this);
                entitywitherskull10.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull10.setTarget(this.getTarget());
                EntityWaterMinion entitywitherskull11 = new EntityWaterMinion(EWEntities.WATER_MINION.get(), this.level);
                entitywitherskull11.setOwner(this);
                entitywitherskull11.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull11.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull10);
                EWUtil.spawnInWorld(this.level, entitywitherskull11);
                this.summonWaterMinion = 200;
            }
            if(this.deathSummon && !this.summoned)
            {
                EntityGiantSquid entitywitherskull12 = new EntityGiantSquid(EWEntities.GIANT_SQUID.get(), this.level);
                entitywitherskull12.setOwner(this);
                entitywitherskull12.moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), this.getYRot(), 0.0F);
                entitywitherskull12.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull12);
                this.startRiding(entitywitherskull12);
                this.summoned = true;
            }
        }
        if(this.random.nextFloat() < 7.5E-4F) 
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        super.aiStep();
    }
    
    @Override
    public boolean canDrownInFluidType(FluidType type)
    {
    	return false;
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
        EntityWaterShoot entitywitherskull = new EntityWaterShoot(this.level, this, d6, d7, d8);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killwaterwitch, 1);
            }
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityWaterShoot | source.getEntity() instanceof EntitySquidInkBomb) && super.hurt(source, damage);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchSummonWater", this.summonWater);
        compound.putInt("WitchSummonWaterSpout", this.summonWaterSpout);
        compound.putInt("WitchSummonWaterMinion", this.summonWaterMinion);
        compound.putBoolean("WitchDeathSummonWater", this.deathSummon);
        compound.putBoolean("WitchDeathSummonedWater", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summonWater = compound.getInt("WitchSummonWater");
        this.summonWaterMinion = compound.getInt("WitchSummonWaterMinion");
        this.summonWaterSpout = compound.getInt("WitchSummonWaterSpout");
        this.deathSummon = compound.getBoolean("WitchDeathSummonWater");
        this.summoned = compound.getBoolean("WitchDeathSummonedWater");
    }
    
    protected Item getDropItem()
    {
        return EWItems.WATER_SHARD.get();
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
        	EntityWaterEgg mob = new EntityWaterEgg(EWEntities.WATER_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
