//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import com.hoopawolf.mwaw.models.*;
import com.min01.ewlegacy.entity.model.ModelMWAWWitch;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class IceWitchRenderer extends RenderLiving
{
    private static final ResourceLocation IceWitch_Texture;
    private static final ResourceLocation IceCoat_Textures;
    private ModelBase witchModel;
    
    public IceWitchRenderer() {
        super((ModelBase)new ModelMWAWWitch(0.5f), 0.5f);
        this.witchModel = (ModelBase)new ModelMWAWWitch(0.5f);
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return IceWitchRenderer.IceWitch_Texture;
    }
    
    protected int shouldRenderPass(final EntityIceWitch p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_1_.getHealth() <= 20.0f) {
            if (p_77032_1_.isInvisible()) {
                GL11.glDepthMask(false);
            }
            else {
                GL11.glDepthMask(true);
            }
            if (p_77032_2_ == 1) {
                final float f1 = p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(IceWitchRenderer.IceCoat_Textures);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                final float f2 = f1 * 0.01f;
                final float f3 = f1 * 0.01f;
                GL11.glTranslatef(f2, f3, 0.0f);
                this.setRenderPassModel(this.witchModel);
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
        }
        return -1;
    }
    
    protected int inheritRenderPass(final EntityIceWitch p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return -1;
    }
    
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityIceWitch)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected int inheritRenderPass(final EntityLivingBase p_77035_1_, final int p_77035_2_, final float p_77035_3_) {
        return this.inheritRenderPass((EntityIceWitch)p_77035_1_, p_77035_2_, p_77035_3_);
    }
    
    static {
        IceWitch_Texture = new ResourceLocation("mwaw:textures/entity/icewitch.png");
        IceCoat_Textures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
}
