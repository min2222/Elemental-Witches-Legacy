package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class EWMobRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M>
{
	private final String textureName;
	
	public EWMobRenderer(Context p_174304_, M p_174305_, float p_174306_, String textureName)
	{
		super(p_174304_, p_174305_, p_174306_);
		this.textureName = textureName;
	}
	
	@Override
	public ResourceLocation getTextureLocation(T p_114482_) 
	{
		return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/" + this.textureName + ".png");
	}
}
