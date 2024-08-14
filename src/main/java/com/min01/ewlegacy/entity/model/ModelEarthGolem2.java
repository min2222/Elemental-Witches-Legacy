package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem2;
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

public class ModelEarthGolem2 extends EntityModel<EntityEarthGolem2> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "earth_golem2"), "main");
	private final ModelPart Left_Shoulder;
	private final ModelPart Dirt;
	private final ModelPart Middle_Finger;
	private final ModelPart Upper_Torso;
	private final ModelPart Head;
	private final ModelPart Thumb;
	private final ModelPart Ring_Finger;
	private final ModelPart Scarf_Button;
	private final ModelPart Lower_Torso;
	private final ModelPart Right_Arm_2;
	private final ModelPart Right_Hand;
	private final ModelPart Scarf_1;
	private final ModelPart Right_Arm_1;
	private final ModelPart Scarf_3;
	private final ModelPart Scarf_2;
	private final ModelPart Scarf_4;
	private final ModelPart Pinky;
	private final ModelPart Right_Palm;
	private final ModelPart Index_Finger;

	public ModelEarthGolem2(ModelPart root) 
	{
		this.Left_Shoulder = root.getChild("Left_Shoulder");
		this.Dirt = root.getChild("Dirt");
		this.Middle_Finger = root.getChild("Middle_Finger");
		this.Upper_Torso = root.getChild("Upper_Torso");
		this.Head = root.getChild("Head");
		this.Thumb = root.getChild("Thumb");
		this.Ring_Finger = root.getChild("Ring_Finger");
		this.Scarf_Button = root.getChild("Scarf_Button");
		this.Lower_Torso = root.getChild("Lower_Torso");
		this.Right_Arm_2 = root.getChild("Right_Arm_2");
		this.Right_Hand = root.getChild("Right_Hand");
		this.Scarf_1 = root.getChild("Scarf_1");
		this.Right_Arm_1 = root.getChild("Right_Arm_1");
		this.Scarf_3 = root.getChild("Scarf_3");
		this.Scarf_2 = root.getChild("Scarf_2");
		this.Scarf_4 = root.getChild("Scarf_4");
		this.Pinky = root.getChild("Pinky");
		this.Right_Palm = root.getChild("Right_Palm");
		this.Index_Finger = root.getChild("Index_Finger");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Left_Shoulder = partdefinition.addOrReplaceChild("Left_Shoulder", CubeListBuilder.create().texOffs(104, 31).addBox(0.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 6.0F, 0.0F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild", CubeListBuilder.create().texOffs(108, 41).addBox(0.0F, 2.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.384F));

		Left_Shoulder.addOrReplaceChild("Left_ShoulderChild_1", CubeListBuilder.create().texOffs(102, 51).addBox(6.5F, 2.5F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5934F));

		partdefinition.addOrReplaceChild("Dirt", CubeListBuilder.create().texOffs(11, 42).addBox(-2.0F, 11.0F, 9.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Middle_Finger", CubeListBuilder.create().texOffs(12, 51).addBox(-1.0F, 14.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Upper_Torso", CubeListBuilder.create().texOffs(40, 35).addBox(-5.5F, 0.0F, -4.0F, 11.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(47, 24).addBox(-3.0F, -5.0F, -3.7F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(77, 13).addBox(1.5F, -4.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.192F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(33, 13).addBox(-3.5F, -4.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, -0.192F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(63, 17).addBox(1.5F, -5.5F, -1.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_11", CubeListBuilder.create().texOffs(69, 13).addBox(-0.5F, -5.0F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.192F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(41, 24).addBox(-2.0F, -6.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(55, 7).addBox(-1.0F, -9.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(51, 14).addBox(-2.0F, -7.0F, -3.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(53, 10).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(55, 20).addBox(-5.0F, -5.0F, -4.7F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(37, 17).addBox(-4.5F, -5.5F, -1.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(65, 24).addBox(3.0F, -1.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(41, 13).addBox(-1.5F, -5.0F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.192F, 0.0F));

		partdefinition.addOrReplaceChild("Thumb", CubeListBuilder.create().texOffs(1, 46).addBox(-3.0F, 11.0F, 8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Ring_Finger", CubeListBuilder.create().texOffs(18, 51).addBox(0.5F, 14.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Scarf_Button", CubeListBuilder.create().texOffs(72, 40).addBox(3.0F, 0.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("Lower_Torso", CubeListBuilder.create().texOffs(46, 51).addBox(-4.0F, 8.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Arm_2", CubeListBuilder.create().texOffs(9, 25).addBox(-2.0F, 1.0F, 8.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Right_Hand", CubeListBuilder.create().texOffs(7, 36).addBox(-2.5F, 9.0F, 7.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Scarf_1", CubeListBuilder.create().texOffs(78, 18).addBox(-11.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Right_Arm_1", CubeListBuilder.create().texOffs(9, 13).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Scarf_3", CubeListBuilder.create().texOffs(0, 3).addBox(-11.0F, -2.0F, -4.5F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Scarf_2", CubeListBuilder.create().texOffs(88, 8).addBox(-11.0F, -1.0F, -4.5F, 11.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		partdefinition.addOrReplaceChild("Scarf_4", CubeListBuilder.create().texOffs(70, 29).addBox(-2.0F, -1.0F, -4.5F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 6.0F, 0.0F, 0.0F, 0.0F, 0.5061F));

		partdefinition.addOrReplaceChild("Pinky", CubeListBuilder.create().texOffs(21, 47).addBox(1.5F, 12.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Right_Palm", CubeListBuilder.create().texOffs(9, 46).addBox(-2.5F, 11.0F, 9.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Index_Finger", CubeListBuilder.create().texOffs(6, 51).addBox(-2.5F, 14.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 6.0F, 0.0F, -1.309F, 0.0F, 0.2269F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityEarthGolem2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Dirt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Middle_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Upper_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thumb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ring_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_Button.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lower_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scarf_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Pinky.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Palm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Index_Finger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}