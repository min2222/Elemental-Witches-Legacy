package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityDarkWitch;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityDarkMark extends AbstractOwnableMonster<EntityDarkWitch>
{
    int timer = 10;
    
    public EntityDarkMark(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityLightWitch.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 10.0)
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
    protected SoundEvent getAmbientSound() 
    {
    	return EWSounds.LAUGH.get();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return null;
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
        if(this.timer != 0 && this.getTarget() != null) 
        {
            --this.timer;
        }
        if(this.tickCount >= 400)
        {
            this.discard();
        }
        if(this.getDeltaMovement().y <= -0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(this.getHealth() <= 0.0F) 
        {
            this.discard();
        }
        if(this.tickCount % 20 == 0)
        {
            List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(5.0, 100.0, 5.0));
        	if(this.getOwner() != null)
        	{
            	this.getOwner().setHealth(this.getOwner().getHealth() + 3.0F);
            }
            if(!this.level.isClientSide)
            {
            	if(this.getOwner() != null)
            	{
                    this.moveTo(this.getOwner().getX(), this.getOwner().getY() + 4.0, this.getOwner().getZ());
            	}
                for(Entity entity1 : list) 
                {
                    if(entity1 instanceof Player)
                    {
                        ((Player)entity1).addEffect(new MobEffectInstance(EWEffects.PARANOID.get(), 4000, 1));
                    }
                }
            }
            ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", this);
            ElementalWitchesLegacy.PROXY.spawnParticles("dark_mark", this);
            if(this.getTarget() != null && this.getTarget() instanceof Mob) 
            {
                ((Mob)this.getTarget()).setTarget(this);
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
}
