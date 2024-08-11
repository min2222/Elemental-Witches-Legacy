package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityIceEgg;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.skill.EntityFrostNova;
import com.min01.ewlegacy.entity.skill.EntityIceCrystal;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidType;

public class EntityIceWitch extends Raider implements RangedAttackMob
{
    int summonIceFog = 200;
    int summonHailRain = 300;
    int summonFrostNova = 600;
    boolean deathSummon = false;
    boolean summoned = false;
    
    public EntityIceWitch(EntityType<? extends Raider> type, Level level)
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
    
    @SuppressWarnings("deprecation")
	@Override
    public void aiStep() 
    {
        if(this.summonFrostNova != 0 && this.getTarget() != null)
        {
            --this.summonFrostNova;
        }
        if(this.summonHailRain != 0 && this.getTarget() != null)
        {
            --this.summonHailRain;
        }
        if(this.summonIceFog != 0 && this.getTarget() != null) 
        {
            --this.summonIceFog;
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_normal", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_bloack", this);
        int i1 = (int) Math.floor(this.getX());
        int j1 = (int) Math.floor(this.getZ());
        for(int l1 = -5; l1 <= 5; ++l1) 
        {
            for(int i2 = -5; i2 <= 5; ++i2) 
            {
                for(int k = 0; k <= 10; ++k) 
                {
                    for(int m = -1; m <= 0; ++m) 
                    {
                        int j2 = i1 + l1;
                        int k2 = (int) (Math.floor(this.getY()) + m);
                        int l2 = j1 + i2;
                        BlockPos pos = new BlockPos(j2, k2, l2);
                        if(this.level.getBlockState(pos).isAir() && Blocks.SNOW.canSurvive(this.level.getBlockState(pos), this.level, pos)) 
                        {
                            this.level.setBlockAndUpdate(pos, Blocks.SNOW.defaultBlockState());
                        }
                        if(this.level.getBlockState(pos).getMaterial() == Material.WATER)
                        {
                            this.level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
                        }
                    }
                }
            }
        }
        if(this.getTarget() != null) 
        {
            if(this.summonFrostNova <= 0) 
            {
                EntityFrostNova entitysnowball = new EntityFrostNova(EWEntities.FROST_NOVA.get(), this.level);
                entitysnowball.setOwner(this);
                entitysnowball.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitysnowball);
                entitysnowball.startRiding(this);
                this.summonFrostNova = 600;
            }
            if(this.summonHailRain <= 0 && this.random.nextInt(100) <= 40) 
            {
                for(int i3 = 0; i3 <= 120; ++i3) 
                {
                    if(i3 / 10 == 0)
                    {
                        EntityIceCube entitywitherskull1 = new EntityIceCube(EWEntities.ICE_CUBE.get(), this.level);
                        entitywitherskull1.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, this.getTarget().getY() + 40.0, this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, 0.0F, 0.0F);
                        EntityIceCube entityIceCube = entitywitherskull1;
                        entityIceCube.setDeltaMovement(entityIceCube.getDeltaMovement().subtract(0, 1, 0));
                        EWUtil.spawnInWorld(this.level, entitywitherskull1);
                    }
                    if(i3 / 6 == 0)
                    {
                        EntityIcicle entitywitherskull2 = new EntityIcicle(EWEntities.ICICLE.get(), this.level);
                        entitywitherskull2.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, this.getTarget().getY() + 40.0, this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 20.0 - 15.0, 0.0F, 0.0F);
                        EntityIcicle entityIcicle = entitywitherskull2;
                        entityIcicle.setDeltaMovement(entityIcicle.getDeltaMovement().subtract(0, 1, 0));
                        EWUtil.spawnInWorld(this.level, entitywitherskull2);
                    }
                    if(i3 == 120) 
                    {
                        this.summonHailRain = 300;
                    }
                }
            }
            if(this.summonIceFog <= 0)
            {
                EntityIceCrystal entitysnowball2 = new EntityIceCrystal(EWEntities.ICE_CRYSTAL.get(), this.level);
                entitysnowball2.setOwner(this);
                entitysnowball2.moveTo(this.getTarget().getX() + 1.0 + this.random.nextDouble() * 10.0 - 5.0, this.getTarget().getY() + 1.0, this.getTarget().getZ() + 1.0 + this.random.nextDouble() * 10.0 - 5.0, 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitysnowball2);
                this.summonIceFog = 200;
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider) 
    {
    	return rider instanceof EntityFrostNova;
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_)
    {
        if(this.getHealth() > 20.0F) 
        {
            for(int i = 0; i < 5; ++i) 
            {
                EntityIceCube entityice = new EntityIceCube(this.level, this);
                double d0 = p_33317_.getX() + p_33317_.getDeltaMovement().x - this.getX();
                double d2 = p_33317_.getY() + p_33317_.getEyeHeight() - 1.100000023841858 - this.getY();
                double d3 = p_33317_.getZ() + p_33317_.getDeltaMovement().z - this.getZ();
                float f1 = (float) Math.sqrt(d0 * d0 + d3 * d3);
                entityice.shoot(d0, d2 + f1 * 0.2F, d3, 0.75F, 8.0F);
                EWUtil.spawnInWorld(this.level, entityice);
            }
        }
        else 
        {
            EntityBigIceCube entityice2 = new EntityBigIceCube(this.level, this);
            double d4 = p_33317_.getX() + p_33317_.getDeltaMovement().x - this.getX();
            double d5 = p_33317_.getY() + p_33317_.getEyeHeight() - 1.100000023841858 - this.getY();
            double d6 = p_33317_.getZ() + p_33317_.getDeltaMovement().z - this.getZ();
            float f2 = (float) Math.sqrt(d4 * d4 + d6 * d6);
            entityice2.shoot(d4, d5 + f2 * 0.2F, d6, 0.75F, 8.0F);
            EWUtil.spawnInWorld(this.level, entityice2);
        }
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killicewitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchSummonFrostNova", this.summonFrostNova);
        compound.putInt("WitchSummonHailRain", this.summonHailRain);
        compound.putInt("WitchSummonIceFog", this.summonIceFog);
        compound.putBoolean("WitchDeathSummon", this.deathSummon);
        compound.putBoolean("WitchSummoned", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summonFrostNova = compound.getInt("WitchSummonFrostNova");
        this.summonHailRain = compound.getInt("WitchSummonHailRain");
        this.summonIceFog = compound.getInt("WitchSummonIceFog");
        this.deathSummon = compound.getBoolean("WitchDeathSummon");
        this.summoned = compound.getBoolean("WitchSummoned");
    }
    
    protected Item getDropItem() 
    {
        return EWItems.ICE_SHARD.get();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source.getEntity() instanceof EntityIceCube || source.getEntity() instanceof EntityIcicle || source.getEntity() instanceof EntityIceCrystal || source.getEntity() instanceof EntityFrostNova)
        {
            return false;
        }
        if(this.getHealth() > 20.0F) 
        {
            return super.hurt(source, damage);
        }
        if(source.getEntity() instanceof EntityBigIceCube)
        {
            return super.hurt(source, 3.0F);
        }
        return !(source.getEntity() instanceof Player) || ((Player)source.getEntity()).getMainHandItem().getItem() instanceof PickaxeItem || super.hurt(source, 0.5F);
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
        	EntityIceEgg mob = new EntityIceEgg(EWEntities.ICE_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.icepet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
