package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelLightningBeast2;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast2;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class LightningBeast2Renderer extends EWMobRenderer<EntityLightningBeast2, ModelLightningBeast2>
{
	public LightningBeast2Renderer(Context p_174304_) 
	{
		super(p_174304_, new ModelLightningBeast2(p_174304_.bakeLayer(ModelLightningBeast2.LAYER_LOCATION)), 0.5F, "lightning_beast_2");
	}

	@Override
	protected void scale(EntityLightningBeast2 p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.4F, 1.4F, 1.4F);
		p_115315_.translate(0.0F, -0.5F, -0.4F);
	}
}
