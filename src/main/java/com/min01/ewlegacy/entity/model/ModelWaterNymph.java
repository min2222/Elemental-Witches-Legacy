package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityWaterNymph;
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

public class ModelWaterNymph extends EntityModel<EntityWaterNymph>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "water_nymph"), "main");
	private final ModelPart Torso;
	private final ModelPart Right_Leg;
	private final ModelPart Left_Arm_2;
	private final ModelPart Head_1;
	private final ModelPart Left_Arm_1;
	private final ModelPart Lower_Torso;
	private final ModelPart Right_Arm_2;
	private final ModelPart Fin_3;
	private final ModelPart Scarf_1;
	private final ModelPart Right_Arm_1;
	private final ModelPart Scarf_3;
	private final ModelPart Scarf_2;
	private final ModelPart Left_Leg;
	private final ModelPart Scarf_5;
	private final ModelPart Scarf_4;

	public ModelWaterNymph(ModelPart root)
	{
		this.Torso = root.getChild("Torso");
		this.Right_Leg = root.getChild("Right_Leg");
		this.Left_Arm_2 = root.getChild("Left_Arm_2");
		this.Head_1 = root.getChild("Head_1");
		this.Left_Arm_1 = root.getChild("Left_Arm_1");
		this.Lower_Torso = root.getChild("Lower_Torso");
		this.Right_Arm_2 = root.getChild("Right_Arm_2");
		this.Fin_3 = root.getChild("Fin_3");
		this.Scarf_1 = root.getChild("Scarf_1");
		this.Right_Arm_1 = root.getChild("Right_Arm_1");
		this.Scarf_3 = root.getChild("Scarf_3");
		this.Scarf_2 = root.getChild("Scarf_2");
		this.Left_Leg = root.getChild("Left_Leg");
		this.Scarf_5 = root.getChild("Scarf_5");
		this.Scarf_4 = root.getChild("Scarf_4");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(59, 35).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(62, 49).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Arm_2", CubeListBuilder.create().texOffs(85, 32).addBox(-2.5F, -0.5F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 15.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition Head_1 = partdefinition.addOrReplaceChild("Head_1", CubeListBuilder.create().texOffs(55, 22).addBox(-4.0F, -6.0F, -3.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child_1", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child_2", CubeListBuilder.create().texOffs(83, 14).addBox(-3.0F, -5.0F, 3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child_4", CubeListBuilder.create().texOffs(48, -10).addBox(0.0F, -3.0F, 2.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4887F, 0.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child_3", CubeListBuilder.create().texOffs(101, 16).addBox(-3.0F, -4.5F, 6.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child", CubeListBuilder.create().texOffs(57, 13).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head_1.addOrReplaceChild("Head_1Child_5", CubeListBuilder.create().texOffs(44, -3).addBox(0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Arm_1", CubeListBuilder.create().texOffs(85, 22).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 15.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("Lower_Torso", CubeListBuilder.create().texOffs(61, 44).addBox(-2.5F, 4.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm_2", CubeListBuilder.create().texOffs(45, 32).addBox(1.5F, -0.5F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 15.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Fin_3", CubeListBuilder.create().texOffs(29, -4).addBox(0.0F, -5.0F, 1.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.6283F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Scarf_1", CubeListBuilder.create().texOffs(95, 32).addBox(-3.5F, 0.0F, -3.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm_1", CubeListBuilder.create().texOffs(41, 22).addBox(-0.5F, 0.0F, -2.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 15.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		partdefinition.addOrReplaceChild("Scarf_3", CubeListBuilder.create().texOffs(89, 41).addBox(-3.5F, 1.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Scarf_2", CubeListBuilder.create().texOffs(105, 39).addBox(1.5F, 1.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(74, 49).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.0F, 0.0F));

		partdefinition.addOrReplaceChild("Scarf_5", CubeListBuilder.create().texOffs(91, 45).addBox(-2.5F, 3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Scarf_4", CubeListBuilder.create().texOffs(90, 43).addBox(-3.0F, 2.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityWaterNymph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head_1.xRot = headPitch / 57.295776F;
        this.Head_1.yRot = netHeadYaw / 57.295776F;
        this.Left_Leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Right_Leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}