package com.min01.ewlegacy.entity.witch;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityAirEgg;
import com.min01.ewlegacy.entity.projectile.EntityAirShoot;
import com.min01.ewlegacy.entity.skill.EntityAirClone;
import com.min01.ewlegacy.entity.skill.EntityMiniTornado;
import com.min01.ewlegacy.entity.skill.EntityTornado;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

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
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityAirWitch extends Raider implements RangedAttackMob
{
    boolean summonTornado = false;
    int summonMiniTornado = 600;
    int summonWindClone = 300;
    
    public EntityAirWitch(EntityType<? extends Raider> type, Level level) 
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
    
    @Override
    public void aiStep() 
    {
        if(!this.onGround && this.getDeltaMovement().y < 0.0) 
        {
        	this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.6, 1));
        }
        if(this.summonMiniTornado != 0 && this.getTarget() != null) 
        {
            --this.summonMiniTornado;
        }
        if(this.summonWindClone != 0 && this.getTarget() != null)
        {
            --this.summonWindClone;
        }
        if(this.random.nextFloat() < 7.5E-4F) 
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("air_main", this);
        if(this.getTarget() != null) 
        {
            if(this.summonMiniTornado == 0) 
            {
                EntityMiniTornado entitywitherskull1 = new EntityMiniTornado(EWEntities.MINI_TORNADO.get(), this.level);
                entitywitherskull1.setOwner(this);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull1.startRiding(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                this.summonMiniTornado = 600;
            }
            if(this.summonWindClone == 0) 
            {
                EntityAirClone entitywitherskull2 = new EntityAirClone(EWEntities.AIR_CLONE.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ() + 1.0, this.getYRot(), 0.0F);
                EntityAirClone entitywitherskull3 = new EntityAirClone(EWEntities.AIR_CLONE.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ() - 1.0, this.getYRot(), 0.0F);
                entitywitherskull2.setTarget(this.getTarget());
                entitywitherskull2.setHealth(this.getHealth());
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                entitywitherskull3.setTarget(this.getTarget());
                entitywitherskull3.setHealth(this.getHealth());
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                this.summonWindClone = 300;
            }
            if(this.getHealth() <= 30.0F && !this.summonTornado)
            {
                EntityTornado entitywitherskull4 = new EntityTornado(EWEntities.TORNADO.get(), this.level);
                entitywitherskull4.setOwner(this);
                entitywitherskull4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull4.startRiding(this);
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
                this.summonTornado = true;
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider) 
    {
    	return rider instanceof EntityTornado;
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
    
    private void performRangedAttack(int par1, double x, double y, double z, boolean par8)
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        double d3 = this.getHeadX(par1);
        double d4 = this.getHeadY(par1);
        double d5 = this.getHeadZ(par1);
        double d6 = x - d3;
        double d7 = y - d4;
        double d8 = z - d5;
        EntityAirShoot entitywitherskull = new EntityAirShoot(this.level, this, d6, d7, d8, randomNumber);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killairwitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("WitchSummonTornado", this.summonTornado);
        compound.putInt("WitchSummonMiniTornado", this.summonMiniTornado);
        compound.putInt("WitchSummonWindClone", this.summonWindClone);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.summonTornado = compound.getBoolean("WitchSummonTornado");
        this.summonMiniTornado = compound.getInt("WitchSummonMiniTornado");
        this.summonWindClone = compound.getInt("WitchSummonWindClone");
    }
    
    protected Item getDropItem() {
        return EWItems.AIR_SHARD.get();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityAirClone) && !(source.getEntity() instanceof EntityMiniTornado) && !(source.getEntity() instanceof EntityAirShoot) && super.hurt(source, damage);
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) 
    {
    	return false;
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
            EntityAirEgg mob = new EntityAirEgg(EWEntities.AIR_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.airpet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
