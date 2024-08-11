package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityEnt;
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

public class ModelEnt extends EntityModel<EntityEnt>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "ent"), "main");
	private final ModelPart LeftArm1;
	private final ModelPart Body4;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart LeftLeg1;
	private final ModelPart RightArm1;
	private final ModelPart RightLeg1;
	private final ModelPart Body1;

	public ModelEnt(ModelPart root) 
	{
		this.LeftArm1 = root.getChild("LeftArm1");
		this.Body4 = root.getChild("Body4");
		this.Body2 = root.getChild("Body2");
		this.Body3 = root.getChild("Body3");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.RightArm1 = root.getChild("RightArm1");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Body1 = root.getChild("Body1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftArm1 = partdefinition.addOrReplaceChild("LeftArm1", CubeListBuilder.create().texOffs(56, 0).addBox(3.0F, -2.0F, -4.0F, 10.0F, 23.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -12.0F, 0.0F));

		LeftArm1.addOrReplaceChild("LeftArm1Child_2", CubeListBuilder.create().texOffs(56, 0).addBox(7.0F, -13.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5585F, -0.2094F, 0.576F));

		LeftArm1.addOrReplaceChild("LeftArm1Child", CubeListBuilder.create().texOffs(56, 0).addBox(7.0F, -13.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, -0.6458F, 0.1222F));

		LeftArm1.addOrReplaceChild("LeftArm1Child_1", CubeListBuilder.create().texOffs(56, 0).addBox(7.0F, -13.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4189F, -0.2094F, 0.2618F));

		partdefinition.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(32, 16).addBox(-8.0F, 0.0F, -2.0F, 9.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.1571F, 0.1571F, 0.0175F));

		partdefinition.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(32, 16).addBox(-8.0F, 0.0F, -2.0F, 9.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.2618F, 0.8552F, -0.3142F));

		partdefinition.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(32, 16).addBox(-8.0F, 0.0F, -2.0F, 9.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.1571F, 2.3038F, 0.0175F));

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(56, 0).addBox(2.0F, 12.0F, -1.0F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 0.0F));

		LeftLeg1.addOrReplaceChild("LeftLeg1Child", CubeListBuilder.create().texOffs(56, 0).addBox(1.5F, 19.0F, -3.5F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm1 = partdefinition.addOrReplaceChild("RightArm1", CubeListBuilder.create().texOffs(56, 0).addBox(-11.0F, -2.0F, -4.0F, 8.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -12.0F, 0.0F));

		RightArm1.addOrReplaceChild("RightArm1Child", CubeListBuilder.create().texOffs(56, 0).addBox(-11.0F, 7.0F, 7.0F, 8.0F, 21.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(56, 0).addBox(-5.0F, 12.0F, -1.0F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 0.0F));

		RightLeg1.addOrReplaceChild("RightLeg1Child", CubeListBuilder.create().texOffs(56, 0).addBox(-5.5F, 19.0F, -3.5F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(32, 16).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.192F, 0.0F, -0.2967F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityEnt entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
        this.RightLeg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LeftLeg1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
	}
	
	@Override
	public void prepareMobModel(EntityEnt p_102957_, float p_102958_, float p_102959_, float p_102960_) 
	{
		int i = p_102957_.getAttackTimer();
		if(i > 0) 
		{
			this.RightArm1.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - p_102960_, 10.0F);
			this.LeftArm1.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - p_102960_, 10.0F);
		}
		else
		{
			this.RightArm1.xRot = (-0.2F + 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
			this.LeftArm1.xRot = (-0.2F - 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		LeftArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}