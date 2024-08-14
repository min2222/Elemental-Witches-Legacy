package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelFireBat;
import com.min01.ewlegacy.entity.skill.EntityFireBat;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class FireBatRenderer extends EWMobRenderer<EntityFireBat, ModelFireBat>
{
	public FireBatRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelFireBat(p_174304_.bakeLayer(ModelFireBat.LAYER_LOCATION)), 0.5F, "fire_bat");
	}
	
	@Override
	protected void scale(EntityFireBat p_115314_, PoseStack p_115315_, float p_115316_) 
	{
		p_115315_.scale(0.3F, 0.3F, 0.3F);
	}
}
