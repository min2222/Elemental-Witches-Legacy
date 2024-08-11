package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.model.ModelLightningGolem;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class LightningGolemRenderer extends EWMobRenderer<EntityLightningGolem, ModelLightningGolem>
{
	public LightningGolemRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelLightningGolem(p_174304_.bakeLayer(ModelLightningGolem.LAYER_LOCATION)), 0.5F, "lightning_golem");
		this.addLayer(new LightningGolemLayer(this, p_174304_.getModelSet()));
	}
}
