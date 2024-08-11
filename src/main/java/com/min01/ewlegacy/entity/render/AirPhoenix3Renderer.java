//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.min01.ewlegacy.entity.pet.EntityAirPhoenix3;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class AirPhoenix3Renderer extends RenderLiving
{
    private static final ResourceLocation AirPet3_Texture;
    
    public AirPhoenix3Renderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.setRenderPassModel(par1ModelBase);
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected int shouldRenderPass(final EntityAirPhoenix3 p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_2_ == 0) {
            this.bindTexture(AirPhoenix3Renderer.AirPet3_Texture);
            if (p_77032_1_.hasCustomNameTag() && ("RAINBOW".equals(p_77032_1_.getCustomNameTag()) | "rainbow".equals(p_77032_1_.getCustomNameTag()) | "Rainbow".equals(p_77032_1_.getCustomNameTag()))) {
                final boolean flag = true;
                final int k = p_77032_1_.ticksExisted / 25 + p_77032_1_.getEntityId();
                final int l = k % com.min01.ewlegacy.entity.witch.rainbowColorTable.length;
                final int i1 = (k + 1) % com.min01.ewlegacy.entity.witch.rainbowColorTable.length;
                final float f1 = (p_77032_1_.ticksExisted % 25 + p_77032_3_) / 25.0f;
                GL11.glColor3f(EntityAirPhoenix3.rainbowColorTable[l][0] * (1.0f - f1) + EntityAirPhoenix3.rainbowColorTable[i1][0] * f1, EntityAirPhoenix3.rainbowColorTable[l][1] * (1.0f - f1) + EntityAirPhoenix3.rainbowColorTable[i1][1] * f1, EntityAirPhoenix3.rainbowColorTable[l][2] * (1.0f - f1) + EntityAirPhoenix3.rainbowColorTable[i1][2] * f1);
            }
            return 1;
        }
        return -1;
    }
    
    protected void renderEquippedItems(final EntityAirPhoenix3 p_77029_1_, final float p_77029_2_) {
        super.renderEquippedItems((EntityLivingBase)p_77029_1_, p_77029_2_);
        final Tessellator tessellator = Tessellator.instance;
        if (p_77029_1_.deathTicks > 0 || p_77029_1_.goldenTicks > 0) {
            RenderHelper.disableStandardItemLighting();
            float f1 = 0.0f;
            if (p_77029_1_.deathTicks > 0) {
                f1 = (p_77029_1_.deathTicks + p_77029_2_) / 200.0f;
            }
            else if (p_77029_1_.goldenTicks > 0) {
                f1 = (p_77029_1_.goldenTicks + p_77029_2_) / 200.0f;
            }
            float f2 = 0.0f;
            if (f1 > 0.8f) {
                f2 = (f1 - 0.8f) / 0.2f;
            }
            final Random random = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            for (int i = 0; i < (f1 + f1 * f1) / 2.0f * 60.0f; ++i) {
                GL11.glRotatef(random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f + f1 * 90.0f, 0.0f, 0.0f, 1.0f);
                tessellator.startDrawing(6);
                final float f3 = random.nextFloat() * 10.0f + 5.0f + f2 * 10.0f;
                final float f4 = random.nextFloat() * 2.0f + 1.0f + f2 * 2.0f;
                tessellator.setColorRGBA(255, 255, 255, (int)(255.0f * (1.0f - f2)));
                tessellator.addVertex(0.0, 0.0, 0.0);
                tessellator.setColorRGBA(255, 255, 255, 0);
                tessellator.addVertex(-0.866 * f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.866 * f4, (double)f3, (double)(-0.5f * f4));
                tessellator.addVertex(0.0, (double)f3, (double)(1.0f * f4));
                tessellator.addVertex(-0.866 * f4, (double)f3, (double)(-0.5f * f4));
                tessellator.draw();
            }
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    protected int getColorMultiplier(final EntityAirPhoenix3 p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        final int f2 = p_77030_1_.deathTicks;
        return 10 << f2 + 225;
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return AirPhoenix3Renderer.AirPet3_Texture;
    }
    
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityAirPhoenix3)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected void renderEquippedItems(final EntityLivingBase p_77029_1_, final float p_77029_2_) {
        this.renderEquippedItems((EntityAirPhoenix3)p_77029_1_, p_77029_2_);
    }
    
    protected int getColorMultiplier(final EntityLivingBase p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        return this.getColorMultiplier((EntityAirPhoenix3)p_77030_1_, p_77030_2_, p_77030_3_);
    }
    
    static {
        AirPet3_Texture = new ResourceLocation("mwaw:textures/entity/windpet3.png");
    }
}
