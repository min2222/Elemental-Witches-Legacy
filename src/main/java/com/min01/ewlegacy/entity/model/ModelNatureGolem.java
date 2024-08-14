package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityNatureGolem;
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

public class ModelNatureGolem extends EntityModel<EntityNatureGolem>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "nature_golem"), "main");
	private final ModelPart Right_Leg;
	private final ModelPart Forehead;
	private final ModelPart Left_Side_Head;
	private final ModelPart Backhead_and_Face;
	private final ModelPart Right_Arm;
	private final ModelPart Leaf_5;
	private final ModelPart Left_Leg;
	private final ModelPart Leaf_2;
	private final ModelPart Leaf_1;
	private final ModelPart Leaf_4;
	private final ModelPart Leaf_3;
	private final ModelPart Bottom_Crack_1;
	private final ModelPart Bottom_Crack_2;
	private final ModelPart Bottom_Crack_3;
	private final ModelPart Seed_1;
	private final ModelPart Bottom_Crack_4;
	private final ModelPart Seed_2;
	private final ModelPart Bottom_Crack_5;
	private final ModelPart Bottom_Crack_6;
	private final ModelPart Left_Arm;
	private final ModelPart Right_Side_Head;
	private final ModelPart Top_Crack_1;
	private final ModelPart Top_Crack_2;
	private final ModelPart Top_Crack_5;
	private final ModelPart Top_Crack_6;
	private final ModelPart Top_Crack_3;
	private final ModelPart Top_Crack_4;
	private final ModelPart Plant_Stem;
	private final ModelPart Lower_Body;

	public ModelNatureGolem(ModelPart root) 
	{
		this.Right_Leg = root.getChild("Right_Leg");
		this.Forehead = root.getChild("Forehead");
		this.Left_Side_Head = root.getChild("Left_Side_Head");
		this.Backhead_and_Face = root.getChild("Backhead_and_Face");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Leaf_5 = root.getChild("Leaf_5");
		this.Left_Leg = root.getChild("Left_Leg");
		this.Leaf_2 = root.getChild("Leaf_2");
		this.Leaf_1 = root.getChild("Leaf_1");
		this.Leaf_4 = root.getChild("Leaf_4");
		this.Leaf_3 = root.getChild("Leaf_3");
		this.Bottom_Crack_1 = root.getChild("Bottom_Crack_1");
		this.Bottom_Crack_2 = root.getChild("Bottom_Crack_2");
		this.Bottom_Crack_3 = root.getChild("Bottom_Crack_3");
		this.Seed_1 = root.getChild("Seed_1");
		this.Bottom_Crack_4 = root.getChild("Bottom_Crack_4");
		this.Seed_2 = root.getChild("Seed_2");
		this.Bottom_Crack_5 = root.getChild("Bottom_Crack_5");
		this.Bottom_Crack_6 = root.getChild("Bottom_Crack_6");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Right_Side_Head = root.getChild("Right_Side_Head");
		this.Top_Crack_1 = root.getChild("Top_Crack_1");
		this.Top_Crack_2 = root.getChild("Top_Crack_2");
		this.Top_Crack_5 = root.getChild("Top_Crack_5");
		this.Top_Crack_6 = root.getChild("Top_Crack_6");
		this.Top_Crack_3 = root.getChild("Top_Crack_3");
		this.Top_Crack_4 = root.getChild("Top_Crack_4");
		this.Plant_Stem = root.getChild("Plant_Stem");
		this.Lower_Body = root.getChild("Lower_Body");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Right_Leg = partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(63, 55).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 19.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		Right_Leg.addOrReplaceChild("Right_LegChild", CubeListBuilder.create().texOffs(61, 61).addBox(-0.5F, 4.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		partdefinition.addOrReplaceChild("Forehead", CubeListBuilder.create().texOffs(53, 25).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Side_Head", CubeListBuilder.create().texOffs(77, 33).addBox(3.0F, 2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Backhead_and_Face", CubeListBuilder.create().texOffs(57, 35).addBox(-3.0F, 2.0F, -1.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Right_Arm = partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(45, 45).addBox(0.0F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		Right_Arm.addOrReplaceChild("Right_ArmChild", CubeListBuilder.create().texOffs(49, 55).addBox(0.0F, 4.0F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("Leaf_5", CubeListBuilder.create().texOffs(58, 13).addBox(-3.0F, -2.0F, 0.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, -0.0175F));

		PartDefinition Left_Leg = partdefinition.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(67, 55).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 19.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		Left_Leg.addOrReplaceChild("Left_LegChild", CubeListBuilder.create().texOffs(67, 61).addBox(-0.5F, 4.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		partdefinition.addOrReplaceChild("Leaf_2", CubeListBuilder.create().texOffs(40, 13).addBox(-6.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0698F, -0.0698F));

		partdefinition.addOrReplaceChild("Leaf_1", CubeListBuilder.create().texOffs(74, 19).addBox(1.0F, -2.0F, -3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.3142F, 0.0F));

		partdefinition.addOrReplaceChild("Leaf_4", CubeListBuilder.create().texOffs(54, 19).addBox(-5.5F, -2.0F, -3.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0698F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Leaf_3", CubeListBuilder.create().texOffs(76, 13).addBox(2.0F, -1.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.0873F, -0.4538F, 0.0F));

		partdefinition.addOrReplaceChild("Bottom_Crack_1", CubeListBuilder.create().texOffs(53, 41).addBox(0.7F, 4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Bottom_Crack_2", CubeListBuilder.create().texOffs(57, 41).addBox(2.2F, 2.5F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 1.0647F));

		partdefinition.addOrReplaceChild("Bottom_Crack_3", CubeListBuilder.create().texOffs(61, 41).addBox(1.5F, 3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		partdefinition.addOrReplaceChild("Seed_1", CubeListBuilder.create().texOffs(61, 3).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Bottom_Crack_4", CubeListBuilder.create().texOffs(65, 41).addBox(3.0F, 1.6F, -3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.8378F));

		partdefinition.addOrReplaceChild("Seed_2", CubeListBuilder.create().texOffs(63, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Bottom_Crack_5", CubeListBuilder.create().texOffs(69, 41).addBox(4.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.8378F));

		partdefinition.addOrReplaceChild("Bottom_Crack_6", CubeListBuilder.create().texOffs(73, 41).addBox(4.0F, 1.5F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.5585F));

		PartDefinition Left_Arm = partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(81, 45).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 13.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		Left_Arm.addOrReplaceChild("Left_ArmChild", CubeListBuilder.create().texOffs(81, 55).addBox(-1.0F, 4.0F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, -0.6981F, 0.0F, -0.3491F));

		partdefinition.addOrReplaceChild("Right_Side_Head", CubeListBuilder.create().texOffs(43, 33).addBox(-4.0F, 2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Top_Crack_1", CubeListBuilder.create().texOffs(53, 33).addBox(0.4F, 3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 1.1345F));

		partdefinition.addOrReplaceChild("Top_Crack_2", CubeListBuilder.create().texOffs(57, 33).addBox(0.2F, 2.5F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		partdefinition.addOrReplaceChild("Top_Crack_5", CubeListBuilder.create().texOffs(69, 33).addBox(0.6F, 1.3F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.3142F));

		partdefinition.addOrReplaceChild("Top_Crack_6", CubeListBuilder.create().texOffs(73, 33).addBox(1.5F, 0.9F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.3142F));

		partdefinition.addOrReplaceChild("Top_Crack_3", CubeListBuilder.create().texOffs(61, 33).addBox(-1.2F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.2793F));

		partdefinition.addOrReplaceChild("Top_Crack_4", CubeListBuilder.create().texOffs(65, 33).addBox(0.5F, 1.3F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		partdefinition.addOrReplaceChild("Plant_Stem", CubeListBuilder.create().texOffs(65, 8).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Body", CubeListBuilder.create().texOffs(53, 43).addBox(-4.0F, 4.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityNatureGolem entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Leaf_1.xRot = Mth.sin(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_1.zRot = Mth.cos(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_2.xRot = Mth.sin(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_2.xRot = Mth.cos(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_3.zRot = Mth.sin(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_3.zRot = Mth.cos(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_4.yRot = Mth.sin(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_4.zRot = Mth.cos(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_5.xRot = Mth.sin(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Leaf_5.yRot = Mth.cos(limbSwing * 0.5F) * 0.2F * limbSwingAmount;
        this.Right_Leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Left_Leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Left_Arm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Right_Arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Forehead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Side_Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Backhead_and_Face.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leaf_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leaf_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leaf_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leaf_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leaf_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Seed_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Seed_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bottom_Crack_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Side_Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top_Crack_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Plant_Stem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}