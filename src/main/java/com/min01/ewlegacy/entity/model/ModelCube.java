package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.skill.EntityExplosivePumpkin;
import com.min01.ewlegacy.entity.skill.EntityFireMeteorite;
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

public class ModelCube<T extends Entity> extends EntityModel<T>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ElementalWitchesLegacy.MODID, "cube"), "main");
	private final ModelPart Shape1;

	public ModelCube(ModelPart root)
	{
		this.Shape1 = root.getChild("Shape1");
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-24.0F, -24.0F, -24.0F, 48.0F, 48.0F, 48.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
        if(entity instanceof EntityFireMeteorite || entity instanceof EntityExplosivePumpkin || entity instanceof EntityIceCube) 
        {
            this.Shape1.yRot = ageInTicks / 10.0F;
            this.Shape1.xRot = ageInTicks / 20.0F;
            this.Shape1.zRot = ageInTicks / 20.0F;
        }
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}