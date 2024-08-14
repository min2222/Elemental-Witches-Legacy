package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelIcicle;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class IcicleRenderer extends EWTranslucentMobRenderer<EntityIcicle, ModelIcicle>
{
	public IcicleRenderer(Context p_174304_)
	{
		super(p_174304_, new ModelIcicle(p_174304_.bakeLayer(ModelIcicle.LAYER_LOCATION)), 0.5F, "icicle");
	}
	
	@Override
	protected void scale(EntityIcicle p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(-1.0F, -1.0F, -1.0F);
		p_115315_.translate(0.0F, -1.3F, 0.0F);
	}
}
