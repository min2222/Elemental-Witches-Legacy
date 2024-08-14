package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityIceBeast;
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

public class ModelIceBeast extends EntityModel<EntityIceBeast> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "ice_beast"), "main");
	private final ModelPart Torso;
	private final ModelPart Right_Fur_Crystal;
	private final ModelPart Fur_1;
	private final ModelPart Back_Right_Foot;
	private final ModelPart Fur_3;
	private final ModelPart Fur_2;
	private final ModelPart Fur_4;
	private final ModelPart Right_Floating_Crystal;
	private final ModelPart Front_Left_Foot;
	private final ModelPart Right_2_Tail_1;
	private final ModelPart Right_2_Tail_2;
	private final ModelPart Front_Right_Foot;
	private final ModelPart Right_2_Tail_3;
	private final ModelPart Back_Left_Foot;
	private final ModelPart Head;
	private final ModelPart Rear;
	private final ModelPart Center_Floating_Crystal;
	private final ModelPart Right_1_Tail_3;
	private final ModelPart Right_1_Tail_2;
	private final ModelPart Right_1_Tail_1;
	private final ModelPart Left_Fur_Crystal;
	private final ModelPart Left_2_Tail_1;
	private final ModelPart Left_1_Tail_1;
	private final ModelPart Left_2_Tail_3;
	private final ModelPart Left_1_Tail_2;
	private final ModelPart Left_2_Tail_2;
	private final ModelPart Left_1_Tail_3;
	private final ModelPart Left_Floating_Crystal;

	public ModelIceBeast(ModelPart root) 
	{
		this.Torso = root.getChild("Torso");
		this.Right_Fur_Crystal = root.getChild("Right_Fur_Crystal");
		this.Fur_1 = root.getChild("Fur_1");
		this.Back_Right_Foot = root.getChild("Back_Right_Foot");
		this.Fur_3 = root.getChild("Fur_3");
		this.Fur_2 = root.getChild("Fur_2");
		this.Fur_4 = root.getChild("Fur_4");
		this.Right_Floating_Crystal = root.getChild("Right_Floating_Crystal");
		this.Front_Left_Foot = root.getChild("Front_Left_Foot");
		this.Right_2_Tail_1 = root.getChild("Right_2_Tail_1");
		this.Right_2_Tail_2 = root.getChild("Right_2_Tail_2");
		this.Front_Right_Foot = root.getChild("Front_Right_Foot");
		this.Right_2_Tail_3 = root.getChild("Right_2_Tail_3");
		this.Back_Left_Foot = root.getChild("Back_Left_Foot");
		this.Head = root.getChild("Head");
		this.Rear = root.getChild("Rear");
		this.Center_Floating_Crystal = root.getChild("Center_Floating_Crystal");
		this.Right_1_Tail_3 = root.getChild("Right_1_Tail_3");
		this.Right_1_Tail_2 = root.getChild("Right_1_Tail_2");
		this.Right_1_Tail_1 = root.getChild("Right_1_Tail_1");
		this.Left_Fur_Crystal = root.getChild("Left_Fur_Crystal");
		this.Left_2_Tail_1 = root.getChild("Left_2_Tail_1");
		this.Left_1_Tail_1 = root.getChild("Left_1_Tail_1");
		this.Left_2_Tail_3 = root.getChild("Left_2_Tail_3");
		this.Left_1_Tail_2 = root.getChild("Left_1_Tail_2");
		this.Left_2_Tail_2 = root.getChild("Left_2_Tail_2");
		this.Left_1_Tail_3 = root.getChild("Left_1_Tail_3");
		this.Left_Floating_Crystal = root.getChild("Left_Floating_Crystal");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(16, 26).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Fur_Crystal", CubeListBuilder.create().texOffs(93, 31).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fur_1", CubeListBuilder.create().texOffs(73, 19).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Back_Right_Foot = partdefinition.addOrReplaceChild("Back_Right_Foot", CubeListBuilder.create().texOffs(26, 59).addBox(-1.0F, 7.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, 12.0F));

		Back_Right_Foot.addOrReplaceChild("Back_Right_FootChild", CubeListBuilder.create().texOffs(26, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Back_Right_Foot.addOrReplaceChild("Back_Right_FootChild_1", CubeListBuilder.create().texOffs(26, 51).addBox(-1.0F, 2.0F, 1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fur_3", CubeListBuilder.create().texOffs(56, 28).addBox(-3.5F, -2.0F, 3.0F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fur_2", CubeListBuilder.create().texOffs(76, 31).addBox(-2.5F, 6.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fur_4", CubeListBuilder.create().texOffs(42, 34).addBox(-2.5F, -3.0F, 5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Floating_Crystal", CubeListBuilder.create().texOffs(110, 40).addBox(-7.5F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Front_Left_Foot = partdefinition.addOrReplaceChild("Front_Left_Foot", CubeListBuilder.create().texOffs(49, 59).addBox(-1.0F, 8.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, 3.0F));

		Front_Left_Foot.addOrReplaceChild("Front_Left_FootChild_1", CubeListBuilder.create().texOffs(44, 46).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Front_Left_Foot.addOrReplaceChild("Front_Left_FootChild_2", CubeListBuilder.create().texOffs(44, 53).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Front_Left_Foot.addOrReplaceChild("Front_Left_FootChild", CubeListBuilder.create().texOffs(34, 46).addBox(-0.5F, -2.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_2_Tail_1", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.3491F, -0.2618F, 0.0F));

		partdefinition.addOrReplaceChild("Right_2_Tail_2", CubeListBuilder.create().texOffs(10, 24).addBox(-0.5F, 1.5F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.7854F, -0.2618F, 0.0F));

		PartDefinition Front_Right_Foot = partdefinition.addOrReplaceChild("Front_Right_Foot", CubeListBuilder.create().texOffs(67, 59).addBox(-1.0F, 8.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, 3.0F));

		Front_Right_Foot.addOrReplaceChild("Front_Right_FootChild_1", CubeListBuilder.create().texOffs(62, 46).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Front_Right_Foot.addOrReplaceChild("Front_Right_FootChild", CubeListBuilder.create().texOffs(52, 46).addBox(-1.5F, -2.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Front_Right_Foot.addOrReplaceChild("Front_Right_FootChild_2", CubeListBuilder.create().texOffs(62, 53).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_2_Tail_3", CubeListBuilder.create().texOffs(18, 22).addBox(-0.5F, 3.5F, 4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 1.2217F, -0.2618F, 0.0F));

		PartDefinition Back_Left_Foot = partdefinition.addOrReplaceChild("Back_Left_Foot", CubeListBuilder.create().texOffs(16, 59).addBox(-1.0F, 7.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, 12.0F));

		Back_Left_Foot.addOrReplaceChild("Back_Left_FootChild_1", CubeListBuilder.create().texOffs(16, 51).addBox(-1.0F, 2.0F, 1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		Back_Left_Foot.addOrReplaceChild("Back_Left_FootChild", CubeListBuilder.create().texOffs(16, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(99, 23).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(100, 18).addBox(-2.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(99, 20).addBox(-2.5F, -4.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(103, 13).addBox(-0.5F, -3.5F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(115, 23).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(110, 18).addBox(1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(115, 29).addBox(-0.5F, 1.5F, -5.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(109, 20).addBox(0.5F, -4.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Rear", CubeListBuilder.create().texOffs(4, 40).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 14.0F));

		partdefinition.addOrReplaceChild("Center_Floating_Crystal", CubeListBuilder.create().texOffs(100, 50).addBox(3.0F, 3.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_1_Tail_3", CubeListBuilder.create().texOffs(18, 16).addBox(-0.5F, 3.5F, 4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 1.2217F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Right_1_Tail_2", CubeListBuilder.create().texOffs(10, 18).addBox(-0.5F, 1.5F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.7854F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Right_1_Tail_1", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.3491F, -0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Fur_Crystal", CubeListBuilder.create().texOffs(93, 15).addBox(3.0F, -2.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Left_2_Tail_1", CubeListBuilder.create().texOffs(0, 29).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.3491F, 0.2618F, 0.0F));

		partdefinition.addOrReplaceChild("Left_1_Tail_1", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.3491F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Left_2_Tail_3", CubeListBuilder.create().texOffs(18, 28).addBox(-0.5F, 3.5F, 4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 1.2217F, 0.2618F, 0.0F));

		partdefinition.addOrReplaceChild("Left_1_Tail_2", CubeListBuilder.create().texOffs(10, 36).addBox(-0.5F, 1.5F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.7854F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Left_2_Tail_2", CubeListBuilder.create().texOffs(10, 30).addBox(-0.5F, 1.5F, 3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 0.7854F, 0.2618F, 0.0F));

		partdefinition.addOrReplaceChild("Left_1_Tail_3", CubeListBuilder.create().texOffs(18, 34).addBox(-0.5F, 3.5F, 4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 14.0F, 1.2217F, 0.7854F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Floating_Crystal", CubeListBuilder.create().texOffs(90, 40).addBox(5.5F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityIceBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Front_Left_Foot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Front_Right_Foot.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Back_Right_Foot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Back_Left_Foot.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Center_Floating_Crystal.yRot = ageInTicks / 24.0F;
        this.Center_Floating_Crystal.xRot = ageInTicks / 23.0F;
        this.Center_Floating_Crystal.zRot = ageInTicks / 5.0F;
        this.Right_Floating_Crystal.yRot = ageInTicks / 19.0F;
        this.Right_Floating_Crystal.xRot = ageInTicks / 13.0F;
        this.Left_Floating_Crystal.yRot = ageInTicks / 8.0F;
        this.Left_Floating_Crystal.zRot = ageInTicks / 5.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Fur_Crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fur_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Right_Foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fur_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fur_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fur_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Floating_Crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Left_Foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_2_Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_2_Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Right_Foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_2_Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Left_Foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Center_Floating_Crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_1_Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_1_Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_1_Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Fur_Crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_2_Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_1_Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_2_Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_1_Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_2_Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_1_Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Floating_Crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}