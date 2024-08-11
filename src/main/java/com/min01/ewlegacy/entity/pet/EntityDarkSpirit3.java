package com.min01.ewlegacy.entity.pet;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.entity.egg.EntityDarkEgg;
import com.min01.ewlegacy.entity.skill.EntityDeathCircle2;
import com.min01.ewlegacy.entity.skill.EntityNinjaKhan;
import com.min01.ewlegacy.entity.skill.EntitySmallDarkMark;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class EntityDarkSpirit3 extends TamableAnimal
{
    public int skillTimer = 100;
    public int skill2Timer = 300;
    public int skill3Timer = 500;
    public int goldenTicks;
    public int deathTicks;
    public boolean goldenTicksActivate = false;
    public float floatingRotation;
    
    public EntityDarkSpirit3(EntityType<? extends TamableAnimal> type, Level level) 
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityDarkSpirit3.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        return target.hurt(DamageSource.mobAttack(this), 10.0F);
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
        if(this.isInWater()) 
        {
           	this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(!this.onGround && this.getDeltaMovement().y < 0.0) 
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.9, 1));
        }
        if(this.getTarget() != null && this.skillTimer != 0) 
        {
            --this.skillTimer;
        }
        if(this.getTarget() != null && this.skill2Timer != 0)
        {
            --this.skill2Timer;
        }
        if(this.getTarget() != null && this.skill3Timer != 0)
        {
            --this.skill3Timer;
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.isOrderedToSit())
        {
            ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 4.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", this);
        if(this.getTarget() != null)
        {
            if(this.skillTimer == 0)
            {
                EntityNinjaKhan entitywitherskull1 = new EntityNinjaKhan(EWEntities.NINJA_KHAN.get(), this.level);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                if(this.getOwner() != null)
                {
                	entitywitherskull1.setOwnerUUID(this.getOwnerUUID());
                }
                entitywitherskull1.setTarget(this.getTarget());
                
                EntityNinjaKhan entitywitherskull2 = new EntityNinjaKhan(EWEntities.NINJA_KHAN.get(), this.level);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                if(this.getOwner() != null)
                {
                	entitywitherskull2.setOwnerUUID(this.getOwnerUUID());
                }
                entitywitherskull2.setTarget(this.getTarget());
                this.skillTimer = 100;
            }
            if(this.skill2Timer == 0)
            {
                List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(7.0, 7.0, 7.0));
                for(Entity entity1 : list) 
                {
                    if(entity1 instanceof Mob && ((Mob)entity1).getMaxHealth() <= 20.0F)
                    {
                        ((Mob)entity1).setTarget(this.getTarget());
                        this.skill2Timer = 300;
                    }
                }
            }
            if(this.skill3Timer == 0) 
            {
                EntitySmallDarkMark entitywitherskull3 = new EntitySmallDarkMark(EWEntities.SMALL_DARK_MARK.get(), this.level);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                if(this.getOwner() != null)
                {
                	entitywitherskull3.setOwnerUUID(this.getOwnerUUID());
                }
                this.skill3Timer = 500;
            }
        }
        if(this.goldenTicksActivate) 
        {
            ++this.goldenTicks;
            if(this.goldenTicks == 1)
            {
            	if(!this.level.isClientSide)
            	{
                    ((ServerLevel) this.level).setDayTime(18000L);
            	}
            }
            if(this.goldenTicks == 5)
            {
                EntityDeathCircle2 entitywitherskull4 = new EntityDeathCircle2(EWEntities.DEATH_CIRCLE_2.get(), this.level);
                entitywitherskull4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                if(this.getOwner() != null)
                {
                	entitywitherskull4.setOwnerUUID(this.getOwnerUUID());
                }
                EWUtil.spawnInWorld(this.level, entitywitherskull4);
            }
            if(this.goldenTicks >= 0 && this.goldenTicks <= 140)
            {
                for(int j = 1; j <= 2; ++j)
                {
                    ElementalWitchesLegacy.PROXY.spawnParticles("dark_tornado", this);
                }
            }
        }
        if(this.goldenTicks == 140)
        {
            if(EWConfig.canDarkWitchDestroyLight.get()) 
            {
                this.destroyLight();
            }
            this.goldenTicksActivate = false;
            this.goldenTicks = 0;
        }
        super.aiStep();
    }
    
    public void destroyLight()
    {
        int radius = 15;
        if(!this.level.isClientSide) 
        {
            for(int x = -radius; x <= radius; ++x)
            {
                for(int y = -radius; y <= radius; ++y) 
                {
                    for(int z = -radius; z <= radius; ++z) 
                    {
                    	BlockPos pos = new BlockPos(this.getBlockX() + x, this.getBlockY() + y, this.getBlockZ() + z);
                        BlockState id = this.level.getBlockState(pos);
                        if(id != null && id.getLightEmission(this.level, pos) > 15 * 0.5F) 
                        {
                            Block.dropResources(id, this.level, pos);
                            this.level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                            id.onBlockExploded(this.level, pos, new Explosion(this.level, this, 0.0, 0.0, 0.0, 0.0F));
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
    {
    	return false;
    }
    
    @Override
    protected void tickDeath() 
    {
        ++this.deathTicks;
        if(this.deathTicks == 1) 
        {
        	if(!this.level.isClientSide)
        	{
                ((ServerLevel) this.level).setDayTime(18000L);
        	}
        }
        if(this.deathTicks == 5) 
        {
            EntityDeathCircle2 entitywitherskull1 = new EntityDeathCircle2(EWEntities.DEATH_CIRCLE_2.get(), this.level);
            entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            if(this.getOwner() != null)
            {
            	entitywitherskull1.setOwnerUUID(this.getOwnerUUID());
            }
            EWUtil.spawnInWorld(this.level, entitywitherskull1);
        }
        if(this.deathTicks >= 0 && this.deathTicks <= 140)
        {
            for(int i = 1; i <= 2; ++i)
            {
                ElementalWitchesLegacy.PROXY.spawnParticles("dark_tornado", this);
            }
        }
        if(this.deathTicks == 140) 
        {
            if(EWConfig.canDarkWitchDestroyLight.get())
            {
                this.destroyLight();
            }
            EntityDarkEgg mob = new EntityDarkEgg(EWEntities.DARK_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            if(this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setCustomNameVisible(true);
            this.discard();
        }
    }
    
    @Override
    public boolean isPushable() 
    {
        return this.deathTicks <= 0;
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
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_)
    {
    	return null;
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityDarkSpirit3) 
            {
                EntityDarkSpirit3 entitywolf = (EntityDarkSpirit3) target;
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
        compound.putInt("PetSkillDark", this.skillTimer);
        compound.putInt("PetSkill2Dark", this.skill2Timer);
        compound.putInt("PetSkill3Dark", this.skill3Timer);
        compound.putInt("PetDeathTicks", this.deathTicks);
        compound.putBoolean("PetGoldenTickBoolean", this.goldenTicksActivate);
        compound.putInt("PetGoldenTick", this.goldenTicks);
        compound.putFloat("PetFloatingRotation", this.floatingRotation);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.skillTimer = compound.getInt("PetSkillDark");
        this.skill2Timer = compound.getInt("PetSkill2Dark");
        this.skill3Timer = compound.getInt("PetSkill3Dark");
        this.deathTicks = compound.getInt("PetDeathTicks");
        this.goldenTicksActivate = compound.getBoolean("PetGoldenTickBoolean");
        this.goldenTicks = compound.getInt("PetGoldenTick");
        this.floatingRotation = compound.getFloat("PetFloatingRotation");
    }
    
    public float getFloatingRotation() 
    {
        return -16.0F - Math.abs((float)Math.sin(this.floatingRotation) * 1.5F);
    }
}
