package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntitySandGolem;
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

public class ModelSandGolem extends EntityModel<EntitySandGolem> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "sand_golem"), "main");
	private final ModelPart Shape18;
	private final ModelPart Shape19;
	private final ModelPart Shape10;
	private final ModelPart Shape21;
	private final ModelPart Shape11;
	private final ModelPart Shape12;
	private final ModelPart Shape13;
	private final ModelPart Shape14;
	private final ModelPart Shape15;
	private final ModelPart Shape16;
	private final ModelPart Shape17;
	private final ModelPart Shape9;
	private final ModelPart Shape20;
	private final ModelPart Shape2;
	private final ModelPart Shape1;
	private final ModelPart Shape4;
	private final ModelPart Shape3;
	private final ModelPart Shape6;
	private final ModelPart Shape5;
	private final ModelPart Shape8;
	private final ModelPart Shape7;
	
	private EntitySandGolem entity;

	public ModelSandGolem(ModelPart root) 
	{
		Shape18 = root.getChild("Shape18");
		Shape19 = root.getChild("Shape19");
		Shape10 = root.getChild("Shape10");
		Shape21 = root.getChild("Shape21");
		Shape11 = root.getChild("Shape11");
		Shape12 = root.getChild("Shape12");
		Shape13 = root.getChild("Shape13");
		Shape14 = root.getChild("Shape14");
		Shape15 = root.getChild("Shape15");
		Shape16 = root.getChild("Shape16");
		Shape17 = root.getChild("Shape17");
		Shape9 = root.getChild("Shape9");
		Shape20 = root.getChild("Shape20");
		Shape2 = root.getChild("Shape2");
		Shape1 = root.getChild("Shape1");
		Shape4 = root.getChild("Shape4");
		Shape3 = root.getChild("Shape3");
		Shape6 = root.getChild("Shape6");
		Shape5 = root.getChild("Shape5");
		Shape8 = root.getChild("Shape8");
		Shape7 = root.getChild("Shape7");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape18", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(24.0F, -48.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape19", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(24.0F, -32.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -32.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape21", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 10.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -32.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -32.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -32.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -64.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -48.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -48.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -16.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape20", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -32.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -48.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -16.0F, 8.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -16.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 10.0F, -8.0F));

		partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -16.0F, 8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntitySandGolem entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        Shape1.yRot = entity.getFloatingRotation();
        Shape2.yRot = entity.getFloatingRotation();
        Shape5.yRot = entity.getFloatingRotation();
        Shape8.yRot = entity.getFloatingRotation();
        Shape21.yRot = entity.getFloatingRotation();
        Shape1.yRot = ageInTicks / 4.0F;
        Shape1.xRot = ageInTicks / 17.0F;
        Shape1.zRot = ageInTicks / 21.0F;
        Shape2.yRot = ageInTicks / 12.0F;
        Shape2.xRot = ageInTicks / 14.0F;
        Shape2.zRot = ageInTicks / 5.0F;
        Shape3.yRot = ageInTicks / 4.0F;
        Shape3.xRot = ageInTicks / 7.0F;
        Shape3.zRot = ageInTicks / 2.0F;
        Shape4.zRot = ageInTicks / 22.0F;
        Shape5.yRot = ageInTicks / 15.0F;
        Shape5.xRot = ageInTicks / 16.0F;
        Shape5.zRot = ageInTicks / 13.0F;
        Shape6.zRot = ageInTicks / 15.0F;
        Shape7.xRot = ageInTicks / 11.0F;
        Shape7.zRot = ageInTicks / 8.0F;
        Shape8.yRot = ageInTicks / 8.0F;
        Shape8.xRot = ageInTicks / 23.0F;
        Shape8.zRot = ageInTicks / 5.0F;
        Shape9.xRot = ageInTicks / 23.0F;
        Shape9.zRot = ageInTicks / 5.0F;
        Shape10.yRot = ageInTicks / 19.0F;
        Shape10.xRot = ageInTicks / 13.0F;
        Shape11.yRot = ageInTicks / 4.0F;
        Shape11.xRot = ageInTicks / 36.0F;
        Shape12.xRot = ageInTicks / 14.0F;
        Shape12.zRot = ageInTicks / 5.0F;
        Shape13.yRot = ageInTicks / 4.0F;
        Shape13.xRot = ageInTicks / 7.0F;
        Shape13.zRot = ageInTicks / 2.0F;
        Shape15.yRot = ageInTicks / 15.0F;
        Shape15.zRot = ageInTicks / 13.0F;
        Shape16.yRot = ageInTicks / 24.0F;
        Shape16.xRot = ageInTicks / 11.0F;
        Shape16.zRot = ageInTicks / 15.0F;
        Shape17.xRot = ageInTicks / 11.0F;
        Shape17.zRot = ageInTicks / 8.0F;
        Shape18.yRot = ageInTicks / 8.0F;
        Shape18.zRot = ageInTicks / 5.0F;
        Shape19.yRot = ageInTicks / 24.0F;
        Shape19.xRot = ageInTicks / 23.0F;
        Shape19.zRot = ageInTicks / 5.0F;
        Shape20.yRot = ageInTicks / 19.0F;
        Shape20.xRot = ageInTicks / 13.0F;
        Shape21.yRot = ageInTicks / 4.0F;
        Shape21.zRot = ageInTicks / 7.0F;
        this.entity = entity;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		if(this.entity.getHealth() == this.entity.getMaxHealth())
		{
			Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
		else if(this.entity.getHealth() >= 90.0F && this.entity.getHealth() < 100.0F)
		{
			Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
		else if(this.entity.getHealth() >= 80.0F && this.entity.getHealth() < 90.0F) 
		{
            Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 70.0F && this.entity.getHealth() < 80.0F) 
        {
            Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
        else if(this.entity.getHealth() >= 60.0F && this.entity.getHealth() < 70.0F)
        {
            Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 50.0F && this.entity.getHealth() < 60.0F)
        {
            Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 40.0F && this.entity.getHealth() < 50.0F) 
        {
            Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 30.0F && this.entity.getHealth() < 40.0F)
        {
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 20.0F && this.entity.getHealth() < 30.0F) 
        {
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape21.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 10.0F && this.entity.getHealth() < 20.0F)
        {
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Shape17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } 
        else if(this.entity.getHealth() >= 0.0F && this.entity.getHealth() < 10.0F)
        {
            Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
	}
}