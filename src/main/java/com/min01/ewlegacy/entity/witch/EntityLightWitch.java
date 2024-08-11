package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityLightEgg;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;
import com.min01.ewlegacy.entity.projectile.EntityLightShoot;
import com.min01.ewlegacy.entity.skill.EntityLightHeal;
import com.min01.ewlegacy.entity.skill.EntityLightShieldBad;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

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
import net.minecraft.world.entity.LightningBolt;
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
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityLightWitch extends Raider implements RangedAttackMob
{
    public int healTimer = 200;
    public int arrowTimer = 300;
    public int mirrorTimer = 600;
    public boolean lastStraw = false;
    public EntityLightHeal healingLight;
    
    public EntityLightWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        if(EWConfig.darkWitchVsLightWitch.get())
        {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityDarkWitch.class, true));
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
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 20.0, 10.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof EntityLightHeal heal)
            {
            	if(heal.getOwner() != null && heal.getOwner() == this)
            	{
                    this.updateHealingCrystal();
            	}
            }
        }
        if(!this.level.isClientSide && this.getTarget() != null && EWConfig.canLightWitchTurnToDay.get()) 
        {
            ((ServerLevel) this.level).setDayTime(6000L);
        }
        if(this.random.nextFloat() < 7.5E-4F)
        {
            this.level.broadcastEntityEvent(this, (byte)15);
        }
        if(this.arrowTimer != 0 && this.getTarget() != null) 
        {
            --this.arrowTimer;
        }
        if(this.healTimer != 0 && this.getTarget() != null) 
        {
            --this.healTimer;
        }
        if(this.mirrorTimer != 0 && this.getTarget() != null) 
        {
            --this.mirrorTimer;
        }
        if(!this.lastStraw && this.getTarget() != null && this.getHealth() <= 20.0F) 
        {
            this.lastStraw = true;
        }
        if(this.getTarget() != null) 
        {
            if(this.arrowTimer == 0) 
            {
                for(int i = 0; i <= 60; ++i)
                {
                    EntityLightArrow entitywitherskull1 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                    entitywitherskull1.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 15.0 - 10.0, this.getY() + 40.0, this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 15.0 - 10.0, 0.0F, 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull1);
                    EntityLightArrow entityLightArrow = entitywitherskull1;
                    entityLightArrow.setDeltaMovement(entityLightArrow.getDeltaMovement().subtract(0, 1, 0));
                    if(i >= 60) 
                    {
                        this.arrowTimer = 300;
                    }
                }
            }
            if(this.healTimer == 0)
            {
                EntityLightHeal entitywitherskull2 = new EntityLightHeal(EWEntities.LIGHT_HEAL.get(), this.level);
                entitywitherskull2.setOwner(this);
                entitywitherskull2.moveTo(this.getX(), this.getY() + 6.0, this.getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                this.healTimer = 200;
            }
            if(this.mirrorTimer == 0) 
            {
                EntityLightShieldBad entitywitherskull3 = new EntityLightShieldBad(EWEntities.LIGHT_SHIELD_BAD.get(), this.level);
                entitywitherskull3.setOwner(this);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                this.mirrorTimer = 600;
            }
            if(this.lastStraw && this.random.nextInt(100) <= 40)
            {
                for(int i = 0; i <= 60; ++i) 
                {
                    if(i / 10 == 0) 
                    {
                    	LightningBolt entitywitherskull4 = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
                        entitywitherskull4.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 30.0 - 25.0, this.getTarget().getY(), this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 30.0 - 25.0, 0.0F, 0.0F);
                        EWUtil.spawnInWorld(this.level, entitywitherskull4);
                    }
                    if(i / 6 == 0) 
                    {
                        LargeFireball entitywitherskull5 = new LargeFireball(EntityType.FIREBALL, this.level);
                        entitywitherskull5.moveTo(this.getTarget().getX() + 5.0 + this.random.nextDouble() * 30.0 - 25.0, this.getTarget().getY() + 40.0, this.getTarget().getZ() + 5.0 + this.random.nextDouble() * 30.0 - 25.0, 0.0F, 0.0F);
                        LargeFireball entityLargeFireball = entitywitherskull5;
                        entityLargeFireball.setDeltaMovement(entityLargeFireball.getDeltaMovement().subtract(0, 4.0, 0));
                        EWUtil.spawnInWorld(this.level, entitywitherskull5);
                    }
                }
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("light_normal", this);
        super.aiStep();
    }
    
    private void updateHealingCrystal() 
    {
        if(this.tickCount % 40 == 0 && this.getHealth() < this.getMaxHealth() && this.getHealth() >= 1.0F)
        {
            this.setHealth(this.getHealth() + 2.0F);
        }
        if(this.random.nextInt(10) == 0) 
        {
            float f = 10.0F;
            List<EntityLightHeal> list = this.level.getEntitiesOfClass(EntityLightHeal.class, this.getBoundingBox().expandTowards((double)f, (double)f, (double)f));
            EntityLightHeal entitylightheal = null;
            double d0 = Double.MAX_VALUE;
            for(EntityLightHeal entitylightheal2 : list) 
            {
                double d2 = entitylightheal2.distanceToSqr(this);
                if(d2 < d0)
                {
                    d0 = d2;
                    entitylightheal = entitylightheal2;
                }
            }
            this.healingLight = entitylightheal;
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
        EntityLightShoot entitywitherskull = new EntityLightShoot(this.level, this, d6, d7, d8);
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
            	//((Player)entitytargetcheck).awardStat(MWAWAchievementsRegistry.killlightwitch, 1);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchLightHeal", this.healTimer);
        compound.putInt("WitchLightArrow", this.arrowTimer);
        compound.putInt("WitchLightMirror", this.mirrorTimer);
        compound.putBoolean("WitchLightLastStraw", this.lastStraw);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.healTimer = compound.getInt("WitchLightHeal");
        this.arrowTimer = compound.getInt("WitchLightArrow");
        this.mirrorTimer = compound.getInt("WitchLightMirror");
        this.lastStraw = compound.getBoolean("WitchLightLastStraw");
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
    
    protected Item getDropItem()
    {
        return EWItems.LIGHT_SHARD.get();
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityLightShoot) && !(source.getEntity() instanceof EntityLightArrow) && !(source.getEntity() instanceof LightningBolt) && !(source.getEntity() instanceof LargeFireball) && super.hurt(source, damage);
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
        	EntityLightEgg mob = new EntityLightEgg(EWEntities.LIGHT_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), p_21472_.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setOwnerUUID(p_21472_.getUUID());
            mob.setCustomName(Component.literal("Owner: " + p_21472_.getDisplayName().getString()));
            mob.setCustomNameVisible(true);
        	//TODO
        	//p_21472_.awardStat(MWAWAchievementsRegistry.lightpet1, 1);
            this.discard();
        }
    	return super.mobInteract(p_21472_, p_21473_);
    }
}
