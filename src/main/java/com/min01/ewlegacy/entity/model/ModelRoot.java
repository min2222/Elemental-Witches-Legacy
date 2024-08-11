package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityRoot;
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

public class ModelRoot extends EntityModel<EntityRoot>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "root"), "main");
	private final ModelPart Root9;
	private final ModelPart Root8;
	private final ModelPart Root7;
	private final ModelPart Root6;
	private final ModelPart Root5;
	private final ModelPart Root4;
	private final ModelPart Root3;
	private final ModelPart Root2;
	private final ModelPart Root1;
	private final ModelPart Root10;
	private final ModelPart Root12;
	private final ModelPart Root11;

	public ModelRoot(ModelPart root) 
	{
		this.Root9 = root.getChild("Root9");
		this.Root8 = root.getChild("Root8");
		this.Root7 = root.getChild("Root7");
		this.Root6 = root.getChild("Root6");
		this.Root5 = root.getChild("Root5");
		this.Root4 = root.getChild("Root4");
		this.Root3 = root.getChild("Root3");
		this.Root2 = root.getChild("Root2");
		this.Root1 = root.getChild("Root1");
		this.Root10 = root.getChild("Root10");
		this.Root12 = root.getChild("Root12");
		this.Root11 = root.getChild("Root11");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Root9", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 18.0F, -5.0F, 0.0F, 0.192F, -0.1047F));

		partdefinition.addOrReplaceChild("Root8", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 15.0F, -4.5F, 0.0F, 0.192F, -0.1047F));

		partdefinition.addOrReplaceChild("Root7", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 14.0F, -3.0F, 0.0F, 0.0F, -0.0873F));

		partdefinition.addOrReplaceChild("Root6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 14.0F, 3.0F, 0.0698F, 0.0F, 0.0698F));

		partdefinition.addOrReplaceChild("Root5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 20.0F, 2.0F));

		partdefinition.addOrReplaceChild("Root4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 21.0F, 4.0F));

		partdefinition.addOrReplaceChild("Root3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 14.0F, 5.8F, -0.2094F, 0.1047F, 0.0873F));

		partdefinition.addOrReplaceChild("Root2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, -4.0F));

		partdefinition.addOrReplaceChild("Root1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 21.0F, -6.0F));

		partdefinition.addOrReplaceChild("Root10", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 17.0F, 4.8F, -0.0698F, 0.1047F, 0.0873F));

		partdefinition.addOrReplaceChild("Root12", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 17.0F, 2.5F, 0.0698F, 0.0F, 0.0698F));

		partdefinition.addOrReplaceChild("Root11", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 18.0F, -3.5F, 0.0F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityRoot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Root9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}