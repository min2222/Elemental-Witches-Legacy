package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityDarkEgg;
import com.min01.ewlegacy.entity.projectile.EntityDarkShoot;
import com.min01.ewlegacy.entity.skill.EntityDarkMark;
import com.min01.ewlegacy.entity.skill.EntityDarkSummoner;
import com.min01.ewlegacy.entity.skill.EntityDeathCircle;
import com.min01.ewlegacy.entity.skill.EntityEnderHole;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class EntityDarkWitch extends Raider implements RangedAttackMob
{
    public boolean deathCircle = false;
    public int summonSummoner = 200;
    public int summonEnderHole = 300;
    public int summonDarkMark = 600;
    public short detroyAllLight = 20;
    
    public EntityDarkWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        if(EWConfig.darkWitchVsLightWitch.get()) 
        {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityLightWitch.class, true));
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
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public void aiStep() 
    {
        if(this.detroyAllLight != 0) 
        {
            --this.detroyAllLight;
        }
        if(this.detroyAllLight == 0 && EWConfig.canDarkWitchDestroyLight.get()) 
        {
            this.destroyLight();
            this.detroyAllLight = 20;
        }
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 20.0, 20.0));
        for(Entity entity1 : list) 
        {
            if(entity1 instanceof Zombie || entity1 instanceof Spider || entity1 instanceof CaveSpider || entity1 instanceof Skeleton || entity1 instanceof Creeper)
            {
                ((Mob)entity1).setTarget(this.getTarget());
                ((Mob)entity1).setTarget(this.getTarget());
            }
        }
        if(!this.level.isClientSide && this.getTarget() != null && EWConfig.canDarkWitchTurnToNight.get()) 
        {
            ((ServerLevel) this.level).setDayTime(18000L);
        }
        if(this.summonSummoner != 0 && this.getTarget() != null) 
        {
            --this.summonSummoner;
        }
        if(this.summonDarkMark != 0 && this.getTarget() != null) 
        {
            --this.summonDarkMark;
        }
        if(this.summonEnderHole != 0 && this.getTarget() != null)
        {
            --this.summonEnderHole;
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", this);
        if(this.getTarget() != null) 
        {
            if(!this.deathCircle && this.getHealth() <= 20.0F) 
            {
                EntityDeathCircle entitywitherskull1 = new EntityDeathCircle(EWEntities.DEATH_CIRCLE.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull1.startRiding(this);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                this.deathCircle = true;
            }
            if(this.summonSummoner == 0) 
            {
                EntityDarkSummoner entitywitherskull2 = new EntityDarkSummoner(EWEntities.DARK_SUMMONER.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX() + this.random.nextInt(5), this.getY(), this.getZ() + this.random.nextInt(5), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                entitywitherskull2.setTarget(this.getTarget());
                entitywitherskull2.setTarget(this.getTarget());
                this.summonSummoner = 200;
            }
            if(this.summonDarkMark == 0) 
            {
                EntityDarkMark entitywitherskull3 = new EntityDarkMark(EWEntities.DARK_MARK.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getX(), this.getY() + 3.0, this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                entitywitherskull3.setTarget(this.getTarget());
                entitywitherskull3.setTarget(this.getTarget());
                this.summonDarkMark = 600;
            }
            if(this.summonEnderHole == 0) 
            {
                EntityEnderHole entitysnowball = new EntityEnderHole(EWEntities.ENDER_HOLE.get(), this.level);
                entitysnowball.setOwner(this);
                entitysnowball.moveTo(this.getTarget().getX(), this.getTarget().getY() + 2.0, this.getTarget().getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitysnowball);
                this.summonEnderHole = 300;
            }
        }
        super.aiStep();
    }
    
    public void destroyLight() 
    {
        int radius = 15;
        if(!this.level.isClientSide) 
        {
            for(int x = -radius; x <= radius; ++x) 
            {
                for(int y = -radius; y <= radius; ++y) 
                {
                    for(int z = -radius; z <= radius; ++z)
                    {
                    	BlockPos pos = new BlockPos((int)this.getX() + x, (int)this.getY() + y, (int)this.getZ() + z);
                        BlockState id = this.level.getBlockState(pos);
                        if(id != null && id.getLightEmission(this.level, pos) > 15 * 0.5F)
                        {
                        	Block.dropResources(id, this.level, pos);
                            this.level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                            id.onBlockExploded(this.level, pos, new Explosion(this.level, this, 0.0, 0.0, 0.0, 0.0f));
                        }
                    }
                }
            }
        }
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
        EntityDarkShoot entitywitherskull = new EntityDarkShoot(this.level, this, d6, d7, d8);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killdarkwitch, 1);
            }
        }
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) 
    {
    	return false;
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("WitchDeathCircle", this.deathCircle);
        compound.putInt("WitchDarkMark", this.summonDarkMark);
        compound.putInt("WitchDarkSummoner", this.summonSummoner);
        compound.putInt("WitchEnderHole", this.summonEnderHole);
        compound.putShort("WitchDestoryLight", this.detroyAllLight);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.deathCircle = compound.getBoolean("WitchDeathCircle");
        this.summonDarkMark = compound.getInt("WitchDarkMark");
        this.summonSummoner = compound.getInt("WitchDarkSummoner");
        this.summonEnderHole = compound.getInt("WitchEnderHole");
        this.detroyAllLight = compound.getShort("WitchDestoryLight");
    }
    
    protected Item getDropItem() 
    {
        return EWItems.DARK_SHARD.get();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityDarkShoot) && !(source.getEntity() instanceof EntityDeathCircle) && !(source.getEntity() instanceof EntityEnderHole) && super.hurt(source, damage);
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
        	EntityDarkEgg mob = new EntityDarkEgg(EWEntities.DARK_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.darkpet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider)
    {
    	return rider instanceof EntityDeathCircle;
    }
}
