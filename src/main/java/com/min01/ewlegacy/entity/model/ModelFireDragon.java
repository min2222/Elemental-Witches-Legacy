package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityFireDragon;
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

public class ModelFireDragon extends EntityModel<EntityFireDragon> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "fire_dragon"), "main");
    public float floatingRotation;
	private final ModelPart leftlegup;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart tail1;
	private final ModelPart leftlegbackup;
	private final ModelPart rightlegbackup;
	private final ModelPart body1;
	private final ModelPart rightlegup;
	private final ModelPart head1;

	public ModelFireDragon(ModelPart root) 
	{
		this.leftlegup = root.getChild("leftlegup");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.tail1 = root.getChild("tail1");
		this.leftlegbackup = root.getChild("leftlegbackup");
		this.rightlegbackup = root.getChild("rightlegbackup");
		this.body1 = root.getChild("body1");
		this.rightlegup = root.getChild("rightlegup");
		this.head1 = root.getChild("head1");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leftlegup = partdefinition.addOrReplaceChild("leftlegup", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 12.0F, 0.0F));

		leftlegup.addOrReplaceChild("leftlegupChild", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 10.0F, 3.0F, -0.1222F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4867F, 9.0F, 1.0F));

		PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(61, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.0F, 6.0F, 0.0F, -6.02F, 0.0F));

		tail1.addOrReplaceChild("tail1Child_2", CubeListBuilder.create().texOffs(34, 22).addBox(0.0F, -2.0F, 6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		tail1.addOrReplaceChild("tail1Child_1", CubeListBuilder.create().texOffs(26, 23).addBox(0.0F, -1.0F, 5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		tail1.addOrReplaceChild("tail1Child", CubeListBuilder.create().texOffs(15, 22).addBox(0.0F, 1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2443F, 0.0F, 0.0F));

		PartDefinition leftlegbackup = partdefinition.addOrReplaceChild("leftlegbackup", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 4.5F));

		leftlegbackup.addOrReplaceChild("leftlegbackupChild", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		PartDefinition rightlegbackup = partdefinition.addOrReplaceChild("rightlegbackup", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 4.5F));

		rightlegbackup.addOrReplaceChild("rightlegbackupChild", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition rightlegup = partdefinition.addOrReplaceChild("rightlegup", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, 0.0F));

		rightlegup.addOrReplaceChild("rightlegupChild", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6807F, 0.0F, 0.0F));

		PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(26, 10).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 10.0F, -1.0F));

		head1.addOrReplaceChild("head1Child_1", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1571F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_5", CubeListBuilder.create().texOffs(11, 6).addBox(-0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_2", CubeListBuilder.create().texOffs(10, 27).addBox(2.5F, -1.0F, 2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4712F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_3", CubeListBuilder.create().texOffs(10, 27).addBox(-3.5F, -1.0F, 2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4712F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_4", CubeListBuilder.create().texOffs(11, 0).addBox(-1.5F, -3.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -2.0F, -3.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0524F, 0.7854F, 0.0524F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(EntityFireDragon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.floatingRotation += 0.02F;
        this.head1.xRot = headPitch / 57.295776F;
        this.head1.yRot = netHeadYaw / 57.295776F;
        this.leftlegup.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightlegup.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.rightlegbackup.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegbackup.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.tail1.yRot = -6.0F - Math.abs((float)Math.sin((double)this.floatingRotation) * 0.5F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		leftlegup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegbackup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegbackup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegup.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}