package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityHalloweenPumpking;
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

public class ModelHalloweenPumpking extends EntityModel<EntityHalloweenPumpking> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "halloween_pumpking"), "main");
	private final ModelPart jaw;
	private final ModelPart legleft1;
	private final ModelPart legleft2;
	private final ModelPart spine3;
	private final ModelPart armright2;
	private final ModelPart armright1;
	private final ModelPart clothes;
	private final ModelPart legright2;
	private final ModelPart armleft1;
	private final ModelPart legright1;
	private final ModelPart armleft2;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart head1;
	private final ModelPart head2;
	private final ModelPart teeth;
	private final ModelPart torso2;
	private final ModelPart torso1;

	public ModelHalloweenPumpking(ModelPart root)
	{
		this.jaw = root.getChild("jaw");
		this.legleft1 = root.getChild("legleft1");
		this.legleft2 = root.getChild("legleft2");
		this.spine3 = root.getChild("spine3");
		this.armright2 = root.getChild("armright2");
		this.armright1 = root.getChild("armright1");
		this.clothes = root.getChild("clothes");
		this.legright2 = root.getChild("legright2");
		this.armleft1 = root.getChild("armleft1");
		this.legright1 = root.getChild("legright1");
		this.armleft2 = root.getChild("armleft2");
		this.spine1 = root.getChild("spine1");
		this.spine2 = root.getChild("spine2");
		this.head1 = root.getChild("head1");
		this.head2 = root.getChild("head2");
		this.teeth = root.getChild("teeth");
		this.torso2 = root.getChild("torso2");
		this.torso1 = root.getChild("torso1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(40, 28).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 2.0F));

		partdefinition.addOrReplaceChild("legleft1", CubeListBuilder.create().texOffs(89, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 7.0F, 0.0F, -0.0374F, -0.1297F, -0.0374F));

		partdefinition.addOrReplaceChild("legleft2", CubeListBuilder.create().texOffs(89, 33).addBox(-0.7F, 1.0F, -1.3F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine3", CubeListBuilder.create().texOffs(18, 29).addBox(-1.0F, -2.0F, 4.7F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -3.0F, 0.2231F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("armright2", CubeListBuilder.create().texOffs(89, 0).addBox(-1.8F, 0.0F, -1.2F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("armright1", CubeListBuilder.create().texOffs(80, 0).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -8.0F, 1.0F, 0.1122F, 0.0F, 0.2992F));

		partdefinition.addOrReplaceChild("clothes", CubeListBuilder.create().texOffs(0, 40).addBox(-4.0F, 16.4F, 0.4F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.0F));

		partdefinition.addOrReplaceChild("legright2", CubeListBuilder.create().texOffs(80, 33).addBox(-1.3F, 1.0F, -1.3F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("armleft1", CubeListBuilder.create().texOffs(80, 11).addBox(-0.5F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -8.0F, 1.0F, 0.1122F, 0.0F, -0.2992F));

		partdefinition.addOrReplaceChild("legright1", CubeListBuilder.create().texOffs(80, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 7.0F, 0.0F, -0.0374F, 0.0947F, 0.0374F));

		partdefinition.addOrReplaceChild("armleft2", CubeListBuilder.create().texOffs(89, 11).addBox(-0.2F, 0.0F, -1.2F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, 8.4F, 4.4F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.0F));

		partdefinition.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(9, 29).addBox(-1.0F, 0.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -3.0F, -0.0744F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -7.4667F, -6.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 2.0F));

		partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(40, 14).addBox(-3.5F, -2.5F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 2.0F));

		partdefinition.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(40, 22).addBox(-3.0F, -2.5F, -6.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 2.0F));

		partdefinition.addOrReplaceChild("torso2", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, 8.4F, 0.4F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.0F));

		partdefinition.addOrReplaceChild("torso1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -3.0F, -0.0744F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityHalloweenPumpking entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.head1.yRot = netHeadYaw / 57.295776F;
        this.head1.xRot = headPitch / 57.295776F;
        this.head2.yRot = this.head1.yRot;
        this.head2.xRot = this.head1.xRot;
        this.teeth.yRot = this.head1.yRot;
        this.teeth.xRot = this.head1.xRot;
        this.jaw.yRot = this.head1.yRot;
        this.jaw.xRot = this.head1.xRot;
        this.armright2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.armleft2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.legright2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legleft2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legleft1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legleft2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armright2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armright1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		clothes.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legright2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armleft1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legright1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armleft2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		spine2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		teeth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}