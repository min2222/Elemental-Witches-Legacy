//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.hoopawolf.mwaw.models.*;
import com.min01.ewlegacy.entity.model.ModelEnderCrystalShoot;
import com.min01.ewlegacy.entity.skill.EntityEnderHole;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class EnderHoleRenderer extends Render
{
    private static final ResourceLocation enderCrystalTextures;
    private ModelBase field_76995_b;
    
    public EnderHoleRenderer() {
        this.shadowSize = 0.5f;
        this.field_76995_b = (ModelBase)new ModelEnderCrystalShoot();
    }
    
    public void doRender(final EntityEnderHole p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        final float f2 = p_76986_1_.innerRotation + p_76986_9_;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        this.bindTexture(EnderHoleRenderer.enderCrystalTextures);
        float f3 = MathHelper.sin(f2 * 0.2f) / 2.0f + 0.5f;
        f3 += f3 * f3;
        this.field_76995_b.render((Entity)p_76986_1_, 0.0f, f2 * 3.0f, f3 * 0.2f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getEntityTexture(final EntityEnderHole p_110775_1_) {
        return EnderHoleRenderer.enderCrystalTextures;
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityEnderHole)p_110775_1_);
    }
    
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityEnderHole)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        enderCrystalTextures = new ResourceLocation("mwaw:textures/entity/enderhole.png");
    }
}
