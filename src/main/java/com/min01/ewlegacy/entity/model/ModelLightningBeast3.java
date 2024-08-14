package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast3;
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

public class ModelLightningBeast3 extends EntityModel<EntityLightningBeast3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "lightning_beast3"), "main");
    public float floatingRotation;
	private final ModelPart Chest;
	private final ModelPart Back_Right_Leg_1;
	private final ModelPart Right_Wing_Membrane_2;
	private final ModelPart Upper_Torso;
	private final ModelPart Head;
	private final ModelPart Lower_Torso;
	private final ModelPart Front_Right_Leg_1;
	private final ModelPart Left_Wing_Membrane_2;
	private final ModelPart Front_Left_Leg_1;
	private final ModelPart Neck;
	private final ModelPart Rear;
	private final ModelPart Back_Left_Leg_1;

	public ModelLightningBeast3(ModelPart root)
	{
		this.Chest = root.getChild("Chest");
		this.Back_Right_Leg_1 = root.getChild("Back_Right_Leg_1");
		this.Right_Wing_Membrane_2 = root.getChild("Right_Wing_Membrane_2");
		this.Upper_Torso = root.getChild("Upper_Torso");
		this.Head = root.getChild("Head");
		this.Lower_Torso = root.getChild("Lower_Torso");
		this.Front_Right_Leg_1 = root.getChild("Front_Right_Leg_1");
		this.Left_Wing_Membrane_2 = root.getChild("Left_Wing_Membrane_2");
		this.Front_Left_Leg_1 = root.getChild("Front_Left_Leg_1");
		this.Neck = root.getChild("Neck");
		this.Rear = root.getChild("Rear");
		this.Back_Left_Leg_1 = root.getChild("Back_Left_Leg_1");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(223, 190).addBox(-8.0F, 2.0F, -5.0F, 16.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Back_Right_Leg_1 = partdefinition.addOrReplaceChild("Back_Right_Leg_1", CubeListBuilder.create().texOffs(38, 209).addBox(-7.0F, -2.0F, -3.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 7.0F, 25.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_3", CubeListBuilder.create().texOffs(66, 244).addBox(-4.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_2", CubeListBuilder.create().texOffs(66, 250).addBox(-7.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_4", CubeListBuilder.create().texOffs(66, 238).addBox(-1.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child", CubeListBuilder.create().texOffs(38, 224).addBox(-7.0F, 1.0F, 1.0F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Back_Right_Leg_1.addOrReplaceChild("Back_Right_Leg_1Child_1", CubeListBuilder.create().texOffs(38, 245).addBox(-7.0F, 13.0F, -4.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Right_Wing_Membrane_2 = partdefinition.addOrReplaceChild("Right_Wing_Membrane_2", CubeListBuilder.create().texOffs(365, 216).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.0F, 7.0F, 0.0F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_3", CubeListBuilder.create().texOffs(386, 226).addBox(0.5F, -10.0F, 2.0F, 0.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_1", CubeListBuilder.create().texOffs(400, 225).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_6", CubeListBuilder.create().texOffs(468, 232).addBox(0.5F, -36.0F, -15.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4486F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_5", CubeListBuilder.create().texOffs(448, 234).addBox(0.5F, -29.0F, 6.0F, 0.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_4", CubeListBuilder.create().texOffs(420, 229).addBox(0.5F, 10.0F, 2.0F, 0.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0821F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child_2", CubeListBuilder.create().texOffs(324, 211).addBox(0.5F, 1.0F, 0.0F, 0.0F, 6.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6632F, -0.5236F, 0.0F));

		Right_Wing_Membrane_2.addOrReplaceChild("Right_Wing_Membrane_2Child", CubeListBuilder.create().texOffs(324, 208).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6632F, -0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Upper_Torso", CubeListBuilder.create().texOffs(147, 170).addBox(-9.0F, 0.0F, 0.0F, 18.0F, 18.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(229, 156).addBox(-6.0F, -12.0F, -9.0F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(263, 137).addBox(-1.5F, -24.0F, 6.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(296, 180).addBox(-2.0F, -11.0F, -11.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_20", CubeListBuilder.create().texOffs(181, 145).addBox(3.0F, -7.0F, -4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(205, 109).addBox(-6.0F, -8.0F, 5.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4538F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(239, 143).addBox(-1.0F, -17.0F, -8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4712F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(265, 131).addBox(-1.0F, -28.0F, 6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_15", CubeListBuilder.create().texOffs(256, 178).addBox(-9.0F, -1.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(273, 160).addBox(-4.0F, -13.0F, -15.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_27", CubeListBuilder.create().texOffs(100, 161).addBox(-4.0F, -6.0F, 8.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.384F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_19", CubeListBuilder.create().texOffs(181, 133).addBox(3.0F, -8.0F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_24", CubeListBuilder.create().texOffs(147, 142).addBox(-6.0F, -10.0F, -9.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -1.1868F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_17", CubeListBuilder.create().texOffs(181, 109).addBox(3.0F, -8.0F, 5.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4538F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(205, 145).addBox(-6.0F, -7.0F, -4.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_18", CubeListBuilder.create().texOffs(181, 121).addBox(3.0F, -8.0F, 2.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(229, 149).addBox(-3.0F, -14.0F, 5.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5061F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_25", CubeListBuilder.create().texOffs(123, 142).addBox(-4.0F, -13.0F, -6.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -1.1868F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_28", CubeListBuilder.create().texOffs(99, 156).addBox(-4.0F, -11.0F, 8.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.7156F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(205, 97).addBox(-6.0F, -8.0F, 8.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_29", CubeListBuilder.create().texOffs(78, 158).addBox(-4.0F, -9.0F, 11.0F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.5411F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_14", CubeListBuilder.create().texOffs(207, 157).addBox(-6.0F, -4.0F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_26", CubeListBuilder.create().texOffs(119, 153).addBox(-4.0F, -12.0F, 2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.925F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_23", CubeListBuilder.create().texOffs(132, 150).addBox(-6.5F, -11.0F, -2.5F, 13.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.384F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(247, 148).addBox(-3.0F, -15.0F, 0.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3665F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(273, 180).addBox(-2.0F, -9.0F, -8.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_22", CubeListBuilder.create().texOffs(240, 178).addBox(6.0F, -1.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(205, 133).addBox(-6.0F, -8.0F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(205, 121).addBox(-6.0F, -8.0F, 2.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_21", CubeListBuilder.create().texOffs(183, 157).addBox(3.0F, -4.0F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_16", CubeListBuilder.create().texOffs(181, 97).addBox(3.0F, -8.0F, 8.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(249, 140).addBox(-1.0F, -20.0F, 3.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3316F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Torso", CubeListBuilder.create().texOffs(83, 173).addBox(-8.0F, 2.5F, 18.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Front_Right_Leg_1 = partdefinition.addOrReplaceChild("Front_Right_Leg_1", CubeListBuilder.create().texOffs(114, 205).addBox(-7.0F, -1.0F, -3.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 3.0F, 4.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_3", CubeListBuilder.create().texOffs(142, 244).addBox(-4.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_4", CubeListBuilder.create().texOffs(142, 238).addBox(-1.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child", CubeListBuilder.create().texOffs(114, 222).addBox(-7.0F, 2.0F, 4.0F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_1", CubeListBuilder.create().texOffs(114, 245).addBox(-7.0F, 17.0F, -6.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Leg_1.addOrReplaceChild("Front_Right_Leg_1Child_2", CubeListBuilder.create().texOffs(142, 250).addBox(-7.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Left_Wing_Membrane_2 = partdefinition.addOrReplaceChild("Left_Wing_Membrane_2", CubeListBuilder.create().texOffs(193, 216).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, 7.0F, 0.0F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_4", CubeListBuilder.create().texOffs(248, 229).addBox(-0.5F, 10.0F, 2.0F, 0.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0821F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_2", CubeListBuilder.create().texOffs(228, 225).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child", CubeListBuilder.create().texOffs(214, 226).addBox(-0.5F, -10.0F, 2.0F, 0.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_1", CubeListBuilder.create().texOffs(152, 208).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6632F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_3", CubeListBuilder.create().texOffs(152, 211).addBox(-0.5F, 1.0F, 0.0F, 0.0F, 6.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6632F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_5", CubeListBuilder.create().texOffs(276, 234).addBox(-0.5F, -29.0F, 6.0F, 0.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8901F, 0.5236F, 0.0F));

		Left_Wing_Membrane_2.addOrReplaceChild("Left_Wing_Membrane_2Child_6", CubeListBuilder.create().texOffs(296, 232).addBox(-0.5F, -36.0F, -15.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4486F, 0.5236F, 0.0F));

		PartDefinition Front_Left_Leg_1 = partdefinition.addOrReplaceChild("Front_Left_Leg_1", CubeListBuilder.create().texOffs(76, 205).addBox(0.0F, -1.0F, -3.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 3.0F, 4.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_1", CubeListBuilder.create().texOffs(76, 245).addBox(0.0F, 17.0F, -6.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_2", CubeListBuilder.create().texOffs(104, 238).addBox(6.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_3", CubeListBuilder.create().texOffs(104, 244).addBox(3.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child", CubeListBuilder.create().texOffs(76, 222).addBox(0.0F, 2.0F, 4.0F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		Front_Left_Leg_1.addOrReplaceChild("Front_Left_Leg_1Child_4", CubeListBuilder.create().texOffs(104, 250).addBox(0.0F, 19.0F, -10.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(203, 168).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.733F, 0.0F, 0.0F));

		PartDefinition Rear = partdefinition.addOrReplaceChild("Rear", CubeListBuilder.create().texOffs(49, 192).addBox(-5.0F, -6.0F, -3.0F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 34.0F, -7.008F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_5", CubeListBuilder.create().texOffs(88, 146).addBox(-2.0F, -24.0F, -17.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild", CubeListBuilder.create().texOffs(24, 183).addBox(-3.0F, -1.0F, 1.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_3", CubeListBuilder.create().texOffs(44, 157).addBox(-5.0F, 9.0F, 12.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_4", CubeListBuilder.create().texOffs(64, 145).addBox(-3.0F, -25.0F, -11.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_2", CubeListBuilder.create().texOffs(22, 167).addBox(-3.0F, 12.5F, 4.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4435F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_6", CubeListBuilder.create().texOffs(108, 150).addBox(-1.0F, -23.0F, -19.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Rear.addOrReplaceChild("RearChild_1", CubeListBuilder.create().texOffs(0, 177).addBox(-3.0F, 5.0F, 5.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		PartDefinition Back_Left_Leg_1 = partdefinition.addOrReplaceChild("Back_Left_Leg_1", CubeListBuilder.create().texOffs(0, 209).addBox(0.0F, -2.0F, -3.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 7.0F, 25.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_2", CubeListBuilder.create().texOffs(28, 238).addBox(6.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_4", CubeListBuilder.create().texOffs(28, 250).addBox(0.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_1", CubeListBuilder.create().texOffs(0, 245).addBox(0.0F, 13.0F, -4.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child", CubeListBuilder.create().texOffs(0, 224).addBox(0.0F, 1.0F, 1.0F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Back_Left_Leg_1.addOrReplaceChild("Back_Left_Leg_1Child_3", CubeListBuilder.create().texOffs(28, 244).addBox(3.0F, 15.0F, -8.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityLightningBeast3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
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
            this.Left_Wing_Membrane_2.zRot = ageInTicks;
            this.Right_Wing_Membrane_2.zRot = -ageInTicks;
        }
        else 
        {
            this.Left_Wing_Membrane_2.zRot = 0.0F;
            this.Right_Wing_Membrane_2.zRot = 0.0F;
        }

        this.Rear.xRot = -7.0F - Math.abs((float)Math.sin((double)this.floatingRotation) * 0.2F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Right_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing_Membrane_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Upper_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Right_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing_Membrane_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Left_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Left_Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}