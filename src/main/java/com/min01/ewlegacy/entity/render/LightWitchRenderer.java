package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class LightWitchRenderer extends EWWitchRenderer<EntityLightWitch>
{
	public LightWitchRenderer(Context p_174304_)
	{
		super(p_174304_, "light_witch");
	}
	
	@Override
	public void render(EntityLightWitch p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_)
	{
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
		if(p_115455_.healingLight != null)
		{
			p_115458_.pushPose();
			float f3 = (float)p_115455_.healingLight.getX() + 0.5F;
			float f4 = (float)p_115455_.healingLight.getY() + 0.5F;
			float f5 = (float)p_115455_.healingLight.getZ() + 0.5F;
			float f6 = (float)((double)f3 - p_115455_.getX());
			float f7 = (float)((double)f4 - p_115455_.getY());
			float f8 = (float)((double)f5 - p_115455_.getZ());
			p_115458_.translate((double)f6, (double)f7, (double)f8);
			renderCrystalBeams(-f6, -f7, -f8, p_115457_, p_115455_.healingLight.innerRotation, p_115458_, p_115459_, p_115460_);
			p_115458_.popPose();
		}
	}
	
	public static void renderCrystalBeams(float p_114188_, float p_114189_, float p_114190_, float p_114191_, int p_114192_, PoseStack p_114193_, MultiBufferSource p_114194_, int p_114195_)
	{
		float f = Mth.sqrt(p_114188_ * p_114188_ + p_114190_ * p_114190_);
		float f1 = Mth.sqrt(p_114188_ * p_114188_ + p_114189_ * p_114189_ + p_114190_ * p_114190_);
		p_114193_.pushPose();
		p_114193_.translate(0.0D, 2.0D, 0.0D);
		p_114193_.mulPose(Vector3f.YP.rotation((float)(-Math.atan2((double)p_114190_, (double)p_114188_)) - ((float)Math.PI / 2F)));
		p_114193_.mulPose(Vector3f.XP.rotation((float)(-Math.atan2((double)f, (double)p_114189_)) - ((float)Math.PI / 2F)));
		VertexConsumer vertexconsumer = p_114194_.getBuffer(RenderType.entitySmoothCutout(new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/light_beam.png")));
		float f2 = 0.0F - ((float)p_114192_ + p_114191_) * 0.01F;
		float f3 = Mth.sqrt(p_114188_ * p_114188_ + p_114189_ * p_114189_ + p_114190_ * p_114190_) / 32.0F - ((float)p_114192_ + p_114191_) * 0.01F;
		float f4 = 0.0F;
		float f5 = 0.75F;
		float f6 = 0.0F;
		PoseStack.Pose posestack$pose = p_114193_.last();
		Matrix4f matrix4f = posestack$pose.pose();
		Matrix3f matrix3f = posestack$pose.normal();

		for(int j = 1; j <= 8; ++j)
		{
			float f7 = Mth.sin((float)j * ((float)Math.PI * 2F) / 8.0F) * 0.75F;
			float f8 = Mth.cos((float)j * ((float)Math.PI * 2F) / 8.0F) * 0.75F;
			float f9 = (float)j / 8.0F;
			vertexconsumer.vertex(matrix4f, f4 * 0.2F, f5 * 0.2F, 0.0F).color(0, 0, 0, 255).uv(f6, f2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114195_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
			vertexconsumer.vertex(matrix4f, f4, f5, f1).color(255, 255, 255, 255).uv(f6, f3).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114195_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
			vertexconsumer.vertex(matrix4f, f7, f8, f1).color(255, 255, 255, 255).uv(f9, f3).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114195_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
			vertexconsumer.vertex(matrix4f, f7 * 0.2F, f8 * 0.2F, 0.0F).color(0, 0, 0, 255).uv(f9, f2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114195_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
			f4 = f7;
			f5 = f8;
			f6 = f9;
		}
		
		p_114193_.popPose();
	}
}
