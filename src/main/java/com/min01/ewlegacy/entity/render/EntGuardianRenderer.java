package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.model.ModelEntGuardian;
import com.min01.ewlegacy.entity.skill.EntityEntGuardian;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class EntGuardianRenderer extends EWMobRenderer<EntityEntGuardian, ModelEntGuardian>
{
	public EntGuardianRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelEntGuardian(p_174304_.bakeLayer(ModelEntGuardian.LAYER_LOCATION)), 0.5F, "ent_guardian");
		this.addLayer(new EntGuardianLayer(this, p_174304_.getModelSet()));
	}

	@Override
	protected void scale(EntityEntGuardian p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(2.0F, 1.5F, 2.0F);
		p_115315_.translate(0.0F, 1.0F, 0.0F);
	}
}
