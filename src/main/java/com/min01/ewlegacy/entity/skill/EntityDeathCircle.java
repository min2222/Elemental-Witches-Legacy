package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityDarkWitch;
import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityDeathCircle extends AbstractOwnableMonster<EntityDarkWitch>
{
    public EntityDeathCircle(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 2.147483647E9)
    			.add(Attributes.MOVEMENT_SPEED, 0.0)
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
    public void aiStep() 
    {
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_circle", this);
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(8.0, 1.0, 8.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof LivingEntity) 
            {
                if(!(entitytargetcheck instanceof EntityDarkWitch))
                {
                    entitytargetcheck.hurt(DamageSource.MAGIC, Math.min(Mth.floor(2.0F), 60));
                    ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
                    ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(EWEffects.PARANOID.get(), 4000, 1));
                    if(this.random.nextInt(50) <= 20)
                    {
                        if(this.random.nextInt(10) == 1) 
                        {
                            entitytargetcheck.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 2) 
                        {
                            entitytargetcheck.playSound(SoundEvents.SPIDER_AMBIENT, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 3)
                        {
                            entitytargetcheck.playSound(SoundEvents.SPIDER_DEATH, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 4) 
                        {
                            entitytargetcheck.playSound(SoundEvents.ZOMBIE_AMBIENT, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 5)
                        {
                            entitytargetcheck.playSound(SoundEvents.ZOMBIE_HURT, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 6) 
                        {
                            entitytargetcheck.playSound(SoundEvents.ZOMBIE_DEATH, 2.0F, 0.6F);
                        }
                        if(this.random.nextInt(10) == 7) 
                        {
                            entitytargetcheck.playSound(SoundEvents.CREEPER_PRIMED, 2.0F, 0.6F);
                        }
                    }
                }
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_)
    {
    	return p_21016_.isBypassInvul();
    }
}
