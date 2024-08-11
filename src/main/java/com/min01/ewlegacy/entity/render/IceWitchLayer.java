package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.model.ModelElementalWitch;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class IceWitchLayer extends RenderLayer<EntityIceWitch, ModelElementalWitch<EntityIceWitch>>
{
	private final ModelElementalWitch<EntityIceWitch> model;
	
	public IceWitchLayer(RenderLayerParent<EntityIceWitch, ModelElementalWitch<EntityIceWitch>> p_117346_, EntityModelSet modelSet)
	{
		super(p_117346_);
		this.model = new ModelElementalWitch<>(modelSet.bakeLayer(ModelLayers.WITCH));
	}

	@Override
	public void render(PoseStack p_116970_, MultiBufferSource p_116971_, int p_116972_, EntityIceWitch p_116973_, float p_116974_, float p_116975_, float p_116976_, float p_116977_, float p_116978_, float p_116979_) 
	{
		if(p_116973_.getHealth() <= 20.0F) 
		{
			float f = (float)p_116973_.tickCount + p_116976_;
			ModelElementalWitch<EntityIceWitch> entitymodel = this.model;
			entitymodel.prepareMobModel(p_116973_, p_116974_, p_116975_, p_116976_);
			this.getParentModel().copyPropertiesTo(entitymodel);
			VertexConsumer vertexconsumer = p_116971_.getBuffer(RenderType.energySwirl(new ResourceLocation("textures/entity/creeper/creeper_armor.png"), f * 0.01F % 1.0F, f * 0.01F % 1.0F));
			entitymodel.setupAnim(p_116973_, p_116974_, p_116975_, p_116977_, p_116978_, p_116979_);
			entitymodel.renderToBuffer(p_116970_, vertexconsumer, p_116972_, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F, 1.0F);
		}
	}
}
