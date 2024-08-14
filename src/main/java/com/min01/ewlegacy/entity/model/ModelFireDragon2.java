package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.pet.EntityFireDragon2;
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

public class ModelFireDragon2 extends EntityModel<EntityFireDragon2>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "fire_dragon2"), "main");
    public float floatingRotation;
	private final ModelPart Back_Torso;
	private final ModelPart Front_Right_Shoulder;
	private final ModelPart Front_Left_Shoulder;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Back_Left_Shoulder;
	private final ModelPart Fire_Tail_1;
	private final ModelPart Back_Right_Shoulder;
	private final ModelPart Front_Torso;
	private final ModelPart Fire_Mane_2;
	private final ModelPart Fire_Mane_4;
	private final ModelPart Fire_Mane_3;

	public ModelFireDragon2(ModelPart root) 
	{
		this.Back_Torso = root.getChild("Back_Torso");
		this.Front_Right_Shoulder = root.getChild("Front_Right_Shoulder");
		this.Front_Left_Shoulder = root.getChild("Front_Left_Shoulder");
		this.Neck = root.getChild("Neck");
		this.Head = root.getChild("Head");
		this.Back_Left_Shoulder = root.getChild("Back_Left_Shoulder");
		this.Fire_Tail_1 = root.getChild("Fire_Tail_1");
		this.Back_Right_Shoulder = root.getChild("Back_Right_Shoulder");
		this.Front_Torso = root.getChild("Front_Torso");
		this.Fire_Mane_2 = root.getChild("Fire_Mane_2");
		this.Fire_Mane_4 = root.getChild("Fire_Mane_4");
		this.Fire_Mane_3 = root.getChild("Fire_Mane_3");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Back_Torso", CubeListBuilder.create().texOffs(38, 24).addBox(-4.0F, 1.0F, 9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Front_Right_Shoulder = partdefinition.addOrReplaceChild("Front_Right_Shoulder", CubeListBuilder.create().texOffs(82, 41).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 14.0F, 3.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild", CubeListBuilder.create().texOffs(82, 47).addBox(-3.0F, 0.5F, 1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Front_Right_Shoulder.addOrReplaceChild("Front_Right_ShoulderChild_1", CubeListBuilder.create().texOffs(81, 58).addBox(-3.0F, 8.0F, -2.3F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Front_Left_Shoulder = partdefinition.addOrReplaceChild("Front_Left_Shoulder", CubeListBuilder.create().texOffs(68, 41).addBox(0.0F, -1.5F, -1.5333F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 14.0F, 3.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild", CubeListBuilder.create().texOffs(68, 47).addBox(0.0F, 0.5F, 1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Front_Left_Shoulder.addOrReplaceChild("Front_Left_ShoulderChild_1", CubeListBuilder.create().texOffs(67, 58).addBox(0.0F, 8.0F, -2.3F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(72, 13).addBox(-2.0F, -2.3F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(84, 5).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_2", CubeListBuilder.create().texOffs(108, 26).addBox(-1.2F, -3.5F, -3.8F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_5", CubeListBuilder.create().texOffs(114, 0).addBox(-2.0F, -4.5F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_1", CubeListBuilder.create().texOffs(108, 17).addBox(-1.1F, -7.5F, -3.9F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		Head.addOrReplaceChild("HeadChild_3", CubeListBuilder.create().texOffs(120, 0).addBox(-3.5F, -13.0F, 0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_8", CubeListBuilder.create().texOffs(76, 0).addBox(1.0F, -4.5F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild", CubeListBuilder.create().texOffs(56, 15).addBox(-2.5F, -5.0F, 4.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_4", CubeListBuilder.create().texOffs(106, 0).addBox(-2.5F, -5.0F, 4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_7", CubeListBuilder.create().texOffs(78, 0).addBox(0.5F, -5.0F, 4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadChild_6", CubeListBuilder.create().texOffs(72, 0).addBox(2.5F, -13.0F, 0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_9", CubeListBuilder.create().texOffs(61, 6).addBox(-2.0F, -10.0F, -7.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3963F, 0.0F, 0.0F));

		Head.addOrReplaceChild("HeadChild_10", CubeListBuilder.create().texOffs(52, 1).addBox(-1.5F, -15.0F, -8.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

		PartDefinition Back_Left_Shoulder = partdefinition.addOrReplaceChild("Back_Left_Shoulder", CubeListBuilder.create().texOffs(40, 43).addBox(0.0F, -1.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 17.0F, 15.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild", CubeListBuilder.create().texOffs(40, 49).addBox(0.0F, 0.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Back_Left_Shoulder.addOrReplaceChild("Back_Left_ShoulderChild_1", CubeListBuilder.create().texOffs(39, 58).addBox(0.0F, 5.0F, -3.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Fire_Tail_1 = partdefinition.addOrReplaceChild("Fire_Tail_1", CubeListBuilder.create().texOffs(14, 27).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 17.0F, 0.0F, -6.02F, 0.0F));

		Fire_Tail_1.addOrReplaceChild("Fire_Tail_1Child_4", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -4.0F, 7.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Fire_Tail_1.addOrReplaceChild("Fire_Tail_1Child", CubeListBuilder.create().texOffs(13, 42).addBox(-4.0F, -4.0F, 0.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Fire_Tail_1.addOrReplaceChild("Fire_Tail_1Child_1", CubeListBuilder.create().texOffs(20, 22).addBox(-1.5F, -7.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		Fire_Tail_1.addOrReplaceChild("Fire_Tail_1Child_3", CubeListBuilder.create().texOffs(6, 25).addBox(-2.5F, -4.0F, 5.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		Fire_Tail_1.addOrReplaceChild("Fire_Tail_1Child_2", CubeListBuilder.create().texOffs(15, 20).addBox(-1.0F, -8.0F, 5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Back_Right_Shoulder = partdefinition.addOrReplaceChild("Back_Right_Shoulder", CubeListBuilder.create().texOffs(54, 43).addBox(-3.0F, -1.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 17.0F, 15.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild_1", CubeListBuilder.create().texOffs(53, 58).addBox(-3.0F, 5.0F, -3.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Back_Right_Shoulder.addOrReplaceChild("Back_Right_ShoulderChild", CubeListBuilder.create().texOffs(54, 49).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Front_Torso", CubeListBuilder.create().texOffs(70, 21).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.0524F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fire_Mane_2", CubeListBuilder.create().texOffs(38, 12).addBox(-3.0F, -13.0F, -2.0F, 6.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -1.7104F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fire_Mane_4", CubeListBuilder.create().texOffs(25, 7).addBox(-2.5F, -16.0F, -7.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -2.0595F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Fire_Mane_3", CubeListBuilder.create().texOffs(38, 5).addBox(-1.0F, -7.0F, 7.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityFireDragon2 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        this.floatingRotation += 0.02F;
        this.Head.xRot = headPitch / 57.295776F;
        this.Head.yRot = netHeadYaw / 57.295776F;
        this.Front_Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Front_Right_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Back_Right_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Back_Left_Shoulder.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.Fire_Tail_1.yRot = -6.0F - Math.abs((float)Math.sin((double)this.floatingRotation) * 0.5F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Back_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Right_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Left_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fire_Tail_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back_Right_Shoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Front_Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fire_Mane_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fire_Mane_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fire_Mane_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}