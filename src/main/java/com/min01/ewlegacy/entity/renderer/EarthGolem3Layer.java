package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelEarthGolem3;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class EarthGolem3Layer extends RenderLayer<EntityEarthGolem3, ModelEarthGolem3>
{
	private ModelEarthGolem3 model;
	
	public EarthGolem3Layer(RenderLayerParent<EntityEarthGolem3, ModelEarthGolem3> p_117346_, EntityModelSet modelSet) 
	{
		super(p_117346_);
		this.model = new ModelEarthGolem3(modelSet.bakeLayer(ModelEarthGolem3.LAYER_LOCATION));
	}

	@Override
	public void render(PoseStack p_116970_, MultiBufferSource p_116971_, int p_116972_, EntityEarthGolem3 p_116973_, float p_116974_, float p_116975_, float p_116976_, float p_116977_, float p_116978_, float p_116979_) 
	{
        if(p_116973_.hasCustomName() && ("RAINBOW".equals(p_116973_.getCustomName().getString()) | "rainbow".equals(p_116973_.getCustomName().getString()) | "Rainbow".equals(p_116973_.getCustomName().getString())))
        {
            int k = p_116973_.tickCount / 25 + p_116973_.getId();
            int l = k % EntityEarthGolem3.RAINBOW_COLOR_TABLE.length;
            int i1 = (k + 1) % EntityEarthGolem3.RAINBOW_COLOR_TABLE.length;
            float f1 = (p_116973_.tickCount % 25 + p_116976_) / 25.0F;
    		ModelEarthGolem3 entitymodel = this.model;
    		entitymodel.prepareMobModel(p_116973_, p_116974_, p_116975_, p_116976_);
    		this.getParentModel().copyPropertiesTo(entitymodel);
    		VertexConsumer vertexconsumer = p_116971_.getBuffer(this.model.renderType(this.getTextureLocation(p_116973_)));
    		entitymodel.setupAnim(p_116973_, p_116974_, p_116975_, p_116977_, p_116978_, p_116979_);
    		entitymodel.renderToBuffer(p_116970_, vertexconsumer, p_116972_, OverlayTexture.NO_OVERLAY, EntityEarthGolem3.RAINBOW_COLOR_TABLE[l][0] * (1.0F - f1) + EntityEarthGolem3.RAINBOW_COLOR_TABLE[i1][0] * f1, EntityEarthGolem3.RAINBOW_COLOR_TABLE[l][1] * (1.0F - f1) + EntityEarthGolem3.RAINBOW_COLOR_TABLE[i1][1] * f1, EntityEarthGolem3.RAINBOW_COLOR_TABLE[l][2] * (1.0F - f1) + EntityEarthGolem3.RAINBOW_COLOR_TABLE[i1][2] * f1, 1.0F);
        }
	}
}
