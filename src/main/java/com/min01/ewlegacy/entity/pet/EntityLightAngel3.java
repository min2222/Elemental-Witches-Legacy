package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityLightEgg;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;
import com.min01.ewlegacy.entity.skill.EntityLightShield;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class EntityLightAngel3 extends TamableAnimal
{
    public int skillTimer = 100;
    public int skill2Timer = 300;
    public int skill3Timer = 500;
    public int deathTicks;
    public int goldenTicks;
    public float floatingRotation;
    public boolean goldenTicksActivate = false;
    
    public EntityLightAngel3(EntityType<? extends TamableAnimal> type, Level level) 
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
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityLightAngel3.class));
        this.setTame(true);
    }
    
    public static boolean grow(Level world, int x, int y, int z, boolean flag) 
    {
    	BlockPos pos = new BlockPos(x, y, z);
        BlockState block = world.getBlockState(pos);
        if(block == Blocks.DIRT.defaultBlockState()) 
        {
        	//TODO?
            /*if(world.getBlockMetadata(x, y, z) == 1)
            {
                world.setBlockAndUpdate(pos, Blocks.MYCELIUM.defaultBlockState());
            }
            else 
            {
                world.setBlockAndUpdate(pos, Blocks.GRASS_BLOCK.defaultBlockState());
            }*/
            world.setBlockAndUpdate(pos, Blocks.GRASS_BLOCK.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.COBBLESTONE.defaultBlockState()) 
        {
            world.setBlockAndUpdate(pos, Blocks.MOSSY_COBBLESTONE.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.STONE_BRICKS.defaultBlockState()) 
        {
            world.setBlockAndUpdate(pos, Blocks.CRACKED_STONE_BRICKS.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.COBBLESTONE_WALL.defaultBlockState()) 
        {
            world.setBlockAndUpdate(pos, Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.SAND.defaultBlockState()) 
        {
            world.setBlockAndUpdate(pos, Blocks.CLAY.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.CLAY.defaultBlockState())
        {
            world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
            flag = true;
        }
        else if(block == Blocks.CACTUS.defaultBlockState() || block == Blocks.SUGAR_CANE.defaultBlockState())
        {
            world.setBlockAndUpdate(pos.above(), block);
            world.setBlockAndUpdate(pos.above(2), block);
            flag = true;
        }
        else if(block.getBlock() instanceof BonemealableBlock && !(block.getBlock() instanceof DoublePlantBlock))
        {
        	BonemealableBlock igrowable = (BonemealableBlock) block.getBlock();
            if (igrowable.isBonemealSuccess(world, world.random, pos, block)) 
            {
            	if(!world.isClientSide)
            	{
                    igrowable.performBonemeal((ServerLevel) world, world.random, pos, block);
            	}
                flag = true;
            }
        }
        return flag;
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.4);
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
        ElementalWitchesLegacy.PROXY.spawnParticles("light_normal", this);
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 4.6, this.getZ(), 0.0, 0.0, 0.0);
        }
        if(this.getTarget() != null) 
        {
            if(this.skillTimer == 0 && this.getOwner() != null) 
            {
                this.getOwner().addEffect(new MobEffectInstance(MobEffects.REGENERATION, 90, 1));
                this.skillTimer = 100;
            }
            if(this.skill2Timer == 0) 
            {
                for(int i = 0; i <= 60; ++i) 
                {
                    EntityLightArrow entitywitherskull1 = new EntityLightArrow(EWEntities.LIGHT_ARROW.get(), this.level);
                    entitywitherskull1.moveTo(this.getTarget().getX() + this.random.nextDouble() * 15.0 - 10.0, this.getY() + 40.0, this.getTarget().getZ() + this.random.nextDouble() * 15.0 - 10.0, 0.0F, 0.0F);
                    EWUtil.spawnInWorld(this.level, entitywitherskull1);
                    EntityLightArrow entityLightArrow = entitywitherskull1;
                    entityLightArrow.setDeltaMovement(entityLightArrow.getDeltaMovement().subtract(0, 1, 0));
                    if(i >= 60)
                    {
                        this.skill2Timer = 300;
                    }
                }
            }
            if(this.skill3Timer == 0) 
            {
                EntityLightShield entitywitherskull2 = new EntityLightShield(EWEntities.LIGHT_SHIELD.get(), this.level);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                if(this.getOwner() != null)
                {
                    entitywitherskull2.setOwnerUUID(this.getOwnerUUID());
                }
                this.skill3Timer = 500;
            }
        }
        if(this.goldenTicksActivate) 
        {
            ++this.goldenTicks;
            List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
            if(this.goldenTicks == 1) 
            {
            	if(!this.level.isClientSide)
            	{
                    ((ServerLevel) this.level).setDayTime(0L);
            	}
            }
            if(this.goldenTicks >= 0 && this.goldenTicks <= 140)
            {
                for(int j = 1; j <= 2; ++j) 
                {
                    ElementalWitchesLegacy.PROXY.spawnParticles("light_circle_small", this);
                }
                if(!this.level.isClientSide)
                {
                 	Random random = new Random();
                    for(int k = 0; k < 20; ++k)
                    {
                        int x1 = (int)this.getX() + random.nextInt(3) * 10 - 10;
                        int y1 = (int)this.getY() - 1;
                        int z1 = (int)this.getZ() + random.nextInt(3) * 10 - 10;
                        grow(this.level, x1, y1, z1, true);
                    }
                    for(Entity entity1 : list) 
                    {
                        if((entity1 instanceof Player && ((Player)entity1).getAbilities().instabuild) || entity1 instanceof EntityLightAngel || (entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner()) || entity1 instanceof EntityLightAngel2 || entity1 instanceof EntityLightAngel3 || entity1 instanceof EntityLightEgg) 
                        {
                            ((LivingEntity)entity1).addEffect(new MobEffectInstance(MobEffects.REGENERATION, 90, 1));
                        }
                    }
                }
                if(this.goldenTicks == 140) 
                {
                    for(Entity entity2 : list)
                    {
                        if((!(entity2 instanceof Player) || !((Player)entity2).getAbilities().instabuild) && !(entity2 instanceof EntityLightAngel) && (!(entity2 instanceof Player) || this.getOwner() == null || entity2 != this.getOwner()) && !(entity2 instanceof EntityLightAngel2) && !(entity2 instanceof EntityLightAngel3)) 
                        {
                            if(!(entity2 instanceof EntityLightEgg))
                            {
                                if(entity2 instanceof Mob) 
                                {
                                    entity2.hurt(DamageSource.MAGIC, ((Mob)entity2).getHealth() / 2.0F);
                                }
                            }
                        }
                    }
                    this.goldenTicksActivate = false;
                    this.goldenTicks = 0;
                }
            }
        }
        super.aiStep();
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
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(this.deathTicks == 1)
        {
        	if(!this.level.isClientSide)
        	{
                ((ServerLevel) this.level).setDayTime(0L);
        	}
        }
        if(this.deathTicks >= 0 && this.deathTicks <= 140)
        {
            for(int i = 1; i <= 2; ++i)
            {
            	ElementalWitchesLegacy.PROXY.spawnParticles("light_circle_small", this);
            }
            if(!this.level.isClientSide) 
            {
                Random random = new Random();
                for(int j = 0; j < 20; ++j) 
                {
                    int x1 = (int)this.getX() + random.nextInt(3) * 10 - 10;
                    int y1 = (int)this.getY() - 1;
                    int z1 = (int)this.getZ() + random.nextInt(3) * 10 - 10;
                    grow(this.level, x1, y1, z1, true);
                }
                for(Entity entity1 : list) 
                {
                    if((entity1 instanceof Player && ((Player)entity1).getAbilities().instabuild) || (entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner()))
                    {
                        this.getOwner().addEffect(new MobEffectInstance(MobEffects.REGENERATION, 90, 1));
                    }
                }
            }
            if(this.deathTicks == 140) 
            {
                EntityLightEgg mob = new EntityLightEgg(EWEntities.LIGHT_EGG.get(), this.level);
                mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, mob);
                if(this.getOwner() != null)
                {
                    mob.setOwnerUUID(this.getOwnerUUID());
                }
                mob.setCustomName(this.getCustomName());
                mob.setCustomNameVisible(true);
                for(Entity entity1 : list)
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityLightAngel) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityLightAngel2) && !(entity1 instanceof EntityLightAngel3)) 
                    {
                        if(!(entity1 instanceof EntityLightEgg)) 
                        {
                            if(entity1 instanceof Mob) 
                            {
                                entity1.hurt(DamageSource.MAGIC, ((Mob)entity1).getHealth() / 2.0F);
                            }
                        }
                    }
                }
                this.discard();
            }
        }
    }
    
    @Override
    public boolean doHurtTarget(Entity target) 
    {
        return target.hurt(DamageSource.mobAttack(this), 5.0F);
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
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityLightAngel3) 
            {
            	EntityLightAngel3 entitywolf = (EntityLightAngel3) target;
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
        compound.putInt("PetSkillLight", this.skillTimer);
        compound.putInt("PetSkill2Light", this.skill2Timer);
        compound.putInt("PetSkill3Light", this.skill3Timer);
        compound.putInt("PetGoldenTick", this.goldenTicks);
        compound.putBoolean("PetGoldenTickBoolean", this.goldenTicksActivate);
        compound.putFloat("PetFloatingRotation", this.floatingRotation);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.skillTimer = compound.getInt("PetSkillLight");
        this.skill2Timer = compound.getInt("PetSkill2Light");
        this.skill3Timer = compound.getInt("PetSkill3Light");
        this.goldenTicksActivate = compound.getBoolean("PetGoldenTickBoolean");
        this.goldenTicks = compound.getInt("PetGoldenTick");
        this.floatingRotation = compound.getFloat("PetFloatingRotation");
    }
    
    public float getFloatingRotation() 
    {
        return -35.0F - Math.abs((float)Math.sin(this.floatingRotation) * 2.5F);
    }
    
    public float getFloatingRotationShawl()
    {
        return -35.0F - Math.abs((float)Math.sin(this.floatingRotation) * 5.5F);
    }
    
    public float getFloatingRotationTail() 
    {
        return 0.0F - Math.abs((float)Math.sin(this.floatingRotation) * 5.5F);
    }
}
