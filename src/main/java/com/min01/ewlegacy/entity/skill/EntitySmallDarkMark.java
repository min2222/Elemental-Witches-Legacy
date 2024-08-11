package com.min01.ewlegacy.entity.skill;

import java.util.List;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntitySmallDarkMark extends TamableAnimal
{
    public EntitySmallDarkMark(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.noCulling = true;
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
        if(this.tickCount >= 400)
        {
            this.discard();
        }
        if(this.getDeltaMovement().y <= -0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(5.0, 3.0, 5.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof Mob) 
            {
                List<Entity> targetList2 = this.level.getEntities(entitytargetcheck, entitytargetcheck.getBoundingBox().expandTowards(5.0, 3.0, 5.0));
                for(Entity entitytargetcheck2 : targetList2)
                {
                    if(entitytargetcheck2 instanceof Mob)
                    {
                        ((Mob)entitytargetcheck).setTarget((LivingEntity) entitytargetcheck2);
                        ((Mob)entitytargetcheck2).setTarget((LivingEntity) entitytargetcheck);
                    }
                }
            }
            if(entitytargetcheck instanceof Player && entitytargetcheck == this.getOwner()) 
            {
                this.moveTo(entitytargetcheck.getX(), entitytargetcheck.getY() + 0.7, entitytargetcheck.getZ(), 0.0F, 0.0F);
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
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
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
}
