//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class WaterSpoutRenderer extends RenderLiving
{
    private static final ResourceLocation WaterSpout_Texture;
    
    public WaterSpoutRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return WaterSpoutRenderer.WaterSpout_Texture;
    }
    
    static {
        WaterSpout_Texture = new ResourceLocation("mwaw:textures/entity/lightninggolem.png");
    }
}
