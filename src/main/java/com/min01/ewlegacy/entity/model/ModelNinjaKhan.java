package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityNinjaKhan;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelNinjaKhan extends EntityModel<EntityNinjaKhan> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "ninja_khan"), "main");
	private final ModelPart rightleg2;
	private final ModelPart mask5;
	private final ModelPart mask4;
	private final ModelPart mask1;
	private final ModelPart body2;
	private final ModelPart mask3;
	private final ModelPart mask2;
	private final ModelPart rightarm2;
	private final ModelPart leftarm2;
	private final ModelPart rightarm1;
	private final ModelPart eye2;
	private final ModelPart leftarm1;
	private final ModelPart eye1;
	private final ModelPart head;
	private final ModelPart body1;
	private final ModelPart leftleg2;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;

	public ModelNinjaKhan(ModelPart root)
	{
		this.rightleg2 = root.getChild("rightleg2");
		this.mask5 = root.getChild("mask5");
		this.mask4 = root.getChild("mask4");
		this.mask1 = root.getChild("mask1");
		this.body2 = root.getChild("body2");
		this.mask3 = root.getChild("mask3");
		this.mask2 = root.getChild("mask2");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm1 = root.getChild("rightarm1");
		this.eye2 = root.getChild("eye2");
		this.leftarm1 = root.getChild("leftarm1");
		this.eye1 = root.getChild("eye1");
		this.head = root.getChild("head");
		this.body1 = root.getChild("body1");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("mask5", CubeListBuilder.create().texOffs(14, 0).addBox(-4.5F, -6.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("mask4", CubeListBuilder.create().texOffs(45, 0).addBox(3.5F, -6.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("mask1", CubeListBuilder.create().texOffs(0, 99).addBox(-4.5F, -5.0F, -4.5F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(93, 26).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("mask3", CubeListBuilder.create().texOffs(0, 13).addBox(-4.5F, -9.0F, -4.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("mask2", CubeListBuilder.create().texOffs(0, 26).addBox(-3.5F, -6.0F, 3.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 33).addBox(-3.5F, -2.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(40, 33).addBox(-1.5F, -2.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(40, 52).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -6.0F, -4.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(40, 52).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.9F, -6.0F, -4.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 78).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0011F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(88, 46).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(91, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(91, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityNinjaKhan entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm1.zRot = 0.0F;
        this.leftarm1.zRot = 0.0F;
        this.rightarm2.zRot = 0.0F;
        this.leftarm2.zRot = 0.0F;
        this.rightarm1.yRot = 0.0F;
        this.leftarm1.yRot = 0.0F;
        this.rightarm2.yRot = 0.0F;
        this.leftarm2.yRot = 0.0F;
        this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.rightleg1.yRot = 0.0F;
        this.leftleg1.yRot = 0.0F;
        this.rightleg2.yRot = 0.0F;
        this.leftleg2.yRot = 0.0F;
        this.head.yRot = netHeadYaw / 57.295776F;
        this.head.xRot = headPitch / 57.295776F;
        this.mask1.yRot = netHeadYaw / 57.295776F;
        this.mask1.xRot = headPitch / 57.295776F;
        this.mask2.yRot = netHeadYaw / 57.295776F;
        this.mask2.xRot = headPitch / 57.295776F;
        this.mask3.yRot = netHeadYaw / 57.295776F;
        this.mask3.xRot = headPitch / 57.295776F;
        this.mask4.yRot = netHeadYaw / 57.295776F;
        this.mask4.xRot = headPitch / 57.295776F;
        this.mask5.yRot = netHeadYaw / 57.295776F;
        this.mask5.xRot = headPitch / 57.295776F;
        this.eye1.yRot = netHeadYaw / 57.295776F;
        this.eye1.xRot = headPitch / 57.295776F;
        this.eye2.yRot = netHeadYaw / 57.295776F;
        this.eye2.xRot = headPitch / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mask5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mask4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mask1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mask3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mask2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}