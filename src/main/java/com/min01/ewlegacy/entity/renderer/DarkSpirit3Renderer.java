package com.min01.ewlegacy.entity.renderer;

import com.min01.ewlegacy.entity.model.ModelDarkSpirit3;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.RandomSource;

public class DarkSpirit3Renderer extends EWMobRenderer<EntityDarkSpirit3, ModelDarkSpirit3>
{
	private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);
	   
	public DarkSpirit3Renderer(Context p_174304_)
	{
		super(p_174304_, new ModelDarkSpirit3(p_174304_.bakeLayer(ModelDarkSpirit3.LAYER_LOCATION)), 0.5F, "dark_spirit_3");
	}

	@Override
	public void render(EntityDarkSpirit3 p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) 
	{
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
		if(p_115455_.deathTicks > 0 || p_115455_.goldenTicks > 0)
		{
			float f5 = 0.0F;
			if(p_115455_.deathTicks > 0)
			{
				f5 = ((float) p_115455_.deathTicks + p_115457_) / 200.0F;
			}
			else if(p_115455_.goldenTicks > 0)
			{
				f5 = ((float) p_115455_.goldenTicks + p_115457_) / 200.0F;
			}
			float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
			RandomSource randomsource = RandomSource.create(432L);
			VertexConsumer vertexconsumer2 = p_115459_.getBuffer(RenderType.lightning());
			p_115458_.pushPose();
			p_115458_.translate(0.0D, 0.0D, 0.0D);
			for(int i = 0; (float) i < (f5 + f5 * f5) / 2.0F * 60.0F; ++i) 
			{
				p_115458_.mulPose(Vector3f.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
				p_115458_.mulPose(Vector3f.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
				p_115458_.mulPose(Vector3f.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
				p_115458_.mulPose(Vector3f.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
				p_115458_.mulPose(Vector3f.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
				p_115458_.mulPose(Vector3f.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
				float f3 = randomsource.nextFloat() * 10.0F + 5.0F + f7 * 10.0F;
				float f4 = randomsource.nextFloat() * 2.0F + 1.0F + f7 * 2.0F;
				Matrix4f matrix4f = p_115458_.last().pose();
				int j = (int) (255.0F * (1.0F - f7));
				vertex01(vertexconsumer2, matrix4f, j);
				vertex2(vertexconsumer2, matrix4f, f3, f4);
				vertex3(vertexconsumer2, matrix4f, f3, f4);
				vertex01(vertexconsumer2, matrix4f, j);
				vertex3(vertexconsumer2, matrix4f, f3, f4);
				vertex4(vertexconsumer2, matrix4f, f3, f4);
				vertex01(vertexconsumer2, matrix4f, j);
				vertex4(vertexconsumer2, matrix4f, f3, f4);
				vertex2(vertexconsumer2, matrix4f, f3, f4);
			}

			p_115458_.popPose();
		}
	}
	
	private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_)
	{
		p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(75, 0, 130, p_114222_).endVertex();
	}

	private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_)
	{
		p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(75, 0, 130, 0).endVertex();
	}

	private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_)
	{
		p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(75, 0, 130, 0).endVertex();
	}

	private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) 
	{
		p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(75, 0, 130, 0).endVertex();
	}
}
