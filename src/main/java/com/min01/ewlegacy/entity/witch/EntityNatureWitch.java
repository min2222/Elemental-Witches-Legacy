package com.min01.ewlegacy.entity.witch;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityNatureEgg;
import com.min01.ewlegacy.entity.projectile.EntityNatureBall;
import com.min01.ewlegacy.entity.projectile.EntityNatureShoot;
import com.min01.ewlegacy.entity.skill.EntityEnt;
import com.min01.ewlegacy.entity.skill.EntityEntGuardian;
import com.min01.ewlegacy.entity.skill.EntityRoot;
import com.min01.ewlegacy.entity.skill.EntitySwiftEnt;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EntityNatureWitch extends Raider implements RangedAttackMob
{
    public int summonRootsTimer = 200;
    public int summonEntsTimer = 300;
    public int mirrorTimer = 600;
    public boolean lastStraw = false;
    
    public EntityNatureWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        if(EWConfig.elementalsVsWitches.get())
        {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Witch.class, true));
        }
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
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
        if(this.summonEntsTimer != 0 && this.getTarget() != null)
        {
            --this.summonEntsTimer;
        }
        if(this.summonRootsTimer != 0 && this.getTarget() != null)
        {
            --this.summonRootsTimer;
        }
        if(this.random.nextFloat() < 7.5E-4F) 
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("leaf_normal", this);
        if(this.getTarget() != null) 
        {
            if(this.summonEntsTimer <= 0) 
            {
                EntityEnt entitywitherskull1 = new EntityEnt(EWEntities.ENT.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                EntitySwiftEnt entitywitherskull2 = new EntitySwiftEnt(EWEntities.SWIFT_ENT.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                EntitySwiftEnt entitywitherskull3 = new EntitySwiftEnt(EWEntities.SWIFT_ENT.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                entitywitherskull1.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                entitywitherskull2.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                entitywitherskull3.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                this.summonEntsTimer = 300;
            }
            if(this.summonRootsTimer <= 0 && this.getHealth() > 20.0f) 
            {
                for(int i = 0; i < 10; ++i) 
                {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(5);
                    EntityRoot entity = new EntityRoot(EWEntities.ROOT.get(), this.level);
                    entity.setOwner(this);
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
            if(this.getHealth() <= 20.0f && !this.lastStraw) 
            {
                EntityEntGuardian entitywitherskull4 = new EntityEntGuardian(EWEntities.ENT_GUARDIAN.get(), this.level);
                entitywitherskull4.setOwner(this);
                entitywitherskull4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull4.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                this.startRiding(entitywitherskull4);
                this.lastStraw = true;
            }
        }
        if(this.tickCount % 40 == 0 && this.getHealth() < this.getMaxHealth() && this.getHealth() >= 1.0F)
        {
            int i = (int) Math.floor(this.getY());
            int i2 = (int) Math.floor(this.getX());
            int j1 = (int) Math.floor(this.getZ());
            for(int l1 = -1; l1 <= 1; ++l1)
            {
                for(int i3 = -1; i3 <= 1; ++i3) 
                {
                    for(int k = 0; k <= 3; ++k)
                    {
                        int j2 = i2 + l1;
                        int m = i + k;
                        int l2 = j1 + i3;
                        BlockPos pos = new BlockPos(j2, m, l2);
                        BlockState block = this.level.getBlockState(pos);
                        if((!block.isAir() && block.is(BlockTags.LEAVES)) || block == Blocks.GRASS_BLOCK.defaultBlockState())
                        {
                            AABB aabb = block.getShape(this.level, pos).bounds();
                            double x = this.getBoundingBox().minX + this.getBoundingBox().maxX;
                            x /= 2.0;
                            double y = this.getBoundingBox().minY + this.getBbHeight();
                            y -= this.getBbHeight() / 2.0;
                            double z = this.getBoundingBox().minZ + this.getBoundingBox().maxZ;
                            z /= 2.0;
                            double trueX = aabb.minX + aabb.maxX;
                            trueX /= 2.0;
                            double trueY = aabb.minY + aabb.maxY;
                            trueY -= 2.0;
                            double trueZ = aabb.minZ + aabb.maxZ;
                            trueZ /= 2.0;
                            Vec3 seekVector = new Vec3(x - trueX, y - trueY, z - trueZ);
                            seekVector = seekVector.normalize();
                            double motionX = seekVector.x * 0.4;
                            double motionY = seekVector.y * 0.4;
                            double motionZ = seekVector.z * 0.4;
                            ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("leaf_normal_recover", this.level, j2, m + 1, l2, motionX, motionY, motionZ);
                            this.setHealth(this.getHealth() + 1.0F);
                        }
                    }
                }
            }
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
        EntityNatureShoot entitywitherskull = new EntityNatureShoot(this.level, this, d6, d7, d8);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killnaturewitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchNatureRoots", this.summonRootsTimer);
        compound.putInt("WitchNatureEnts", this.summonEntsTimer);
        compound.putInt("WitchLightMirror", this.mirrorTimer);
        compound.putBoolean("WitchLightLastStraw", this.lastStraw);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summonRootsTimer = compound.getInt("WitchNatureRoots");
        this.summonEntsTimer = compound.getInt("WitchNatureEnts");
        this.mirrorTimer = compound.getInt("WitchLightMirror");
        this.lastStraw = compound.getBoolean("WitchLightLastStraw");
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    protected Item getDropItem() 
    {
        return EWItems.NATURE_SHARD.get();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityEnt) && !(source.getEntity() instanceof EntitySwiftEnt) && !(source.getEntity() instanceof EntityRoot) && !(source.getEntity() instanceof EntityEntGuardian) && !(source.getEntity() instanceof EntityNatureBall) && super.hurt(source, damage);
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
        	EntityNatureEgg mob = new EntityNatureEgg(EWEntities.NATURE_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.naturepet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
