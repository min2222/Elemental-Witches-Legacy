package com.min01.ewlegacy.entity.render;

import net.minecraft.client.model.WitchModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Mob;

public class EWWitchRenderer<T extends Mob> extends EWMobRenderer<T, WitchModel<T>>
{
	public EWWitchRenderer(Context p_174304_, String textureName)
	{
		super(p_174304_, new WitchModel<>(p_174304_.bakeLayer(ModelLayers.WITCH)), 0.5F, textureName);
	}
}
