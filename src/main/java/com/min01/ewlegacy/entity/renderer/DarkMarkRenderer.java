package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelDarkMark;
import com.min01.ewlegacy.entity.skill.EntityDarkMark;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class DarkMarkRenderer extends EWMobRenderer<EntityDarkMark, ModelDarkMark<EntityDarkMark>>
{
	public DarkMarkRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelDarkMark<>(p_174304_.bakeLayer(ModelDarkMark.LAYER_LOCATION)), 0.5F, "dark_mark");
	}
	
	@Override
	protected void scale(EntityDarkMark p_115314_, PoseStack p_115315_, float p_115316_) 
	{
		p_115315_.scale(1.5F, 1.5F, 1.5F);
	}
}
