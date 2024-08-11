package com.min01.ewlegacy.entity.witch;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.projectile.EntityChristmasShoot;
import com.min01.ewlegacy.entity.skill.EntityBigSnowGolem;
import com.min01.ewlegacy.entity.skill.EntityBlock;
import com.min01.ewlegacy.entity.skill.EntityCandyCane;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
import com.min01.ewlegacy.entity.skill.EntityRifle;
import com.min01.ewlegacy.init.EWBlocks;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;

public class EntityChristmasWitch extends Raider implements RangedAttackMob
{
    int summonChristmas = 600;
    int summonChristmasToy = 300;
    int summonPresent = 400;
    boolean deathSummon = false;
    boolean summoned = false;
    
    public EntityChristmasWitch(EntityType<? extends Raider> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 60, 10.0F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
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
        if(this.summonChristmas != 0 && this.getTarget() != null)
        {
            --this.summonChristmas;
        }
        if(this.summonChristmasToy != 0 && this.getTarget() != null) 
        {
            --this.summonChristmasToy;
        }
        if(this.summonPresent != 0)
        {
            --this.summonPresent;
        }
        if(this.getHealth() < 20.0F && !this.deathSummon)
        {
            this.deathSummon = true;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("christmas_normal", this);
        if(this.summonPresent == 0 && this.level.getBlockState(this.blockPosition()).isAir())
        {
            EntityBlock block = new EntityBlock(this.level, 0.0, 0.0, 0.0, EWBlocks.PRESENT.get());
            block.setPos(this.position());
            EWUtil.spawnInWorld(this.level, block);
            this.summonPresent = 400;
        }
        if(this.getTarget() != null) 
        {
            if(this.deathSummon && !this.summoned)
            {
                Minecart cart = new Minecart(EntityType.MINECART, this.level);
                cart.setPos(this.position());
                Bat bat = new Bat(EntityType.BAT, this.level);
                bat.setPos(this.position());
                bat.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20000, 1));
                bat.setAbsorptionAmount(1000.0F);
                bat.setCustomName(Component.literal("Merry Christmas"));
                for(int i = 1; i <= 3; ++i)
                {
                    EntityBigSnowGolem golem = new EntityBigSnowGolem(EWEntities.BIG_SNOW_GOLEM.get(), this.level);
                    golem.setOwner(this);
                    golem.setPos(this.position());
                    golem.setTarget(this.getTarget());
                    EWUtil.spawnInWorld(this.level, golem);
                }
                EWUtil.spawnInWorld(this.level, cart);
                EWUtil.spawnInWorld(this.level, bat);
                this.startRiding(cart);
                cart.startRiding(bat);
                this.summoned = true;
            }
            if(this.summonChristmasToy == 0) 
            {
                EntityCandyCane sword = new EntityCandyCane(EWEntities.CANDY_CANE.get(), this.level);
                sword.setOwner(this);
                sword.setPos(this.position());
                sword.setTarget(this.getTarget());
                sword.setTarget(this.getTarget());
                EntityRifle rifle = new EntityRifle(EWEntities.RIFLE.get(), this.level);
                rifle.setOwner(this);
                rifle.setPos(this.position());
                rifle.setTarget(this.getTarget());
                rifle.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, sword);
                EWUtil.spawnInWorld(this.level, rifle);
                this.summonChristmasToy = 300;
            }
            if(this.summonChristmas == 0 && this.getHealth() > 20.0f)
            {
                EntityBigSnowGolem golem2 = new EntityBigSnowGolem(EWEntities.BIG_SNOW_GOLEM.get(), this.level);
                golem2.setOwner(this);
                golem2.setPos(this.position());
                golem2.setTarget(this.getTarget());
                EWUtil.spawnInWorld(this.level, golem2);
                this.startRiding(golem2);
                this.summonChristmas = 600;
            }
        }
        if(this.random.nextFloat() < 7.5E-4f) 
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
        EntityChristmasShoot entitywitherskull = new EntityChristmasShoot(this.level, this, d6, d7, d8);
        entitywitherskull.setPos(d3, d4 + 0.5, d5);
        EWUtil.spawnInWorld(this.level, entitywitherskull);
    }
    
    @Override
    public void remove(RemovalReason p_146834_) 
    {
    	super.remove(p_146834_);
    	if(this.getVehicle() != null && this.getVehicle() instanceof Minecart)
    	{
    		this.getVehicle().discard();
    		if(this.getVehicle().getVehicle() != null && this.getVehicle().getVehicle() instanceof Bat)
    		{
    			this.getVehicle().getVehicle().discard();
    		}
    	}
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityIcicle) && !(source.getEntity() instanceof PrimedTnt) && !(source.getEntity() instanceof EntityRifle) && !(source.getEntity() instanceof EntityBlock) && !(source.getEntity() instanceof EntityChristmasShoot) && super.hurt(source, damage);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("WitchSummonChristmas", this.summonChristmas);
        compound.putInt("WitchSummonChristmasToy", this.summonChristmasToy);
        compound.putInt("WitchSummonPresent", this.summonPresent);
        compound.putBoolean("WitchDeathSummon", this.deathSummon);
        compound.putBoolean("WitchDeathSummoned", this.summoned);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.summonChristmas = compound.getInt("WitchSummonChristmas");
        this.summonChristmasToy = compound.getInt("WitchSummonChristmasToy");
        this.summonPresent = compound.getInt("WitchSummonPresent");
        this.deathSummon = compound.getBoolean("WitchDeathSummon");
        this.summoned = compound.getBoolean("WitchDeathSummoned");
    }

    @Override
    public boolean removeWhenFarAway(double p_37894_)
    {
    	return false;
    }
}
