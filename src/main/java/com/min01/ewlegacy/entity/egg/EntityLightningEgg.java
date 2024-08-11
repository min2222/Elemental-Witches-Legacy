package com.min01.ewlegacy.entity.egg;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightAngel;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class EntityLightningEgg extends TamableAnimal
{
    public int TimerToHatch = 1000;
    
    public EntityLightningEgg(EntityType<? extends TamableAnimal> type, Level level)
    {
        super(type, level);
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.0);
    }
    
    @Override
    public void aiStep() 
    {
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(this.TimerToHatch == 0 && this.tickCount % 10 == 0)
        {
            for(Entity entity1 : list) 
            {
                if(entity1 instanceof Player && this.getOwner() != null && entity1 == this.getOwner())
                {
                    EntityLightAngel mob = new EntityLightAngel(EWEntities.LIGHTNING_BEAST.get(), this.level);
                    mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    if(this.getOwner() != null) 
                    {
                        mob.setOwnerUUID(this.getOwnerUUID());
                    }
                    mob.setCustomName(this.getCustomName());
                    EWUtil.spawnInWorld(this.level, mob);
                    mob.setCustomNameVisible(true);
                	//TODO
                	//((Player)this.getOwner()).awardStat(MWAWAchievementsRegistry.lightningpet2, 1);
                    this.discard();
                }
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("lightning_normal", this);
        if(this.tickCount % 20 == 0 && this.level.getBlockState(this.blockPosition().offset(0, -1, 0)) == Blocks.HAY_BLOCK.defaultBlockState())
        {
            --this.TimerToHatch;
            --this.TimerToHatch;
        }
        else if(this.tickCount % 20 == 0 && this.level.getBlockState(this.blockPosition().offset(0, -1, 0)) != Blocks.HAY_BLOCK.defaultBlockState())
        {
            --this.TimerToHatch;
        }
        for(Entity entity1 : list) 
        {
            if(entity1 instanceof Zombie || entity1 instanceof Spider || entity1 instanceof CaveSpider || entity1 instanceof Skeleton || entity1 instanceof Creeper)
            {
                ((Mob)entity1).setTarget(this);
            }
        }
        super.aiStep();
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("TimerToHatch", this.TimerToHatch);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.TimerToHatch = compound.getInt("TimerToHatch");
    }
    
    @Override
    public boolean removeWhenFarAway(double p_27598_) 
    {
    	return false;
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_) 
    {
        if(p_27584_.getAbilities().instabuild && p_27584_.isHolding(EWItems.LIGHTNING_SHARD.get())) 
        {
            this.TimerToHatch = 3;
        }
        if(this.isTame()) 
        {
            if(!this.isPassenger()) 
            {
                this.startRiding(p_27584_);
            }
            else if(this.isPassenger()) 
            {
                this.stopRiding();
            }
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
}
