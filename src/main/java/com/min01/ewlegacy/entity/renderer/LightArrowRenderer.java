package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class LightArrowRenderer extends ArrowRenderer<EntityLightArrow>
{
	public LightArrowRenderer(Context p_173917_)
	{
		super(p_173917_);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityLightArrow p_114482_) 
	{
		return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/light_arrow.png");
	}
}
