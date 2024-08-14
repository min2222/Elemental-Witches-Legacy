package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightAngel2;
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

public class ModelLightAngel2 extends EntityModel<EntityLightAngel2> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "light_angel2"), "main");
	private final ModelPart Torso;
	private final ModelPart Left_Cloud_1;
	private final ModelPart Skirt_4;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Cloud_2;
	private final ModelPart Skirt_1;
	private final ModelPart Skirt_2;
	private final ModelPart Skirt_3;
	private final ModelPart Head;
	private final ModelPart Right_Cloud_1;
	private final ModelPart Right_Cloud_2;
	private final ModelPart Left_Arm;
	private final ModelPart Tail_5;
	private final ModelPart Tail_4;
	private final ModelPart Tail_3;
	private final ModelPart Tail_2;
	private final ModelPart Tail_1;

	public ModelLightAngel2(ModelPart root) 
	{
		this.Torso = root.getChild("Torso");
		this.Left_Cloud_1 = root.getChild("Left_Cloud_1");
		this.Skirt_4 = root.getChild("Skirt_4");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Cloud_2 = root.getChild("Left_Cloud_2");
		this.Skirt_1 = root.getChild("Skirt_1");
		this.Skirt_2 = root.getChild("Skirt_2");
		this.Skirt_3 = root.getChild("Skirt_3");
		this.Head = root.getChild("Head");
		this.Right_Cloud_1 = root.getChild("Right_Cloud_1");
		this.Right_Cloud_2 = root.getChild("Right_Cloud_2");
		this.Left_Arm = root.getChild("Left_Arm");
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

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(110, 73).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Cloud_1", CubeListBuilder.create().texOffs(150, 76).addBox(0.0F, 0.0F, 3.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Skirt_4", CubeListBuilder.create().texOffs(102, 112).addBox(-6.0F, 9.0F, -5.0F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(98, 76).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("Left_Cloud_2", CubeListBuilder.create().texOffs(150, 84).addBox(11.0F, 0.0F, -3.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0698F, 0.3491F, 0.2618F));

		partdefinition.addOrReplaceChild("Skirt_1", CubeListBuilder.create().texOffs(108, 85).addBox(-4.5F, 6.0F, -3.5F, 9.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_2", CubeListBuilder.create().texOffs(106, 93).addBox(-5.0F, 7.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_3", CubeListBuilder.create().texOffs(104, 102).addBox(-5.5F, 8.0F, -4.5F, 11.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(98, 52).addBox(-7.0F, -9.0F, -6.0F, 14.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(70, 34).addBox(-4.5F, -10.0F, 6.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_14", CubeListBuilder.create().texOffs(66, 34).addBox(-5.5F, -11.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(102, 10).addBox(-6.0F, -15.0F, -5.0F, 12.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_19", CubeListBuilder.create().texOffs(146, 10).addBox(3.5F, -9.0F, 7.5F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(182, 52).addBox(6.5F, -8.0F, 0.5F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(170, 52).addBox(6.5F, -8.0F, -2.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_15", CubeListBuilder.create().texOffs(119, 6).addBox(-2.0F, -12.0F, 7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(94, 34).addBox(-8.0F, -13.0F, -7.0F, 16.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_17", CubeListBuilder.create().texOffs(94, 10).addBox(-6.5F, -9.0F, 7.5F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(77, 39).addBox(-8.5F, -10.0F, -6.5F, 2.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(98, 21).addBox(-7.0F, -14.0F, -6.0F, 14.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(154, 52).addBox(6.5F, -8.0F, -7.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(82, 31).addBox(0.5F, -10.0F, 6.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_16", CubeListBuilder.create().texOffs(99, 0).addBox(-8.0F, -20.0F, 7.5F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(138, 52).addBox(0.5F, -9.0F, -7.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(146, 52).addBox(3.5F, -9.0F, -7.0F, 3.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(90, 30).addBox(3.5F, -9.0F, 6.0F, 3.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(192, 52).addBox(6.5F, -8.0F, 2.5F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_18", CubeListBuilder.create().texOffs(129, 0).addBox(-1.0F, -20.0F, 7.5F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(202, 52).addBox(6.5F, -8.0F, 4.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("Right_Cloud_1", CubeListBuilder.create().texOffs(62, 76).addBox(-14.0F, 0.0F, 3.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Cloud_2", CubeListBuilder.create().texOffs(62, 84).addBox(-15.0F, 0.0F, -3.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0698F, -0.3491F, -0.2618F));

		partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(138, 76).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("Tail_5", CubeListBuilder.create().texOffs(10, 123).addBox(-1.0F, 5.0F, -21.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_4", CubeListBuilder.create().texOffs(18, 121).addBox(-1.5F, 1.0F, -22.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_3", CubeListBuilder.create().texOffs(30, 119).addBox(-2.0F, 3.5F, -20.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.3963F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_2", CubeListBuilder.create().texOffs(46, 117).addBox(-3.0F, 11.0F, -13.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(70, 116).addBox(-4.0F, 13.0F, -6.5F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(EntityLightAngel2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Head.y = entity.getFloatingRotation();
        this.Right_Cloud_1.y = entity.getFloatingRotationShawl();
        this.Right_Cloud_2.y = entity.getFloatingRotationShawl();
        this.Left_Cloud_1.y = entity.getFloatingRotationShawl();
        this.Left_Cloud_2.y = entity.getFloatingRotationShawl();
        this.Torso.y = entity.getFloatingRotation();
        this.Skirt_1.y = entity.getFloatingRotation();
        this.Skirt_2.y = entity.getFloatingRotation();
        this.Skirt_3.y = entity.getFloatingRotation();
        this.Skirt_4.y = entity.getFloatingRotation();
        this.Tail_1.y = entity.getFloatingRotation();
        this.Tail_2.y = entity.getFloatingRotation();
        this.Tail_3.y = entity.getFloatingRotation();
        this.Tail_4.y = entity.getFloatingRotation();
        this.Tail_5.y = entity.getFloatingRotation();
        this.Right_Arm.y = entity.getFloatingRotation();
        this.Left_Arm.y = entity.getFloatingRotation();
        
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}