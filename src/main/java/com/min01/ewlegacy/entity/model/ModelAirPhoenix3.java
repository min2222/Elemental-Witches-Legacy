package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix3;
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

public class ModelAirPhoenix3 extends EntityModel<EntityAirPhoenix3> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "air_phoenix3"), "main");
	private final ModelPart Torso;
	private final ModelPart BottomRightTailFeather;
	private final ModelPart MiddleRightTailFeather;
	private final ModelPart Torso2;
	private final ModelPart LeftWing;
	private final ModelPart TopTailFeather;
	private final ModelPart Butt;
	private final ModelPart BottomLeftTailFeather;
	private final ModelPart RightHip;
	private final ModelPart TopRightTailFeather;
	private final ModelPart RightTail1;
	private final ModelPart RightTail2;
	private final ModelPart RightTail3;
	private final ModelPart TopLeftTailFeather;
	private final ModelPart NeckRing1;
	private final ModelPart NeckRing2;
	private final ModelPart RightWing;
	private final ModelPart NeckRing_3;
	private final ModelPart LeftTail1;
	private final ModelPart LeftTail2;
	private final ModelPart Neck;
	private final ModelPart LeftTail3;
	private final ModelPart BackFeather2;
	private final ModelPart BackFeather3;
	private final ModelPart BackFeather1;
	private final ModelPart Torso3;
	private final ModelPart LeftHip;
	private final ModelPart MiddleLeftTailFeather;
	private final ModelPart Skull;

	public ModelAirPhoenix3(ModelPart root)
	{
		this.Torso = root.getChild("Torso");
		this.BottomRightTailFeather = root.getChild("BottomRightTailFeather");
		this.MiddleRightTailFeather = root.getChild("MiddleRightTailFeather");
		this.Torso2 = root.getChild("Torso2");
		this.LeftWing = root.getChild("LeftWing");
		this.TopTailFeather = root.getChild("TopTailFeather");
		this.Butt = root.getChild("Butt");
		this.BottomLeftTailFeather = root.getChild("BottomLeftTailFeather");
		this.RightHip = root.getChild("RightHip");
		this.TopRightTailFeather = root.getChild("TopRightTailFeather");
		this.RightTail1 = root.getChild("RightTail1");
		this.RightTail2 = root.getChild("RightTail2");
		this.RightTail3 = root.getChild("RightTail3");
		this.TopLeftTailFeather = root.getChild("TopLeftTailFeather");
		this.NeckRing1 = root.getChild("NeckRing1");
		this.NeckRing2 = root.getChild("NeckRing2");
		this.RightWing = root.getChild("RightWing");
		this.NeckRing_3 = root.getChild("NeckRing_3");
		this.LeftTail1 = root.getChild("LeftTail1");
		this.LeftTail2 = root.getChild("LeftTail2");
		this.Neck = root.getChild("Neck");
		this.LeftTail3 = root.getChild("LeftTail3");
		this.BackFeather2 = root.getChild("BackFeather2");
		this.BackFeather3 = root.getChild("BackFeather3");
		this.BackFeather1 = root.getChild("BackFeather1");
		this.Torso3 = root.getChild("Torso3");
		this.LeftHip = root.getChild("LeftHip");
		this.MiddleLeftTailFeather = root.getChild("MiddleLeftTailFeather");
		this.Skull = root.getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.925F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BottomRightTailFeather", CubeListBuilder.create().texOffs(88, 87).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 8.0F, 8.0F, 0.2793F, -0.2793F, 0.0F));

		partdefinition.addOrReplaceChild("MiddleRightTailFeather", CubeListBuilder.create().texOffs(78, 21).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 6.0F, 7.0F, 0.4712F, 0.0F, -0.7854F));

		partdefinition.addOrReplaceChild("Torso2", CubeListBuilder.create().texOffs(0, 64).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -7.0F, -1.1345F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(31, 124).addBox(0.0F, -2.0F, -2.0F, 1.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -2.0F, -8.0F, -0.2094F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("TopTailFeather", CubeListBuilder.create().texOffs(77, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 8.0F, 0.4538F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Butt", CubeListBuilder.create().texOffs(0, 18).addBox(-4.5F, 1.0F, -2.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 3.0F));

		partdefinition.addOrReplaceChild("BottomLeftTailFeather", CubeListBuilder.create().texOffs(88, 105).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 8.0F, 8.0F, 0.2793F, 0.2793F, 0.0F));

		PartDefinition RightHip = partdefinition.addOrReplaceChild("RightHip", CubeListBuilder.create().texOffs(124, 27).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 9.0F, 1.0F));

		RightHip.addOrReplaceChild("RightHipChild_1", CubeListBuilder.create().texOffs(147, 5).addBox(-1.0F, 5.0F, 4.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4887F, 0.0F, 0.0F));

		RightHip.addOrReplaceChild("RightHipChild_2", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2793F, 0.0F));

		RightHip.addOrReplaceChild("RightHipChild", CubeListBuilder.create().texOffs(17, 7).addBox(-1.0F, 3.0F, -2.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3665F, 0.0F, 0.0F));

		RightHip.addOrReplaceChild("RightHipChild_4", CubeListBuilder.create().texOffs(161, 20).addBox(-1.0F, 13.0F, -2.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		RightHip.addOrReplaceChild("RightHipChild_3", CubeListBuilder.create().texOffs(121, 39).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2793F, 0.0F));

		partdefinition.addOrReplaceChild("TopRightTailFeather", CubeListBuilder.create().texOffs(83, 59).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 4.0F, 8.0F, 0.4189F, 0.0F, -0.4189F));

		partdefinition.addOrReplaceChild("RightTail1", CubeListBuilder.create().texOffs(0, 175).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("RightTail2", CubeListBuilder.create().texOffs(0, 175).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("RightTail3", CubeListBuilder.create().texOffs(0, 175).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, 0.8727F));

		partdefinition.addOrReplaceChild("TopLeftTailFeather", CubeListBuilder.create().texOffs(84, 73).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 8.0F, 0.4189F, 0.0F, 0.4189F));

		partdefinition.addOrReplaceChild("NeckRing1", CubeListBuilder.create().texOffs(0, 220).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		partdefinition.addOrReplaceChild("NeckRing2", CubeListBuilder.create().texOffs(0, 227).addBox(-3.5F, -5.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(31, 86).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, -8.0F, -0.2094F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("NeckRing_3", CubeListBuilder.create().texOffs(0, 235).addBox(-4.0F, -4.1F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		partdefinition.addOrReplaceChild("LeftTail1", CubeListBuilder.create().texOffs(0, 145).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("LeftTail2", CubeListBuilder.create().texOffs(0, 145).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, -0.6109F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 93).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -9.5F, -0.2793F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftTail3", CubeListBuilder.create().texOffs(0, 145).addBox(0.0F, 0.0F, -13.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 9.0F, 9.0F, 0.3491F, 0.0F, -0.8727F));

		partdefinition.addOrReplaceChild("BackFeather2", CubeListBuilder.create().texOffs(0, 210).addBox(-3.0F, -3.0F, 3.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackFeather3", CubeListBuilder.create().texOffs(0, 215).addBox(-4.0F, 0.0F, 6.5F, 8.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.2094F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackFeather1", CubeListBuilder.create().texOffs(0, 205).addBox(-2.0F, -6.0F, 2.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.4887F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Torso3", CubeListBuilder.create().texOffs(0, 81).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		PartDefinition LeftHip = partdefinition.addOrReplaceChild("LeftHip", CubeListBuilder.create().texOffs(123, 15).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 9.0F, 1.0F));

		LeftHip.addOrReplaceChild("LeftHipChild_1", CubeListBuilder.create().texOffs(147, 20).addBox(-1.0F, 5.0F, 4.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4887F, 0.0F, 0.0F));

		LeftHip.addOrReplaceChild("LeftHipChild_2", CubeListBuilder.create().texOffs(160, 3).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2793F, 0.0F));

		LeftHip.addOrReplaceChild("LeftHipChild_3", CubeListBuilder.create().texOffs(119, 49).addBox(-1.0F, 13.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2793F, 0.0F));

		LeftHip.addOrReplaceChild("LeftHipChild_4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 13.0F, -2.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		LeftHip.addOrReplaceChild("LeftHipChild", CubeListBuilder.create().texOffs(38, 23).addBox(-1.0F, 3.0F, -2.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3665F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("MiddleLeftTailFeather", CubeListBuilder.create().texOffs(78, 40).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.0F, 7.0F, 0.4712F, 0.0F, 0.7854F));

		PartDefinition Skull = partdefinition.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 118).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, -7.0F));

		Skull.addOrReplaceChild("SkullChild_12", CubeListBuilder.create().texOffs(180, 0).addBox(0.0F, -11.0F, -2.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Skull.addOrReplaceChild("SkullChild", CubeListBuilder.create().texOffs(0, 134).addBox(-2.0F, -1.0F, -8.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.8203F, 0.0F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_5", CubeListBuilder.create().texOffs(58, 51).addBox(-3.0F, -7.0F, 2.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_8", CubeListBuilder.create().texOffs(46, 68).addBox(-3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4538F, -0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_1", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -4.5F, -12.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_6", CubeListBuilder.create().texOffs(44, 60).addBox(-3.0F, -4.0F, 1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_9", CubeListBuilder.create().texOffs(59, 70).addBox(2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4538F, 0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_10", CubeListBuilder.create().texOffs(122, 2).addBox(0.5F, -3.5F, -10.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1222F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_11", CubeListBuilder.create().texOffs(28, -1).addBox(-2.5F, -3.5F, -10.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1222F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_4", CubeListBuilder.create().texOffs(44, 50).addBox(2.0F, -7.0F, 2.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_7", CubeListBuilder.create().texOffs(58, 61).addBox(2.0F, -4.0F, 1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.192F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_2", CubeListBuilder.create().texOffs(70, 0).addBox(-0.5F, -0.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2793F, 0.0F, 0.0F));

		Skull.addOrReplaceChild("SkullChild_3", CubeListBuilder.create().texOffs(50, 14).addBox(-0.5F, -2.0F, -11.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityAirPhoenix3 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Skull.xRot = headPitch / 57.295776F;
        this.Skull.yRot = netHeadYaw / 57.295776F;
        this.RightHip.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LeftHip.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        if(!entity.isOnGround()) 
        {
            this.LeftWing.zRot = ageInTicks;
            this.RightWing.zRot = -ageInTicks;
        } 
        else 
        {
            this.LeftWing.zRot = 0.0F;
            this.RightWing.zRot = 0.0F;
        }
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BottomRightTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MiddleRightTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TopTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Butt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BottomLeftTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightHip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TopRightTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightTail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightTail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightTail3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TopLeftTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NeckRing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NeckRing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		NeckRing_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftTail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftTail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftTail3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFeather2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFeather3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFeather1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MiddleLeftTailFeather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}