package com.min01.ewlegacy.entity.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Mob;

public class EWTranslucentMobRenderer<T extends Mob, M extends EntityModel<T>> extends EWMobRenderer<T, M>
{
	public EWTranslucentMobRenderer(Context p_174304_, M p_174305_, float p_174306_, String textureName) 
	{
		super(p_174304_, p_174305_, p_174306_, textureName);
	}

	@Override
	protected RenderType getRenderType(T p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) 
	{
		return RenderType.entityTranslucent(this.getTextureLocation(p_115322_));
	}
}
