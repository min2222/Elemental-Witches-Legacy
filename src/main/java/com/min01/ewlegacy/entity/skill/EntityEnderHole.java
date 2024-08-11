package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityDarkShoot;
import com.min01.ewlegacy.entity.witch.EntityDarkWitch;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class EntityEnderHole extends AbstractOwnableMonster<EntityDarkWitch>
{
    public int innerRotation = this.random.nextInt(100000);
    
    public EntityEnderHole(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
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
    public void tick() 
    {
        if(!this.onGround && this.getDeltaMovement().y <= 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.0, 1));
        }
        ++this.innerRotation;
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 10.0, 10.0));
        for(Entity entity1 : list) 
        {
            if(!(entity1 instanceof EntityDarkMark) && !(entity1 instanceof EntityDarkWitch) && !(entity1 instanceof EntityDarkShoot) && !(entity1 instanceof EntityDarkSummoner)) 
            {
            	boolean flag = entity1 instanceof Player player ? !player.getAbilities().instabuild : true;
                if(!(entity1 instanceof EntityEnderHole) && flag)
                {
                    double xx = entity1.getX() - this.getX();
                    double zz = entity1.getZ() - this.getZ();
                    entity1.setDeltaMovement(-xx / (16.0F * entity1.distanceTo(this)), entity1.getDeltaMovement().y, -zz / (16.0F * entity1.distanceTo(this)));
                }
            }
        }
        if(!this.level.isClientSide && this.tickCount >= 200)
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, explosion$blockinteraction);
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("ender_normal", this);
        super.tick();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public boolean canBeCollidedWith() 
    {
    	return true;
    }
    
    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_)
    {
    	return p_21016_.isBypassInvul();
    }
}
