package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.witch.EntityLightningWitch;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class LightningWitchRenderer extends EWWitchRenderer<EntityLightningWitch>
{
	public LightningWitchRenderer(Context p_174304_) 
	{
		super(p_174304_, "lightning_witch");
		this.addLayer(new LightningWitchLayer(this, p_174304_.getModelSet()));
	}
}
