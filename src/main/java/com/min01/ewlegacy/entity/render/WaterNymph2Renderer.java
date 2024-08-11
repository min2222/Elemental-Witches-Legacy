//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\nooung\other\minecraft\source\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package com.min01.ewlegacy.entity.render;

import com.min01.ewlegacy.entity.pet.EntityWaterNymph2;

import net.minecraft.entity.*;
import net.minecraft.resources.ResourceLocation;

public class WaterNymph2Renderer extends RenderLiving
{
    private static final ResourceLocation WaterPet2_Texture;
    
    public WaterNymph2Renderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    protected int getColorMultiplier(final EntityWaterNymph2 p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        final int f2 = p_77030_1_.deathTicks;
        return 10 << f2 + 225;
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return WaterNymph2Renderer.WaterPet2_Texture;
    }
    
    protected int getColorMultiplier(final EntityLivingBase p_77030_1_, final float p_77030_2_, final float p_77030_3_) {
        return this.getColorMultiplier((EntityWaterNymph2)p_77030_1_, p_77030_2_, p_77030_3_);
    }
    
    static {
        WaterPet2_Texture = new ResourceLocation("mwaw:textures/entity/waterpet2.png");
    }
}
