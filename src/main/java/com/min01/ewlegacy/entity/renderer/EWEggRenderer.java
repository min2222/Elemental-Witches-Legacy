package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelEgg;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class EWEggRenderer<T extends Mob> extends EWMobRenderer<T, ModelEgg<T>>
{
	public EWEggRenderer(Context p_174304_, float p_174306_, String textureName) 
	{
		super(p_174304_, new ModelEgg<>(p_174304_.bakeLayer(ModelEgg.LAYER_LOCATION)), p_174306_, textureName);
	}
	
	@Override
	public void render(T p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) 
	{
		if(p_115455_.isPassenger() && p_115455_.getVehicle() instanceof LivingEntity)
		{
			p_115458_.translate(0.0F, 1.2F, 0.0F);
		}
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
	}
}
