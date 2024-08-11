package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityEntGuardian;
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

public class ModelEntGuardian extends EntityModel<EntityEntGuardian>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "ent_guardian"), "main");
	private final ModelPart Chest_Gem;
	private final ModelPart Right_Shoulder_1;
	private final ModelPart Right_Shoulder_2;
	private final ModelPart Right_Shoulder_3;
	private final ModelPart Left_Wing_Twig;
	private final ModelPart Left_Shoulder_1;
	private final ModelPart Left_Shoulder_2;
	private final ModelPart Head;
	private final ModelPart Left_Wing_Leaf;
	private final ModelPart Left_Shoulder_3;
	private final ModelPart Right_Wing_Twig;
	private final ModelPart Left_Arm_1;
	private final ModelPart Torso_1;
	private final ModelPart Torso_3;
	private final ModelPart Torso_2;
	private final ModelPart Right_Arm_1;
	private final ModelPart Orb;
	private final ModelPart Right_Wing_Leaf;

	public ModelEntGuardian(ModelPart root) 
	{
		this.Chest_Gem = root.getChild("Chest_Gem");
		this.Right_Shoulder_1 = root.getChild("Right_Shoulder_1");
		this.Right_Shoulder_2 = root.getChild("Right_Shoulder_2");
		this.Right_Shoulder_3 = root.getChild("Right_Shoulder_3");
		this.Left_Wing_Twig = root.getChild("Left_Wing_Twig");
		this.Left_Shoulder_1 = root.getChild("Left_Shoulder_1");
		this.Left_Shoulder_2 = root.getChild("Left_Shoulder_2");
		this.Head = root.getChild("Head");
		this.Left_Wing_Leaf = root.getChild("Left_Wing_Leaf");
		this.Left_Shoulder_3 = root.getChild("Left_Shoulder_3");
		this.Right_Wing_Twig = root.getChild("Right_Wing_Twig");
		this.Left_Arm_1 = root.getChild("Left_Arm_1");
		this.Torso_1 = root.getChild("Torso_1");
		this.Torso_3 = root.getChild("Torso_3");
		this.Torso_2 = root.getChild("Torso_2");
		this.Right_Arm_1 = root.getChild("Right_Arm_1");
		this.Orb = root.getChild("Orb");
		this.Right_Wing_Leaf = root.getChild("Right_Wing_Leaf");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Chest_Gem", CubeListBuilder.create().texOffs(255, 109).addBox(-2.0F, 3.0F, -8.0F, 4.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Shoulder_1", CubeListBuilder.create().texOffs(182, 74).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("Right_Shoulder_2", CubeListBuilder.create().texOffs(162, 72).addBox(-9.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		partdefinition.addOrReplaceChild("Right_Shoulder_3", CubeListBuilder.create().texOffs(148, 70).addBox(-12.0F, -5.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("Left_Wing_Twig", CubeListBuilder.create().texOffs(310, 22).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -22.0F, 7.0F, 0.5236F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Shoulder_1", CubeListBuilder.create().texOffs(298, 74).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -26.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("Left_Shoulder_2", CubeListBuilder.create().texOffs(326, 72).addBox(0.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -26.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(244, 59).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(288, 58).addBox(12.0F, -1.0F, 0.0F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(248, 52).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_12", CubeListBuilder.create().texOffs(265, 41).addBox(-1.0F, -16.0F, -3.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(210, 65).addBox(-24.0F, 2.0F, -0.5F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(247, 41).addBox(-1.0F, -16.0F, -3.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(276, 65).addBox(8.0F, 2.0F, -0.5F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(256, 0).addBox(-1.0F, -12.0F, 18.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(210, 58).addBox(-23.0F, -1.0F, 0.0F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(256, 5).addBox(-1.0F, -20.0F, 7.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(232, 67).addBox(-9.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(256, 14).addBox(-1.0F, -16.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_13", CubeListBuilder.create().texOffs(265, 31).addBox(-1.0F, -22.0F, -8.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, -0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(276, 67).addBox(4.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(247, 31).addBox(-1.0F, -22.0F, -8.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Wing_Leaf", CubeListBuilder.create().texOffs(372, 30).addBox(0.0F, -9.5F, 5.0F, 0.0F, 20.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -22.0F, 7.0F, 0.5236F, 0.5236F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Shoulder_3", CubeListBuilder.create().texOffs(350, 70).addBox(5.0F, -5.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -26.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("Right_Wing_Twig", CubeListBuilder.create().texOffs(114, 22).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -22.0F, 7.0F, 0.5236F, -0.5236F, 0.0F));

		PartDefinition Left_Arm_1 = partdefinition.addOrReplaceChild("Left_Arm_1", CubeListBuilder.create().texOffs(298, 92).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -23.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child_1", CubeListBuilder.create().texOffs(292, 131).addBox(-4.0F, 22.0F, 3.5F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.6109F, 0.0F, -0.4363F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child_3", CubeListBuilder.create().texOffs(324, 141).addBox(-5.0F, 25.0F, 4.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.5236F, 0.0F, -0.6807F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child", CubeListBuilder.create().texOffs(294, 112).addBox(-3.5F, 10.0F, 4.0F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.6109F, 0.0F, -0.4363F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child_2", CubeListBuilder.create().texOffs(316, 142).addBox(-5.0F, 23.0F, 9.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.8029F, 0.0F, -0.6981F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child_4", CubeListBuilder.create().texOffs(324, 131).addBox(0.0F, 26.0F, 2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.3316F, 0.0F, -0.4712F));

		Left_Arm_1.addOrReplaceChild("Left_Arm_1Child_5", CubeListBuilder.create().texOffs(292, 142).addBox(2.0F, 24.0F, 7.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, -0.733F, 0.0F, -0.192F));

		partdefinition.addOrReplaceChild("Torso_1", CubeListBuilder.create().texOffs(222, 77).addBox(-12.0F, 0.0F, -7.0F, 24.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		partdefinition.addOrReplaceChild("Torso_3", CubeListBuilder.create().texOffs(238, 141).addBox(-6.0F, 24.0F, -5.0F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		partdefinition.addOrReplaceChild("Torso_2", CubeListBuilder.create().texOffs(232, 123).addBox(-8.0F, 18.0F, -6.0F, 16.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		PartDefinition Right_Arm_1 = partdefinition.addOrReplaceChild("Right_Arm_1", CubeListBuilder.create().texOffs(202, 92).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -23.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child", CubeListBuilder.create().texOffs(198, 112).addBox(-3.5F, 10.0F, 4.0F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.4363F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child_4", CubeListBuilder.create().texOffs(188, 131).addBox(-2.0F, 26.0F, 2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.3316F, 0.0F, 0.4712F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child_1", CubeListBuilder.create().texOffs(196, 131).addBox(-4.0F, 22.0F, 3.5F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.4363F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child_3", CubeListBuilder.create().texOffs(188, 141).addBox(3.0F, 25.0F, 4.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.6807F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child_5", CubeListBuilder.create().texOffs(220, 142).addBox(-4.0F, 24.0F, 7.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.733F, 0.0F, 0.192F));

		Right_Arm_1.addOrReplaceChild("Right_Arm_1Child_2", CubeListBuilder.create().texOffs(196, 142).addBox(3.0F, 23.0F, 9.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, -0.8029F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Orb", CubeListBuilder.create().texOffs(252, 23).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -43.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Wing_Leaf", CubeListBuilder.create().texOffs(68, 30).addBox(0.0F, -9.5F, 5.0F, 0.0F, 20.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -22.0F, 7.0F, 0.5236F, -0.5236F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 256);
	}

	@Override
	public void setupAnim(EntityEntGuardian entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Orb.yRot = ageInTicks / 10.0F;
        this.Orb.xRot = ageInTicks / 20.0F;
        this.Orb.zRot = ageInTicks / 20.0F;
	}
	
	@Override
	public void prepareMobModel(EntityEntGuardian p_102957_, float p_102958_, float p_102959_, float p_102960_) 
	{
		int i = p_102957_.getAttackTimer();
		if(i > 0) 
		{
			this.Right_Arm_1.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - p_102960_, 10.0F);
			this.Left_Arm_1.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - p_102960_, 10.0F);
		} 
		else
		{
			this.Right_Arm_1.xRot = (-0.2F + 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
			this.Left_Arm_1.xRot = (-0.2F - 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Chest_Gem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Shoulder_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing_Twig.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing_Leaf.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Shoulder_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing_Twig.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Orb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing_Leaf.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}