package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;
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

public class ModelLightningGolem extends EntityModel<EntityLightningGolem> 
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "lightning_golem"), "main");
	private final ModelPart Shoulder_Blade_Right_1;
	private final ModelPart Shoulder_Blade_Right_2;
	private final ModelPart Jaw;
	private final ModelPart Spine_2;
	private final ModelPart Spine_1;
	private final ModelPart Rib_4;
	private final ModelPart Shoulder_Blade_Left_1;
	private final ModelPart Arm_Left_1;
	private final ModelPart Chestbone;
	private final ModelPart Arm_Left_2;
	private final ModelPart Vertebra_2;
	private final ModelPart Shoulder_Blade_Left_2;
	private final ModelPart Vertebra_3;
	private final ModelPart Rib_1;
	private final ModelPart Shoulder_Right;
	private final ModelPart Torso_Top;
	private final ModelPart Vertebra_4;
	private final ModelPart Rib_2;
	private final ModelPart Head_2;
	private final ModelPart Vertebra_5;
	private final ModelPart Rib_3;
	private final ModelPart Head_1;
	private final ModelPart Arm_Right_1;
	private final ModelPart Vertebra_6;
	private final ModelPart Arm_Right_2;
	private final ModelPart Head_3;
	private final ModelPart Vertebra_1;
	private final ModelPart Shoulder_Left;
	private final ModelPart Detail_3;
	private final ModelPart Detail_2;
	private final ModelPart Detail_1;

	public ModelLightningGolem(ModelPart root)
	{
		this.Shoulder_Blade_Right_1 = root.getChild("Shoulder_Blade_Right_1");
		this.Shoulder_Blade_Right_2 = root.getChild("Shoulder_Blade_Right_2");
		this.Jaw = root.getChild("Jaw");
		this.Spine_2 = root.getChild("Spine_2");
		this.Spine_1 = root.getChild("Spine_1");
		this.Rib_4 = root.getChild("Rib_4");
		this.Shoulder_Blade_Left_1 = root.getChild("Shoulder_Blade_Left_1");
		this.Arm_Left_1 = root.getChild("Arm_Left_1");
		this.Chestbone = root.getChild("Chestbone");
		this.Arm_Left_2 = root.getChild("Arm_Left_2");
		this.Vertebra_2 = root.getChild("Vertebra_2");
		this.Shoulder_Blade_Left_2 = root.getChild("Shoulder_Blade_Left_2");
		this.Vertebra_3 = root.getChild("Vertebra_3");
		this.Rib_1 = root.getChild("Rib_1");
		this.Shoulder_Right = root.getChild("Shoulder_Right");
		this.Torso_Top = root.getChild("Torso_Top");
		this.Vertebra_4 = root.getChild("Vertebra_4");
		this.Rib_2 = root.getChild("Rib_2");
		this.Head_2 = root.getChild("Head_2");
		this.Vertebra_5 = root.getChild("Vertebra_5");
		this.Rib_3 = root.getChild("Rib_3");
		this.Head_1 = root.getChild("Head_1");
		this.Arm_Right_1 = root.getChild("Arm_Right_1");
		this.Vertebra_6 = root.getChild("Vertebra_6");
		this.Arm_Right_2 = root.getChild("Arm_Right_2");
		this.Head_3 = root.getChild("Head_3");
		this.Vertebra_1 = root.getChild("Vertebra_1");
		this.Shoulder_Left = root.getChild("Shoulder_Left");
		this.Detail_3 = root.getChild("Detail_3");
		this.Detail_2 = root.getChild("Detail_2");
		this.Detail_1 = root.getChild("Detail_1");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shoulder_Blade_Right_1", CubeListBuilder.create().texOffs(24, 19).addBox(-10.0F, 3.0F, 9.0F, 9.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shoulder_Blade_Right_2", CubeListBuilder.create().texOffs(21, 33).addBox(-8.0F, 14.0F, 9.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(80, 25).addBox(-3.0F, -4.0F, -2.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -3.0F, 0.1859F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Spine_2", CubeListBuilder.create().texOffs(13, 40).addBox(-1.5F, 15.0F, 8.6F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.0372F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Spine_1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, -1.0F, 7.5F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Rib_4", CubeListBuilder.create().texOffs(0, 104).addBox(-6.0F, 19.0F, 2.0F, 12.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.0372F, -0.1859F, -0.1115F));

		partdefinition.addOrReplaceChild("Shoulder_Blade_Left_1", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 3.0F, 9.0F, 9.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Arm_Left_1", CubeListBuilder.create().texOffs(163, 14).addBox(-1.5F, 2.0F, -1.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -16.0F, 2.0F, 0.0F, 0.0F, -0.1859F));

		partdefinition.addOrReplaceChild("Chestbone", CubeListBuilder.create().texOffs(28, 40).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.2231F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Arm_Left_2", CubeListBuilder.create().texOffs(167, 29).addBox(0.5F, 11.0F, -1.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -16.0F, 2.0F));

		partdefinition.addOrReplaceChild("Vertebra_2", CubeListBuilder.create().texOffs(21, 61).addBox(-3.0F, 4.0F, 10.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shoulder_Blade_Left_2", CubeListBuilder.create().texOffs(0, 33).addBox(1.0F, 14.0F, 9.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Vertebra_3", CubeListBuilder.create().texOffs(40, 61).addBox(-2.5F, 8.0F, 10.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Rib_1", CubeListBuilder.create().texOffs(0, 66).addBox(-10.0F, 6.0F, -1.0F, 20.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shoulder_Right", CubeListBuilder.create().texOffs(145, 0).addBox(-3.0F, -3.0F, -3.0F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -16.0F, 2.0F, 0.0F, 0.0F, 0.2231F));

		partdefinition.addOrReplaceChild("Torso_Top", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5F, -1.0F, -2.0F, 21.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1487F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Vertebra_4", CubeListBuilder.create().texOffs(58, 61).addBox(-2.0F, 12.0F, 10.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Rib_2", CubeListBuilder.create().texOffs(0, 79).addBox(-10.0F, 10.0F, -1.0F, 20.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head_2", CubeListBuilder.create().texOffs(80, 17).addBox(-4.5F, -3.0F, 2.5F, 9.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -3.0F, 0.1859F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Vertebra_5", CubeListBuilder.create().texOffs(73, 61).addBox(-1.5F, 16.0F, 10.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.0744F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Rib_3", CubeListBuilder.create().texOffs(0, 92).addBox(-8.0F, 14.0F, 0.0F, 16.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head_1", CubeListBuilder.create().texOffs(80, 0).addBox(-5.0F, -10.0F, -2.0F, 10.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -3.0F, 0.1859F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Arm_Right_1", CubeListBuilder.create().texOffs(145, 14).addBox(-2.5F, 2.0F, -1.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -16.0F, 2.0F, 0.0F, 0.0F, 0.1859F));

		partdefinition.addOrReplaceChild("Vertebra_6", CubeListBuilder.create().texOffs(85, 61).addBox(-1.5F, -2.0F, 5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.2974F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Arm_Right_2", CubeListBuilder.create().texOffs(145, 29).addBox(-5.5F, 11.0F, -1.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -16.0F, 2.0F));

		partdefinition.addOrReplaceChild("Head_3", CubeListBuilder.create().texOffs(109, 17).addBox(-1.0F, -10.5F, -3.0F, 2.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -3.0F, 0.1859F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Vertebra_1", CubeListBuilder.create().texOffs(0, 61).addBox(-3.5F, 0.0F, 10.5F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 0.1115F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shoulder_Left", CubeListBuilder.create().texOffs(171, 0).addBox(-2.0F, -3.0F, -3.0F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -16.0F, 2.0F, 0.0F, 0.0F, -0.2231F));

		partdefinition.addOrReplaceChild("Detail_3", CubeListBuilder.create().texOffs(104, 74).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8667F, 21.0F, 3.0F, -0.409F, 0.3346F, 0.0F));

		partdefinition.addOrReplaceChild("Detail_2", CubeListBuilder.create().texOffs(87, 73).addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 17.0F, 4.0F, 0.1859F, -0.2603F, 0.0F));

		partdefinition.addOrReplaceChild("Detail_1", CubeListBuilder.create().texOffs(63, 71).addBox(-2.0F, -1.0F, -2.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 11.0F, 3.0F, -0.1487F, 0.0372F, 0.3718F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(EntityLightningGolem entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		Shoulder_Blade_Right_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shoulder_Blade_Right_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Spine_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Spine_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rib_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shoulder_Blade_Left_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_Left_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Chestbone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_Left_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shoulder_Blade_Left_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rib_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shoulder_Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso_Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rib_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rib_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_Right_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_Right_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Vertebra_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shoulder_Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Detail_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Detail_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Detail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}