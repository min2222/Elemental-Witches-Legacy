package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityAirEgg;
import com.min01.ewlegacy.entity.skill.EntityMiniTornado;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityAirPhoenix3 extends TamableAnimal
{
    public static final float[][] RAINBOW_COLOR_TABLE = new float[][] { { 1.0F, 1.0F, 1.0F }, { 0.85F, 0.5F, 0.2F }, { 0.7F, 0.3F, 0.85F }, { 0.4F, 0.6F, 0.85F }, { 0.9F, 0.9F, 0.2F }, { 0.5F, 0.8F, 0.1F }, { 0.95F, 0.5F, 0.65F }, { 0.3F, 0.3F, 0.3F }, { 0.6F, 0.6F, 0.6F }, { 0.3F, 0.5F, 0.6F }, { 0.5F, 0.25F, 0.7F }, { 0.2F, 0.3F, 0.7F }, { 0.4F, 0.3F, 0.2F }, { 0.4F, 0.5F, 0.2F }, { 0.6F, 0.2F, 0.2F }, { 0.1F, 0.1F, 0.1F } };
    public int deathTicks;
    public int goldenTicks;
    public int tornadoTimer = 100;
    public int skill2Timer = 300;
    public boolean goldenTicksActivate = false;
    
    public EntityAirPhoenix3(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityAirPhoenix3.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.6);
    }
    
    @Override
    public void aiStep()
    {
        if(!this.onGround && this.getDeltaMovement().y < 0.0) 
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.6, 1));
        }
        if(this.tornadoTimer != 0 && this.getTarget() != null) 
        {
            --this.tornadoTimer;
        }
        if(this.skill2Timer != 0 && this.getTarget() != null) 
        {
            --this.skill2Timer;
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.isOrderedToSit())
        {
            ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 2.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("air_normal", this);
        if(this.getTarget() != null)
        {
            if(this.tornadoTimer == 0)
            {
                EntityMiniTornado entitywitherskull1 = new EntityMiniTornado(EWEntities.MINI_TORNADO.get(), this.level);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull1.startRiding(this.getTarget());
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                this.tornadoTimer = 300;
            }
            if(this.skill2Timer == 0 && this.getOwner() != null)
            {
                List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 20.0, 20.0));
                for(Entity entity1 : list) 
                {
                    if(entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner()) 
                    {
                        this.getOwner().addEffect(new MobEffectInstance(EWEffects.AIR_STANCE.get(), 2000, 1));
                        this.getOwner().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 1));
                        this.skill2Timer = 300;
                    }
                }
            }
        }
        if(this.goldenTicksActivate) 
        {
            ++this.goldenTicks;
            List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
            if(this.goldenTicks >= 0 && this.goldenTicks <= 140) 
            {
                for(int i = 1; i <= 4; ++i)
                {
                    ElementalWitchesLegacy.PROXY.spawnParticles("air_tornado_small", this);
                }
                for(Entity entity1 : list) 
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityAirPhoenix3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityAirPhoenix2) && !(entity1 instanceof EntityAirPhoenix))
                    {
                        if(!(entity1 instanceof EntityAirEgg)) 
                        {
                            double xx = entity1.getX() - this.getX();
                            double zz = entity1.getZ() - this.getZ();
                            entity1.setDeltaMovement(-xx / (4.0F * entity1.distanceTo(this)), entity1.getDeltaMovement().y, -zz / (4.0F * entity1.distanceTo(this)));
                        }
                    }
                }
            }
            if(this.goldenTicks == 140)
            {
                for(Entity entity1 : list) 
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityAirPhoenix3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityAirPhoenix2) && !(entity1 instanceof EntityAirPhoenix))
                    {
                        if(!(entity1 instanceof EntityAirEgg))
                        {
                            entity1.setDeltaMovement(entity1.getDeltaMovement().x, 2.0, entity1.getDeltaMovement().z);
                        }
                    }
                }
                if(this.getOwner() != null) 
                {
                    for(Entity entity1 : list) 
                    {
                        if(entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner()) 
                        {
                            this.getOwner().addEffect(new MobEffectInstance(EWEffects.AIR_STANCE.get(), 2000, 1));
                            this.getOwner().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 1));
                            this.skill2Timer = 300;
                        }
                    }
                }
                this.goldenTicksActivate = false;
                this.goldenTicks = 0;
            }
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath() 
    {
        ++this.deathTicks;
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            for(int i = 1; i <= 4; ++i)
            {
                ElementalWitchesLegacy.PROXY.spawnParticles("air_tornado_small", this);
            }
            for(Entity entity1 : list) 
            {
                if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityAirPhoenix3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityAirPhoenix2) && !(entity1 instanceof EntityAirPhoenix)) 
                {
                    if(!(entity1 instanceof EntityAirEgg)) 
                    {
                        double xx = entity1.getX() - this.getX();
                        double zz = entity1.getZ() - this.getZ();
                        entity1.setDeltaMovement(-xx / (4.0F * entity1.distanceTo(this)), entity1.getDeltaMovement().y, -zz / (4.0F * entity1.distanceTo(this)));
                    }
                }
            }
        }
        if(this.deathTicks == 140) 
        {
            EntityAirEgg mob = new EntityAirEgg(EWEntities.AIR_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            if(this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setCustomNameVisible(true);
            for(Entity entity2 : list)
            {
                if((!(entity2 instanceof Player) || !((Player)entity2).getAbilities().instabuild) && !(entity2 instanceof EntityAirPhoenix3) && (!(entity2 instanceof Player) || this.getOwner() == null || entity2 != this.getOwner()) && !(entity2 instanceof EntityAirPhoenix2) && !(entity2 instanceof EntityAirPhoenix))
                {
                    if(!(entity2 instanceof EntityAirEgg)) 
                    {
                        entity2.setDeltaMovement(entity2.getDeltaMovement().x, 2.0, entity2.getDeltaMovement().z);
                    }
                }
            }
            if(this.getOwner() != null)
            {
                for(Entity entity2 : list)
                {
                    if(entity2 instanceof Player && entity2 == this.getOwner()) 
                    {
                        this.getOwner().addEffect(new MobEffectInstance(EWEffects.AIR_STANCE.get(), 2000, 1));
                        this.getOwner().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 1));
                        this.skill2Timer = 300;
                    }
                }
            }
            this.discard();
        }
    }
    
    @Override
    public boolean isPushable() 
    {
        return this.deathTicks <= 0 && this.goldenTicks <= 0;
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
        return this.deathTicks <= 0 && this.goldenTicks <= 0;
    }
    
    @Override
    public boolean isPushedByFluid(FluidType type)
    {
        return this.deathTicks <= 0 && this.goldenTicks <= 0;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        return !(source.getEntity() instanceof EntityMiniTornado) && super.hurt(source, damage);
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        Random rand = new Random();
        int form = rand.nextInt(4);
        if(form == 1) 
        {
            float f4 = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
            if(f4 > 0.0F)
            {
            	target.push(this.getDeltaMovement().x * 3.0 * 0.6000000238418579 / f4, 0.1, this.getDeltaMovement().z * 3.0 * 0.6000000238418579 / f4);
            }
            target.hurt(DamageSource.mobAttack(this), 3.0F);
            return true;
        }
        if(form == 2) 
        {
        	target.hurt(DamageSource.mobAttack(this), 3.0F);
        	target.setDeltaMovement(target.getDeltaMovement().x, 1.0, target.getDeltaMovement().z);
            return true;
        }
        if(form == 3) 
        {
        	target.hurt(DamageSource.mobAttack(this), 7.0F);
            return true;
        }
        return false;
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
            if(target instanceof EntityAirPhoenix3) 
            {
            	EntityAirPhoenix3 entitywolf = (EntityAirPhoenix3) target;
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
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_)
    {
        if(!p_27584_.isShiftKeyDown())
        {
            if(!this.isOrderedToSit()) 
            {
                this.setTarget(null);
                this.setOrderedToSit(true);
            }
            else if(this.isOrderedToSit()) 
            {
                this.setOrderedToSit(false);
            }
        }
        else if(p_27584_.isHolding(Items.GOLDEN_APPLE) && !this.goldenTicksActivate) 
        {
            this.goldenTicksActivate = true;
            if(!p_27584_.getAbilities().instabuild)
            {
                ItemStack getHeldItem = p_27584_.getItemInHand(p_27585_);
                getHeldItem.shrink(1);
            }
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("PetSummonMiniTornado", this.tornadoTimer);
        compound.putInt("PetSkill2Timer", this.skill2Timer);
        compound.putInt("PetDeathTicks", this.deathTicks);
        compound.putInt("PetGoldenTick", this.goldenTicks);
        compound.putBoolean("PetGoldenTickBoolean", this.goldenTicksActivate);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.tornadoTimer = compound.getInt("PetSummonMiniTornado");
        this.skill2Timer = compound.getInt("PetSkill2Timer");
        this.deathTicks = compound.getInt("PetDeathTicks");
        this.goldenTicksActivate = compound.getBoolean("PetGoldenTickBoolean");
        this.goldenTicks = compound.getInt("PetGoldenTick");
    }
}
