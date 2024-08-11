package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.witch.EntityEarthWitch;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class EarthWitchRenderer extends EWWitchRenderer<EntityEarthWitch>
{
	public EarthWitchRenderer(Context p_174304_) 
	{
		super(p_174304_, "earth_witch");
		this.addLayer(new EarthWitchLayer(this, p_174304_.getModelSet()));
	}
}
