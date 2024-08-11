//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.hoopawolf.mwaw.models.*;
import com.min01.ewlegacy.entity.model.ModelDarkPet2;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit2;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class DarkSpirit2Renderer extends RenderLiving
{
    private static final ResourceLocation DarkPet2_Texture;
    private static final ResourceLocation armoredblitsuneTextures;
    private ModelBase modelLightningGolem;
    
    public DarkSpirit2Renderer() {
        super((ModelBase)new ModelDarkPet2(), 0.5f);
        this.modelLightningGolem = new ModelDarkPet2();
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected int getColorMultiplier(final EntityDarkSpirit2 p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        final int f2 = p_77030_1_.deathTicks;
        return 10 << f2 + 225;
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return DarkSpirit2Renderer.DarkPet2_Texture;
    }
    
    protected int shouldRenderPass(final EntityDarkSpirit2 p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        if (p_77032_2_ == 1) {
            final float f1 = p_77032_1_.ticksExisted + p_77032_3_;
            this.bindTexture(DarkSpirit2Renderer.armoredblitsuneTextures);
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            final float f2 = f1 * 0.02f;
            final float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, -f3, 0.0f);
            this.setRenderPassModel(this.modelLightningGolem);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            final float f4 = 1.5f;
            GL11.glColor4f(f4, f4, f4, 1.0f);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            return 1;
        }
        if (p_77032_2_ == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
        }
        return -1;
    }
    
    protected int inheritRenderPass(final EntityDarkSpirit2 p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return -1;
    }
    
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityDarkSpirit2)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected int inheritRenderPass(final EntityLivingBase p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return this.inheritRenderPass((EntityDarkSpirit2)p_77035_1_, p_77035_2_, p_77035_3_);
    }
    
    protected int getColorMultiplier(final EntityLivingBase p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        return this.getColorMultiplier((EntityDarkSpirit2)p_77030_1_, p_77030_2_, p_77030_3_);
    }
    
    static {
        DarkPet2_Texture = new ResourceLocation("mwaw:textures/entity/darkpet2.png");
        armoredblitsuneTextures = new ResourceLocation("mwaw:textures/entity/dark_body.png");
    }
}
