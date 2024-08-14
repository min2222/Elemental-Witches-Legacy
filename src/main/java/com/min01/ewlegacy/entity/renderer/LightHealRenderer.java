package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityLightHeal;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class LightHealRenderer extends EntityRenderer<EntityLightHeal> 
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/light_heal.png");
	private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE);
	private static final float SIN_45 = (float) Math.sin((Math.PI / 4.0D));
	private final ModelPart cube;
	private final ModelPart glass;

	public LightHealRenderer(Context p_173970_) 
	{
		super(p_173970_);
		this.shadowRadius = 0.5F;
		ModelPart modelpart = p_173970_.bakeLayer(ModelLayers.END_CRYSTAL);
		this.glass = modelpart.getChild("glass");
		this.cube = modelpart.getChild("cube");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("glass", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void render(EntityLightHeal p_114162_, float p_114163_, float p_114164_, PoseStack p_114165_, MultiBufferSource p_114166_, int p_114167_)
	{
		p_114165_.pushPose();
		float f = getY(p_114162_, p_114164_);
		float f1 = ((float) p_114162_.innerRotation + p_114164_) * 3.0F;
		VertexConsumer vertexconsumer = p_114166_.getBuffer(RENDER_TYPE);
		p_114165_.pushPose();
		p_114165_.scale(2.0F, 2.0F, 2.0F);
		p_114165_.translate(0.0D, -0.5D, 0.0D);
		int i = OverlayTexture.NO_OVERLAY;

		p_114165_.mulPose(Vector3f.YP.rotationDegrees(f1));
		p_114165_.translate(0.0D, (double) (1.5F + f / 2.0F), 0.0D);
		p_114165_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
		this.glass.render(p_114165_, vertexconsumer, p_114167_, i);
		p_114165_.scale(0.875F, 0.875F, 0.875F);
		p_114165_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
		p_114165_.mulPose(Vector3f.YP.rotationDegrees(f1));
		this.glass.render(p_114165_, vertexconsumer, p_114167_, i);
		p_114165_.scale(0.875F, 0.875F, 0.875F);
		p_114165_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
		p_114165_.mulPose(Vector3f.YP.rotationDegrees(f1));
		this.cube.render(p_114165_, vertexconsumer, p_114167_, i);
		p_114165_.popPose();
		p_114165_.popPose();
		
		if(p_114162_.getOwner() != null)
		{
			p_114165_.pushPose();
			float f3 = (float)p_114162_.getOwner().getX() + 0.5F;
			float f4 = (float)p_114162_.getOwner().getY() + 0.5F;
			float f5 = (float)p_114162_.getOwner().getZ() + 0.5F;
			float f6 = (float)((double)f3 - p_114162_.getX());
			float f7 = (float)((double)f4 - p_114162_.getY());
			float f8 = (float)((double)f5 - p_114162_.getZ());
			p_114165_.translate((double)f6, (double)f7, (double)f8);
			renderCrystalBeams(-f6, -f7, -f8, p_114164_, p_114162_.innerRotation, p_114165_, p_114166_, p_114167_);
			p_114165_.popPose();
		}

		super.render(p_114162_, p_114163_, p_114164_, p_114165_, p_114166_, p_114167_);
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

	public static float getY(EntityLightHeal p_114159_, float p_114160_) 
	{
		float f = (float) p_114159_.innerRotation + p_114160_;
		float f1 = Mth.sin(f * 0.2F) / 2.0F + 0.5F;
		f1 = (f1 * f1 + f1) * 0.4F;
		return f1 - 1.4F;
	}

	@Override
	public ResourceLocation getTextureLocation(EntityLightHeal p_114157_) 
	{
		return TEXTURE;
	}
}
