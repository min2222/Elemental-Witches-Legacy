package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightAngel3;
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

public class ModelLightAngel3 extends EntityModel<EntityLightAngel3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "light_angel3"), "main");
	private final ModelPart Torso;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Wrist_1;
	private final ModelPart Left_Wrist_2;
	private final ModelPart Head;
	private final ModelPart Right_Sleeve;
	private final ModelPart Right_Cloud_Arm_2;
	private final ModelPart Right_Cloud_Arm_1;
	private final ModelPart Left_Sleeve;
	private final ModelPart Skirt_4;
	private final ModelPart Skirt_5;
	private final ModelPart Skirt_6;
	private final ModelPart Skirt_7;
	private final ModelPart Right_Wrist_2;
	private final ModelPart Right_Wrist_1;
	private final ModelPart Skirt_1;
	private final ModelPart Skirt_2;
	private final ModelPart Skirt_3;
	private final ModelPart Left_Cloud_Arm_2;
	private final ModelPart Left_Cloud_Arm_1;
	private final ModelPart Left_Arm;
	private final ModelPart Tail_6;
	private final ModelPart Tail_5;
	private final ModelPart Tail_4;
	private final ModelPart Tail_3;
	private final ModelPart Tail_2;
	private final ModelPart Tail_1;

	public ModelLightAngel3(ModelPart root) 
	{
		this.Torso = root.getChild("Torso");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Wrist_1 = root.getChild("Left_Wrist_1");
		this.Left_Wrist_2 = root.getChild("Left_Wrist_2");
		this.Head = root.getChild("Head");
		this.Right_Sleeve = root.getChild("Right_Sleeve");
		this.Right_Cloud_Arm_2 = root.getChild("Right_Cloud_Arm_2");
		this.Right_Cloud_Arm_1 = root.getChild("Right_Cloud_Arm_1");
		this.Left_Sleeve = root.getChild("Left_Sleeve");
		this.Skirt_4 = root.getChild("Skirt_4");
		this.Skirt_5 = root.getChild("Skirt_5");
		this.Skirt_6 = root.getChild("Skirt_6");
		this.Skirt_7 = root.getChild("Skirt_7");
		this.Right_Wrist_2 = root.getChild("Right_Wrist_2");
		this.Right_Wrist_1 = root.getChild("Right_Wrist_1");
		this.Skirt_1 = root.getChild("Skirt_1");
		this.Skirt_2 = root.getChild("Skirt_2");
		this.Skirt_3 = root.getChild("Skirt_3");
		this.Left_Cloud_Arm_2 = root.getChild("Left_Cloud_Arm_2");
		this.Left_Cloud_Arm_1 = root.getChild("Left_Cloud_Arm_1");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Tail_6 = root.getChild("Tail_6");
		this.Tail_5 = root.getChild("Tail_5");
		this.Tail_4 = root.getChild("Tail_4");
		this.Tail_3 = root.getChild("Tail_3");
		this.Tail_2 = root.getChild("Tail_2");
		this.Tail_1 = root.getChild("Tail_1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(212, 149).addBox(-8.0F, 0.0F, -6.0F, 16.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(148, 160).addBox(-28.0F, 1.0F, -2.0F, 28.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("Left_Wrist_1", CubeListBuilder.create().texOffs(322, 168).addBox(21.0F, -0.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, 0.9599F));

		partdefinition.addOrReplaceChild("Left_Wrist_2", CubeListBuilder.create().texOffs(340, 167).addBox(23.0F, -1.0F, -4.0F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(200, 100).addBox(-11.0F, -18.0F, -9.0F, 22.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.9076F, 0.0F, 0.0F, -0.0164F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(200, 42).addBox(-11.0F, -24.0F, -9.0F, 22.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_15", CubeListBuilder.create().texOffs(274, 23).addBox(-12.0F, -9.0F, 10.0F, 24.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(204, 5).addBox(-10.0F, -25.0F, -8.0F, 20.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(222, 94).addBox(-4.0F, -20.0F, -10.0F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(264, 136).addBox(12.0F, -10.0F, -8.0F, 7.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(150, 100).addBox(-18.0F, -15.0F, -10.0F, 5.0F, 18.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(116, 129).addBox(-19.0F, -10.0F, -10.0F, 7.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Head.addOrReplaceChild("HeadChild_14", CubeListBuilder.create().texOffs(276, 0).addBox(-12.0F, -15.0F, 11.0F, 24.0F, 18.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(200, 96).addBox(-14.0F, -19.0F, -10.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Head.addOrReplaceChild("HeadChild_17", CubeListBuilder.create().texOffs(252, 136).addBox(10.0F, -12.0F, 7.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_16", CubeListBuilder.create().texOffs(200, 136).addBox(-17.0F, -12.0F, 7.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, -0.2618F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(196, 62).addBox(-12.0F, -22.0F, -10.0F, 24.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(280, 100).addBox(13.0F, -15.0F, -8.0F, 5.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(192, 0).addBox(-25.0F, -27.0F, -3.5F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(198, 22).addBox(-11.5F, -23.5F, -9.5F, 23.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(258, 94).addBox(6.0F, 2.0F, -10.0F, 10.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8727F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(246, 86).addBox(12.0F, -17.0F, -10.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.192F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(171, 9).addBox(-23.0F, -20.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Right_Sleeve", CubeListBuilder.create().texOffs(158, 169).addBox(-21.0F, 0.0F, -3.0F, 21.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("Right_Cloud_Arm_2", CubeListBuilder.create().texOffs(360, 141).addBox(-28.0F, -3.0F, -17.0F, 6.0F, 6.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.9967F, 6.0F, 0.0F, -0.2618F, -0.2618F));

		PartDefinition Right_Cloud_Arm_1 = partdefinition.addOrReplaceChild("Right_Cloud_Arm_1", CubeListBuilder.create().texOffs(334, 155).addBox(-26.0F, -3.0F, -2.0F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.9967F, 6.0F, 0.0F, 0.0F, -0.2618F));

		Right_Cloud_Arm_1.addOrReplaceChild("Right_Cloud_Arm_1Child_1", CubeListBuilder.create().texOffs(280, 46).addBox(-6.0F, -2.0F, -1.0F, 4.0F, 8.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		Right_Cloud_Arm_1.addOrReplaceChild("Right_Cloud_Arm_1Child_3", CubeListBuilder.create().texOffs(376, 41).addBox(-6.0F, -3.0F, 24.0F, 4.0F, 8.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.5236F, 0.0F));

		Right_Cloud_Arm_1.addOrReplaceChild("Right_Cloud_Arm_1Child", CubeListBuilder.create().texOffs(348, 92).addBox(-6.0F, -1.0F, 5.0F, 4.0F, 6.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.5236F, 0.0F));

		Right_Cloud_Arm_1.addOrReplaceChild("Right_Cloud_Arm_1Child_2", CubeListBuilder.create().texOffs(334, 49).addBox(-6.0F, -3.0F, 17.0F, 4.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Sleeve", CubeListBuilder.create().texOffs(268, 169).addBox(0.0F, 0.0F, -3.0F, 21.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, 0.9599F));

		partdefinition.addOrReplaceChild("Skirt_4", CubeListBuilder.create().texOffs(196, 229).addBox(-12.0F, 20.0F, -10.0F, 24.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_5", CubeListBuilder.create().texOffs(121, 189).addBox(-13.0F, 22.0F, -11.0F, 26.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_6", CubeListBuilder.create().texOffs(112, 213).addBox(-14.0F, 24.0F, -12.0F, 28.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_7", CubeListBuilder.create().texOffs(0, 221).addBox(-15.0F, 26.0F, -13.0F, 30.0F, 9.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Wrist_2", CubeListBuilder.create().texOffs(118, 167).addBox(-26.0F, -1.0F, -4.0F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("Right_Wrist_1", CubeListBuilder.create().texOffs(140, 168).addBox(-23.0F, -0.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("Skirt_1", CubeListBuilder.create().texOffs(208, 172).addBox(-9.0F, 11.0F, -7.0F, 18.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_2", CubeListBuilder.create().texOffs(204, 189).addBox(-10.0F, 14.0F, -8.0F, 20.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_3", CubeListBuilder.create().texOffs(200, 208).addBox(-11.0F, 17.0F, -9.0F, 22.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.9076F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Cloud_Arm_2", CubeListBuilder.create().texOffs(58, 141).addBox(22.0F, -3.0F, -17.0F, 6.0F, 6.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.9967F, 6.0F, 0.0F, 0.2618F, 0.2618F));

		PartDefinition Left_Cloud_Arm_1 = partdefinition.addOrReplaceChild("Left_Cloud_Arm_1", CubeListBuilder.create().texOffs(96, 155).addBox(6.0F, -3.0F, -2.0F, 20.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.9967F, 6.0F, 0.0F, 0.0F, 0.2618F));

		Left_Cloud_Arm_1.addOrReplaceChild("Left_Cloud_Arm_1Child_1", CubeListBuilder.create().texOffs(100, 46).addBox(2.0F, -2.0F, -1.0F, 4.0F, 8.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		Left_Cloud_Arm_1.addOrReplaceChild("Left_Cloud_Arm_1Child_2", CubeListBuilder.create().texOffs(70, 49).addBox(2.0F, -3.0F, 17.0F, 4.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.5236F, 0.0F));

		Left_Cloud_Arm_1.addOrReplaceChild("Left_Cloud_Arm_1Child_3", CubeListBuilder.create().texOffs(28, 41).addBox(2.0F, -3.0F, 24.0F, 4.0F, 8.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.5236F, 0.0F));

		Left_Cloud_Arm_1.addOrReplaceChild("Left_Cloud_Arm_1Child", CubeListBuilder.create().texOffs(60, 92).addBox(2.0F, -1.0F, 5.0F, 4.0F, 6.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(268, 160).addBox(0.0F, 1.0F, -2.0F, 28.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -35.9076F, 0.0F, 0.0F, 0.0F, 0.9599F));

		partdefinition.addOrReplaceChild("Tail_6", CubeListBuilder.create().texOffs(0, 87).addBox(-2.0F, 7.0F, -31.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 2.7925F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_5", CubeListBuilder.create().texOffs(0, 92).addBox(-4.0F, 13.0F, -25.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 2.2689F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_4", CubeListBuilder.create().texOffs(0, 107).addBox(-6.0F, 6.0F, -17.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 1.7453F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_3", CubeListBuilder.create().texOffs(0, 135).addBox(-8.0F, 1.0F, -12.5F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_2", CubeListBuilder.create().texOffs(0, 163).addBox(-10.0F, -3.0F, -10.5F, 20.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(0, 192).addBox(-12.0F, -4.0F, -11.0F, 24.0F, 7.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9967F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityLightAngel3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head.y = entity.getFloatingRotation();
        this.Torso.y = entity.getFloatingRotation();
        this.Skirt_1.y = entity.getFloatingRotation();
        this.Skirt_2.y = entity.getFloatingRotation();
        this.Skirt_3.y = entity.getFloatingRotation();
        this.Skirt_4.y = entity.getFloatingRotation();
        this.Skirt_5.y = entity.getFloatingRotation();
        this.Skirt_6.y = entity.getFloatingRotation();
        this.Skirt_7.y = entity.getFloatingRotation();
        this.Tail_1.y = entity.getFloatingRotationTail();
        this.Tail_2.y = entity.getFloatingRotationTail();
        this.Tail_3.y = entity.getFloatingRotationTail();
        this.Tail_4.y = entity.getFloatingRotationTail();
        this.Tail_5.y = entity.getFloatingRotationTail();
        this.Tail_6.y = entity.getFloatingRotationTail();
        this.Right_Sleeve.y = entity.getFloatingRotation();
        this.Right_Wrist_1.y = entity.getFloatingRotation();
        this.Right_Wrist_2.y = entity.getFloatingRotation();
        this.Right_Arm.y = entity.getFloatingRotation();
        this.Left_Sleeve.y = entity.getFloatingRotation();
        this.Left_Wrist_1.y = entity.getFloatingRotation();
        this.Left_Arm.y = entity.getFloatingRotation();
        this.Left_Wrist_2.y = entity.getFloatingRotation();
        this.Right_Cloud_Arm_1.y = entity.getFloatingRotationShawl();
        this.Right_Cloud_Arm_2.y = entity.getFloatingRotationShawl();
        this.Left_Cloud_Arm_1.y = entity.getFloatingRotationShawl();
        this.Left_Cloud_Arm_2.y = entity.getFloatingRotationShawl();
        
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wrist_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wrist_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Sleeve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Sleeve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wrist_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wrist_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}