package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelFireDragon2;
import com.min01.ewlegacy.entity.pet.EntityFireDragon2;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class FireDragon2Renderer extends EWMobRenderer<EntityFireDragon2, ModelFireDragon2>
{
	public FireDragon2Renderer(Context p_174304_) 
	{
		super(p_174304_, new ModelFireDragon2(p_174304_.bakeLayer(ModelFireDragon2.LAYER_LOCATION)), 0.5F, "fire_dragon_2");
	}

	@Override
	protected void scale(EntityFireDragon2 p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.4F, 1.4F, 1.4F);
		p_115315_.translate(0.0F, 0.0F, -0.5F);
	}
}
