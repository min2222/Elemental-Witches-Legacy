package com.min01.ewlegacy.entity.pet;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityHalloweenPumpking extends TamableAnimal
{
    public int TimerTeleport = 50;
    public int TimerControl = 200;
    public int TimerEvolve = 500;
    public boolean Control = false;
    
    public EntityHalloweenPumpking(EntityType<? extends TamableAnimal> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.3));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityHalloweenPumpking.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 80.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4);
    }
    
    @Override
    public void aiStep()
    {
        if(!this.isTame())
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("halloween_normal", this);
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(!this.level.isClientSide)
        {
            if(this.TimerEvolve != 0) 
            {
                --this.TimerEvolve;
            }
            if(this.TimerTeleport != 0) 
            {
                --this.TimerTeleport;
            }
            if(this.TimerControl != 0)
            {
                --this.TimerControl;
            }
        }
        if(this.TimerControl == 0) 
        {
            this.Control = true;
        }
        if(this.getTarget() != null) 
        {
            if(this.TimerTeleport == 0) 
            {
                this.teleportRandomly(this.getTarget());
                this.TimerTeleport = 10;
            }
            if(this.TimerControl == 0 && this.Control)
            {
                List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(7.0, 7.0, 7.0));
                for(int i = 0; i < list.size(); i++)
                {
                	Entity entity1 = list.get(i);
                    if(entity1 instanceof Mob && ((Mob)entity1).getMaxHealth() <= 20.0F) 
                    {
                        ((Mob)entity1).setTarget(this.getTarget());
                        if(i == list.size()) 
                        {
                            this.Control = false;
                            this.TimerControl = 50;
                        }
                    }
                }
            }
        }
        if(this.TimerEvolve == 0)
        {
            EntityHalloweenPumpkin mob = new EntityHalloweenPumpkin(EWEntities.HALLOWEEN_PUMPKIN.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            if(this.getOwner() != null)
            {
            	mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setTame(true);
            EWUtil.spawnInWorld(this.level, mob);
            mob.setCustomNameVisible(true);
            this.discard();
        }
        super.aiStep();
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        if(!this.level.isDay()) 
        {
            return target.hurt(DamageSource.mobAttack(this), 8.0F);
        }
        return target.hurt(DamageSource.mobAttack(this), 4.0F);
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) 
    {
    	return false;
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_)
    {
    	return null;
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityHalloweenPumpking) 
            {
            	EntityHalloweenPumpking entitywolf = (EntityHalloweenPumpking) target;
                if(entitywolf.isTame() && entitywolf.getOwner() == owner)
                {
                    return false;
                }
            }
            return (target instanceof Player && owner instanceof Player && !((Player)owner).canAttack((Player)target)) ? false : ((!(target instanceof Horse) || !((Horse)target).isTamed()));
        }
        return false;
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("TimerDevolve", this.TimerEvolve);
        compound.putInt("TimerControl", this.TimerControl);
        compound.putInt("TimerTeleport", this.TimerTeleport);
        compound.putBoolean("ControlBoolean", this.Control);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.TimerEvolve = compound.getInt("TimerDevolve");
        this.TimerControl = compound.getInt("TimerControl");
        this.TimerTeleport = compound.getInt("TimerTeleport");
        this.Control = compound.getBoolean("ControlBoolean");
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
}
