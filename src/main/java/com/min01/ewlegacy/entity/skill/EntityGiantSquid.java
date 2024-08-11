package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntitySquidInkBomb;
import com.min01.ewlegacy.entity.projectile.EntityWaterShoot;
import com.min01.ewlegacy.entity.witch.EntityWaterWitch;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class EntityGiantSquid extends AbstractOwnableMonster<EntityWaterWitch> implements RangedAttackMob
{
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    public short squidAttack = 70;
    public short squidBomb = 150;
    public short squidWater = 200;
    private float rotationVelocity;
    
    public EntityGiantSquid(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
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
    protected SoundEvent getAmbientSound() 
    {
    	return null;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return null;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return null;
    }
    
    @Override
    protected float getSoundVolume() 
    {
    	return 0.4F;
    }
    
    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_) 
    {
    	super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);
        for(int j = this.random.nextInt(300 + p_21386_) + 1, k = 0; k < j; ++k)
        {
            this.spawnAtLocation(new ItemStack(Items.INK_SAC), 0.0F);
        }
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider)
    {
    	return true;
    }
    
    @Override
    public void aiStep() 
    {
        if(this.squidAttack != 0)
        {
            --this.squidAttack;
        }
        if(this.squidBomb != 0) 
        {
            --this.squidBomb;
        }
        if(this.squidWater != 0) 
        {
            --this.squidWater;
        }
        if(!this.level.isRaining()) 
        {
            this.level.getLevelData().setRaining(true);
        }
        if(this.getTarget() != null)
        {
            if(this.squidAttack == 0) 
            {
                List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 20.0, 10.0));
                for(Entity entitytargetcheck : targetList) 
                {
                    if(entitytargetcheck instanceof LivingEntity && !(entitytargetcheck instanceof EntityWaterWitch))
                    {
                        if(!(entitytargetcheck instanceof Squid))
                        {
                            ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(EWEffects.ENDER_SKIN.get(), 4000, 1));
                        }
                    }
                }
                this.squidAttack = 70;
            }
            if(this.squidBomb == 0)
            {
                for(int j = 0; j <= 30; ++j)
                {
                    EntitySquidInkBomb entitywitherskull1 = new EntitySquidInkBomb(EWEntities.INK_BOMB.get(), this.level);
                    entitywitherskull1.moveTo(this.getX() + this.random.nextDouble() * 30.0, this.getY() + 60.0, this.getZ() + this.random.nextDouble() * 30.0, 0.0F, 0.0F);
                    EntitySquidInkBomb entitywitherskull2 = new EntitySquidInkBomb(EWEntities.INK_BOMB.get(), this.level);
                    entitywitherskull2.moveTo(this.getX() - this.random.nextDouble() * 30.0, this.getY() + 60.0, this.getZ() + this.random.nextDouble() * 30.0, 0.0F, 0.0F);
                    EntitySquidInkBomb entitywitherskull3 = new EntitySquidInkBomb(EWEntities.INK_BOMB.get(), this.level);
                    entitywitherskull3.moveTo(this.getX() + this.random.nextDouble() * 30.0, this.getY() + 60.0, this.getZ() - this.random.nextDouble() * 30.0, 0.0F, 0.0F);
                    EntitySquidInkBomb entitywitherskull4 = new EntitySquidInkBomb(EWEntities.INK_BOMB.get(), this.level);
                    entitywitherskull4.moveTo(this.getX() - this.random.nextDouble() * 30.0, this.getY() + 60.0, this.getZ() - this.random.nextDouble() * 30.0, 0.0F, 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull1);
                    EWUtil.spawnInWorld(this.level, entitywitherskull2);
                    EWUtil.spawnInWorld(this.level, entitywitherskull3);
                    EWUtil.spawnInWorld(this.level, entitywitherskull4);
                }
                this.squidBomb = 150;
            }
            if(this.squidWater == 0)
            {
                List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 20.0, 10.0));
                for(Entity entitytargetcheck : targetList) 
                {
                    if(entitytargetcheck instanceof LivingEntity) 
                    {
                        if(!(entitytargetcheck instanceof EntityWaterWitch))
                        {
                            if(this.level.getBlockState(entitytargetcheck.blockPosition()) == Blocks.AIR.defaultBlockState())
                            {
                                this.level.setBlockAndUpdate(entitytargetcheck.blockPosition(), Blocks.WATER.defaultBlockState());
                            }
                        }
                    }
                }
                this.squidWater = 200;
            }
        }
        super.aiStep();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if(this.squidRotation > 6.2831855F) 
        {
            this.squidRotation -= 6.2831855F;
            if(this.random.nextInt(10) == 0) 
            {
                this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0f) * 0.2F;
            }
        }
        this.tentacleAngle = Mth.abs(Mth.sin(this.squidRotation)) * 3.1415927F * 0.25F;
        if(!this.level.isClientSide)
        {
            this.setDeltaMovement(0.0, this.getDeltaMovement().y - 0.08, 0.0);
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.9800000190734863, 1));
        }
        if(this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
        {
            int j = (int) Math.floor(this.getY());
            int i2 = (int) Math.floor(this.getX());
            int j2 = (int) Math.floor(this.getZ());
            boolean flag = false;
            for(int l1 = -10; l1 <= 10; ++l1) 
            {
                for(int i3 = -10; i3 <= 10; ++i3) 
                {
                    for(int k = 0; k <= 20; ++k)
                    {
                        int j3 = i2 + l1;
                        int m = j + k;
                        int l2 = j2 + i3;
                        BlockPos pos = new BlockPos(j3, m, l2);
                        BlockState block = this.level.getBlockState(pos);
                        if(!this.level.isClientSide && !block.isAir() && block != Blocks.BEDROCK.defaultBlockState() && block != Blocks.OBSIDIAN.defaultBlockState() && block != Blocks.WATER.defaultBlockState())
                        {
                            flag = (this.level.destroyBlock(pos, false) || flag);
                        }
                    }
                }
            }
            if(flag) 
            {
                this.level.levelEvent(null, 1012, this.blockPosition(), 0);
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
        compound.putShort("SquidAttack", this.squidAttack);
        compound.putShort("SquidBomb", this.squidBomb);
        compound.putShort("SquidHead", this.squidWater);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.squidAttack = compound.getShort("SquidAttack");
        this.squidBomb = compound.getShort("SquidBomb");
        this.squidWater = compound.getShort("SquidHead");
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
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_)
    {
        for(int i = 0; i < 10; ++i)
        {
            this.performRangedAttack(0, p_33317_);
        }
    }
    
    private void performRangedAttack(int par1, LivingEntity living) 
    {
        this.performRangedAttack(par1, living.getX(), living.getY() + living.getEyeHeight() * 0.5, living.getZ(), par1 == 0 && this.random.nextFloat() < 0.001F);
    }
    
    private void performRangedAttack(int par1, double x, double y, double z, boolean par8)
    {
        double d3 = this.getHeadX(par1);
        double d4 = this.getHeadY(par1);
        double d5 = this.getHeadZ(par1);
        double d6 = x - d3;
        double d7 = y - d4;
        double d8 = z - d5;
        EntityWaterShoot entitywitherskull = new EntityWaterShoot(this.level, this, d6, d7, d8);
        entitywitherskull.setPos(d3, d4 + 0.5, d5);
        EWUtil.spawnInWorld(this.level, entitywitherskull);
    }
}
