package com.min01.ewlegacy.entity.projectile;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityPumpkinSkull extends AbstractEWHurtingProjectile
{
    public EntityPumpkinSkull(EntityType<? extends AbstractEWHurtingProjectile> type, Level level)
    {
        super(type, level);
    }
    
    public EntityPumpkinSkull(Level level, LivingEntity living, double x, double y, double z) 
    {
        super(EWEntities.PUMPKIN_SKULL.get(), level, living, x, y, z);
    }
    
    public EntityPumpkinSkull(Level level, double x, double y, double z, double motionX, double motionY, double motionZ) 
    {
        super(EWEntities.PUMPKIN_SKULL.get(), level, x, y, z, motionX, motionY, motionZ);
    }
    
    @Override
    public float getBlockExplosionResistance(Explosion p_19992_, BlockGetter p_19993_, BlockPos p_19994_, BlockState p_19995_, FluidState p_19996_, float p_19997_)
    {
    	float f = super.getBlockExplosionResistance(p_19992_, p_19993_, p_19994_, p_19995_, p_19996_, p_19997_);
        if(this.isInvulnerable() && p_19995_ != Blocks.BEDROCK.defaultBlockState() && p_19995_ != Blocks.END_PORTAL.defaultBlockState() && p_19995_ != Blocks.END_PORTAL_FRAME.defaultBlockState() && p_19995_ != Blocks.COMMAND_BLOCK.defaultBlockState()) 
        {
            f = Math.min(0.8F, f);
        }
    	return f;
    }
    
    @Override
    protected void onHit(HitResult p_37260_)
    {
    	super.onHit(p_37260_);
        if(!this.level.isClientSide) 
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("pumpkin_shoot", this);
    }
    
    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if(!this.level.isClientSide) 
        {
            if(hitResult.getEntity() != null) 
            {
                if(this.getOwner() != null) 
                {
                    if(hitResult.getEntity().hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), 8.0F) && !hitResult.getEntity().isAlive())
                    {
                        ((LivingEntity) this.getOwner()).heal(3.0F);
                    }
                }
                else 
                {
                    hitResult.getEntity().hurt(DamageSource.MAGIC, 3.0F);
                }
                if(hitResult.getEntity() instanceof LivingEntity)
                {
                    byte b0 = 0;
                    if(this.level.getDifficulty() == Difficulty.NORMAL)
                    {
                        b0 = 10;
                    }
                    else if(this.level.getDifficulty() == Difficulty.HARD)
                    {
                        b0 = 15;
                    }
                    if(b0 > 0)
                    {
                        ((LivingEntity)hitResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * b0, 1));
                    }
                }
            }
        }
    }
    
    @Override
    protected void onHitBlock(BlockHitResult hitResult) 
    {
    	super.onHitBlock(hitResult);
        int i = hitResult.getBlockPos().getX();
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
        }
        if(this.level.isEmptyBlock(new BlockPos(i, j, k))) 
        {
            this.level.setBlockAndUpdate(new BlockPos(i, j, k), Blocks.JACK_O_LANTERN.defaultBlockState());
        }
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return false;
    }
}
