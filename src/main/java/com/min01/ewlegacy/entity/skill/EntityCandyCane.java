package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityChristmasWitch;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityCandyCane extends AbstractOwnableMonster<EntityChristmasWitch>
{
    public float floatingRotation;
    
    public EntityCandyCane(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.2));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.2, 32.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return SoundEvents.ITEM_BREAK;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25)
    			.add(Attributes.ATTACK_DAMAGE, 1.5)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 10.0);
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
        this.floatingRotation += 0.02F;
        ElementalWitchesLegacy.PROXY.spawnParticles("toysParticle", this);
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityIcicle) && !(source.getEntity() instanceof PrimedTnt) && !(source.getEntity() instanceof EntityRifle) && !(source.getEntity() instanceof EntityChristmasWitch) && !(source.getEntity() instanceof EntityBlock) && super.hurt(source, damage);
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    public float getFloatingRotation() 
    {
        return 12.0F - Math.abs((float)Math.sin(this.floatingRotation) * 5.5F);
    }
}
