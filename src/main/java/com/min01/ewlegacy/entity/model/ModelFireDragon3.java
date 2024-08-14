package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityFireDragon3;
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

public class ModelFireDragon3 extends EntityModel<EntityFireDragon3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "fire_dragon3"), "main");
	private final ModelPart Back_Flame_2;
	private final ModelPart Chest;
	private final ModelPart Back_Flame_1;
	private final ModelPart Back_Torso;
	private final ModelPart Neck_Flame;
	private final ModelPart Head;
	private final ModelPart Front_Right_Shoulder;
	private final ModelPart Front_Left_Shoulder;
	private final ModelPart Neck;
	private final ModelPart Rear_1;
	private final ModelPart Back_Left_Shoulder;
	private final ModelPart Back_Right_Shoulder;
	private final ModelPart Front_Torso;

	public ModelFireDragon3(ModelPart root)
	{
		this.Back_Flame_2 = root.getChild("Back_Flame_2");
		this.Chest = root.getChild("Chest");
		this.Back_Flame_1 = root.getChild("Back_Flame_1");
		this.Back_Torso = root.getChild("Back_Torso");
		this.Neck_Flame = root.getChild("Neck_Flame");
		this.Head = root.getChild("Head");
		this.Front_Right_Shoulder = root.getChild("Front_Right_Shoulder");
		this.Front_Left_Shoulder = root.getChild("Front_Left_Shoulder");
		this.Neck = root.getChild("Neck");
		this.Rear_1 = root.getChild("Rear_1");
		this.Back_Left_Shoulder = root.getChild("Back_Left_Shoulder");
		this.Back_Right_Shoulder = root.getChild("Back_Right_Shoulder");
		this.Front_Torso = root.getChild("Front_Torso");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Back_Flame_2", CubeListBuilder.create().texOffs(168, 129).addBox(0.0F, -4.0F, 27.0F, 12.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -7.0F, 0.0F, -0.1396F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(366, 172).addBox(-8.0F, 0.0F, -1.0F, 16.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.0524F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Back_Flame_1", CubeListBuilder.create().texOffs(226, 128).addBox(-7.0F, -5.0F, 12.0F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Back_Torso", CubeListBuilder.create().texOffs(210, 150).addBox(-9.0F, 2.0F, 21.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		partdefinition.addOrReplaceChild("Neck_Flame", CubeListBuilder.create().texOffs(286, 128).addBox(-6.0F, -7.0F, 7.0F, 12.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(356, 112).addBox(-7.0F, -16.0F, -3.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(266, 93).addBox(-3.0F, -15.0F, 27.0F, 6.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_21", CubeListBuilder.create().texOffs(420, 130).addBox(-3.5F, -11.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_16", CubeListBuilder.create().texOffs(356, 97).addBox(18.0F, 8.5F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		Head.addOrReplaceChild("HeadChild_19", CubeListBuilder.create().texOffs(412, 142).addBox(-3.0F, -5.0F, -12.5F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_18", CubeListBuilder.create().texOffs(412, 115).addBox(-4.0F, -10.0F, -13.0F, 8.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_17", CubeListBuilder.create().texOffs(356, 91).addBox(13.0F, 17.5F, 4.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0944F));

		Head.addOrReplaceChild("HeadChild_14", CubeListBuilder.create().texOffs(356, 109).addBox(12.0F, -11.0F, 4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(408, 59).addBox(-4.0F, -13.0F, 14.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.3491F, 0.0F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(400, 97).addBox(-21.0F, 8.5F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(406, 77).addBox(-4.0F, -8.0F, 11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, -0.3491F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(412, 90).addBox(-4.0F, -7.0F, 9.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.3491F, 0.0F));

		Head.addOrReplaceChild("HeadChild_20", CubeListBuilder.create().texOffs(412, 130).addBox(-3.5F, -9.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_23", CubeListBuilder.create().texOffs(412, 136).addBox(2.5F, -9.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(294, 99).addBox(-6.5F, -15.0F, 10.0F, 13.0F, 13.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_24", CubeListBuilder.create().texOffs(420, 138).addBox(2.5F, -11.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(336, 59).addBox(2.0F, -13.0F, 14.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.3491F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(398, 119).addBox(-7.5F, -12.0F, 5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_15", CubeListBuilder.create().texOffs(356, 103).addBox(18.0F, -2.0F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		Head.addOrReplaceChild("HeadChild_25", CubeListBuilder.create().texOffs(426, 140).addBox(2.5F, -12.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(400, 103).addBox(-21.0F, -2.0F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(396, 91).addBox(-18.0F, 17.5F, 4.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0944F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(336, 90).addBox(2.0F, -7.0F, 9.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.3491F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(398, 109).addBox(-16.0F, -11.0F, 4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(356, 119).addBox(6.5F, -12.0F, 5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_22", CubeListBuilder.create().texOffs(426, 130).addBox(-3.5F, -12.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(336, 77).addBox(2.0F, -8.0F, 11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.3491F, 0.0F));

		PartDefinition Front_Right_Shoulder = partdefinition.addOrReplaceChild("Front_Right_Shoulder", CubeListBuilder.create().texOffs(402, 192).addBox(-8.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 3.0F, 6.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_5", CubeListBuilder.create().texOffs(96, 207).addBox(-9.0F, -6.0F, 22.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild", CubeListBuilder.create().texOffs(0, 201).addBox(-9.0F, -6.0F, -6.0F, 6.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_6", CubeListBuilder.create().texOffs(370, 192).addBox(-8.0F, 1.0F, -5.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.733F, 0.0F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_1", CubeListBuilder.create().texOffs(36, 210).addBox(-9.0F, -6.0F, 6.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_8", CubeListBuilder.create().texOffs(370, 232).addBox(-8.0F, 17.0F, 1.5F, 8.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_2", CubeListBuilder.create().texOffs(54, 211).addBox(-9.0F, -6.0F, 10.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_12", CubeListBuilder.create().texOffs(360, 239).addBox(-4.5F, 19.0F, 10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_4", CubeListBuilder.create().texOffs(84, 213).addBox(-9.0F, -6.0F, 18.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_11", CubeListBuilder.create().texOffs(404, 220).addBox(0.0F, 18.0F, -1.5F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_10", CubeListBuilder.create().texOffs(404, 233).addBox(-5.0F, 18.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_9", CubeListBuilder.create().texOffs(404, 240).addBox(-9.0F, 18.0F, -3.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_3", CubeListBuilder.create().texOffs(70, 212).addBox(-9.0F, -6.0F, 14.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.0873F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_7", CubeListBuilder.create().texOffs(370, 211).addBox(-8.0F, 4.0F, 7.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Front_Left_Shoulder = partdefinition.addOrReplaceChild("Front_Left_Shoulder", CubeListBuilder.create().texOffs(338, 192).addBox(0.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 3.0F, 6.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_9", CubeListBuilder.create().texOffs(340, 220).addBox(8.0F, 18.0F, -3.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_8", CubeListBuilder.create().texOffs(306, 232).addBox(0.0F, 17.0F, 1.5F, 8.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_1", CubeListBuilder.create().texOffs(36, 189).addBox(4.0F, -6.0F, 6.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_6", CubeListBuilder.create().texOffs(306, 192).addBox(0.0F, 1.0F, -5.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.733F, 0.0F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_2", CubeListBuilder.create().texOffs(54, 190).addBox(5.0F, -6.0F, 10.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_11", CubeListBuilder.create().texOffs(340, 240).addBox(-1.0F, 18.0F, -1.5F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_4", CubeListBuilder.create().texOffs(84, 192).addBox(7.0F, -6.0F, 18.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_5", CubeListBuilder.create().texOffs(96, 186).addBox(8.0F, -6.0F, 22.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_3", CubeListBuilder.create().texOffs(70, 191).addBox(6.0F, -6.0F, 14.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_12", CubeListBuilder.create().texOffs(296, 239).addBox(3.5F, 19.0F, 10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_10", CubeListBuilder.create().texOffs(340, 233).addBox(3.0F, 18.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0175F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_7", CubeListBuilder.create().texOffs(306, 211).addBox(0.0F, 4.0F, 7.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild", CubeListBuilder.create().texOffs(0, 180).addBox(3.0F, -6.0F, -6.0F, 6.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0873F, 0.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(326, 130).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Rear_1 = partdefinition.addOrReplaceChild("Rear_1", CubeListBuilder.create().texOffs(192, 150).addBox(-8.0F, 3.0F, 39.0F, 16.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child_4", CubeListBuilder.create().texOffs(16, 150).addBox(-3.0F, 8.0F, 68.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child_1", CubeListBuilder.create().texOffs(112, 150).addBox(-6.0F, -10.5F, 41.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child_5", CubeListBuilder.create().texOffs(0, 150).addBox(-2.0F, 15.0F, 72.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child", CubeListBuilder.create().texOffs(160, 150).addBox(-7.0F, 4.0F, 41.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child_2", CubeListBuilder.create().texOffs(72, 150).addBox(-5.0F, -5.0F, 52.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Rear_1.addOrReplaceChild("Rear_1Child_3", CubeListBuilder.create().texOffs(40, 150).addBox(-4.0F, 1.0F, 61.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Back_Left_Shoulder = partdefinition.addOrReplaceChild("Back_Left_Shoulder", CubeListBuilder.create().texOffs(210, 192).addBox(0.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 7.0F, 32.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_4", CubeListBuilder.create().texOffs(190, 242).addBox(3.0F, 15.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_5", CubeListBuilder.create().texOffs(202, 242).addBox(0.0F, 15.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild", CubeListBuilder.create().texOffs(178, 192).addBox(0.0F, 0.0F, -5.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.733F, 0.0F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_1", CubeListBuilder.create().texOffs(178, 211).addBox(0.0F, 3.0F, 4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_2", CubeListBuilder.create().texOffs(178, 230).addBox(0.0F, 14.0F, -1.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_3", CubeListBuilder.create().texOffs(178, 242).addBox(7.0F, 15.0F, -5.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Back_Right_Shoulder = partdefinition.addOrReplaceChild("Back_Right_Shoulder", CubeListBuilder.create().texOffs(274, 192).addBox(-8.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 7.0F, 32.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild", CubeListBuilder.create().texOffs(242, 192).addBox(-8.0F, 0.0F, -5.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.733F, 0.0F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_5", CubeListBuilder.create().texOffs(242, 242).addBox(-1.0F, 15.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_1", CubeListBuilder.create().texOffs(242, 211).addBox(-8.0F, 3.0F, 4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_4", CubeListBuilder.create().texOffs(254, 242).addBox(-5.0F, 15.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_2", CubeListBuilder.create().texOffs(242, 230).addBox(-8.0F, 14.0F, -1.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_3", CubeListBuilder.create().texOffs(266, 242).addBox(-8.0F, 15.0F, -5.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		partdefinition.addOrReplaceChild("Front_Torso", CubeListBuilder.create().texOffs(282, 150).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.0524F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityFireDragon3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Front_Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Front_Right_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Back_Right_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Back_Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Back_Flame_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Flame_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck_Flame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Right_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rear_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Right_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}