package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.projectile.EntityPumpkinSkull;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PumpkinSkullRenderer extends EntityRenderer<EntityPumpkinSkull>
{
	public final SkullModel model;

	public PumpkinSkullRenderer(Context p_174008_)
    {
		super(p_174008_);
        this.model = new SkullModel(p_174008_.bakeLayer(ModelLayers.SKELETON_SKULL));
	}
    
    @SuppressWarnings("deprecation")
	@Override
    public void render(EntityPumpkinSkull p_116484_, float p_116485_, float p_116486_, PoseStack p_116487_, MultiBufferSource p_116488_, int p_116489_) 
    {
    	p_116487_.pushPose();
        p_116487_.scale(-1.0F, -1.0F, 1.0F);
        float f = Mth.rotlerp(p_116484_.yRotO, p_116484_.getYRot(), p_116486_);
        float f1 = Mth.lerp(p_116486_, p_116484_.xRotO, p_116484_.getXRot());
        VertexConsumer vertexconsumer = p_116488_.getBuffer(this.model.renderType(this.getTextureLocation(p_116484_)));
        this.model.setupAnim(0.0F, f, f1);
        this.model.renderToBuffer(p_116487_, vertexconsumer, p_116489_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_116487_.popPose();
        super.render(p_116484_, p_116485_, p_116486_, p_116487_, p_116488_, p_116489_);
    }

	@Override
	public ResourceLocation getTextureLocation(EntityPumpkinSkull p_114482_)
	{
		return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/pumpkin_skull.png");
	}
}
