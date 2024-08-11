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
import net.minecraft.world.entity.LivingEntity;

public class ModelEgg<T extends LivingEntity> extends EntityModel<T>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "egg"), "main");
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;

	public ModelEgg(ModelPart root)
	{
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 10.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 11.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 12.0F, -4.5F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 22.0F, -4.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 23.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}