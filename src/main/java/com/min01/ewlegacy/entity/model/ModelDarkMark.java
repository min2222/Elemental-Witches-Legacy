package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
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
import net.minecraft.world.entity.Entity;

public class ModelDarkMark<T extends Entity> extends EntityModel<T> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "dark_mark"), "main");
	private final ModelPart head1;

	public ModelDarkMark(ModelPart root)
	{
		this.head1 = root.getChild("head1");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 125).addBox(7.0F, -9.0F, -5.0F, 3.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -3.0F));

		head1.addOrReplaceChild("head1Child_7", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -25.0F, 2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2094F));

		head1.addOrReplaceChild("head1Child_1", CubeListBuilder.create().texOffs(0, 168).addBox(-10.0F, -9.0F, 10.0F, 20.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_5", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -18.0F, 0.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		head1.addOrReplaceChild("head1Child_6", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -14.0F, 0.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5061F));

		head1.addOrReplaceChild("head1Child_8", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -18.0F, 0.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		head1.addOrReplaceChild("head1Child_2", CubeListBuilder.create().texOffs(0, 83).addBox(-10.0F, -9.0F, -5.0F, 3.0F, 20.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_9", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -22.0F, 1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3142F));

		head1.addOrReplaceChild("head1Child", CubeListBuilder.create().texOffs(0, 197).addBox(-7.0F, -9.0F, -5.0F, 14.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_3", CubeListBuilder.create().texOffs(0, 48).addBox(-10.0F, -9.0F, -8.0F, 20.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		head1.addOrReplaceChild("head1Child_4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -14.0F, 0.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5061F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.head1.xRot = headPitch / 57.295776F;
        this.head1.yRot = netHeadYaw / 57.295776F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}