package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.model.ModelSandGolem;
import com.min01.ewlegacy.entity.skill.EntitySandGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SandGolemLayer extends RenderLayer<EntitySandGolem, ModelSandGolem>
{
	private final ModelSandGolem model;
	
	public SandGolemLayer(RenderLayerParent<EntitySandGolem, ModelSandGolem> p_117346_, EntityModelSet modelSet)
	{
		super(p_117346_);
		this.model = new ModelSandGolem(modelSet.bakeLayer(ModelSandGolem.LAYER_LOCATION));
	}

	@Override
	public void render(PoseStack p_116970_, MultiBufferSource p_116971_, int p_116972_, EntitySandGolem p_116973_, float p_116974_, float p_116975_, float p_116976_, float p_116977_, float p_116978_, float p_116979_) 
	{
		float f = (float)p_116973_.tickCount + p_116976_;
		ModelSandGolem entitymodel = this.model;
		entitymodel.prepareMobModel(p_116973_, p_116974_, p_116975_, p_116976_);
		this.getParentModel().copyPropertiesTo(entitymodel);
		VertexConsumer vertexconsumer = p_116971_.getBuffer(RenderType.energySwirl(new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/earth_armor.png"), f * 0.01F % 1.0F, f * 0.01F % 1.0F));
		entitymodel.setupAnim(p_116973_, p_116974_, p_116975_, p_116977_, p_116978_, p_116979_);
		entitymodel.renderToBuffer(p_116970_, vertexconsumer, p_116972_, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F, 1.0F);
	}
}
