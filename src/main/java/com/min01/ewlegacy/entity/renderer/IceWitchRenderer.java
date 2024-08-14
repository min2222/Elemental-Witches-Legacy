package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.witch.EntityIceWitch;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class IceWitchRenderer extends EWWitchRenderer<EntityIceWitch>
{
	public IceWitchRenderer(Context p_174304_) 
	{
		super(p_174304_, "ice_witch");
		this.addLayer(new IceWitchLayer(this, p_174304_.getModelSet()));
	}
}
