package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.entity.pet.EntityWaterNymph2;
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

public class ModelWaterNymph2 extends EntityModel<EntityWaterNymph2>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "water_nymph2"), "main");
	private final ModelPart Torso;
	private final ModelPart Right_Arm;
	private final ModelPart Head;
	private final ModelPart Left_Arm;

	public ModelWaterNymph2(ModelPart root) 
	{
		this.Torso = root.getChild("Torso");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Head = root.getChild("Head");
		this.Left_Arm = root.getChild("Left_Arm");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(122, 51).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_8", CubeListBuilder.create().texOffs(112, 95).addBox(-5.5F, 9.0F, -5.0F, 11.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_17", CubeListBuilder.create().texOffs(80, 73).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4712F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_2", CubeListBuilder.create().texOffs(0, 9).addBox(-2.5F, 2.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_6", CubeListBuilder.create().texOffs(116, 76).addBox(-4.5F, 7.0F, -4.0F, 9.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_13", CubeListBuilder.create().texOffs(144, 121).addBox(2.0F, 19.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		Torso.addOrReplaceChild("TorsoChild_11", CubeListBuilder.create().texOffs(113, 121).addBox(-4.0F, 19.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		Torso.addOrReplaceChild("TorsoChild_5", CubeListBuilder.create().texOffs(118, 68).addBox(-4.0F, 6.0F, -3.5F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_10", CubeListBuilder.create().texOffs(101, 118).addBox(-5.0F, 13.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		Torso.addOrReplaceChild("TorsoChild_4", CubeListBuilder.create().texOffs(120, 61).addBox(-3.5F, 5.0F, -3.0F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_16", CubeListBuilder.create().texOffs(76, 66).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.1745F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_14", CubeListBuilder.create().texOffs(84, 61).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.3665F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_9", CubeListBuilder.create().texOffs(110, 106).addBox(-6.0F, 10.0F, -5.5F, 12.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_7", CubeListBuilder.create().texOffs(114, 85).addBox(-5.0F, 8.0F, -4.5F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_19", CubeListBuilder.create().texOffs(82, 81).addBox(0.0F, 1.0F, 0.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.8378F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_1", CubeListBuilder.create().texOffs(0, 7).addBox(-2.5F, 1.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_3", CubeListBuilder.create().texOffs(0, 11).addBox(-2.5F, 3.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_12", CubeListBuilder.create().texOffs(154, 118).addBox(2.0F, 13.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		Torso.addOrReplaceChild("TorsoChild_15", CubeListBuilder.create().texOffs(78, 62).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.1222F, 0.0F, 0.0F));

		Torso.addOrReplaceChild("TorsoChild_18", CubeListBuilder.create().texOffs(82, 79).addBox(0.0F, 3.0F, 0.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.5934F, 0.0F, 0.0F));

		PartDefinition Right_Arm = partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(99, 51).addBox(-12.0F, 0.0F, -1.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.4014F));

		Right_Arm.addOrReplaceChild("Right_ArmChild_3", CubeListBuilder.create().texOffs(106, 60).addBox(-10.0F, 3.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.576F));

		Right_Arm.addOrReplaceChild("Right_ArmChild", CubeListBuilder.create().texOffs(99, 45).addBox(-10.0F, 0.0F, 0.0F, 9.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1222F));

		Right_Arm.addOrReplaceChild("Right_ArmChild_1", CubeListBuilder.create().texOffs(95, 48).addBox(-11.0F, 0.0F, 0.0F, 11.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Right_Arm.addOrReplaceChild("Right_ArmChild_2", CubeListBuilder.create().texOffs(102, 56).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4712F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(117, 35).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(90, 0).addBox(-5.5F, -8.5F, -2.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, -0.2618F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(150, 0).addBox(3.5F, -8.5F, -2.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, 0.2618F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(116, 0).addBox(-3.0F, -10.0F, -2.0F, 6.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0698F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(116, 19).addBox(-4.5F, -9.0F, -3.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Left_Arm = partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(139, 51).addBox(0.0F, 0.0F, -1.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.4014F));

		Left_Arm.addOrReplaceChild("Left_ArmChild_2", CubeListBuilder.create().texOffs(144, 56).addBox(0.0F, 0.0F, 0.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4712F));

		Left_Arm.addOrReplaceChild("Left_ArmChild", CubeListBuilder.create().texOffs(149, 45).addBox(1.0F, 0.0F, 0.0F, 9.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1222F));

		Left_Arm.addOrReplaceChild("Left_ArmChild_1", CubeListBuilder.create().texOffs(149, 48).addBox(0.0F, 0.0F, 0.0F, 11.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Left_Arm.addOrReplaceChild("Left_ArmChild_3", CubeListBuilder.create().texOffs(144, 60).addBox(2.0F, 3.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.576F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(EntityWaterNymph2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head.y = entity.getFloatingRotation();
        this.Torso.y = entity.getFloatingRotation();
        this.Right_Arm.y = entity.getFloatingRotation();
        this.Left_Arm.y = entity.getFloatingRotation();
        
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Right_Arm.yRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.Left_Arm.yRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}