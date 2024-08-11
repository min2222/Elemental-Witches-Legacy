package com.min01.ewlegacy.entity.projectile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityLightArrow extends AbstractArrow
{
	public EntityLightArrow(EntityType<? extends AbstractArrow> p_36711_, Level p_36715_) 
	{
		super(p_36711_, p_36715_);
		this.pickup = Pickup.DISALLOWED;
	}
	
	public EntityLightArrow(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_,double p_36714_, Level p_36715_) 
	{
		super(p_36711_, p_36712_, p_36713_, p_36714_, p_36715_);
		this.pickup = Pickup.DISALLOWED;
	}
	
	public EntityLightArrow(EntityType<? extends AbstractArrow> p_36711_, LivingEntity p_36718_, Level p_36715_) 
	{
		super(p_36711_, p_36718_, p_36715_);
		this.pickup = Pickup.DISALLOWED;
	}
	
	//TODO
    public static DamageSource causeLightArrowDamage(EntityLightArrow entitylightarrow, Entity entity) 
    {
        return new IndirectEntityDamageSource("light_arrow", entitylightarrow, entity).setProjectile();
    }

	@Override
	protected ItemStack getPickupItem()
	{
		return ItemStack.EMPTY;
	}
}
