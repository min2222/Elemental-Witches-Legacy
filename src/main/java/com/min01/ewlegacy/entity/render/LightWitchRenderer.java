//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.hoopawolf.mwaw.models.*;
import com.min01.ewlegacy.entity.model.ModelMWAWWitch;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class LightWitchRenderer extends RenderLiving
{
    private static final ResourceLocation LightWitch_Texture;
    private static final ResourceLocation LigtBeam_Texture;
    
    public LightWitchRenderer() {
        super((ModelBase)new ModelMWAWWitch(0.5f), 0.5f);
    }
    
    public void doRender(final EntityLightWitch p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        if (p_76986_1_.healingLight != null) {
            final float f2 = p_76986_1_.healingLight.innerRotation + p_76986_9_;
            float f3 = MathHelper.sin(f2 * 0.2f) / 2.0f + 0.5f;
            f3 = (f3 * f3 + f3) * 0.2f;
            final float f4 = (float)(p_76986_1_.healingLight.posX - p_76986_1_.posX - (p_76986_1_.prevPosX - p_76986_1_.posX) * (1.0f - p_76986_9_));
            final float f5 = (float)(f3 + p_76986_1_.healingLight.posY - 1.0 - p_76986_1_.posY - (p_76986_1_.prevPosY - p_76986_1_.posY) * (1.0f - p_76986_9_));
            final float f6 = (float)(p_76986_1_.healingLight.posZ - p_76986_1_.posZ - (p_76986_1_.prevPosZ - p_76986_1_.posZ) * (1.0f - p_76986_9_));
            final float f7 = MathHelper.sqrt_float(f4 * f4 + f6 * f6);
            final float f8 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + 2.0f, (float)p_76986_6_);
            GL11.glRotatef((float)(-Math.atan2(f6, f4)) * 180.0f / 3.1415927f - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef((float)(-Math.atan2(f7, f5)) * 180.0f / 3.1415927f - 90.0f, 1.0f, 0.0f, 0.0f);
            final Tessellator tessellator = Tessellator.instance;
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2884);
            this.bindTexture(LightWitchRenderer.LigtBeam_Texture);
            GL11.glShadeModel(7425);
            final float f9 = 0.0f - (p_76986_1_.ticksExisted + p_76986_9_) * 0.01f;
            final float f10 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6) / 32.0f - (p_76986_1_.ticksExisted + p_76986_9_) * 0.01f;
            tessellator.startDrawing(5);
            final byte b0 = 8;
            for (int i = 0; i <= b0; ++i) {
                final float f11 = MathHelper.sin(i % b0 * 3.1415927f * 2.0f / b0) * 0.75f;
                final float f12 = MathHelper.cos(i % b0 * 3.1415927f * 2.0f / b0) * 0.75f;
                final float f13 = i % b0 * 1.0f / b0;
                tessellator.setColorOpaque_I(16777215);
                tessellator.addVertexWithUV((double)(f11 * 0.2f), (double)(f12 * 0.2f), 0.0, (double)f13, (double)f10);
                tessellator.setColorOpaque_I(16777215);
                tessellator.addVertexWithUV((double)f11, (double)f12, (double)f8, (double)f13, (double)f9);
            }
            tessellator.draw();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            RenderHelper.enableStandardItemLighting();
            GL11.glPopMatrix();
        }
    }
    
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityLightWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return LightWitchRenderer.LightWitch_Texture;
    }
    
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityLightWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityLightWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        LightWitch_Texture = new ResourceLocation("mwaw:textures/entity/lightwitch.png");
        LigtBeam_Texture = new ResourceLocation("mwaw:textures/entity/light_beam.png");
    }
}
