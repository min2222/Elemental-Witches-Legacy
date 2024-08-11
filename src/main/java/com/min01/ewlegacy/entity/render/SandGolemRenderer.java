package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.model.ModelSandGolem;
import com.min01.ewlegacy.entity.skill.EntitySandGolem;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class SandGolemRenderer extends EWMobRenderer<EntitySandGolem, ModelSandGolem>
{
	public SandGolemRenderer(Context p_174304_) 
	{
		super(p_174304_, new ModelSandGolem(p_174304_.bakeLayer(ModelSandGolem.LAYER_LOCATION)), 0.5F, "sand_stone");
		this.addLayer(new SandGolemLayer(this, p_174304_.getModelSet()));
	}
}
