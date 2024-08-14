package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelSwiftEnt;
import com.min01.ewlegacy.entity.skill.EntitySwiftEnt;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class SwiftEntRenderer extends EWMobRenderer<EntitySwiftEnt, ModelSwiftEnt>
{
	public SwiftEntRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelSwiftEnt(p_174304_.bakeLayer(ModelSwiftEnt.LAYER_LOCATION)), 0.2F, "swift_ent");
	}
	
	@Override
	protected void scale(EntitySwiftEnt p_115314_, PoseStack p_115315_, float p_115316_) 
	{
		p_115315_.scale(0.5F, 0.5F, 0.5F);
	}
}
