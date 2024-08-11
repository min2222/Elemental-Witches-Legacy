package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityWaterWitch;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;

public class EntityWaterMinion extends AbstractOwnableMonster<EntityWaterWitch>
{
    public EntityWaterMinion(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.2));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.2, 32.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.2)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 5.0);
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
    public boolean hurt(DamageSource source, float damage)
    {
        if(source.isFire()) 
        {
            this.playSound(SoundEvents.LAVA_EXTINGUISH, 1.0F, 1.0F);
            ElementalWitchesLegacy.PROXY.spawnParticles("water_evaporate", this);
            this.setHealth(this.getHealth() - 1.0F);
        }
        if(source.isBypassInvul())
        {
        	return super.hurt(source, damage);
        }
        return false;
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        this.level.setBlockAndUpdate(this.blockPosition(), Blocks.WATER.defaultBlockState());
        return true;
    }
    
    @Override
    public void aiStep() 
    {
        if(this.getHealth() <= 0.0F)
        {
            this.discard();
        }
        if(this.isOnFire())
        {
            this.clearFire();
        }
        if(this.isInWaterRainOrBubble())
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY());
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        Biome biome = this.level.getBiome(blockpos).value();
        if(biome.shouldSnowGolemBurn(blockpos))
        {
            this.playSound(SoundEvents.LAVA_EXTINGUISH, 1.0F, 1.0F);
            ElementalWitchesLegacy.PROXY.spawnParticles("water_evaporate", this);
            this.setHealth(this.getHealth() - 0.5F);
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
}
