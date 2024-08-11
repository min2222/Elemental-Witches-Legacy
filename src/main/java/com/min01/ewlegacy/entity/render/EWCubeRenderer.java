package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.model.ModelCube;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.skill.EntityExplosivePumpkin;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class EWCubeRenderer<T extends Entity> extends EntityRenderer<T>
{
	public final String textureName;
	public final ModelCube<T> model;
	
	public EWCubeRenderer(Context p_174008_, String textureName)
	{
		super(p_174008_);
		this.model = new ModelCube<>(p_174008_.bakeLayer(ModelCube.LAYER_LOCATION));
		this.textureName = textureName;
	}
	
	@Override
	public void render(T p_114485_, float p_114486_, float p_114487_, PoseStack p_114488_, MultiBufferSource p_114489_, int p_114490_) 
	{
		p_114488_.pushPose();
		p_114488_.scale(-1.0F, -1.0F, 1.0F);
		p_114488_.translate(0, -1.5F, 0);
		if(p_114485_ instanceof EntityIceCube)
		{
			p_114488_.scale(0.1F, 0.1F, 0.1F);
		}
		else if(p_114485_ instanceof EntityExplosivePumpkin | p_114485_ instanceof EntityBigIceCube)
		{
			p_114488_.scale(0.5F, 0.5F, 0.5F);
		}
		this.model.setupAnim(p_114485_, 0, 0, p_114485_.tickCount + p_114487_, 0, 0);
		this.model.renderToBuffer(p_114488_, p_114489_.getBuffer(RenderType.entityCutoutNoCull(this.getTextureLocation(p_114485_))), p_114490_, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		p_114488_.popPose();
	}
	
	@Override
	public ResourceLocation getTextureLocation(T p_114482_) 
	{
		return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/" + this.textureName + ".png");
	}
}
