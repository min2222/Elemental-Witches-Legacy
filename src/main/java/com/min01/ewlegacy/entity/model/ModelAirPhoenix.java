package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix;
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

public class ModelAirPhoenix extends EntityModel<EntityAirPhoenix> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "air_phoenix"), "main");
	private final ModelPart Chest;
	private final ModelPart Right_Leg;
	private final ModelPart Left_Leg;
	private final ModelPart Beak_Lower;
	private final ModelPart Base;
	private final ModelPart Head;
	private final ModelPart Neck;
	private final ModelPart Left_Wing;
	private final ModelPart Beak_Upper;
	private final ModelPart Right_Wing;
	private final ModelPart TailFeathers1;
	private final ModelPart TaileFeathers2;
	private final ModelPart TailFeathers3;
	private final ModelPart TailFeathers4;
	private final ModelPart TailFeathers5;
	private final ModelPart TailFeathers6;
	private final ModelPart TailFeathers7;

	public ModelAirPhoenix(ModelPart root)
	{
		this.Chest = root.getChild("Chest");
		this.Right_Leg = root.getChild("Right_Leg");
		this.Left_Leg = root.getChild("Left_Leg");
		this.Beak_Lower = root.getChild("Beak_Lower");
		this.Base = root.getChild("Base");
		this.Head = root.getChild("Head");
		this.Neck = root.getChild("Neck");
		this.Left_Wing = root.getChild("Left_Wing");
		this.Beak_Upper = root.getChild("Beak_Upper");
		this.Right_Wing = root.getChild("Right_Wing");
		this.TailFeathers1 = root.getChild("TailFeathers1");
		this.TaileFeathers2 = root.getChild("TaileFeathers2");
		this.TailFeathers3 = root.getChild("TailFeathers3");
		this.TailFeathers4 = root.getChild("TailFeathers4");
		this.TailFeathers5 = root.getChild("TailFeathers5");
		this.TailFeathers6 = root.getChild("TailFeathers6");
		this.TailFeathers7 = root.getChild("TailFeathers7");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 16.0F, -6.0F));

		PartDefinition Right_Leg = partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(22, 41).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.8667F, 20.0F, 1.0F));

		Right_Leg.addOrReplaceChild("Right_Toe_1", CubeListBuilder.create().texOffs(22, 50).mirror().addBox(1.3F, -17.0F, -3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.9F, 20.0F, 1.0F));

		Right_Leg.addOrReplaceChild("Right_Toe_2", CubeListBuilder.create().texOffs(12, 50).mirror().addBox(1.2F, -17.0F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.9F, 20.0F, 1.0F));

		PartDefinition Left_Leg = partdefinition.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(22, 56).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, 20.0F, 1.0F));

		Left_Leg.addOrReplaceChild("Left_Toe_2", CubeListBuilder.create().texOffs(22, 22).mirror().addBox(-2.3F, -17.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, 20.0F, 1.0F));

		Left_Leg.addOrReplaceChild("Left_Toe_1", CubeListBuilder.create().texOffs(12, 44).mirror().addBox(-2.2F, -17.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, 20.0F, 1.0F));

		partdefinition.addOrReplaceChild("Beak_Lower", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-3.5F, -0.8F, -9.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.0F, -1.0F));

		partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, -3.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(-4.5F, -5.0F, -7.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadFeathers6", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(-4.45F, -17.5F, -11.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, -1.0F, -0.576F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadFeathers2", CubeListBuilder.create().texOffs(36, 21).mirror().addBox(-5.6F, -17.5F, -11.0F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, -1.0F, -0.576F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadFeathers3", CubeListBuilder.create().texOffs(52, 21).mirror().addBox(0.5F, -17.5F, -11.0F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, -1.0F, -0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, -6.0F));

		partdefinition.addOrReplaceChild("Left_Wing", CubeListBuilder.create().texOffs(67, 21).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 13.0F, 0.0F, -0.6632F, 0.1047F, 0.0F));

		partdefinition.addOrReplaceChild("Beak_Upper", CubeListBuilder.create().texOffs(35, 34).mirror().addBox(-4.0F, -3.1F, -10.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.0F, -1.0F));

		partdefinition.addOrReplaceChild("Right_Wing", CubeListBuilder.create().texOffs(34, 44).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 13.0F, 0.0F, -0.6632F, -0.1047F, 0.0F));

		partdefinition.addOrReplaceChild("TailFeathers1", CubeListBuilder.create().texOffs(60, 36).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1F, 10.0F, 4.0F, -0.576F, 0.0175F, 0.0175F));

		partdefinition.addOrReplaceChild("TaileFeathers2", CubeListBuilder.create().texOffs(76, 34).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 5.5F, -0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("TailFeathers3", CubeListBuilder.create().texOffs(50, 51).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1F, 10.0F, 4.0F, -0.576F, -0.0175F, -0.0175F));

		partdefinition.addOrReplaceChild("TailFeathers4", CubeListBuilder.create().texOffs(90, 27).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 10.0F, 4.0F, -0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("TailFeathers5", CubeListBuilder.create().texOffs(94, 15).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 13.0F, 7.0F, -0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("TailFeathers6", CubeListBuilder.create().texOffs(78, 44).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 13.0F, 6.0F, -0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("TailFeathers7", CubeListBuilder.create().texOffs(21, 30).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.0F, 4.0F, -0.576F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityAirPhoenix entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Beak_Upper.xRot = this.Head.xRot;
        this.Beak_Upper.yRot = this.Head.yRot;
        this.Beak_Lower.xRot = this.Head.xRot;
        this.Beak_Lower.yRot = this.Head.yRot;
        this.Right_Leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
        this.Left_Leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.7F * limbSwingAmount;
        if(!entity.isOnGround()) 
        {
            this.Left_Wing.zRot = ageInTicks;
            this.Right_Wing.zRot = -ageInTicks;
        }
        else 
        {
            this.Left_Wing.zRot = 0.0F;
            this.Right_Wing.zRot = 0.0F;
        }
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Beak_Lower.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Beak_Upper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TaileFeathers2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFeathers7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}