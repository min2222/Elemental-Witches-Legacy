package com.min01.ewlegacy.entity.skill;

import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityNatureBall;
import com.min01.ewlegacy.entity.projectile.EntityNatureShoot;
import com.min01.ewlegacy.entity.witch.EntityNatureWitch;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

public class EntityEntGuardian extends AbstractOwnableMonster<EntityNatureWitch>
{
    private int attackTimer;
    private int armor = 1;
    private int rangeTimer = 30;
    private int summonRootsTimer = 300;
    private boolean setfire = false;
    private boolean maxHealthset = false;
    
    public EntityEntGuardian(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.25));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.25));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.25, 32.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityEntGuardian.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 60.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 2.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.05);
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        this.attackTimer = 10;
        this.level.broadcastEntityEvent(this, (byte)4);
        boolean flag = target.hurt(DamageSource.mobAttack(this), 5.0F);
        if(flag)
        {
            target.setDeltaMovement(target.getDeltaMovement().add(0, 0.4000000059604645, 0));
        }
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
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
    public void aiStep() 
    {
        super.aiStep();
        if(!this.level.isClientSide && this.tickCount <= 100 && !this.maxHealthset)
        {
            int i = (int) Math.floor(this.getY());
            int i2 = (int) Math.floor(this.getX());
            int j1 = (int) Math.floor(this.getZ());
            for(int l1 = -4; l1 <= 4; ++l1)
            {
                for(int i3 = -4; i3 <= 4; ++i3)
                {
                    for(int k = -1; k <= 5; ++k) 
                    {
                        int j2 = i2 + l1;
                        int m = i + k;
                        int l2 = j1 + i3;
                        BlockPos pos = new BlockPos(j2, m, l2);
                        BlockState block = this.level.getBlockState(pos);
                        if((!block.isAir() && block.is(BlockTags.LEAVES)) || block == Blocks.GRASS_BLOCK.defaultBlockState()|| block == Blocks.TALL_GRASS.defaultBlockState() || block == Blocks.POPPY.defaultBlockState() || block == Blocks.DANDELION.defaultBlockState())
                        {
                            if(block == Blocks.TALL_GRASS.defaultBlockState())
                            {
                                this.level.setBlockAndUpdate(pos, Blocks.DEAD_BUSH.defaultBlockState());
                            }
                            else if(block == Blocks.GRASS_BLOCK.defaultBlockState())
                            {
                                this.level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                            }
                            else 
                            {
                                this.level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                            }
                            ++this.armor;
                            if(this.tickCount > 100 && !this.maxHealthset)
                            {
                                this.setAbsorptionAmount((float)(this.armor * 2));
                                this.maxHealthset = true;
                            }
                        }
                    }
                }
            }
        }
        if(this.isInWater())
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(this.attackTimer > 0) 
        {
            --this.attackTimer;
        }
        if(this.rangeTimer != 0)
        {
            --this.rangeTimer;
        }
        if(this.summonRootsTimer != 0) 
        {
            --this.summonRootsTimer;
        }
        if(this.getTarget() != null) 
        {
            if(this.rangeTimer == 0 && this.getTarget().distanceTo(this) <= 20.0F) 
            {
                Vec3 look = this.getLookAngle();
                EntityNatureBall entityNatureBall = new EntityNatureBall(this.level, this);
                double d0 = this.getTarget().getX() + this.getTarget().getDeltaMovement().x - this.getX();
                double d2 = this.getTarget().getY() + this.getTarget().getEyeHeight() - 1.100000023841858 - this.getY();
                double d3 = this.getTarget().getZ() + this.getTarget().getDeltaMovement().z - this.getZ();
                float f1 = (float) Math.sqrt(d0 * d0 + d3 * d3);
                entityNatureBall.setPos(this.getX() + look.x * 1.0, this.getY() + 3.0, this.getZ() + look.z * 1.0);
                entityNatureBall.shoot(d0, d2 + f1 * 0.2F, d3, 0.75F, 8.0F);
                EWUtil.spawnInWorld(this.level, entityNatureBall);
                this.rangeTimer = 30;
            }
            if(this.summonRootsTimer <= 0)
            {
                for(int i = 0; i < 10; ++i) 
                {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(5);
                    EntityRoot entity = new EntityRoot(EWEntities.ROOT.get(), this.level);
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
                this.summonRootsTimer = 200;
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("leaf_normal", this);
        if(this.isOnFire() && !this.setfire)
        {
            this.setSecondsOnFire(100000000);
            this.setfire = true;
        }
    }
    
    @Override
    public void handleEntityEvent(byte p_28844_)
    {
        if(p_28844_ == 4) 
        {
        	this.attackTimer = 10;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        }
        else
        {
            super.handleEntityEvent(p_28844_);
        }
    }
    
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) 
    {
    	this.playSound(SoundEvents.WOOD_STEP, 0.15F, 1.0F);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
    }
    
    public int getAttackTimer()
    {
        return this.attackTimer;
    }
    
    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_)
    {
    	super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        if(randomNumber == 1)
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 4), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 4);
            }
        }
        else if(randomNumber == 2) 
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 6), 0.0F);
            }
            else
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 9);
            }
        }
        else if(randomNumber == 3) 
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 7), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 11);
            }
        }
        else if(randomNumber == 4)
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 8), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 6);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("EntSetFire", this.setfire);
        compound.putBoolean("EntSetMaxHealth", this.maxHealthset);
        compound.putInt("EntShootTimer", this.rangeTimer);
        compound.putInt("EntSummonRootsTimer", this.summonRootsTimer);
        compound.putInt("EntArmor", this.armor);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.setfire = compound.getBoolean("EntSetFire");
        this.maxHealthset = compound.getBoolean("EntSetMaxHealth");
        this.rangeTimer = compound.getInt("EntShootTimer");
        this.summonRootsTimer = compound.getInt("EntSummonRootsTimer");
        this.armor = compound.getInt("EntArmor");
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
    	if(source == DamageSource.IN_WALL || source == DamageSource.DROWN || source.getEntity() instanceof EntityNatureWitch || source.getEntity() instanceof EntityRoot || source.getEntity() instanceof EntitySwiftEnt || source.getEntity() instanceof EntityEnt || source.getEntity() instanceof EntityNatureBall || source.getEntity() instanceof EntityEntGuardian || source.getEntity() instanceof EntityNatureShoot) 
        {
            return false;
        }
        if(source.getEntity() instanceof LivingEntity && ((LivingEntity)source.getEntity()).getMainHandItem().getItem() instanceof AxeItem) 
        {
            return super.hurt(source, damage);
        }
        return super.hurt(source, 1.0F);
    }
    
    @Override
    protected void doPush(Entity p_20971_) 
    {
        if(!(p_20971_ instanceof EntityNatureWitch) && !(p_20971_ instanceof EntityEnt))
        {
            if(!(p_20971_ instanceof EntitySwiftEnt))
            {
                super.doPush(p_20971_);
            }
        }
    }
}
