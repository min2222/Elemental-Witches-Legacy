package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
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

public class ModelIcicle extends EntityModel<EntityIcicle>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "icicle"), "main");
	private final ModelPart O1;
	private final ModelPart O2;
	private final ModelPart O3;
	private final ModelPart O4;
	private final ModelPart O5;
	private final ModelPart O6;
	private final ModelPart I1;
	private final ModelPart O7;
	private final ModelPart I2;
	private final ModelPart M6;
	private final ModelPart I3;
	private final ModelPart I4;
	private final ModelPart I5;
	private final ModelPart E1;
	private final ModelPart I6;
	private final ModelPart I7;
	private final ModelPart I8;
	private final ModelPart BYE;
	private final ModelPart I9;
	private final ModelPart A2;
	private final ModelPart A3;
	private final ModelPart R1;
	private final ModelPart P3;
	private final ModelPart N1;
	private final ModelPart P4;
	private final ModelPart L1;
	private final ModelPart N3;
	private final ModelPart L3;
	private final ModelPart I10;
	private final ModelPart H1;
	private final ModelPart D1;
	private final ModelPart D4;
	private final ModelPart Y5;

	public ModelIcicle(ModelPart root) 
	{
		this.O1 = root.getChild("O1");
		this.O2 = root.getChild("O2");
		this.O3 = root.getChild("O3");
		this.O4 = root.getChild("O4");
		this.O5 = root.getChild("O5");
		this.O6 = root.getChild("O6");
		this.I1 = root.getChild("I1");
		this.O7 = root.getChild("O7");
		this.I2 = root.getChild("I2");
		this.M6 = root.getChild("M6");
		this.I3 = root.getChild("I3");
		this.I4 = root.getChild("I4");
		this.I5 = root.getChild("I5");
		this.E1 = root.getChild("E1");
		this.I6 = root.getChild("I6");
		this.I7 = root.getChild("I7");
		this.I8 = root.getChild("I8");
		this.BYE = root.getChild("BYE");
		this.I9 = root.getChild("I9");
		this.A2 = root.getChild("A2");
		this.A3 = root.getChild("A3");
		this.R1 = root.getChild("R1");
		this.P3 = root.getChild("P3");
		this.N1 = root.getChild("N1");
		this.P4 = root.getChild("P4");
		this.L1 = root.getChild("L1");
		this.N3 = root.getChild("N3");
		this.L3 = root.getChild("L3");
		this.I10 = root.getChild("I10");
		this.H1 = root.getChild("H1");
		this.D1 = root.getChild("D1");
		this.D4 = root.getChild("D4");
		this.Y5 = root.getChild("Y5");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("O1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.0F, 0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("O2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 13.0F, -3.0F, 0.0F, 0.0F, -0.2094F));

		partdefinition.addOrReplaceChild("O3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.0F, -2.0F, 0.0F, 0.0F, -0.2094F));

		partdefinition.addOrReplaceChild("O4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 6.0F, 0.0F, 0.0F, 0.5585F, 0.2094F));

		partdefinition.addOrReplaceChild("O5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 1.0F, 0.2443F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("O6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 22.0F, -5.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("I1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 13.0F, -4.0F, -0.2443F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("O7", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 21.4F, -6.0222F, 0.0F, 0.0F, -0.3316F));

		partdefinition.addOrReplaceChild("I2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 14.0F, -6.0F, 0.0F, -0.5585F, 0.2094F));

		partdefinition.addOrReplaceChild("M6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 22.0F, 5.0F));

		partdefinition.addOrReplaceChild("I3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 13.0F, -3.0F, 0.0F, 0.0F, 0.2094F));

		partdefinition.addOrReplaceChild("I4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 14.0F, -1.0F, 0.0F, -0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("I5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 7.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 13.0F, 3.0F, 0.2443F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("E1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 21.0F, 3.0F, 0.0F, 1.0123F, 1.0297F));

		partdefinition.addOrReplaceChild("I6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 14.0F, -4.4F, 0.0F, 0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("I7", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 14.0F, 0.0F, 0.0F, 0.5585F, 0.2094F));

		partdefinition.addOrReplaceChild("I8", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.0F, -2.0F, 0.0F, 0.0F, 0.3316F));

		partdefinition.addOrReplaceChild("BYE", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 22.0F, 5.0F, 0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("I9", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 6.0F, -3.0F, 0.0F, -0.5585F, 0.2793F));

		partdefinition.addOrReplaceChild("A2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 6.0F, 2.0F, 0.2443F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("A3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, 0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("R1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -1.0F, 0.0F, 0.0F, -0.2094F));

		partdefinition.addOrReplaceChild("P3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.3316F));

		partdefinition.addOrReplaceChild("N1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 21.0F, -6.0F, 0.0F, 0.0F, 0.3316F));

		partdefinition.addOrReplaceChild("P4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -1.0F, 0.0F, -0.8901F, 0.2793F));

		partdefinition.addOrReplaceChild("L1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 0.5585F, 0.2094F));

		partdefinition.addOrReplaceChild("N3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -0.4F, -0.8F, 0.0F, 0.0F, 0.8365F));

		partdefinition.addOrReplaceChild("L3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.0F, 0.0F, -0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("I10", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 6.0F, -2.0F, -0.2443F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("H1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.0F, -1.0F, 0.0F, -0.5585F, -0.2094F));

		partdefinition.addOrReplaceChild("D1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 22.0F, 5.0F, 0.0F, 0.0F, 0.384F));

		partdefinition.addOrReplaceChild("D4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 22.0F, -5.0F, 0.0F, 0.0F, 0.2269F));

		partdefinition.addOrReplaceChild("Y5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, -1.0F, -0.2443F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityIcicle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		O1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		O7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		M6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		E1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BYE.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		A2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		A3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		R1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		P3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		N1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		P4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		L1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		N3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		L3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		I10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		H1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		D1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		D4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Y5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}