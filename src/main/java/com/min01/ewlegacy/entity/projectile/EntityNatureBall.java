package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityNatureBall extends ThrowableProjectile implements ItemSupplier
{
    public EntityNatureBall(EntityType<? extends ThrowableProjectile> type, Level level)
    {
        super(type, level);
    }
    
    public EntityNatureBall(Level level, LivingEntity living)
    {
        super(EWEntities.NATURE_BALL.get(), living, level);
    }
    
    public EntityNatureBall(Level level, double x, double y, double z)
    {
        super(EWEntities.NATURE_BALL.get(), x, y, z, level);
    }
    
    @Override
    protected void defineSynchedData()
    {
    	
    }
    
    @Override
    protected float getGravity() 
    {
        return 0.05F;
    }
    
    @Override
    protected void onHit(HitResult p_37260_)
    {
    	super.onHit(p_37260_);
        this.playSound(SoundEvents.GRASS_BREAK, 1.0F, 1.0F);
        this.discard();
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if(hitResult.getEntity() != null) 
        {
            ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.POISON, 200, 20));
            hitResult.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 4.0F);
        }
    }
    
    @Override
    protected void onHitBlock(BlockHitResult hitResult)
    {
        //TODO
        /*int i = hitResult.getBlockPos().getX();
        int j = hitResult.getBlockPos().getY();
        int k = hitResult.getBlockPos().getZ();
        switch(hitResult.getDirection())
        {
            case DOWN: 
            {
                --j;
                break;
            }
            case UP: 
            {
                ++j;
                break;
            }
            case NORTH: 
            {
                --k;
                break;
            }
            case SOUTH: 
            {
                ++k;
                break;
            }
            case WEST: 
            {
                --i;
                break;
            }
            case EAST: 
            {
                ++i;
                break;
            }
        }*/
        /*if(this.level.isEmptyBlock(new BlockPos(i, j, k))) 
        {
            int rand = this.level.random.nextInt(10);
            switch(rand)
            {
                case 1:
                {
                    this.level.setBlockAndUpdate(new BlockPos(i, j, k), EWBlocks.POISON_PLANT.get().defaultBlockState());
                    break;
                }
                case 2: 
                {
                    this.level.setBlockAndUpdate(new BlockPos(i, j, k), EWBlocks.EXPLOSIVE_PLANT.get().defaultBlockState());
                    break;
                }
                case 3: 
                {
                    this.level.setBlockAndUpdate(new BlockPos(i, j, k), EWBlocks.SLOWNESS_PLANT.get().defaultBlockState());
                    break;
                }
                case 4: 
                {
                    this.level.setBlockAndUpdate(new BlockPos(i, j, k), EWBlocks.DARKNESS_PLANT.get().defaultBlockState());
                    break;
                }
                case 5: 
                {
                    this.level.setBlockAndUpdate(new BlockPos(i, j, k), EWBlocks.STRANGLING_PLANT_BOTTOM.get().defaultBlockState());
                    this.level.setBlockAndUpdate(new BlockPos(i, j + 1, k), EWBlocks.STRANGLING_PLANT_TOP.get().defaultBlockState());
                    break;
                }
            }
        }*/
    }
    
    @Override
    public ItemStack getItem()
    {
    	return new ItemStack(EWItems.NATURE_SHARD.get());
    }
}
