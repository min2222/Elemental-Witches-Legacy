package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightAngel;
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

public class ModelLightAngel extends EntityModel<EntityLightAngel> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "light_angel"), "main");
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart Left_Cloud_1;
	private final ModelPart Right_Cloud_1;
	private final ModelPart Right_Cloud_2;
	private final ModelPart Left_Arm;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Cloud_2;
	private final ModelPart Skirt_1;
	private final ModelPart Skirt_2;

	public ModelLightAngel(ModelPart root) 
	{
		this.Torso = root.getChild("Torso");
		this.Head = root.getChild("Head");
		this.Left_Cloud_1 = root.getChild("Left_Cloud_1");
		this.Right_Cloud_1 = root.getChild("Right_Cloud_1");
		this.Right_Cloud_2 = root.getChild("Right_Cloud_2");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Cloud_2 = root.getChild("Left_Cloud_2");
		this.Skirt_1 = root.getChild("Skirt_1");
		this.Skirt_2 = root.getChild("Skirt_2");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(61, 35).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(55, 25).addBox(-3.5F, -4.0F, -3.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(40, 15).addBox(-4.0F, -4.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(58, 21).addBox(-4.5F, -6.5F, -4.0F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(88, 16).addBox(4.0F, -5.0F, 1.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(47, 25).addBox(-3.0F, -4.0F, 3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(32, 14).addBox(-5.0F, -5.0F, 5.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(38, 16).addBox(-5.0F, -5.0F, 1.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(53, 10).addBox(-4.0F, -8.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(57, 4).addBox(-3.0F, -8.0F, -2.5F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(94, 14).addBox(4.0F, -5.0F, 5.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(78, 15).addBox(3.0F, -4.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(62, 0).addBox(4.0F, -8.0F, 2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(68, 0).addBox(-6.0F, -8.0F, 2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("Left_Cloud_1", CubeListBuilder.create().texOffs(75, 35).addBox(0.0F, 0.0F, 1.5F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		partdefinition.addOrReplaceChild("Right_Cloud_1", CubeListBuilder.create().texOffs(43, 35).addBox(-7.0F, 0.0F, 1.5F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Cloud_2", CubeListBuilder.create().texOffs(31, 31).addBox(-7.0F, 0.0F, -2.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.0698F, -0.3491F, -0.2618F));

		partdefinition.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(73, 39).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 15.0F, 0.0F, 0.0F, 0.0F, -0.733F));

		partdefinition.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(55, 39).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 15.0F, 0.0F, 0.0F, 0.0F, 0.733F));

		partdefinition.addOrReplaceChild("Left_Cloud_2", CubeListBuilder.create().texOffs(85, 31).addBox(5.0F, 0.0F, -2.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.0698F, 0.3491F, 0.2618F));

		partdefinition.addOrReplaceChild("Skirt_1", CubeListBuilder.create().texOffs(59, 41).addBox(-2.5F, 3.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("Skirt_2", CubeListBuilder.create().texOffs(57, 46).addBox(-3.0F, 4.0F, -2.5F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityLightAngel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head.y = entity.getFloatingRotation();
        this.Right_Arm.y = entity.getFloatingRotation();
        this.Left_Arm.y = entity.getFloatingRotation();
        this.Torso.y = entity.getFloatingRotation();
        this.Skirt_1.y = entity.getFloatingRotation();
        this.Skirt_2.y = entity.getFloatingRotation();
        this.Right_Cloud_1.y = entity.getFloatingRotation();
        this.Right_Cloud_2.y = entity.getFloatingRotation();
        this.Left_Cloud_1.y = entity.getFloatingRotation();
        this.Left_Cloud_2.y = entity.getFloatingRotation();
        
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Cloud_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Cloud_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skirt_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}