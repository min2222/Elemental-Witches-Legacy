package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityDarkEgg;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit2;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit3;
import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityDeathCircle2 extends TamableAnimal
{
    public EntityDeathCircle2(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.setTame(true);
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
        if(this.tickCount >= 500)
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_circle_2", this);
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 1.0, 10.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof LivingEntity && (!(entitytargetcheck instanceof Player) || !((Player)entitytargetcheck).getAbilities().instabuild) && !(entitytargetcheck instanceof EntityDarkSpirit3) && (!(entitytargetcheck instanceof Player) || entitytargetcheck != this.getOwner()) && !(entitytargetcheck instanceof EntityDarkSpirit2) && !(entitytargetcheck instanceof EntityDarkSpirit) && !(entitytargetcheck instanceof EntityDarkEgg))
            {
                if(!(entitytargetcheck instanceof EntityNinjaKhan))
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
        for(Entity entity1 : targetList) 
        {
            if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityDarkSpirit3) && (!(entity1 instanceof Player) || entity1 != this.getOwner()) && !(entity1 instanceof EntityDarkSpirit2) && !(entity1 instanceof EntityDarkSpirit)) 
            {
                if(!(entity1 instanceof EntityNinjaKhan)) 
                {
                    double xx = entity1.getX() - this.getX();
                    double zz = entity1.getZ() - this.getZ();
                    entity1.setDeltaMovement(-xx / (16.0F * entity1.distanceTo(this)), entity1.getDeltaMovement().y, -zz / (16.0F * entity1.distanceTo(this)));
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
    public boolean removeWhenFarAway(double p_27598_) 
    {
    	return false;
    }
    
    @Override
    public boolean hurt(DamageSource p_27567_, float p_27568_)
    {
    	return p_27567_.isBypassInvul();
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_)
    {
    	return null;
    }
}
