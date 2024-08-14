package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.entity.witch.EntitySandWitch;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;

public class EntitySandGolem extends Monster
{
    public short squidAttack = 70;
    public short squidBomb = 150;
    public short squidWater = 200;
    public float floatingRotation;
    
    public EntitySandGolem(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
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
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.STONE_BREAK;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
    }
    
    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_) 
    {
    	super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);
        for(int j = this.random.nextInt(300 + p_21386_) + 1, k = 0; k < j; ++k)
        {
            this.spawnAtLocation(new ItemStack(Blocks.SANDSTONE), 0.0F);
        }
    	
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
    
    @Override
    public boolean canBeRiddenUnderFluidType(FluidType type, Entity rider) 
    {
    	return true;
    }
    
    @Override
    public void aiStep() 
    {
        this.floatingRotation += 0.02F;
        if(this.squidAttack != 0) 
        {
            --this.squidAttack;
        }
        if(this.squidBomb != 0) 
        {
            --this.squidBomb;
        }
        if(this.squidWater != 0) 
        {
            --this.squidWater;
        }
        if(this.getTarget() != null) 
        {
            if(this.squidAttack == 0) 
            {
                List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 20.0, 10.0));
                for(Entity entitytargetcheck : targetList)
                {
                    if(entitytargetcheck instanceof LivingEntity && !(entitytargetcheck instanceof EntitySandWitch)) 
                    {
                        if(!(entitytargetcheck instanceof EntitySandGolem))
                        {
                            ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4000, 1));
                        }
                    }
                }
                this.squidAttack = 70;
            }
            if(this.squidBomb == 0) 
            {
                int xx = (int)Math.floor(this.getTarget().getX());
                int yy = (int)Math.floor(this.getTarget().getY());
                int zz = (int)Math.floor(this.getTarget().getZ());
                EntityBlock entitywitherskull = new EntityBlock(this.level, (double)xx, (double)(yy + 3), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskull2 = new EntityBlock(this.level, (double)xx, (double)(yy + 3), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull3 = new EntityBlock(this.level, (double)xx, (double)(yy + 3), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull4 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 3), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul4 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 3), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul5 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 3), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul6 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 3), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul7 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 3), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul8 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 3), (double)(zz - 1), Blocks.SANDSTONE);
                this.level.addFreshEntity(entitywitherskull);
                this.level.addFreshEntity(entitywitherskull2);
                this.level.addFreshEntity(entitywitherskull3);
                this.level.addFreshEntity(entitywitherskull4);
                this.level.addFreshEntity(entitywitherskul4);
                this.level.addFreshEntity(entitywitherskul5);
                this.level.addFreshEntity(entitywitherskul6);
                this.level.addFreshEntity(entitywitherskul7);
                this.level.addFreshEntity(entitywitherskul8);
                EntityBlock entitywitherskull5 = new EntityBlock(this.level, (double)xx, (double)(yy + 4), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskull6 = new EntityBlock(this.level, (double)xx, (double)(yy + 4), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull7 = new EntityBlock(this.level, (double)xx, (double)(yy + 4), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull8 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 4), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul9 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 4), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul10 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 4), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul11 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 4), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul12 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 4), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul13 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 4), (double)(zz - 1), Blocks.SANDSTONE);
                this.level.addFreshEntity(entitywitherskull5);
                this.level.addFreshEntity(entitywitherskull6);
                this.level.addFreshEntity(entitywitherskull7);
                this.level.addFreshEntity(entitywitherskull8);
                this.level.addFreshEntity(entitywitherskul9);
                this.level.addFreshEntity(entitywitherskul10);
                this.level.addFreshEntity(entitywitherskul11);
                this.level.addFreshEntity(entitywitherskul12);
                this.level.addFreshEntity(entitywitherskul13);
                EntityBlock entitywitherskull9 = new EntityBlock(this.level, (double)xx, (double)(yy + 5), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskull10 = new EntityBlock(this.level, (double)xx, (double)(yy + 5), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull11 = new EntityBlock(this.level, (double)xx, (double)(yy + 5), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskull12 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 5), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul14 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 5), (double)zz, Blocks.SANDSTONE);
                EntityBlock entitywitherskul15 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 5), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul16 = new EntityBlock(this.level, (double)(xx - 1), (double)(yy + 5), (double)(zz - 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul17 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 5), (double)(zz + 1), Blocks.SANDSTONE);
                EntityBlock entitywitherskul18 = new EntityBlock(this.level, (double)(xx + 1), (double)(yy + 5), (double)(zz - 1), Blocks.SANDSTONE);
                this.level.addFreshEntity(entitywitherskull9);
                this.level.addFreshEntity(entitywitherskull10);
                this.level.addFreshEntity(entitywitherskull11);
                this.level.addFreshEntity(entitywitherskull12);
                this.level.addFreshEntity(entitywitherskul14);
                this.level.addFreshEntity(entitywitherskul15);
                this.level.addFreshEntity(entitywitherskul16);
                this.level.addFreshEntity(entitywitherskul17);
                this.level.addFreshEntity(entitywitherskul18);
                this.squidBomb = 150;
            }
            if(this.squidWater == 0) 
            {
                List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 20.0, 10.0));
                for(Entity entitytargetcheck : targetList) 
                {
                    if(entitytargetcheck instanceof LivingEntity) 
                    {
                        if(!(entitytargetcheck instanceof EntitySandGolem)) 
                        {
                            if(this.level.getBlockState(entitytargetcheck.blockPosition()).isAir())
                            {
                                this.level.setBlockAndUpdate(entitytargetcheck.blockPosition(), Blocks.SAND.defaultBlockState());
                            }
                        }
                    }
                }
                this.squidWater = 200;
            }
        }
        super.aiStep();
        if(!this.level.isClientSide)
        {
        	this.setDeltaMovement(0.0, this.getDeltaMovement().y - 0.08, 0.0);
        	this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.9800000190734863, 1));
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
        if(source.getEntity() instanceof LivingEntity && ((LivingEntity)source.getEntity()).getMainHandItem().getItem() instanceof PickaxeItem) 
        {
            return super.hurt(source, damage);
        }
        return super.hurt(source, 0.0F);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putShort("SquidAttack", this.squidAttack);
        compound.putShort("SquidBomb", this.squidBomb);
        compound.putShort("SquidHead", this.squidWater);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.squidAttack = compound.getShort("SquidAttack");
        this.squidBomb = compound.getShort("SquidBomb");
        this.squidWater = compound.getShort("SquidHead");
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    public float getFloatingRotation() 
    {
        return 10.0F - Math.abs((float)Math.sin(this.floatingRotation) * 5.5F);
    }
}
