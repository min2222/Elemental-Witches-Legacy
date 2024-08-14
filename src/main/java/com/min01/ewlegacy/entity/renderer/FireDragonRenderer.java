package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelFireDragon;
import com.min01.ewlegacy.entity.pet.EntityFireDragon;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class FireDragonRenderer extends EWMobRenderer<EntityFireDragon, ModelFireDragon>
{
	public FireDragonRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelFireDragon(p_174304_.bakeLayer(ModelFireDragon.LAYER_LOCATION)), 0.5F, "fire_dragon");
	}

	@Override
	protected void scale(EntityFireDragon p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.5F, 1.5F, 1.5F);
		p_115315_.translate(-0.15F, 0.5F, -0.1F);
	}
}
