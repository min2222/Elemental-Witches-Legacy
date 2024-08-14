package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelDarkSpirit2;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit2;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class DarkSpirit2Renderer extends EWMobRenderer<EntityDarkSpirit2, ModelDarkSpirit2>
{
	public DarkSpirit2Renderer(Context p_174304_) 
	{
		super(p_174304_, new ModelDarkSpirit2(p_174304_.bakeLayer(ModelDarkSpirit2.LAYER_LOCATION)), 0.5F, "dark_spirit_2");
		this.addLayer(new DarkSpirit2Layer(this, p_174304_.getModelSet()));
	}
}
