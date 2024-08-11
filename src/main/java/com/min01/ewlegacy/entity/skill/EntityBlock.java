package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.entity.witch.EntityChristmasWitch;
import com.min01.ewlegacy.entity.witch.EntityEarthMinion;
import com.min01.ewlegacy.entity.witch.EntityEarthWitch;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class EntityBlock extends FallingBlockEntity
{
    public BlockState block;
    
    public EntityBlock(EntityType<? extends FallingBlockEntity> type, Level world)
    {
        super(type, world);
    }
    
    public EntityBlock(Level world, double x, double y, double z, Block block) 
    {
        this(EWEntities.BLOCK.get(), world);
        this.block = block.defaultBlockState();
        this.blocksBuilding = true;
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.setStartPos(this.blockPosition());
    }
    
    @Override
    public void tick() 
    {
    	super.tick();
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(1.0, 1.0, 1.0));
        for(Entity entitytargetcheck : targetList) 
        {
            if(entitytargetcheck instanceof LivingEntity && !(entitytargetcheck instanceof EntityEarthWitch) && !(entitytargetcheck instanceof EntityEarthMinion) && !(entitytargetcheck instanceof EntityBlock) && !(entitytargetcheck instanceof EntityChristmasWitch) && !(entitytargetcheck instanceof Bat) && !(entitytargetcheck instanceof Minecart) && !(entitytargetcheck instanceof EntityRifle) && !(entitytargetcheck instanceof EntityCandyCane))
            {
                if(!(entitytargetcheck instanceof EntityBigSnowGolem)) 
                {
                    int k = Mth.ceil(1.0F);
                    entitytargetcheck.hurt(DamageSource.FALLING_BLOCK, (float)Math.min(Math.floor(k * 2.0F), 60));
                    ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
                }
            }
        }
        if(this.tickCount >= 30) 
        {
            this.level.setBlockAndUpdate(this.blockPosition(), this.block);
            this.discard();
        }
    }
    
    @Override
    public boolean causeFallDamage(float distance, float p_149644_, DamageSource p_149645_)
    {
        int i = Mth.ceil(distance - 1.0F);
        if(i > 0)
        {
            boolean hurt = false;
            for(Entity entity : this.level.getEntities(this, this.getBoundingBox())) 
            {
            	entity.hurt(DamageSource.FALLING_BLOCK, (float)Math.min(Mth.floor(i * 3.0F), 60));
                if(!hurt)
                {
                    hurt = true;
                }
            }
        }
    	return false;
    }
}
