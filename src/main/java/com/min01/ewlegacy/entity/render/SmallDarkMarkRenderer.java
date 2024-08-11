//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.min01.ewlegacy.entity.skill.EntitySmallDarkMark;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class SmallDarkMarkRenderer extends RenderLiving
{
    private static final ResourceLocation darkmarkTextures;
    private float scale;
    
    public SmallDarkMarkRenderer(final ModelBase p_i1268_1_, final float p_i1268_2_, final float p_i1255_3_) {
        super(p_i1268_1_, p_i1268_2_ * p_i1255_3_);
        this.scale = p_i1255_3_;
    }
    
    protected void preRenderCallback(final EntitySmallDarkMark p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
    }
    
    public void doRender(final EntitySmallDarkMark p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.9f, 0.9f, 0.9f, 0.7f);
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        GL11.glDisable(3042);
    }
    
    protected ResourceLocation getEntityTexture(final EntitySmallDarkMark p_110775_1_) {
        return SmallDarkMarkRenderer.darkmarkTextures;
    }
    
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntitySmallDarkMark)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntitySmallDarkMark)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntitySmallDarkMark)p_110775_1_);
    }
    
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntitySmallDarkMark)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntitySmallDarkMark)p_77041_1_, p_77041_2_);
    }
    
    static {
        darkmarkTextures = new ResourceLocation("mwaw:textures/entity/DarkMark.png");
    }
}
