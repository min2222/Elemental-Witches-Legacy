package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit2;
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

public class ModelDarkSpirit2 extends EntityModel<EntityDarkSpirit2>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "dark_spirit2"), "main");
	private final ModelPart Ethereal_Lower_Body_1;
	private final ModelPart Left_Chestplate_Piece;
	private final ModelPart Right_Chestplate_Piece;
	private final ModelPart Ethereal_Lower_Body_2;
	private final ModelPart Left_Shoulder_Pad_Back_Strap;
	private final ModelPart Helmet_Top;
	private final ModelPart Right_Ethereal_Hand;
	private final ModelPart Left_Ethereal_Claw_2_2;
	private final ModelPart Left_Ethereal_Claw_2_1;
	private final ModelPart Right_Shoulder_Pad_Front_Strap;
	private final ModelPart Main_Chestplate_Piece;
	private final ModelPart Front_Chestplate_Piece;
	private final ModelPart Right_Shoulder_Pad_Main_Piece;
	private final ModelPart Left_Shoulder_Pad_Front_Strap;
	private final ModelPart Left_Shoulder_Pad_Main_Piece;
	private final ModelPart Right_Ethereal_Claw_2_2;
	private final ModelPart Right_Ethereal_Claw_2_1;
	private final ModelPart Bottom_Armor_2;
	private final ModelPart Bottom_Armor_1;
	private final ModelPart Ethereal_Waist;
	private final ModelPart Right_Glove_2;
	private final ModelPart Right_Glove_1;
	private final ModelPart Left_Glove_2;
	private final ModelPart Left_Glove_1;
	private final ModelPart Ethereal_Torso;
	private final ModelPart Right_Shoulder_Pad_Back_Strap;
	private final ModelPart Left_Ethereal_Claw_3_1;
	private final ModelPart Left_Ethereal_Claw_3_2;
	private final ModelPart Left_Ethereal_Claw_1_1;
	private final ModelPart Left_Ethereal_Claw_1_2;
	private final ModelPart Right_Ethereal_Claw_3_2;
	private final ModelPart Right_Ethereal_Claw_1_1;
	private final ModelPart Right_Ethereal_Claw_3_1;
	private final ModelPart Left_Ethereal_Hand;
	private final ModelPart Right_Ethereal_Claw_1_2;

	public ModelDarkSpirit2(ModelPart root)
	{
		this.Ethereal_Lower_Body_1 = root.getChild("Ethereal_Lower_Body_1");
		this.Left_Chestplate_Piece = root.getChild("Left_Chestplate_Piece");
		this.Right_Chestplate_Piece = root.getChild("Right_Chestplate_Piece");
		this.Ethereal_Lower_Body_2 = root.getChild("Ethereal_Lower_Body_2");
		this.Left_Shoulder_Pad_Back_Strap = root.getChild("Left_Shoulder_Pad_Back_Strap");
		this.Helmet_Top = root.getChild("Helmet_Top");
		this.Right_Ethereal_Hand = root.getChild("Right_Ethereal_Hand");
		this.Left_Ethereal_Claw_2_2 = root.getChild("Left_Ethereal_Claw_2_2");
		this.Left_Ethereal_Claw_2_1 = root.getChild("Left_Ethereal_Claw_2_1");
		this.Right_Shoulder_Pad_Front_Strap = root.getChild("Right_Shoulder_Pad_Front_Strap");
		this.Main_Chestplate_Piece = root.getChild("Main_Chestplate_Piece");
		this.Front_Chestplate_Piece = root.getChild("Front_Chestplate_Piece");
		this.Right_Shoulder_Pad_Main_Piece = root.getChild("Right_Shoulder_Pad_Main_Piece");
		this.Left_Shoulder_Pad_Front_Strap = root.getChild("Left_Shoulder_Pad_Front_Strap");
		this.Left_Shoulder_Pad_Main_Piece = root.getChild("Left_Shoulder_Pad_Main_Piece");
		this.Right_Ethereal_Claw_2_2 = root.getChild("Right_Ethereal_Claw_2_2");
		this.Right_Ethereal_Claw_2_1 = root.getChild("Right_Ethereal_Claw_2_1");
		this.Bottom_Armor_2 = root.getChild("Bottom_Armor_2");
		this.Bottom_Armor_1 = root.getChild("Bottom_Armor_1");
		this.Ethereal_Waist = root.getChild("Ethereal_Waist");
		this.Right_Glove_2 = root.getChild("Right_Glove_2");
		this.Right_Glove_1 = root.getChild("Right_Glove_1");
		this.Left_Glove_2 = root.getChild("Left_Glove_2");
		this.Left_Glove_1 = root.getChild("Left_Glove_1");
		this.Ethereal_Torso = root.getChild("Ethereal_Torso");
		this.Right_Shoulder_Pad_Back_Strap = root.getChild("Right_Shoulder_Pad_Back_Strap");
		this.Left_Ethereal_Claw_3_1 = root.getChild("Left_Ethereal_Claw_3_1");
		this.Left_Ethereal_Claw_3_2 = root.getChild("Left_Ethereal_Claw_3_2");
		this.Left_Ethereal_Claw_1_1 = root.getChild("Left_Ethereal_Claw_1_1");
		this.Left_Ethereal_Claw_1_2 = root.getChild("Left_Ethereal_Claw_1_2");
		this.Right_Ethereal_Claw_3_2 = root.getChild("Right_Ethereal_Claw_3_2");
		this.Right_Ethereal_Claw_1_1 = root.getChild("Right_Ethereal_Claw_1_1");
		this.Right_Ethereal_Claw_3_1 = root.getChild("Right_Ethereal_Claw_3_1");
		this.Left_Ethereal_Hand = root.getChild("Left_Ethereal_Hand");
		this.Right_Ethereal_Claw_1_2 = root.getChild("Right_Ethereal_Claw_1_2");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Ethereal_Lower_Body_1", CubeListBuilder.create().texOffs(0, -12).addBox(-4.0F, 12.0F, -2.5F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Chestplate_Piece", CubeListBuilder.create().texOffs(76, 27).addBox(4.0F, 0.0F, -4.0F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Chestplate_Piece", CubeListBuilder.create().texOffs(34, 27).addBox(-8.0F, 0.0F, -4.0F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Lower_Body_2", CubeListBuilder.create().texOffs(0, -10).addBox(-1.5F, 18.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Pad_Back_Strap", CubeListBuilder.create().texOffs(98, 15).addBox(1.0F, -4.0F, 3.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Helmet_Top = partdefinition.addOrReplaceChild("Helmet_Top", CubeListBuilder.create().texOffs(46, 8).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild", CubeListBuilder.create().texOffs(53, 1).addBox(-3.0F, -11.0F, -6.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_2", CubeListBuilder.create().texOffs(50, 21).addBox(-3.0F, -6.0F, -5.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_1", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -13.0F, -7.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_11", CubeListBuilder.create().texOffs(50, 19).addBox(-3.0F, -7.0F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_10", CubeListBuilder.create().texOffs(35, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_6", CubeListBuilder.create().texOffs(74, 10).addBox(3.0F, -9.0F, -5.0F, 2.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_12", CubeListBuilder.create().texOffs(68, 19).addBox(1.0F, -7.0F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_13", CubeListBuilder.create().texOffs(0, -13).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_8", CubeListBuilder.create().texOffs(35, 3).addBox(-2.0F, -14.0F, -8.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_7", CubeListBuilder.create().texOffs(71, 0).addBox(-3.0F, -8.0F, 3.0F, 6.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_9", CubeListBuilder.create().texOffs(39, 3).addBox(1.0F, -14.0F, -8.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_3", CubeListBuilder.create().texOffs(58, 22).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_5", CubeListBuilder.create().texOffs(28, 10).addBox(-5.0F, -9.0F, -5.0F, 2.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Helmet_Top.addOrReplaceChild("Helmet_TopChild_4", CubeListBuilder.create().texOffs(66, 21).addBox(1.0F, -6.0F, -5.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Hand", CubeListBuilder.create().texOffs(0, -12).addBox(-8.0F, 10.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_2_2", CubeListBuilder.create().texOffs(0, -4).addBox(-9.5F, 17.0F, 5.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, -0.5236F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_2_1", CubeListBuilder.create().texOffs(0, -5).addBox(-6.0F, 14.0F, 5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, -0.5236F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Pad_Front_Strap", CubeListBuilder.create().texOffs(14, 30).addBox(-5.0F, -4.0F, -5.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Main_Chestplate_Piece", CubeListBuilder.create().texOffs(48, 29).addBox(-6.0F, 1.0F, -5.0F, 12.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Front_Chestplate_Piece", CubeListBuilder.create().texOffs(56, 42).addBox(-2.0F, 2.0F, -6.0F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Pad_Main_Piece", CubeListBuilder.create().texOffs(6, 20).addBox(-6.0F, -5.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Pad_Front_Strap", CubeListBuilder.create().texOffs(98, 30).addBox(1.0F, -4.0F, -5.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Pad_Main_Piece", CubeListBuilder.create().texOffs(90, 20).addBox(0.0F, -5.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_2_2", CubeListBuilder.create().texOffs(0, -4).addBox(3.5F, 17.0F, 5.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, -0.5236F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_2_1", CubeListBuilder.create().texOffs(0, -5).addBox(4.0F, 14.0F, 5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, -0.5236F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Bottom_Armor_2", CubeListBuilder.create().texOffs(57, 60).addBox(-2.0F, 19.0F, -2.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Bottom_Armor_1", CubeListBuilder.create().texOffs(54, 55).addBox(-3.0F, 16.0F, -3.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Ethereal_Waist", CubeListBuilder.create().texOffs(0, -8).addBox(-6.0F, 11.0F, -3.0F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Glove_2", CubeListBuilder.create().texOffs(10, 45).addBox(-7.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Right_Glove_1", CubeListBuilder.create().texOffs(13, 35).addBox(-6.0F, 2.0F, -7.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -4.0F, 0.0F, 0.7854F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Left_Glove_2", CubeListBuilder.create().texOffs(94, 45).addBox(2.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Left_Glove_1", CubeListBuilder.create().texOffs(97, 35).addBox(4.0F, 2.0F, -7.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -4.0F, 0.0F, 0.7854F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Ethereal_Torso", CubeListBuilder.create().texOffs(0, -18).addBox(-8.0F, 0.0F, -3.0F, 16.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Pad_Back_Strap", CubeListBuilder.create().texOffs(14, 15).addBox(-5.0F, -4.0F, 3.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_3_1", CubeListBuilder.create().texOffs(0, -5).addBox(-6.0F, 14.0F, -7.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, 0.5236F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_3_2", CubeListBuilder.create().texOffs(0, -4).addBox(-9.5F, 17.0F, -7.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, 0.5236F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_1_1", CubeListBuilder.create().texOffs(0, -5).addBox(11.0F, 8.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Claw_1_2", CubeListBuilder.create().texOffs(0, -4).addBox(10.5F, 11.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_3_2", CubeListBuilder.create().texOffs(0, -4).addBox(3.5F, 17.0F, -7.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, 0.5236F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_1_1", CubeListBuilder.create().texOffs(0, -5).addBox(-13.0F, 8.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_3_1", CubeListBuilder.create().texOffs(0, -5).addBox(4.0F, 14.0F, -7.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, 0.5236F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Left_Ethereal_Hand", CubeListBuilder.create().texOffs(0, -12).addBox(2.0F, 10.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Ethereal_Claw_1_2", CubeListBuilder.create().texOffs(0, -4).addBox(-16.5F, 11.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityDarkSpirit2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Helmet_Top.y = entity.getFloatingRotation();
        this.Main_Chestplate_Piece.y = entity.getFloatingRotation();
        this.Front_Chestplate_Piece.y = entity.getFloatingRotation();
        this.Right_Chestplate_Piece.y = entity.getFloatingRotation();
        this.Left_Chestplate_Piece.y = entity.getFloatingRotation();
        this.Right_Shoulder_Pad_Main_Piece.y = entity.getFloatingRotation();
        this.Right_Shoulder_Pad_Front_Strap.y = entity.getFloatingRotation();
        this.Right_Shoulder_Pad_Back_Strap.y = entity.getFloatingRotation();
        this.Left_Shoulder_Pad_Main_Piece.y = entity.getFloatingRotation();
        this.Left_Shoulder_Pad_Front_Strap.y = entity.getFloatingRotation();
        this.Left_Shoulder_Pad_Back_Strap.y = entity.getFloatingRotation();
        this.Bottom_Armor_1.y = entity.getFloatingRotation();
        this.Bottom_Armor_2.y = entity.getFloatingRotation();
        this.Right_Glove_1.y = entity.getFloatingRotation();
        this.Left_Glove_1.y = entity.getFloatingRotation();
        this.Right_Glove_2.y = entity.getFloatingRotation();
        this.Left_Glove_2.y = entity.getFloatingRotation();
        
        this.Helmet_Top.xRot = headPitch / 57.295776F;
        this.Helmet_Top.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Ethereal_Lower_Body_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Chestplate_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Chestplate_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Lower_Body_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Pad_Back_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Helmet_Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_2_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_2_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Pad_Front_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Main_Chestplate_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Chestplate_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Pad_Main_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Pad_Front_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Pad_Main_Piece.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_2_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_2_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Armor_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Armor_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Glove_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Glove_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Glove_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Glove_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ethereal_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Pad_Back_Strap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_3_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_3_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_1_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Claw_1_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_3_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_1_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_3_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ethereal_Hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ethereal_Claw_1_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}