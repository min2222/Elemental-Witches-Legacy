package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelWaterNymph;
import com.min01.ewlegacy.entity.pet.EntityWaterNymph;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class WaterNymphRenderer extends EWMobRenderer<EntityWaterNymph, ModelWaterNymph>
{
	public WaterNymphRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelWaterNymph(p_174304_.bakeLayer(ModelWaterNymph.LAYER_LOCATION)), 0.5F, "water_nymph");
	}

	@Override
	protected void scale(EntityWaterNymph p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.translate(0.0F, 0.2F, 0.0F);
	}
}
