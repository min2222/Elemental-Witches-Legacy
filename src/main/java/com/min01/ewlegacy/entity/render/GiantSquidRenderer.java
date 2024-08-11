//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.min01.ewlegacy.entity.skill.EntityGiantSquid;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class GiantSquidRenderer extends RenderLiving
{
    private static final ResourceLocation squidTextures;
    private float scale;
    
    public GiantSquidRenderer(final ModelBase p_i1268_1_, final float p_i1268_2_, final float p_i1255_3_) {
        super(p_i1268_1_, p_i1268_2_ * p_i1255_3_);
        this.scale = p_i1255_3_;
    }
    
    protected void preRenderCallback(final EntityGiantSquid p_77041_1_, final float p_77041_2_) {
        GL11.glScalef(this.scale, this.scale, this.scale);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
    }
    
    public void doRender(final EntityGiantSquid p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.9f, 0.9f, 0.9f, 0.7f);
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        GL11.glDisable(3042);
    }
    
    protected ResourceLocation getEntityTexture(final EntityGiantSquid p_110775_1_) {
        return GiantSquidRenderer.squidTextures;
    }
    
    protected void rotateCorpse(final EntityGiantSquid p_77043_1_, final float p_77043_2_, final float p_77043_3_, final float p_77043_4_) {
        final float f3 = p_77043_1_.prevSquidPitch + (p_77043_1_.squidPitch - p_77043_1_.prevSquidPitch) * p_77043_4_;
        final float f4 = p_77043_1_.prevSquidYaw + (p_77043_1_.squidYaw - p_77043_1_.prevSquidYaw) * p_77043_4_;
        GL11.glTranslatef(0.0f, 0.5f, 0.0f);
        GL11.glRotatef(180.0f - p_77043_3_, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(f3, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(f4, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -1.2f, 0.0f);
    }
    
    protected float handleRotationFloat(final EntityGiantSquid p_77044_1_, final float p_77044_2_) {
        return p_77044_1_.lastTentacleAngle + (p_77044_1_.tentacleAngle - p_77044_1_.lastTentacleAngle) * p_77044_2_;
    }
    
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityGiantSquid)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected float handleRotationFloat(final EntityLivingBase p_77044_1_, final float p_77044_2_) {
        return this.handleRotationFloat((EntityGiantSquid)p_77044_1_, p_77044_2_);
    }
    
    protected void rotateCorpse(final EntityLivingBase p_77043_1_, final float p_77043_2_, final float p_77043_3_, final float p_77043_4_) {
        this.rotateCorpse((EntityGiantSquid)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }
    
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityGiantSquid)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityGiantSquid)p_110775_1_);
    }
    
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityGiantSquid)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityGiantSquid)p_77041_1_, p_77041_2_);
    }
    
    static {
        squidTextures = new ResourceLocation("mwaw:textures/entity/squid.png");
    }
}
