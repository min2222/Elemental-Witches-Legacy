package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntitySwiftEnt;
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

public class ModelSwiftEnt extends EntityModel<EntitySwiftEnt> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "swift_ent"), "main");
	private final ModelPart Right_Shoulder_Muscle_Filling;
	private final ModelPart Right_Claw_Finger_4;
	private final ModelPart Left_Claw_Finger_7;
	private final ModelPart Right_Claw_Finger_3;
	private final ModelPart Left_Claw_Finger_6;
	private final ModelPart Head_Base;
	private final ModelPart Right_Claw_Finger_2;
	private final ModelPart Right_Claw_Finger_1;
	private final ModelPart Left_Claw_Finger_8;
	private final ModelPart Right_Claw_Finger_8;
	private final ModelPart Right_Claw_Finger_7;
	private final ModelPart Right_Claw_Finger_6;
	private final ModelPart Right_Claw_Finger_5;
	private final ModelPart Left_Armpit;
	private final ModelPart Left_Spike_1;
	private final ModelPart Left_Claw_Finger_1;
	private final ModelPart Left_Shoulder_End;
	private final ModelPart Left_Spike_2;
	private final ModelPart Left_Claw_Finger_3;
	private final ModelPart Left_Claw_Finger_2;
	private final ModelPart Left_Claw_Finger_5;
	private final ModelPart Left_Claw_Finger_4;
	private final ModelPart Left_Shoulder_Filling_2;
	private final ModelPart Right_Lower_Arm;
	private final ModelPart Left_Shoulder_Filling_3;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Leg;
	private final ModelPart Left_Chest;
	private final ModelPart Right_Ear;
	private final ModelPart Left_Shoulder_Bottom;
	private final ModelPart Buttocks;
	private final ModelPart Head_Filling_1;
	private final ModelPart Left_Claw_Finger_Helper;
	private final ModelPart Head_Filling_2;
	private final ModelPart Right_Shoulder_Filling_3;
	private final ModelPart Belly_rope;
	private final ModelPart Right_Shoulder_Filling_2;
	private final ModelPart Left_Clavicle;
	private final ModelPart Head_Filling_5;
	private final ModelPart Head_Filling_6;
	private final ModelPart Head_Filling_3;
	private final ModelPart Left_Claw;
	private final ModelPart Head_Filling_4;
	private final ModelPart Right_Spike_2;
	private final ModelPart Right_Shoulder_Top;
	private final ModelPart Left_Shoulder_Filling;
	private final ModelPart Right_Spike_1;
	private final ModelPart Right_Shoulder_End;
	private final ModelPart Left_Shoulder_Top;
	private final ModelPart Left_Shoulder_End_2;
	private final ModelPart Head_Top_Left;
	private final ModelPart Head_Base_Top;
	private final ModelPart Right_Shoulder_Bottom;
	private final ModelPart Right_Claw_Finger_Helper;
	private final ModelPart Right_Shoulder_End_2;
	private final ModelPart Right_Leg;
	private final ModelPart Neck_Begin;
	private final ModelPart Left_Ear;
	private final ModelPart Mouth;
	private final ModelPart Right_Shoulder_Filling;
	private final ModelPart Right_Shoulder_Muscle;
	private final ModelPart Neck;
	private final ModelPart Left_Arm_Lower;
	private final ModelPart Belly;
	private final ModelPart Right_Claw;
	private final ModelPart Right_Armpit;
	private final ModelPart Right_Clavicle;
	private final ModelPart Head_Top_Right;
	private final ModelPart Right_Chest;
	private final ModelPart Base;
	private final ModelPart Left_Arm;
	private final ModelPart Left_Shoulder_Muscle;

	public ModelSwiftEnt(ModelPart root)
	{
		this.Right_Shoulder_Muscle_Filling = root.getChild("Right_Shoulder_Muscle_Filling");
		this.Right_Claw_Finger_4 = root.getChild("Right_Claw_Finger_4");
		this.Left_Claw_Finger_7 = root.getChild("Left_Claw_Finger_7");
		this.Right_Claw_Finger_3 = root.getChild("Right_Claw_Finger_3");
		this.Left_Claw_Finger_6 = root.getChild("Left_Claw_Finger_6");
		this.Head_Base = root.getChild("Head_Base");
		this.Right_Claw_Finger_2 = root.getChild("Right_Claw_Finger_2");
		this.Right_Claw_Finger_1 = root.getChild("Right_Claw_Finger_1");
		this.Left_Claw_Finger_8 = root.getChild("Left_Claw_Finger_8");
		this.Right_Claw_Finger_8 = root.getChild("Right_Claw_Finger_8");
		this.Right_Claw_Finger_7 = root.getChild("Right_Claw_Finger_7");
		this.Right_Claw_Finger_6 = root.getChild("Right_Claw_Finger_6");
		this.Right_Claw_Finger_5 = root.getChild("Right_Claw_Finger_5");
		this.Left_Armpit = root.getChild("Left_Armpit");
		this.Left_Spike_1 = root.getChild("Left_Spike_1");
		this.Left_Claw_Finger_1 = root.getChild("Left_Claw_Finger_1");
		this.Left_Shoulder_End = root.getChild("Left_Shoulder_End");
		this.Left_Spike_2 = root.getChild("Left_Spike_2");
		this.Left_Claw_Finger_3 = root.getChild("Left_Claw_Finger_3");
		this.Left_Claw_Finger_2 = root.getChild("Left_Claw_Finger_2");
		this.Left_Claw_Finger_5 = root.getChild("Left_Claw_Finger_5");
		this.Left_Claw_Finger_4 = root.getChild("Left_Claw_Finger_4");
		this.Left_Shoulder_Filling_2 = root.getChild("Left_Shoulder_Filling_2");
		this.Right_Lower_Arm = root.getChild("Right_Lower_Arm");
		this.Left_Shoulder_Filling_3 = root.getChild("Left_Shoulder_Filling_3");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Leg = root.getChild("Left_Leg");
		this.Left_Chest = root.getChild("Left_Chest");
		this.Right_Ear = root.getChild("Right_Ear");
		this.Left_Shoulder_Bottom = root.getChild("Left_Shoulder_Bottom");
		this.Buttocks = root.getChild("Buttocks");
		this.Head_Filling_1 = root.getChild("Head_Filling_1");
		this.Left_Claw_Finger_Helper = root.getChild("Left_Claw_Finger_Helper");
		this.Head_Filling_2 = root.getChild("Head_Filling_2");
		this.Right_Shoulder_Filling_3 = root.getChild("Right_Shoulder_Filling_3");
		this.Belly_rope = root.getChild("Belly_rope");
		this.Right_Shoulder_Filling_2 = root.getChild("Right_Shoulder_Filling_2");
		this.Left_Clavicle = root.getChild("Left_Clavicle");
		this.Head_Filling_5 = root.getChild("Head_Filling_5");
		this.Head_Filling_6 = root.getChild("Head_Filling_6");
		this.Head_Filling_3 = root.getChild("Head_Filling_3");
		this.Left_Claw = root.getChild("Left_Claw");
		this.Head_Filling_4 = root.getChild("Head_Filling_4");
		this.Right_Spike_2 = root.getChild("Right_Spike_2");
		this.Right_Shoulder_Top = root.getChild("Right_Shoulder_Top");
		this.Left_Shoulder_Filling = root.getChild("Left_Shoulder_Filling");
		this.Right_Spike_1 = root.getChild("Right_Spike_1");
		this.Right_Shoulder_End = root.getChild("Right_Shoulder_End");
		this.Left_Shoulder_Top = root.getChild("Left_Shoulder_Top");
		this.Left_Shoulder_End_2 = root.getChild("Left_Shoulder_End_2");
		this.Head_Top_Left = root.getChild("Head_Top_Left");
		this.Head_Base_Top = root.getChild("Head_Base_Top");
		this.Right_Shoulder_Bottom = root.getChild("Right_Shoulder_Bottom");
		this.Right_Claw_Finger_Helper = root.getChild("Right_Claw_Finger_Helper");
		this.Right_Shoulder_End_2 = root.getChild("Right_Shoulder_End_2");
		this.Right_Leg = root.getChild("Right_Leg");
		this.Neck_Begin = root.getChild("Neck_Begin");
		this.Left_Ear = root.getChild("Left_Ear");
		this.Mouth = root.getChild("Mouth");
		this.Right_Shoulder_Filling = root.getChild("Right_Shoulder_Filling");
		this.Right_Shoulder_Muscle = root.getChild("Right_Shoulder_Muscle");
		this.Neck = root.getChild("Neck");
		this.Left_Arm_Lower = root.getChild("Left_Arm_Lower");
		this.Belly = root.getChild("Belly");
		this.Right_Claw = root.getChild("Right_Claw");
		this.Right_Armpit = root.getChild("Right_Armpit");
		this.Right_Clavicle = root.getChild("Right_Clavicle");
		this.Head_Top_Right = root.getChild("Head_Top_Right");
		this.Right_Chest = root.getChild("Right_Chest");
		this.Base = root.getChild("Base");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Left_Shoulder_Muscle = root.getChild("Left_Shoulder_Muscle");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Right_Shoulder_Muscle_Filling", CubeListBuilder.create().texOffs(84, 42).addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -4.0F, -3.5F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_4", CubeListBuilder.create().texOffs(40, 78).addBox(1.4F, 13.3F, 2.1F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_7", CubeListBuilder.create().texOffs(155, 1).addBox(4.9F, 12.0F, 0.3F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.1222F, 0.0F, 0.384F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_3", CubeListBuilder.create().texOffs(40, 65).addBox(1.4F, 13.3F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_6", CubeListBuilder.create().texOffs(150, 1).addBox(0.1F, 13.4F, 0.3F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head_Base", CubeListBuilder.create().texOffs(132, 16).addBox(0.0F, 0.0F, 0.0F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -10.6F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_2", CubeListBuilder.create().texOffs(23, 106).addBox(2.8F, 13.5F, 0.3F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_1", CubeListBuilder.create().texOffs(8, 43).addBox(1.0F, 14.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.1222F, 0.0F, -0.192F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_8", CubeListBuilder.create().texOffs(160, 0).addBox(5.0F, 11.8F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.0F, 0.0F, 0.384F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_8", CubeListBuilder.create().texOffs(28, 68).addBox(0.1F, 13.3F, 3.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_7", CubeListBuilder.create().texOffs(33, 100).addBox(0.1F, 13.5F, 0.4F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_6", CubeListBuilder.create().texOffs(100, 66).addBox(1.0F, 13.8F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.0F, 0.0F, -0.192F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_5", CubeListBuilder.create(), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Armpit", CubeListBuilder.create().texOffs(31, 5).addBox(0.0F, 0.0F, 0.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.6632F));

		partdefinition.addOrReplaceChild("Left_Spike_1", CubeListBuilder.create().texOffs(0, 33).addBox(10.5F, 10.5F, 1.5F, 1.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.0524F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_1", CubeListBuilder.create().texOffs(8, 35).addBox(2.5333F, 13.4F, 0.3F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Shoulder_End", CubeListBuilder.create().texOffs(0, 65).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -4.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("Left_Spike_2", CubeListBuilder.create().texOffs(0, 88).addBox(12.3F, 9.5F, 1.0F, 1.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.1222F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_3", CubeListBuilder.create().texOffs(133, 0).addBox(1.3F, 13.3F, -0.1F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_2", CubeListBuilder.create().texOffs(40, 91).addBox(2.5F, 13.0F, 3.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_5", CubeListBuilder.create(), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_4", CubeListBuilder.create().texOffs(140, 0).addBox(1.3F, 13.0F, 2.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Filling_2", CubeListBuilder.create().texOffs(102, 42).addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.6F, -4.0F, -3.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Right_Lower_Arm", CubeListBuilder.create().texOffs(89, 5).addBox(0.5F, 7.0F, 0.6F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Filling_3", CubeListBuilder.create().texOffs(77, 9).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6F, -4.0F, -3.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(11, 89).addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(12, 42).addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("Left_Chest", CubeListBuilder.create().texOffs(50, 19).addBox(0.0F, 0.0F, 0.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.3316F));

		partdefinition.addOrReplaceChild("Right_Ear", CubeListBuilder.create().texOffs(13, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -4.0F, -10.5F, 0.0F, 0.0F, 0.2007F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Bottom", CubeListBuilder.create().texOffs(100, 30).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.8F, -4.0F, -3.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Buttocks", CubeListBuilder.create().texOffs(49, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -4.0F));

		partdefinition.addOrReplaceChild("Head_Filling_1", CubeListBuilder.create().texOffs(127, 52).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Left_Claw_Finger_Helper", CubeListBuilder.create().texOffs(71, 0).addBox(3.5F, 11.5F, 0.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -3.5F, 0.0F, 0.0F, 0.3025F));

		partdefinition.addOrReplaceChild("Head_Filling_2", CubeListBuilder.create().texOffs(130, 31).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Filling_3", CubeListBuilder.create().texOffs(77, 18).addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9F, -4.0F, -3.5F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Belly_rope", CubeListBuilder.create().texOffs(0, 70).addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Filling_2", CubeListBuilder.create().texOffs(72, 29).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Left_Clavicle", CubeListBuilder.create().texOffs(49, 8).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Head_Filling_5", CubeListBuilder.create().texOffs(140, 50).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Head_Filling_6", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Head_Filling_3", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Left_Claw", CubeListBuilder.create().texOffs(50, 94).addBox(0.0F, 12.0F, 0.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Head_Filling_4", CubeListBuilder.create().texOffs(140, 29).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Right_Spike_2", CubeListBuilder.create().texOffs(0, 107).addBox(-9.3F, 12.0F, 1.0F, 1.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.1222F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Top", CubeListBuilder.create().texOffs(0, 50).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -4.0F, -3.5F, 0.0F, 0.0F, -1.2741F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Filling", CubeListBuilder.create().texOffs(32, 26).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.6F, -4.0F, -3.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Right_Spike_1", CubeListBuilder.create().texOffs(23, 2).addBox(-7.6F, 12.0F, 1.5F, 1.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.0698F));

		partdefinition.addOrReplaceChild("Right_Shoulder_End", CubeListBuilder.create().texOffs(44, 33).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -4.0F, 0.4F, -0.9076F, 0.0F, -0.4189F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Top", CubeListBuilder.create().texOffs(72, 40).addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.8F, -4.0F, -3.5F, 0.0F, 0.0F, 1.2915F));

		partdefinition.addOrReplaceChild("Left_Shoulder_End_2", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -4.0F, 0.5F, -0.9599F, 0.0F, 0.4189F));

		partdefinition.addOrReplaceChild("Head_Top_Left", CubeListBuilder.create().texOffs(150, 13).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -4.0F, -10.5F, 0.0F, 0.0F, -0.1658F));

		partdefinition.addOrReplaceChild("Head_Base_Top", CubeListBuilder.create().texOffs(120, 67).addBox(0.0F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.0F, -10.5F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Bottom", CubeListBuilder.create().texOffs(88, 30).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -4.0F, -3.5F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Right_Claw_Finger_Helper", CubeListBuilder.create().texOffs(12, 105).addBox(-5.0F, 12.0F, 0.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -3.5F, 0.0F, 0.0F, -0.6458F));

		partdefinition.addOrReplaceChild("Right_Shoulder_End_2", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -4.0F, 0.4F, 0.0F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(110, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("Neck_Begin", CubeListBuilder.create().texOffs(50, 66).addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Left_Ear", CubeListBuilder.create().texOffs(120, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -4.0F, -10.5F, 0.0F, 0.0F, -0.2356F));

		partdefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(32, 55).addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -10.5F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Filling", CubeListBuilder.create().texOffs(32, 33).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9F, -4.0F, -3.5F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Right_Shoulder_Muscle", CubeListBuilder.create().texOffs(78, 53).addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(184, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -8.3F, 0.2793F, -0.192F, 0.7854F));

		partdefinition.addOrReplaceChild("Left_Arm_Lower", CubeListBuilder.create().texOffs(50, 81).addBox(0.5F, 7.0F, 0.6F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 80).addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -4.0F));

		partdefinition.addOrReplaceChild("Right_Claw", CubeListBuilder.create().texOffs(166, 0).addBox(0.0F, 12.0F, 0.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Right_Armpit", CubeListBuilder.create().texOffs(32, 40).addBox(0.0F, 0.0F, 0.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.6981F));

		partdefinition.addOrReplaceChild("Right_Clavicle", CubeListBuilder.create().texOffs(50, 53).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.0F, -4.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Head_Top_Right", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -4.0F, -10.5F, 0.0F, 0.0F, 0.1658F));

		partdefinition.addOrReplaceChild("Right_Chest", CubeListBuilder.create().texOffs(50, 36).addBox(0.0F, 0.0F, 0.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1F, -4.0F, -4.1F, 0.0F, 0.0F, -0.3316F));

		partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(12, 20).addBox(0.0F, 0.0F, 0.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -4.0F));

		partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(91, 16).addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -4.0F, -3.5F));

		partdefinition.addOrReplaceChild("Left_Shoulder_Muscle", CubeListBuilder.create().texOffs(100, 53).addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(EntitySwiftEnt entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Right_Shoulder_Top.yRot = entity.getFloatingRotation();
        this.Left_Spike_1.yRot = entity.getFloatingRotation();
        this.Left_Leg.yRot = entity.getFloatingRotation();
        this.Base.yRot = entity.getFloatingRotation();
        this.Mouth.yRot = entity.getFloatingRotation();
        this.Right_Armpit.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Filling.yRot = entity.getFloatingRotation();
        this.Right_Clavicle.yRot = entity.getFloatingRotation();
        this.Right_Chest.yRot = entity.getFloatingRotation();
        this.Left_Chest.yRot = entity.getFloatingRotation();
        this.Left_Clavicle.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Filling.yRot = entity.getFloatingRotation();
        this.Left_Armpit.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Top.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_End.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Muscle.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Muscle_Filling.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Filling_2.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Filling_3.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_Bottom.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Muscle.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Filling_2.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Filling_3.yRot = entity.getFloatingRotation();
        this.Buttocks.yRot = entity.getFloatingRotation();
        this.Left_Arm.yRot = entity.getFloatingRotation();
        this.Right_Lower_Arm.yRot = entity.getFloatingRotation();
        this.Right_Spike_1.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_1.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_Helper.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_1.yRot = entity.getFloatingRotation();
        this.Right_Shoulder_End_2.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_End_2.yRot = entity.getFloatingRotation();
        this.Right_Leg.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_End.yRot = entity.getFloatingRotation();
        this.Belly_rope.yRot = entity.getFloatingRotation();
        this.Belly.yRot = entity.getFloatingRotation();
        this.Left_Spike_2.yRot = entity.getFloatingRotation();
        this.Right_Spike_2.yRot = entity.getFloatingRotation();
        this.Right_Arm.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_Helper.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_2.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_3.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_4.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_2.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_5.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_6.yRot = entity.getFloatingRotation();
        this.Neck_Begin.yRot = entity.getFloatingRotation();
        this.Left_Arm_Lower.yRot = entity.getFloatingRotation();
        this.Left_Claw.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_7.yRot = entity.getFloatingRotation();
        this.Right_Claw_Finger_8.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_3.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_4.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_5.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_6.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_7.yRot = entity.getFloatingRotation();
        this.Left_Claw_Finger_8.yRot = entity.getFloatingRotation();
        this.Right_Claw.yRot = entity.getFloatingRotation();
        this.Neck.yRot = entity.getFloatingRotation();
        this.Left_Ear.yRot = entity.getFloatingRotation();
        this.Head_Filling_1.yRot = entity.getFloatingRotation();
        this.Head_Top_Left.yRot = entity.getFloatingRotation();
        this.Head_Base.yRot = entity.getFloatingRotation();
        this.Head_Base_Top.yRot = entity.getFloatingRotation();
        this.Right_Ear.yRot = entity.getFloatingRotation();
        this.Head_Top_Right.yRot = entity.getFloatingRotation();
        this.Head_Filling_2.yRot = entity.getFloatingRotation();
        this.Head_Filling_3.yRot = entity.getFloatingRotation();
        this.Head_Filling_4.yRot = entity.getFloatingRotation();
        this.Head_Filling_5.yRot = entity.getFloatingRotation();
        this.Head_Filling_6.yRot = entity.getFloatingRotation();
        this.Left_Shoulder_Bottom.yRot = entity.getFloatingRotation();
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Right_Shoulder_Muscle_Filling.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armpit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Spike_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_End.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Spike_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Filling_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Lower_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Filling_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Ear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Buttocks.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw_Finger_Helper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Filling_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Belly_rope.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Filling_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Clavicle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Claw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Filling_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Spike_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Filling.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Spike_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_End.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_End_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Top_Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Base_Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw_Finger_Helper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_End_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck_Begin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Ear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Mouth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Filling.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_Muscle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm_Lower.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Claw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armpit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Clavicle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_Top_Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_Muscle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}