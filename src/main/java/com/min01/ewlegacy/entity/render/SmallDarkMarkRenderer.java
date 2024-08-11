package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.model.ModelDarkMark;
import com.min01.ewlegacy.entity.skill.EntitySmallDarkMark;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class SmallDarkMarkRenderer extends EWMobRenderer<EntitySmallDarkMark, ModelDarkMark<EntitySmallDarkMark>>
{
	public SmallDarkMarkRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelDarkMark<>(p_174304_.bakeLayer(ModelDarkMark.LAYER_LOCATION)), 0.5F * 0.3F, "dark_mark");
	}
	
	@Override
	protected void scale(EntitySmallDarkMark p_115314_, PoseStack p_115315_, float p_115316_) 
	{
		p_115315_.scale(0.3F, 0.3F, 0.3F);
		p_115315_.translate(0.0F, -0.5F, 0.0F);
	}
}
