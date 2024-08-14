package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem3;
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

public class ModelEarthGolem3 extends EntityModel<EntityEarthGolem3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "earth_golem3"), "main");
	private final ModelPart Left_Shoulder;
	private final ModelPart Dirt;
	private final ModelPart Right_Pinky;
	private final ModelPart Right_Middle_Finger;
	private final ModelPart Right_Thumb;
	private final ModelPart Upper_Torso;
	private final ModelPart Head;
	private final ModelPart Scarf_Button;
	private final ModelPart Lower_Torso;
	private final ModelPart Right_Arm_2;
	private final ModelPart Scarf_1;
	private final ModelPart Right_Arm_1;
	private final ModelPart Scarf_3;
	private final ModelPart Right_Index_Finger;
	private final ModelPart Scarf_2;
	private final ModelPart Scarf_4;
	private final ModelPart Right_Ring_Finger;
	private final ModelPart Right_Palm;

	public ModelEarthGolem3(ModelPart root) 
	{
		this.Left_Shoulder = root.getChild("Left_Shoulder");
		this.Dirt = root.getChild("Dirt");
		this.Right_Pinky = root.getChild("Right_Pinky");
		this.Right_Middle_Finger = root.getChild("Right_Middle_Finger");
		this.Right_Thumb = root.getChild("Right_Thumb");
		this.Upper_Torso = root.getChild("Upper_Torso");
		this.Head = root.getChild("Head");
		this.Scarf_Button = root.getChild("Scarf_Button");
		this.Lower_Torso = root.getChild("Lower_Torso");
		this.Right_Arm_2 = root.getChild("Right_Arm_2");
		this.Scarf_1 = root.getChild("Scarf_1");
		this.Right_Arm_1 = root.getChild("Right_Arm_1");
		this.Scarf_3 = root.getChild("Scarf_3");
		this.Right_Index_Finger = root.getChild("Right_Index_Finger");
		this.Scarf_2 = root.getChild("Scarf_2");
		this.Scarf_4 = root.getChild("Scarf_4");
		this.Right_Ring_Finger = root.getChild("Right_Ring_Finger");
		this.Right_Palm = root.getChild("Right_Palm");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Left_Shoulder = partdefinition.addOrReplaceChild("Left_Shoulder", CubeListBuilder.create().texOffs(278, 136).addBox(0.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -7.0F, 0.0F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_2", CubeListBuilder.create().texOffs(274, 222).addBox(3.0F, 18.0F, -15.0F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.576F, -0.3665F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_1", CubeListBuilder.create().texOffs(290, 199).addBox(-3.0F, 8.0F, -6.0F, 14.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3665F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_3", CubeListBuilder.create().texOffs(282, 231).addBox(10.0F, 13.0F, 10.0F, 7.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.3665F, 0.3491F, 0.0F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_5", CubeListBuilder.create().texOffs(262, 207).addBox(5.0F, 9.0F, 4.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.6283F, 0.4887F, 0.0F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild", CubeListBuilder.create().texOffs(296, 183).addBox(-1.0F, 2.0F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3665F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_6", CubeListBuilder.create().texOffs(312, 231).addBox(5.0F, 9.0F, -6.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.8727F, 0.5585F, 0.0F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_4", CubeListBuilder.create().texOffs(342, 217).addBox(3.0F, 9.0F, -8.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.5061F, -0.4189F, 0.0F));

		partdefinition.addOrReplaceChild("Dirt", CubeListBuilder.create().texOffs(175, 239).addBox(-9.0F, 24.0F, 5.0F, 10.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Right_Pinky", CubeListBuilder.create().texOffs(211, 213).addBox(2.0F, 28.0F, 4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Right_Middle_Finger", CubeListBuilder.create().texOffs(178, 227).addBox(-6.0F, 34.0F, 4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Right_Thumb", CubeListBuilder.create().texOffs(143, 207).addBox(-14.0F, 24.0F, 4.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Upper_Torso", CubeListBuilder.create().texOffs(210, 148).addBox(-11.0F, 0.0F, -8.0F, 22.0F, 26.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(221, 121).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, -0.7118F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(235, 44).addBox(-6.0F, -11.0F, 16.0F, 12.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(239, 59).addBox(-1.0F, -7.0F, 12.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(221, 75).addBox(-3.0F, -9.0F, 11.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.1745F, 0.0F));

		Head.addOrReplaceChild("HeadChild_14", CubeListBuilder.create().texOffs(265, 21).addBox(-5.0F, -16.0F, 19.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(241, 69).addBox(-6.0F, -24.0F, 2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.7854F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(261, 75).addBox(-1.0F, -9.0F, 11.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.1745F, 0.0F));

		Head.addOrReplaceChild("HeadChild_16", CubeListBuilder.create().texOffs(161, 13).addBox(-6.0F, -4.0F, 19.5F, 12.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(249, 83).addBox(3.0F, -15.0F, -3.0F, 10.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_17", CubeListBuilder.create().texOffs(121, 13).addBox(-5.0F, 4.0F, 23.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(208, 103).addBox(-14.0F, -4.0F, -5.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(233, 86).addBox(-8.0F, -17.0F, 0.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.7854F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(237, 75).addBox(-7.0F, -22.0F, 1.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.7854F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_15", CubeListBuilder.create().texOffs(209, 13).addBox(-7.0F, -12.0F, 18.0F, 14.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_18", CubeListBuilder.create().texOffs(89, 13).addBox(-4.0F, 19.0F, 24.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(254, 103).addBox(6.0F, -4.0F, -5.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(244, 103).addBox(-10.0F, -10.0F, -8.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(193, 83).addBox(-13.0F, -15.0F, -3.0F, 10.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(201, 73).addBox(-3.0F, -9.0F, 11.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(277, 73).addBox(-2.0F, -9.0F, 11.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Scarf_Button", CubeListBuilder.create().texOffs(278, 142).addBox(8.0F, -3.0F, -10.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Torso", CubeListBuilder.create().texOffs(220, 190).addBox(-8.0F, 18.0F, -6.0F, 16.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm_2", CubeListBuilder.create().texOffs(170, 173).addBox(-9.0F, -1.0F, 8.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Scarf_1", CubeListBuilder.create().texOffs(113, 124).addBox(-23.0F, -1.0F, -9.0F, 34.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Arm_1", CubeListBuilder.create().texOffs(170, 148).addBox(-9.0F, 2.0F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Scarf_3", CubeListBuilder.create().texOffs(113, 80).addBox(-23.0F, -5.0F, -9.0F, 18.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Index_Finger", CubeListBuilder.create().texOffs(154, 227).addBox(-11.0F, 34.0F, 4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Scarf_2", CubeListBuilder.create().texOffs(113, 102).addBox(-23.0F, -3.0F, -9.0F, 24.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Scarf_4", CubeListBuilder.create().texOffs(286, 160).addBox(9.0F, -6.0F, -9.0F, 17.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.3316F));

		partdefinition.addOrReplaceChild("Right_Ring_Finger", CubeListBuilder.create().texOffs(202, 227).addBox(-1.0F, 34.0F, 4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		partdefinition.addOrReplaceChild("Right_Palm", CubeListBuilder.create().texOffs(169, 207).addBox(-10.0F, 23.0F, 10.0F, 12.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -4.0F, 0.0F, -1.309F, 0.0F, 0.192F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityEarthGolem3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Dirt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Pinky.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Middle_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Thumb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Upper_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_Button.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Index_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ring_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Palm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}