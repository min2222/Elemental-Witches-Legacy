package com.min01.ewlegacy.entity.skill;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.witch.EntityChristmasWitch;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

public class EntityBigSnowGolem extends AbstractGolem
{
    private int attackTimer;
    private int holdRoseTick;
	public static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(EntityBigSnowGolem.class, EntityDataSerializers.OPTIONAL_UUID);
    
    public EntityBigSnowGolem(EntityType<? extends AbstractGolem> type, Level level)
    {
        super(type, level);
        this.getNavigation().setCanFloat(true);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 1.0));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }
    
	@Override
	protected void defineSynchedData()
	{
		super.defineSynchedData();
		this.entityData.define(OWNER_UUID, Optional.empty());
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag p_37265_) 
	{
		super.addAdditionalSaveData(p_37265_);
		if(this.entityData.get(OWNER_UUID).isPresent())
		{
			p_37265_.putUUID("Owner", this.entityData.get(OWNER_UUID).get());
		}
	}
	
	@Override
	public void readAdditionalSaveData(CompoundTag p_37262_) 
	{
		super.readAdditionalSaveData(p_37262_);
		if(p_37262_.hasUUID("Owner")) 
		{
			this.entityData.set(OWNER_UUID, Optional.of(p_37262_.getUUID("Owner")));
		}
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(this.getOwner() == null)
		{
			this.discard();
		}
	}
	
	public void setOwner(@Nullable EntityChristmasWitch p_37263_)
	{
		if(p_37263_ != null)
		{
			this.entityData.set(OWNER_UUID, Optional.of(p_37263_.getUUID()));
		}
	}
	
	@Nullable
	public EntityChristmasWitch getOwner() 
	{
		if(this.entityData.get(OWNER_UUID).isPresent()) 
		{
			return (EntityChristmasWitch) EWUtil.getEntityByUUID(this.level, this.entityData.get(OWNER_UUID).get());
		}
		return null;
	}
    
    @Override
    public float getStepHeight() 
    {
    	return 2.0F;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 50.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider) 
    {
    	return true;
    }
    
    @Override
    protected int decreaseAirSupply(int p_28882_) 
    {
    	return p_28882_;
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
        super.aiStep();
        ElementalWitchesLegacy.PROXY.spawnParticles("christmas_normal", this);
        if(this.attackTimer > 0) 
        {
            --this.attackTimer;
        }
        if(this.holdRoseTick > 0) 
        {
            --this.holdRoseTick;
        }
        if(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z > 2.500000277905201E-7 && this.random.nextInt(5) == 0)
        {
            int i = (int) Math.floor(this.getX());
            int j = (int) Math.floor(this.getY() - 0.20000000298023224);
            int k = (int) Math.floor(this.getZ());
            BlockPos pos = new BlockPos(i, j, k);
            BlockState block = this.level.getBlockState(pos);
            if(!block.isAir())
            {
                this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block).setPos(pos), this.getX() + (this.random.nextFloat() - 0.5) * this.getBbWidth(), this.getBoundingBox().minY + 0.1, this.getZ() + (this.random.nextFloat() - 0.5) * this.getBbWidth(), 4.0 * (this.random.nextFloat() - 0.5), 0.5, (this.random.nextFloat() - 0.5) * 4.0);
            }
        }
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY());
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        Biome biome = this.level.getBiome(blockpos).value();
        BlockState blockstate = Blocks.SNOW.defaultBlockState();
        if(biome.shouldSnowGolemBurn(blockpos))
        {
            this.hurt(DamageSource.ON_FIRE, 1.0F);
        }
        for(int l = 0; l < 4; ++l) 
        {
            i = (int) Math.floor(this.getX() + (l % 2 * 2 - 1) * 0.25F);
            j = (int) Math.floor(this.getY());
            k = (int) Math.floor(this.getZ() + (l / 2 % 2 * 2 - 1) * 0.25F);
            BlockPos blockpos1 = new BlockPos(i, j, k);
            if(this.level.isEmptyBlock(blockpos1) && blockstate.canSurvive(this.level, blockpos1))
            {
            	this.level.setBlockAndUpdate(blockpos1, blockstate);
            	this.level.gameEvent(GameEvent.BLOCK_PLACE, blockpos1, GameEvent.Context.of(this, blockstate));
            }
        }
    }
    
    @Override
    public boolean isSensitiveToWater() 
    {
    	return true;
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        this.attackTimer = 10;
        this.level.broadcastEntityEvent(this, (byte)4);
        boolean flag = target.hurt(DamageSource.mobAttack(this), (7 + this.random.nextInt(15)));
        if(flag)
        {
            target.setDeltaMovement(target.getDeltaMovement().add(0, 0.4000000059604645, 0));
        }
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }
    
    @Override
    protected void doPush(Entity p_28839_) 
    {
        if(this.getFirstPassenger() instanceof Player && p_28839_ instanceof Enemy && this.getRandom().nextInt(20) == 0)
        {
        	this.setTarget((LivingEntity)p_28839_);
        }

        super.doPush(p_28839_);
    }
    
    @Override
    public void handleEntityEvent(byte p_28844_)
    {
        if(p_28844_ == 4) 
        {
        	this.attackTimer = 10;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        }
        else if(p_28844_ == 11)
        {
            this.holdRoseTick = 400;
        }
        else
        {
            super.handleEntityEvent(p_28844_);
        }
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    public int getAttackTimer() 
    {
        return this.attackTimer;
    }
    
    public void setHoldingRose(boolean p_70851_1_)
    {
        this.holdRoseTick = (p_70851_1_ ? 400 : 0);
        this.level.broadcastEntityEvent(this, (byte)11);
    }
    
    @Override
    protected SoundEvent getDeathSound() 
    {
    	return SoundEvents.IRON_GOLEM_DEATH;
    }
    
    public int getHoldRoseTick() 
    {
        return this.holdRoseTick;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityIcicle) && !(source.getEntity() instanceof PrimedTnt) && !(source.getEntity() instanceof EntityChristmasWitch) && !(source.getEntity() instanceof EntityBlock) && !(source.getEntity() instanceof EntityRifle) && !(source.getEntity() instanceof SnowGolem) && super.hurt(source, damage);
    }
}
