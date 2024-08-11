package com.min01.ewlegacy.entity.witch;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.projectile.EntityPumpkinSkull;
import com.min01.ewlegacy.entity.skill.EntityExplosivePumpkin;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class EntityHalloweenWitch extends Raider implements RangedAttackMob
{
    int summonTeleport = 50;
    int summonSkeleton = 300;
    int summonPumkinAirStrike = 400;
    boolean deathSummon = false;
    boolean summoned = false;
    
    public EntityHalloweenWitch(EntityType<? extends Raider> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0f));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
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
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    
    @Override
    public void aiStep() 
    {
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 20.0, 20.0));
        for(Entity entity1 : list)
        {
            if(entity1 instanceof Zombie || entity1 instanceof Spider || entity1 instanceof CaveSpider || entity1 instanceof Skeleton || entity1 instanceof Creeper)
            {
                ((Mob)entity1).setTarget(this.getTarget());
                ((Mob)entity1).setTarget(this.getTarget());
            }
        }
        if(this.summonTeleport != 0 && this.getTarget() != null) 
        {
            --this.summonTeleport;
        }
        if(this.summonSkeleton != 0 && this.getTarget() != null)
        {
            --this.summonSkeleton;
            if(!this.level.isClientSide)
            {
                ((ServerLevel) this.level).setDayTime(18000L);
            }
        }
        if(this.summonPumkinAirStrike != 0 && this.getTarget() != null)
        {
            --this.summonPumkinAirStrike;
        }
        if(this.getHealth() <= 20.0F && !this.deathSummon) 
        {
            this.deathSummon = true;
        }
        if(this.getTarget() != null)
        {
            if(this.summonTeleport == 0) 
            {
                this.teleportRandomly(this.getTarget());
                this.summonTeleport = 50;
            }
            if(this.deathSummon && !this.summoned)
            {
                for(int i = 0; i < 5; ++i) 
                {
                    Spider entitywitherskull1 = new Spider(EntityType.SPIDER, this.level);
                    entitywitherskull1.moveTo(this.getTarget().getX() + this.random.nextInt(4), this.getTarget().getY(), this.getTarget().getZ() + this.random.nextInt(4), this.getYRot(), 0.0F);
                    entitywitherskull1.setTarget(this.getTarget());
                    entitywitherskull1.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5000, 2));
                    EWUtil.spawnInWorld(this.level, entitywitherskull1);
                    if(i == 4) 
                    {
                        this.summoned = true;
                    }
                }
            }
            if(this.summonSkeleton == 0) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                    Skeleton entitywitherskull2 = new Skeleton(EntityType.SKELETON, this.level);
                    entitywitherskull2.moveTo(this.getX() + this.random.nextInt(4), this.getY(), this.getZ() + this.random.nextInt(4), this.getYRot(), 0.0F);
                    entitywitherskull2.setTarget(this.getTarget());
                    entitywitherskull2.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
                    entitywitherskull2.setCustomName(Component.literal("Pumpkin Minion").withStyle(ChatFormatting.YELLOW));
                    entitywitherskull2.setCustomNameVisible(true);
                    EWUtil.spawnInWorld(this.level, entitywitherskull2);
                    if(i == 4)
                    {
                        this.summonSkeleton = 300;
                    }
                }
            }
            if(this.summonPumkinAirStrike == 0)
            {
                for(int i = 0; i < 10; ++i) 
                {
                    EntityExplosivePumpkin entitywitherskull3 = new EntityExplosivePumpkin(EWEntities.EXPLOSIVE_PUMPKIN.get(), this.level);
                    entitywitherskull3.setOwner(this);
                    entitywitherskull3.moveTo(this.getTarget().getX() + this.random.nextInt(10), this.getTarget().getY() + 25.0, this.getTarget().getZ() + this.random.nextInt(10), this.getYRot(), 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull3);
                    if(i == 9) 
                    {
                        this.summonPumkinAirStrike = 200;
                    }
                }
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("halloween_normal_4", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("portal", this);
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
        this.performRangedAttack(0, p_33317_);
        this.level.levelEvent(null, 1009, this.blockPosition(), 0);
    }
    
    private void performRangedAttack(int par1, LivingEntity living)
    {
        this.performRangedAttack(par1, living.getX(), living.getY() + living.getEyeHeight() * 0.5, living.getZ(), par1 == 0 && this.random.nextFloat() < 0.001F);
    }
    
    private void performRangedAttack(int par1, double par2, double par4, double par6, boolean par8) {
        double d3 = this.getHeadX(par1);
        double d4 = this.getHeadY(par1);
        double d5 = this.getHeadZ(par1);
        double d6 = par2 - d3;
        double d7 = par4 - d4;
        double d8 = par6 - d5;
        EntityPumpkinSkull entitywitherskull = new EntityPumpkinSkull(this.level, this, d6, d7, d8);
        entitywitherskull.setPos(d3, d4 + 0.5, d5);
        EWUtil.spawnInWorld(this.level, entitywitherskull);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchTeleport", this.summonTeleport);
        compound.putInt("WitchSummonSkeleton", this.summonSkeleton);
        compound.putInt("WitchPumkinAirStrike", this.summonPumkinAirStrike);
        compound.putBoolean("WitchDeathSummon", this.deathSummon);
        compound.putBoolean("WitchDeathSummoned", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.summonTeleport = compound.getInt("WitchTeleport");
        this.summonPumkinAirStrike = compound.getInt("WitchPumkinAirStrike");
        this.summonSkeleton = compound.getInt("WitchSummonSkeleton");
        this.deathSummon = compound.getBoolean("WitchDeathSummon");
        this.summoned = compound.getBoolean("WitchDeathSummoned");
    }
    
    protected boolean teleportRandomly(Entity entity)
    {
        Vec3 vec3 = new Vec3(this.getX() - entity.getX(), this.getBoundingBox().minY + this.getBbHeight() / 2.0F - entity.getY() + entity.getEyeHeight(), this.getZ() - entity.getZ());
        vec3 = vec3.normalize();
        double d0 = 16.0;
        double d2 = this.getX() + (this.random.nextDouble() - 0.5) * 8.0 - vec3.x * d0;
        double d3 = this.getY() + (this.random.nextInt(16) - 8) - vec3.y * d0;
        double d4 = this.getZ() + (this.random.nextDouble() - 0.5) * 8.0 - vec3.z * d0;
        return this.randomTeleport(d2, d3, d4, true);
    }
    
    @Override
    public boolean removeWhenFarAway(double p_37894_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityExplosivePumpkin) && !(source.getEntity() instanceof Skeleton) && !(source.getEntity() instanceof Spider) && super.hurt(source, damage);
    }
}
