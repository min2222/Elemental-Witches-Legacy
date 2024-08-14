package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelEarthGolem2;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem2;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class EarthGolem2Renderer extends EWMobRenderer<EntityEarthGolem2, ModelEarthGolem2>
{
	public EarthGolem2Renderer(Context p_174304_) 
	{
		super(p_174304_, new ModelEarthGolem2(p_174304_.bakeLayer(ModelEarthGolem2.LAYER_LOCATION)), 0.5F, "earth_golem_2");
	}

	@Override
	protected void scale(EntityEarthGolem2 p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(1.5F, 1.5F, 1.5F);
		p_115315_.translate(0.0F, -0.2F, 0.0F);
	}
}
