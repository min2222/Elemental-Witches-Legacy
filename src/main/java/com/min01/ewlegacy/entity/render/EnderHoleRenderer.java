package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityEnderHole;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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

public class EnderHoleRenderer extends EntityRenderer<EntityEnderHole> 
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/entity/ender_hole.png");
	private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE);
	private static final float SIN_45 = (float) Math.sin((Math.PI / 4.0D));
	private final ModelPart cube;
	private final ModelPart glass;

	public EnderHoleRenderer(Context p_173970_) 
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
	public void render(EntityEnderHole p_114162_, float p_114163_, float p_114164_, PoseStack p_114165_, MultiBufferSource p_114166_, int p_114167_)
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

		super.render(p_114162_, p_114163_, p_114164_, p_114165_, p_114166_, p_114167_);
	}

	public static float getY(EntityEnderHole p_114159_, float p_114160_) 
	{
		float f = (float) p_114159_.innerRotation + p_114160_;
		float f1 = Mth.sin(f * 0.2F) / 2.0F + 0.5F;
		f1 = (f1 * f1 + f1) * 0.4F;
		return f1 - 1.4F;
	}

	@Override
	public ResourceLocation getTextureLocation(EntityEnderHole p_114157_) 
	{
		return TEXTURE;
	}
}
