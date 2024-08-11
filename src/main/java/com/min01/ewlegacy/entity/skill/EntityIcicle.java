package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;
import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityIcicle extends Monster
{
    public EntityIcicle(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 2.147483647E9)
    			.add(Attributes.ATTACK_DAMAGE, 2.5)
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
    public void aiStep()
    {
        if(this.onGround)
        {
            this.level.playSound(null, this, SoundEvents.GLASS_BREAK, this.getSoundSource(), 5.0F, 1.0F);
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_block", this);
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(1.0, 2.0, 1.0));
        for(Entity entity1 : list) 
        {
            if(!(entity1 instanceof EntityIceWitch) && !(entity1 instanceof EntityIceCube) && !(entity1 instanceof EntityIceCrystal) && !(entity1 instanceof EntityFrostNova) && (!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild))
            {
                if(!(entity1 instanceof EntityBigIceCube))
                {
                    if(entity1 instanceof LivingEntity) 
                    {
                        ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 100, 3));
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
