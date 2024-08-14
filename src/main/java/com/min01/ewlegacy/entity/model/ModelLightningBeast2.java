package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast2;
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

public class ModelLightningBeast2 extends EntityModel<EntityLightningBeast2>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "lightning_beast2"), "main");
    public float floatingRotation;
	private final ModelPart Chest;
	private final ModelPart Back_Right_Leg_1;
	private final ModelPart Right_Wing_Membrane_1;
	private final ModelPart Upper_Torso;
	private final ModelPart Head;
	private final ModelPart Lower_Torso;
	private final ModelPart Front_Right_Leg_1;
	private final ModelPart Left_Wing_Membrane_1;
	private final ModelPart Front_Left_Leg_1;
	private final ModelPart Neck;
	private final ModelPart Rear;
	private final ModelPart Back_Left_Leg_1;

	public ModelLightningBeast2(ModelPart root) 
	{
		this.Chest = root.getChild("Chest");
		this.Back_Right_Leg_1 = root.getChild("Back_Right_Leg_1");
		this.Right_Wing_Membrane_1 = root.getChild("Right_Wing_Membrane_1");
		this.Upper_Torso = root.getChild("Upper_Torso");
		this.Head = root.getChild("Head");
		this.Lower_Torso = root.getChild("Lower_Torso");
		this.Front_Right_Leg_1 = root.getChild("Front_Right_Leg_1");
		this.Left_Wing_Membrane_1 = root.getChild("Left_Wing_Membrane_1");
		this.Front_Left_Leg_1 = root.getChild("Front_Left_Leg_1");
		this.Neck = root.getChild("Neck");
		this.Rear = root.getChild("Rear");
		this.Back_Left_Leg_1 = root.getChild("Back_Left_Leg_1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(88, 26).addBox(-4.0F, 1.5F, -3.0F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Back_Right_Leg_1 = partdefinition.addOrReplaceChild("Back_Right_Leg_1", CubeListBuilder.create().texOffs(16, 42).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 16.0F, 12.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_2", CubeListBuilder.create().texOffs(28, 59).addBox(-3.0F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_1", CubeListBuilder.create().texOffs(16, 59).addBox(-3.0F, 6.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_3", CubeListBuilder.create().texOffs(28, 60).addBox(-1.5F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_4", CubeListBuilder.create().texOffs(28, 61).addBox(0.0F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child", CubeListBuilder.create().texOffs(16, 49).addBox(-3.0F, 0.0F, 0.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Right_Wing_Membrane_1 = partdefinition.addOrReplaceChild("Right_Wing_Membrane_1", CubeListBuilder.create().texOffs(68, 40).addBox(0.0F, -4.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 10.0F, 3.0F, -0.5236F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child_1", CubeListBuilder.create().texOffs(60, 40).addBox(0.0F, -14.0F, -2.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child_3", CubeListBuilder.create().texOffs(72, 47).addBox(0.5F, -1.0F, 1.5F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4538F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child_4", CubeListBuilder.create().texOffs(64, 49).addBox(0.5F, -13.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child_5", CubeListBuilder.create().texOffs(60, 48).addBox(0.5F, -13.0F, -5.5F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.501F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child", CubeListBuilder.create().texOffs(64, 40).addBox(0.0F, -7.0F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0071F, -0.5236F, 0.0F));

		Right_Wing_Membrane_1.addOrReplaceChild("Right_Wing_Membrane_1Child_2", CubeListBuilder.create().texOffs(76, 53).addBox(0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4887F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Upper_Torso", CubeListBuilder.create().texOffs(50, 21).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(88, 9).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(99, 5).addBox(-0.5F, -7.0F, 0.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5585F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(89, 0).addBox(3.0F, -6.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(81, 0).addBox(3.0F, -5.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(89, 4).addBox(3.0F, -4.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(55, 3).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(120, 0).addBox(-4.0F, -6.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(81, 4).addBox(3.0F, -3.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(110, 10).addBox(-2.0F, -6.5F, -6.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(120, 4).addBox(-4.0F, -4.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(112, 0).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, -0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(112, 4).addBox(-4.0F, -3.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, -0.0873F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(100, 0).addBox(-0.5F, -11.0F, 1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5585F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(41, 6).addBox(-2.0F, -5.0F, 3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Torso", CubeListBuilder.create().texOffs(18, 24).addBox(-4.0F, 1.0F, 8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Front_Right_Leg_1 = partdefinition.addOrReplaceChild("Front_Right_Leg_1", CubeListBuilder.create().texOffs(48, 40).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 15.0F, 2.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_2", CubeListBuilder.create().texOffs(60, 59).addBox(-3.0F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_1", CubeListBuilder.create().texOffs(48, 59).addBox(-3.0F, 7.0F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child", CubeListBuilder.create().texOffs(48, 48).addBox(-3.0F, 0.0F, 1.6F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_4", CubeListBuilder.create().texOffs(60, 61).addBox(0.0F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_3", CubeListBuilder.create().texOffs(60, 60).addBox(-1.5F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Left_Wing_Membrane_1 = partdefinition.addOrReplaceChild("Left_Wing_Membrane_1", CubeListBuilder.create().texOffs(98, 40).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 10.0F, 3.0F, -0.5236F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child_1", CubeListBuilder.create().texOffs(90, 40).addBox(-1.0F, -14.0F, -2.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child_2", CubeListBuilder.create().texOffs(106, 53).addBox(-0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4887F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child", CubeListBuilder.create().texOffs(94, 40).addBox(-1.0F, -7.0F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0071F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child_3", CubeListBuilder.create().texOffs(102, 47).addBox(-0.5F, -1.0F, 1.5F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4538F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child_5", CubeListBuilder.create().texOffs(90, 48).addBox(-0.5F, -13.0F, -5.5F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.501F, 0.5236F, 0.0F));

		Left_Wing_Membrane_1.addOrReplaceChild("Left_Wing_Membrane_1Child_4", CubeListBuilder.create().texOffs(94, 49).addBox(-0.5F, -13.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.5236F, 0.0F));

		PartDefinition Front_Left_Leg_1 = partdefinition.addOrReplaceChild("Front_Left_Leg_1", CubeListBuilder.create().texOffs(32, 40).addBox(0.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 15.0F, 2.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_1", CubeListBuilder.create().texOffs(32, 59).addBox(0.0F, 7.0F, -3.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child", CubeListBuilder.create().texOffs(32, 48).addBox(0.0F, 0.0F, 1.6F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_2", CubeListBuilder.create().texOffs(44, 59).addBox(3.0F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_3", CubeListBuilder.create().texOffs(44, 60).addBox(1.5F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_4", CubeListBuilder.create().texOffs(44, 61).addBox(0.0F, 8.0F, -5.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(72, 12).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.3665F, 0.0F, 0.0F));

		PartDefinition Rear = partdefinition.addOrReplaceChild("Rear", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 16.0F, -6.02F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_2", CubeListBuilder.create().texOffs(16, 13).addBox(-1.5F, 7.0F, 2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4435F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_3", CubeListBuilder.create().texOffs(32, 13).addBox(-1.0F, 6.0F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_4", CubeListBuilder.create().texOffs(40, 13).addBox(-1.0F, 9.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_5", CubeListBuilder.create().texOffs(48, 13).addBox(-0.5F, 10.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, 0.0F, 2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_1", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, 4.0F, 3.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		PartDefinition Back_Left_Leg_1 = partdefinition.addOrReplaceChild("Back_Left_Leg_1", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 16.0F, 12.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, 0.0F, 0.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_3", CubeListBuilder.create().texOffs(12, 60).addBox(1.5F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_2", CubeListBuilder.create().texOffs(12, 59).addBox(3.0F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_1", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, 6.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_4", CubeListBuilder.create().texOffs(12, 61).addBox(0.0F, 7.0F, -4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityLightningBeast2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.floatingRotation += 0.02F;
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Front_Left_Leg_1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Front_Right_Leg_1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Back_Right_Leg_1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Back_Left_Leg_1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        if(!entity.isOnGround()) 
        {
            this.Left_Wing_Membrane_1.zRot = ageInTicks;
            this.Right_Wing_Membrane_1.zRot = -ageInTicks;
        }
        else 
        {
            this.Left_Wing_Membrane_1.zRot = 0.0F;
            this.Right_Wing_Membrane_1.zRot = 0.0F;
        }

        this.Rear.xRot = -6.0F - Math.abs((float)Math.sin((double)this.floatingRotation) * 0.5F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Right_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing_Membrane_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Upper_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Right_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing_Membrane_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Left_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Left_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}