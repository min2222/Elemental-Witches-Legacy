package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelLightningBeast;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class LightningBeastRenderer extends EWMobRenderer<EntityLightningBeast, ModelLightningBeast>
{
	public LightningBeastRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelLightningBeast(p_174304_.bakeLayer(ModelLightningBeast.LAYER_LOCATION)), 0.5F, "lightning_beast");
	}

	@Override
	protected void scale(EntityLightningBeast p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.5F, 1.5F, 1.5F);
		p_115315_.translate(-0.15F, 0.5F, -0.1F);
	}
}
