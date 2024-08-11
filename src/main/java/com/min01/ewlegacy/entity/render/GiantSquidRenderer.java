package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.skill.EntityGiantSquid;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.SquidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public class GiantSquidRenderer extends EWTranslucentMobRenderer<EntityGiantSquid, SquidModel<EntityGiantSquid>>
{
	public GiantSquidRenderer(Context p_174304_) 
	{
		super(p_174304_, new SquidModel<>(p_174304_.bakeLayer(ModelLayers.SQUID)), 5.0F, "giant_squid");
	}

	@Override
	protected void scale(EntityGiantSquid p_115314_, PoseStack p_115315_, float p_115316_)
	{
		p_115315_.scale(10.0F, 10.0F, 10.0F);
		p_115315_.translate(0.0F, -0.5F, 0.0F);
	}
	
	@Override
	protected void setupRotations(EntityGiantSquid p_116035_, PoseStack p_116036_, float p_116037_, float p_116038_, float p_116039_)
	{
		float f = Mth.lerp(p_116039_, p_116035_.prevSquidPitch, p_116035_.squidPitch);
		float f1 = Mth.lerp(p_116039_, p_116035_.prevSquidYaw, p_116035_.squidYaw);
		p_116036_.translate(0.0D, 0.5D, 0.0D);
		p_116036_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_116038_));
		p_116036_.mulPose(Vector3f.XP.rotationDegrees(f));
		p_116036_.mulPose(Vector3f.YP.rotationDegrees(f1));
		p_116036_.translate(0.0D, (double)-1.2F, 0.0D);
	}

	@Override
	protected float getBob(EntityGiantSquid p_116032_, float p_116033_)
	{
		return Mth.lerp(p_116033_, p_116032_.lastTentacleAngle, p_116032_.tentacleAngle);
	}
}
