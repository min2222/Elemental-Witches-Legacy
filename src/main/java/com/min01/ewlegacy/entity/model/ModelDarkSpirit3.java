package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit3;
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

public class ModelDarkSpirit3 extends EntityModel<EntityDarkSpirit3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "dark_spirit3"), "main");
	private final ModelPart Left_Chestplate_Strap;
	private final ModelPart Ethereal_Lower_Body_1;
	private final ModelPart Left_Bracelet_1;
	private final ModelPart Left_Bracelet_2;
	private final ModelPart Right_Chestplate_Strap;
	private final ModelPart Ethereal_Lower_Body_2;
	private final ModelPart Ethereal_Head;
	private final ModelPart Top_Helm;
	private final ModelPart Ethereal_Waist_2;
	private final ModelPart Ethereal_Waist_1;
	private final ModelPart Right_Bracelet_2;
	private final ModelPart Ethereal_Left_Knuckle_2;
	private final ModelPart Right_Bracelet_1;
	private final ModelPart Ethereal_Left_Knuckle_1;
	private final ModelPart Front_Chestplate_Piece_1;
	private final ModelPart Lower_Body_Armor_7;
	private final ModelPart Lower_Body_Armor_1;
	private final ModelPart Ethereal_Torso;
	private final ModelPart Ethereal_Right_Hand_2;
	private final ModelPart Ethereal_Right_Hand_1;
	private final ModelPart Ethereal_Left_Hand_1;
	private final ModelPart Ethereal_Left_Hand_2;
	private final ModelPart Ethereal_Right_Knuckle_2;
	private final ModelPart Ethereal_Right_Knuckle_1;
	private final ModelPart Ring;

	public ModelDarkSpirit3(ModelPart root) 
	{
		this.Left_Chestplate_Strap = root.getChild("Left_Chestplate_Strap");
		this.Ethereal_Lower_Body_1 = root.getChild("Ethereal_Lower_Body_1");
		this.Left_Bracelet_1 = root.getChild("Left_Bracelet_1");
		this.Left_Bracelet_2 = root.getChild("Left_Bracelet_2");
		this.Right_Chestplate_Strap = root.getChild("Right_Chestplate_Strap");
		this.Ethereal_Lower_Body_2 = root.getChild("Ethereal_Lower_Body_2");
		this.Ethereal_Head = root.getChild("Ethereal_Head");
		this.Top_Helm = root.getChild("Top_Helm");
		this.Ethereal_Waist_2 = root.getChild("Ethereal_Waist_2");
		this.Ethereal_Waist_1 = root.getChild("Ethereal_Waist_1");
		this.Right_Bracelet_2 = root.getChild("Right_Bracelet_2");
		this.Ethereal_Left_Knuckle_2 = root.getChild("Ethereal_Left_Knuckle_2");
		this.Right_Bracelet_1 = root.getChild("Right_Bracelet_1");
		this.Ethereal_Left_Knuckle_1 = root.getChild("Ethereal_Left_Knuckle_1");
		this.Front_Chestplate_Piece_1 = root.getChild("Front_Chestplate_Piece_1");
		this.Lower_Body_Armor_7 = root.getChild("Lower_Body_Armor_7");
		this.Lower_Body_Armor_1 = root.getChild("Lower_Body_Armor_1");
		this.Ethereal_Torso = root.getChild("Ethereal_Torso");
		this.Ethereal_Right_Hand_2 = root.getChild("Ethereal_Right_Hand_2");
		this.Ethereal_Right_Hand_1 = root.getChild("Ethereal_Right_Hand_1");
		this.Ethereal_Left_Hand_1 = root.getChild("Ethereal_Left_Hand_1");
		this.Ethereal_Left_Hand_2 = root.getChild("Ethereal_Left_Hand_2");
		this.Ethereal_Right_Knuckle_2 = root.getChild("Ethereal_Right_Knuckle_2");
		this.Ethereal_Right_Knuckle_1 = root.getChild("Ethereal_Right_Knuckle_1");
		this.Ring = root.getChild("Ring");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Left_Chestplate_Strap = partdefinition.addOrReplaceChild("Left_Chestplate_Strap", CubeListBuilder.create().texOffs(306, 59).addBox(7.0F, -2.0F, -3.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_4", CubeListBuilder.create().texOffs(338, 61).addBox(3.0F, -3.0F, 5.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_5", CubeListBuilder.create().texOffs(362, 54).addBox(0.0F, -10.0F, -4.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_7", CubeListBuilder.create().texOffs(378, 32).addBox(4.0F, -16.0F, -2.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_3", CubeListBuilder.create().texOffs(338, 85).addBox(3.0F, -3.0F, -7.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_6", CubeListBuilder.create().texOffs(370, 42).addBox(2.0F, -13.0F, -3.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_1", CubeListBuilder.create().texOffs(386, 72).addBox(11.0F, -7.0F, -4.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild", CubeListBuilder.create().texOffs(338, 69).addBox(1.0F, -5.0F, -5.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_8", CubeListBuilder.create().texOffs(386, 25).addBox(6.0F, -18.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_2", CubeListBuilder.create().texOffs(410, 75).addBox(8.0F, -12.0F, -3.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		Left_Chestplate_Strap.addOrReplaceChild("Left_Chestplate_StrapChild_9", CubeListBuilder.create().texOffs(394, 20).addBox(8.5F, -20.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Ethereal_Lower_Body_1", CubeListBuilder.create().texOffs(0, 8).addBox(-4.0F, 26.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Bracelet_1", CubeListBuilder.create().texOffs(416, 85).addBox(22.0F, 0.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Left_Bracelet_2 = partdefinition.addOrReplaceChild("Left_Bracelet_2", CubeListBuilder.create().texOffs(392, 85).addBox(3.0F, 14.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child_4", CubeListBuilder.create().texOffs(0, 169).addBox(25.0F, 18.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child_2", CubeListBuilder.create().texOffs(60, 186).addBox(4.5F, 25.0F, -14.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child", CubeListBuilder.create().texOffs(0, 187).addBox(4.0F, 26.0F, 9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child_3", CubeListBuilder.create().texOffs(72, 152).addBox(6.0F, 22.0F, -48.0F, 0.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child_1", CubeListBuilder.create().texOffs(16, 173).addBox(5.0F, 27.0F, -11.0F, 2.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Left_Bracelet_2.addOrReplaceChild("Left_Bracelet_2Child_5", CubeListBuilder.create().texOffs(4, 112).addBox(25.0F, 9.0F, -40.0F, 0.0F, 9.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Right_Chestplate_Strap = partdefinition.addOrReplaceChild("Right_Chestplate_Strap", CubeListBuilder.create().texOffs(196, 59).addBox(-13.0F, -2.0F, -3.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_5", CubeListBuilder.create().texOffs(132, 54).addBox(-10.0F, -10.0F, -4.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_4", CubeListBuilder.create().texOffs(172, 61).addBox(-11.0F, -3.0F, 5.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_2", CubeListBuilder.create().texOffs(94, 75).addBox(-15.0F, -12.0F, -3.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_8", CubeListBuilder.create().texOffs(132, 25).addBox(-10.0F, -18.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_7", CubeListBuilder.create().texOffs(132, 32).addBox(-10.0F, -16.0F, -2.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_9", CubeListBuilder.create().texOffs(132, 20).addBox(-10.5F, -20.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_1", CubeListBuilder.create().texOffs(124, 72).addBox(-13.0F, -7.0F, -4.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild", CubeListBuilder.create().texOffs(148, 69).addBox(-13.0F, -5.0F, -5.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_3", CubeListBuilder.create().texOffs(172, 85).addBox(-11.0F, -3.0F, -7.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Right_Chestplate_Strap.addOrReplaceChild("Right_Chestplate_StrapChild_6", CubeListBuilder.create().texOffs(132, 42).addBox(-10.0F, -13.0F, -3.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("Ethereal_Lower_Body_2", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, 33.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Head", CubeListBuilder.create().texOffs(0, -23).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		PartDefinition Top_Helm = partdefinition.addOrReplaceChild("Top_Helm", CubeListBuilder.create().texOffs(240, 65).addBox(-7.0F, -18.0F, -7.0F, 14.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_2", CubeListBuilder.create().texOffs(262, 82).addBox(-2.0F, -14.0F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_14", CubeListBuilder.create().texOffs(274, 52).addBox(-10.5F, -21.5F, -8.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_1", CubeListBuilder.create().texOffs(256, 81).addBox(-4.0F, -16.0F, -5.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_3", CubeListBuilder.create().texOffs(278, 80).addBox(4.0F, -16.0F, -5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_15", CubeListBuilder.create().texOffs(256, 52).addBox(9.5F, -21.5F, -8.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_17", CubeListBuilder.create().texOffs(254, 25).addBox(-6.0F, -16.0F, 7.0F, 12.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_10", CubeListBuilder.create().texOffs(196, 71).addBox(-9.0F, -15.0F, -6.0F, 1.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_16", CubeListBuilder.create().texOffs(252, 38).addBox(-7.0F, -17.0F, 6.0F, 14.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_11", CubeListBuilder.create().texOffs(282, 68).addBox(5.0F, -16.0F, -7.0F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_4", CubeListBuilder.create().texOffs(272, 81).addBox(2.0F, -15.0F, -5.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild", CubeListBuilder.create().texOffs(252, 80).addBox(-5.0F, -16.0F, -5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_5", CubeListBuilder.create().texOffs(268, 82).addBox(1.0F, -14.0F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_12", CubeListBuilder.create().texOffs(314, 71).addBox(8.0F, -15.0F, -6.0F, 1.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_7", CubeListBuilder.create().texOffs(264, 87).addBox(-1.0F, -11.0F, -6.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_9", CubeListBuilder.create().texOffs(220, 68).addBox(-8.0F, -16.0F, -7.0F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_8", CubeListBuilder.create().texOffs(270, 84).addBox(1.0F, -13.0F, -7.0F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_13", CubeListBuilder.create().texOffs(260, 58).addBox(-14.5F, -14.5F, -8.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Top_Helm.addOrReplaceChild("Top_HelmChild_6", CubeListBuilder.create().texOffs(252, 84).addBox(-5.0F, -13.0F, -7.0F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Waist_2", CubeListBuilder.create().texOffs(0, 8).addBox(-10.0F, 23.0F, -6.0F, 20.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Waist_1", CubeListBuilder.create().texOffs(0, 8).addBox(-12.0F, 22.0F, -6.0F, 24.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		PartDefinition Right_Bracelet_2 = partdefinition.addOrReplaceChild("Right_Bracelet_2", CubeListBuilder.create().texOffs(118, 85).addBox(-9.0F, 14.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_2.addOrReplaceChild("Right_Bracelet_2Child_1", CubeListBuilder.create().texOffs(34, 195).addBox(-8.0F, 13.0F, -23.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.1745F));

		Right_Bracelet_2.addOrReplaceChild("Right_Bracelet_2Child_2", CubeListBuilder.create().texOffs(34, 207).addBox(-8.0F, 25.0F, 9.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.1745F));

		Right_Bracelet_2.addOrReplaceChild("Right_Bracelet_2Child", CubeListBuilder.create().texOffs(0, 202).addBox(-7.0F, 27.0F, -7.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_2.addOrReplaceChild("Right_Bracelet_2Child_3", CubeListBuilder.create().texOffs(50, 176).addBox(-6.0F, 25.0F, -36.0F, 0.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Left_Knuckle_2", CubeListBuilder.create().texOffs(0, 8).addBox(2.0F, 31.0F, -3.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Right_Bracelet_1 = partdefinition.addOrReplaceChild("Right_Bracelet_1", CubeListBuilder.create().texOffs(94, 85).addBox(-28.0F, 0.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_1.addOrReplaceChild("Right_Bracelet_1Child_1", CubeListBuilder.create().texOffs(74, 231).addBox(-26.5F, 12.5F, -37.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_1.addOrReplaceChild("Right_Bracelet_1Child_3", CubeListBuilder.create().texOffs(74, 228).addBox(-25.0F, 15.5F, -40.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_1.addOrReplaceChild("Right_Bracelet_1Child", CubeListBuilder.create().texOffs(0, 219).addBox(-26.0F, 13.0F, -25.0F, 2.0F, 2.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Right_Bracelet_1.addOrReplaceChild("Right_Bracelet_1Child_2", CubeListBuilder.create().texOffs(74, 203).addBox(-25.0F, 2.5F, -40.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Left_Knuckle_1", CubeListBuilder.create().texOffs(0, 8).addBox(21.0F, 17.0F, -3.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Front_Chestplate_Piece_1 = partdefinition.addOrReplaceChild("Front_Chestplate_Piece_1", CubeListBuilder.create().texOffs(240, 96).addBox(-12.0F, 1.0F, -9.0F, 24.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_2", CubeListBuilder.create().texOffs(256, 121).addBox(-4.0F, 4.0F, -12.0F, 8.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_5", CubeListBuilder.create().texOffs(329, 132).addBox(-7.0F, 17.0F, 5.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child", CubeListBuilder.create().texOffs(212, 93).addBox(-15.0F, 0.0F, -7.0F, 8.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_4", CubeListBuilder.create().texOffs(331, 115).addBox(-7.0F, 1.0F, 9.0F, 14.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_6", CubeListBuilder.create().texOffs(332, 138).addBox(-6.0F, 20.0F, 5.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_1", CubeListBuilder.create().texOffs(294, 93).addBox(7.0F, 0.0F, -7.0F, 8.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Chestplate_Piece_1.addOrReplaceChild("Front_Chestplate_Piece_1Child_3", CubeListBuilder.create().texOffs(322, 93).addBox(-10.0F, 0.0F, 5.0F, 20.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Lower_Body_Armor_7 = partdefinition.addOrReplaceChild("Lower_Body_Armor_7", CubeListBuilder.create().texOffs(255, 170).addBox(-3.0F, 35.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Lower_Body_Armor_7.addOrReplaceChild("Lower_Body_Armor_7Child", CubeListBuilder.create().texOffs(259, 178).addBox(-2.0F, 37.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Lower_Body_Armor_1 = partdefinition.addOrReplaceChild("Lower_Body_Armor_1", CubeListBuilder.create().texOffs(255, 164).addBox(-5.0F, 29.0F, -6.0F, 10.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		Lower_Body_Armor_1.addOrReplaceChild("Lower_Body_Armor_1Child_1", CubeListBuilder.create().texOffs(277, 155).addBox(4.0F, 29.0F, -5.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Lower_Body_Armor_1.addOrReplaceChild("Lower_Body_Armor_1Child_2", CubeListBuilder.create().texOffs(257, 148).addBox(-4.0F, 29.0F, 4.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Lower_Body_Armor_1.addOrReplaceChild("Lower_Body_Armor_1Child_3", CubeListBuilder.create().texOffs(249, 148).addBox(-5.0F, 29.0F, 2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Lower_Body_Armor_1.addOrReplaceChild("Lower_Body_Armor_1Child", CubeListBuilder.create().texOffs(243, 155).addBox(-6.0F, 29.0F, -5.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Lower_Body_Armor_1.addOrReplaceChild("Lower_Body_Armor_1Child_4", CubeListBuilder.create().texOffs(277, 148).addBox(4.0F, 29.0F, 2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Torso", CubeListBuilder.create().texOffs(0, 8).addBox(-14.0F, 0.0F, -6.0F, 28.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Right_Hand_2", CubeListBuilder.create().texOffs(0, 8).addBox(-11.0F, 22.0F, -3.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Right_Hand_1", CubeListBuilder.create().texOffs(0, 8).addBox(-30.0F, 8.0F, -3.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Left_Hand_1", CubeListBuilder.create().texOffs(0, 8).addBox(20.0F, 8.0F, -3.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Left_Hand_2", CubeListBuilder.create().texOffs(0, 8).addBox(1.0F, 22.0F, -3.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Right_Knuckle_2", CubeListBuilder.create().texOffs(0, 8).addBox(-11.0F, 31.0F, -3.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ethereal_Right_Knuckle_1", CubeListBuilder.create().texOffs(0, 8).addBox(-30.0F, 17.0F, -3.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("Ring", CubeListBuilder.create().texOffs(243, 0).addBox(-12.0F, -12.0F, 0.0F, 24.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityDarkSpirit3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Top_Helm.xRot = headPitch / 57.295776F;
        this.Top_Helm.yRot = netHeadYaw / 57.295776F;
        this.Ethereal_Head.xRot = headPitch / 57.295776F;
        this.Ethereal_Head.yRot = netHeadYaw / 57.295776F;
        this.Left_Bracelet_1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Right_Bracelet_2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Left_Bracelet_2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Right_Bracelet_1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Left_Hand_1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Right_Hand_2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Left_Hand_2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Right_Hand_1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Left_Knuckle_1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Right_Knuckle_2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Left_Knuckle_2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Ethereal_Right_Knuckle_1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Left_Chestplate_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Lower_Body_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Bracelet_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Bracelet_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Chestplate_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Lower_Body_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Helm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Waist_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Waist_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Bracelet_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Left_Knuckle_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Bracelet_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Left_Knuckle_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Chestplate_Piece_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Body_Armor_7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Body_Armor_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Right_Hand_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Right_Hand_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Left_Hand_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Left_Hand_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Right_Knuckle_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Right_Knuckle_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ring.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}