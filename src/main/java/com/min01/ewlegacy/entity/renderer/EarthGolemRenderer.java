package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelEarthGolem;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class EarthGolemRenderer extends EWMobRenderer<EntityEarthGolem, ModelEarthGolem>
{
	public EarthGolemRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelEarthGolem(p_174304_.bakeLayer(ModelEarthGolem.LAYER_LOCATION)), 0.5F, "earth_golem");
	}

	@Override
	protected void scale(EntityEarthGolem p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.5F, 1.5F, 1.5F);
		p_115315_.translate(-0.15F, 0.5F, -0.1F);
	}
}
