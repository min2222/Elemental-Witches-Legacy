package com.min01.ewlegacy.entity.projectile;

import java.util.List;

import com.min01.ewlegacy.entity.skill.EntityGiantSquid;
import com.min01.ewlegacy.entity.witch.EntityWaterWitch;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntitySquidInkBomb extends ThrowableProjectile implements ItemSupplier
{
    public EntitySquidInkBomb(EntityType<? extends ThrowableProjectile> type, Level level) 
    {
        super(type, level);
    }
    
    public EntitySquidInkBomb(Level level, LivingEntity living)
    {
        super(EWEntities.INK_BOMB.get(), living, level);
    }
    
    public EntitySquidInkBomb(Level level, double x, double y, double z) 
    {
        super(EWEntities.INK_BOMB.get(), x, y, z, level);
        this.noCulling = true;
    }
    
    @Override
    protected void defineSynchedData()
    {
    	
    }
    
    @Override
    protected void onHit(HitResult hitResult) 
    {
    	super.onHit(hitResult);
        List<Entity> targetList = this.level.getEntities(this, this.getBoundingBox().expandTowards(2.0, 2.0, 2.0));
        for(Entity entitytargetcheck : targetList)
        {
            if(entitytargetcheck instanceof LivingEntity) 
            {
                if(!(entitytargetcheck instanceof EntityWaterWitch | entitytargetcheck instanceof EntityGiantSquid)) 
                {
                    entitytargetcheck.hurt(DamageSource.thrown(this, this.getOwner()), 0.5F);
                    Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
                    this.level.explode(this, this.getX(), this.getY(), this.getZ(), 0.0F, false, explosion$blockinteraction);
                    ((LivingEntity)entitytargetcheck).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 1));
                }
            }
        }
        if(!this.level.isClientSide)
        {
            this.discard();
        }
    }
    
    @Override
    public ItemStack getItem() 
    {
    	return new ItemStack(Items.INK_SAC);
    }
}
