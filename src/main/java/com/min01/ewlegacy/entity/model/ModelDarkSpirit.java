package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit;
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

public class ModelDarkSpirit extends EntityModel<EntityDarkSpirit>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "dark_spirit"), "main");
	private final ModelPart Left_Armor_4;
	private final ModelPart Left_Armor_2;
	private final ModelPart Left_Armor_3;
	private final ModelPart Left_Armor_1;
	private final ModelPart Body;
	private final ModelPart Right_Armor_3;
	private final ModelPart Right_Armor_4;
	private final ModelPart Right_Armor_Spike_1;
	private final ModelPart Right_Armor_Spike_2;
	private final ModelPart Left_Armor_Spike_2;
	private final ModelPart Left_Armor_Spike_1;
	private final ModelPart Tail_3;
	private final ModelPart Tail_2;
	private final ModelPart Right_Armor_1;
	private final ModelPart Tail_1;
	private final ModelPart Right_Armor_2;

	public ModelDarkSpirit(ModelPart root) 
	{
		this.Left_Armor_4 = root.getChild("Left_Armor_4");
		this.Left_Armor_2 = root.getChild("Left_Armor_2");
		this.Left_Armor_3 = root.getChild("Left_Armor_3");
		this.Left_Armor_1 = root.getChild("Left_Armor_1");
		this.Body = root.getChild("Body");
		this.Right_Armor_3 = root.getChild("Right_Armor_3");
		this.Right_Armor_4 = root.getChild("Right_Armor_4");
		this.Right_Armor_Spike_1 = root.getChild("Right_Armor_Spike_1");
		this.Right_Armor_Spike_2 = root.getChild("Right_Armor_Spike_2");
		this.Left_Armor_Spike_2 = root.getChild("Left_Armor_Spike_2");
		this.Left_Armor_Spike_1 = root.getChild("Left_Armor_Spike_1");
		this.Tail_3 = root.getChild("Tail_3");
		this.Tail_2 = root.getChild("Tail_2");
		this.Right_Armor_1 = root.getChild("Right_Armor_1");
		this.Tail_1 = root.getChild("Tail_1");
		this.Right_Armor_2 = root.getChild("Right_Armor_2");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Left_Armor_4", CubeListBuilder.create().texOffs(52, 15).addBox(5.5F, -2.5F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Armor_2", CubeListBuilder.create().texOffs(60, 20).addBox(4.5F, -2.0F, 0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Armor_3", CubeListBuilder.create().texOffs(56, 20).addBox(4.5F, -2.0F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Armor_1", CubeListBuilder.create().texOffs(56, 25).addBox(5.0F, -2.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(26, 7).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		Body.addOrReplaceChild("BodyChild_12", CubeListBuilder.create().texOffs(27, 0).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Body.addOrReplaceChild("BodyChild_7", CubeListBuilder.create().texOffs(53, 3).addBox(0.5F, -5.0F, -2.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_17", CubeListBuilder.create().texOffs(29, 20).addBox(-1.5F, -0.5F, 1.2F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		Body.addOrReplaceChild("BodyChild_2", CubeListBuilder.create().texOffs(5, 3).addBox(-1.5F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, -0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_18", CubeListBuilder.create().texOffs(20, 6).addBox(-2.5F, -1.5F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, -0.7854F, 0.0F));

		Body.addOrReplaceChild("BodyChild_23", CubeListBuilder.create().texOffs(40, 10).mirror().addBox(2.0F, -0.1F, -0.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, 0.0F, 0.2094F));

		Body.addOrReplaceChild("BodyChild_9", CubeListBuilder.create().texOffs(42, 3).addBox(0.0F, -4.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.2269F, 0.0F));

		Body.addOrReplaceChild("BodyChild", CubeListBuilder.create().texOffs(12, 5).addBox(-1.5F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, -0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_6", CubeListBuilder.create().texOffs(50, 5).addBox(0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_8", CubeListBuilder.create().texOffs(57, 3).addBox(0.5F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_19", CubeListBuilder.create().texOffs(16, 5).addBox(-2.5F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, -0.7854F, 0.0F));

		Body.addOrReplaceChild("BodyChild_3", CubeListBuilder.create().texOffs(20, 3).addBox(-1.0F, -4.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, -0.2269F, 0.0F));

		Body.addOrReplaceChild("BodyChild_15", CubeListBuilder.create().texOffs(38, 2).addBox(-1.0F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Body.addOrReplaceChild("BodyChild_10", CubeListBuilder.create().texOffs(45, 1).addBox(0.0F, -5.0F, -2.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.2269F, 0.0F));

		Body.addOrReplaceChild("BodyChild_4", CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -5.0F, -2.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, -0.2269F, 0.0F));

		Body.addOrReplaceChild("BodyChild_16", CubeListBuilder.create().texOffs(27, 14).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		Body.addOrReplaceChild("BodyChild_22", CubeListBuilder.create().texOffs(44, 5).addBox(1.5F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.7854F, 0.0F));

		Body.addOrReplaceChild("BodyChild_13", CubeListBuilder.create().texOffs(31, 5).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		Body.addOrReplaceChild("BodyChild_14", CubeListBuilder.create().texOffs(24, 2).addBox(0.0F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		Body.addOrReplaceChild("BodyChild_11", CubeListBuilder.create().texOffs(49, 1).addBox(0.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.2269F, 0.0F));

		Body.addOrReplaceChild("BodyChild_20", CubeListBuilder.create().texOffs(20, 10).mirror().addBox(-3.0F, -0.1F, -0.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, 0.0F, -0.2094F));

		Body.addOrReplaceChild("BodyChild_1", CubeListBuilder.create().texOffs(7, 3).addBox(-1.5F, -5.0F, -2.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, -0.6981F, 0.0F));

		Body.addOrReplaceChild("BodyChild_21", CubeListBuilder.create().texOffs(40, 6).addBox(1.5F, -1.5F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.7854F, 0.0F));

		Body.addOrReplaceChild("BodyChild_5", CubeListBuilder.create().texOffs(13, 1).addBox(-1.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, -0.2269F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_3", CubeListBuilder.create().texOffs(4, 20).addBox(-5.5F, -2.0F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_4", CubeListBuilder.create().texOffs(6, 15).addBox(-6.5F, -2.5F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_Spike_1", CubeListBuilder.create().texOffs(0, 15).addBox(-8.0F, -2.4F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_Spike_2", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -0.6F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Armor_Spike_2", CubeListBuilder.create().texOffs(58, 18).addBox(6.0F, -0.6F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Left_Armor_Spike_1", CubeListBuilder.create().texOffs(58, 15).addBox(6.0F, -2.4F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_3", CubeListBuilder.create().texOffs(32, 30).addBox(0.0F, 3.0F, 3.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_2", CubeListBuilder.create().texOffs(32, 26).addBox(0.0F, -0.5F, 4.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_1", CubeListBuilder.create().texOffs(0, 25).addBox(-6.0F, -2.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(32, 24).addBox(0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 1.0F, 0.1571F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Right_Armor_2", CubeListBuilder.create().texOffs(0, 20).addBox(-5.5F, -2.0F, 0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityDarkSpirit entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.Body.y = entity.getFloatingRotation();
        this.Tail_1.y = entity.getFloatingRotation();
        this.Tail_2.y = entity.getFloatingRotation();
        this.Tail_3.y = entity.getFloatingRotation();
        this.Right_Armor_1.y = entity.getFloatingRotation();
        this.Right_Armor_2.y = entity.getFloatingRotation();
        this.Right_Armor_3.y = entity.getFloatingRotation();
        this.Right_Armor_4.y = entity.getFloatingRotation();
        this.Right_Armor_Spike_1.y = entity.getFloatingRotation();
        this.Right_Armor_Spike_2.y = entity.getFloatingRotation();
        this.Left_Armor_1.y = entity.getFloatingRotation();
        this.Left_Armor_2.y = entity.getFloatingRotation();
        this.Left_Armor_3.y = entity.getFloatingRotation();
        this.Left_Armor_4.y = entity.getFloatingRotation();
        this.Left_Armor_Spike_1.y = entity.getFloatingRotation();
        this.Left_Armor_Spike_2.y = entity.getFloatingRotation();
        this.Left_Armor_1.y = entity.getFloatingRotation();
        
        this.Body.xRot = headPitch / 57.295776F;
        this.Body.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Left_Armor_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_Spike_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_Spike_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor_Spike_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor_Spike_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}