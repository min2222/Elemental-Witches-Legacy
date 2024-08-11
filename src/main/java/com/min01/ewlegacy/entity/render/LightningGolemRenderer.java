//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.hoopawolf.mwaw.models.*;
import com.min01.ewlegacy.entity.model.ModelLightningGolem;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class LightningGolemRenderer extends RenderLiving
{
    private static final ResourceLocation LightningWitch_Texture;
    private static final ResourceLocation armoredblitsuneTextures;
    private ModelBase modelLightningGolem;
    
    public LightningGolemRenderer() {
        super((ModelBase)new ModelLightningGolem(), 0.5f);
        this.modelLightningGolem = (ModelBase)new ModelLightningGolem();
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return LightningGolemRenderer.LightningWitch_Texture;
    }
    
    protected int shouldRenderPass(final EntityLightningGolem p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        if (p_77032_2_ == 1) {
            final float f1 = p_77032_1_.ticksExisted + p_77032_3_;
            this.bindTexture(LightningGolemRenderer.armoredblitsuneTextures);
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            final float f2 = f1 * 0.01f;
            final float f3 = f1 * 0.01f;
            GL11.glTranslatef(f2, f3, 0.0f);
            this.setRenderPassModel(this.modelLightningGolem);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            final float f4 = 0.5f;
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
    
    protected int inheritRenderPass(final EntityLightningGolem p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return -1;
    }
    
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityLightningGolem)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected int inheritRenderPass(final EntityLivingBase p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return this.inheritRenderPass((EntityLightningGolem)p_77035_1_, p_77035_2_, p_77035_3_);
    }
    
    static {
        LightningWitch_Texture = new ResourceLocation("mwaw:textures/entity/lightninggolem.png");
        armoredblitsuneTextures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
}
