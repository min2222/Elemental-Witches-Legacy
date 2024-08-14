package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityHalloweenPumpkin;
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

public class ModelHalloweenPumpkin extends EntityModel<EntityHalloweenPumpkin>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "halloween_pumpkin"), "main");
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart Right_Leg;
	private final ModelPart Left_Glove;
	private final ModelPart Left_Arm;
	private final ModelPart Right_Boot_1;
	private final ModelPart Right_Hand;
	private final ModelPart Left_Hand;
	private final ModelPart Left_Boot_3;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Boot_2;
	private final ModelPart Left_Boot_1;
	private final ModelPart Right_Glove;
	private final ModelPart Left_Leg;
	private final ModelPart Right_Boot_2;
	private final ModelPart Right_Boot_3;

	public ModelHalloweenPumpkin(ModelPart root)
	{
		this.Torso = root.getChild("Torso");
		this.Head = root.getChild("Head");
		this.Right_Leg = root.getChild("Right_Leg");
		this.Left_Glove = root.getChild("Left_Glove");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Right_Boot_1 = root.getChild("Right_Boot_1");
		this.Right_Hand = root.getChild("Right_Hand");
		this.Left_Hand = root.getChild("Left_Hand");
		this.Left_Boot_3 = root.getChild("Left_Boot_3");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Boot_2 = root.getChild("Left_Boot_2");
		this.Left_Boot_1 = root.getChild("Left_Boot_1");
		this.Right_Glove = root.getChild("Right_Glove");
		this.Left_Leg = root.getChild("Left_Leg");
		this.Right_Boot_2 = root.getChild("Right_Boot_2");
		this.Right_Boot_3 = root.getChild("Right_Boot_3");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(62, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(42, 0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(60, 31).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.1222F));

		partdefinition.addOrReplaceChild("Left_Glove", CubeListBuilder.create().texOffs(74, 25).addBox(-1.5F, 5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(70, 24).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("Right_Boot_1", CubeListBuilder.create().texOffs(57, 38).addBox(-2.0F, 4.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Hand", CubeListBuilder.create().texOffs(46, 26).addBox(0.0F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Left_Hand", CubeListBuilder.create().texOffs(82, 26).addBox(-1.0F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("Left_Boot_3", CubeListBuilder.create().texOffs(67, 48).addBox(0.0F, 7.0F, -3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(58, 24).addBox(0.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Left_Boot_2", CubeListBuilder.create().texOffs(67, 42).addBox(-0.5F, 6.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Boot_1", CubeListBuilder.create().texOffs(67, 38).addBox(0.0F, 4.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Glove", CubeListBuilder.create().texOffs(50, 25).addBox(-0.5F, 5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(68, 31).addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 16.0F, 0.0F, 0.0F, 0.0F, -0.1222F));

		partdefinition.addOrReplaceChild("Right_Boot_2", CubeListBuilder.create().texOffs(51, 42).addBox(-2.5F, 6.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 16.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Boot_3", CubeListBuilder.create().texOffs(59, 48).addBox(-2.0F, 7.0F, -3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityHalloweenPumpkin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Right_Leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Right_Boot_1.xRot = this.Right_Leg.xRot;
        this.Right_Boot_2.xRot = this.Right_Leg.xRot;
        this.Right_Boot_3.xRot = this.Right_Leg.xRot;
        this.Left_Leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Left_Boot_1.xRot = this.Left_Leg.xRot;
        this.Left_Boot_2.xRot = this.Left_Leg.xRot;
        this.Left_Boot_3.xRot = this.Left_Leg.xRot;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Head.xRot = headPitch / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Glove.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Boot_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Boot_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Boot_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Boot_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Glove.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Boot_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Boot_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}