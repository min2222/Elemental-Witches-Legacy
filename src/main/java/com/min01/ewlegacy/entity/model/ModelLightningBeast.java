package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast;
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

public class ModelLightningBeast extends EntityModel<EntityLightningBeast> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "lightning_beast"), "main");
    public float floatingRotation;
	private final ModelPart leftlegup;
	private final ModelPart body2;
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart leftlegbackup;
	private final ModelPart rightlegbackup;
	private final ModelPart rightlegup;
	private final ModelPart wing1;
	private final ModelPart head1;
	private final ModelPart wing2;

	public ModelLightningBeast(ModelPart root)
	{
		this.leftlegup = root.getChild("leftlegup");
		this.body2 = root.getChild("body2");
		this.body = root.getChild("body");
		this.tail1 = root.getChild("tail1");
		this.leftlegbackup = root.getChild("leftlegbackup");
		this.rightlegbackup = root.getChild("rightlegbackup");
		this.rightlegup = root.getChild("rightlegup");
		this.wing1 = root.getChild("wing1");
		this.head1 = root.getChild("head1");
		this.wing2 = root.getChild("wing2");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leftlegup = partdefinition.addOrReplaceChild("leftlegup", CubeListBuilder.create().texOffs(11, 25).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 11.5F, 0.0F));

		leftlegup.addOrReplaceChild("leftlegupChild", CubeListBuilder.create().texOffs(6, 3).addBox(0.5F, 1.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(56, 10).addBox(0.0F, 0.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 10.0F, 3.0F, -0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(34, 17).addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(38, 8).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 11.0F, 6.0F, -5.02F, 0.0F, 0.0F));

		tail1.addOrReplaceChild("tail1Child_1", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, 2.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		tail1.addOrReplaceChild("tail1Child", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftlegbackup = partdefinition.addOrReplaceChild("leftlegbackup", CubeListBuilder.create().texOffs(11, 6).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 4.5F));

		leftlegbackup.addOrReplaceChild("leftlegbackupChild", CubeListBuilder.create().texOffs(6, 3).addBox(0.0F, 1.0F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		PartDefinition rightlegbackup = partdefinition.addOrReplaceChild("rightlegbackup", CubeListBuilder.create().texOffs(11, 6).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 4.5F));

		rightlegbackup.addOrReplaceChild("rightlegbackupChild", CubeListBuilder.create().texOffs(6, 3).addBox(0.0F, 0.5F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		PartDefinition rightlegup = partdefinition.addOrReplaceChild("rightlegup", CubeListBuilder.create().texOffs(11, 25).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 11.5F, 0.0F));

		rightlegup.addOrReplaceChild("rightlegupChild", CubeListBuilder.create().texOffs(6, 3).addBox(-0.5F, 1.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(22, 21).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 11.0F, 2.0F));

		PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 10.0F, -1.0F));

		head1.addOrReplaceChild("head1Child_9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_6", CubeListBuilder.create().texOffs(14, 21).addBox(2.5F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.192F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_4", CubeListBuilder.create().texOffs(41, 0).addBox(-1.5F, -3.0F, 1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_2", CubeListBuilder.create().texOffs(14, 21).addBox(2.5F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2967F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_8", CubeListBuilder.create().texOffs(36, 0).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_7", CubeListBuilder.create().texOffs(14, 21).addBox(-3.5F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.192F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 1.0F, -4.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1571F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_3", CubeListBuilder.create().texOffs(14, 21).addBox(-3.5F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2967F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_5", CubeListBuilder.create().texOffs(22, 9).addBox(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(22, 21).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityLightningBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.floatingRotation += 0.02F;
        this.head1.xRot = headPitch / 57.295776F;
        this.head1.yRot = netHeadYaw / 57.295776F;
        this.leftlegup.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightlegup.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.rightlegbackup.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegbackup.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.tail1.xRot = -5.0F - Math.abs((float)Math.sin((double)this.floatingRotation) * 0.5F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		leftlegup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegbackup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegbackup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}