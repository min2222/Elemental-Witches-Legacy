//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class IceCrystalRenderer extends RenderLiving
{
    private static final ResourceLocation Ice_Crystal_Texture;
    
    public IceCrystalRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.7f);
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return IceCrystalRenderer.Ice_Crystal_Texture;
    }
    
    static {
        Ice_Crystal_Texture = new ResourceLocation("mwaw:textures/entity/ice_crystal.png");
    }
}
