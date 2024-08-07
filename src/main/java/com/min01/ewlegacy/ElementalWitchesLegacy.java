package com.min01.ewlegacy;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;

@Mod(ElementalWitchesLegacy.MODID)
public class ElementalWitchesLegacy 
{
	public static final String MODID = "ewlegacy";
	
	public static final CreativeModeTab TAB = new CreativeModeTab(MODID)
	{
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(Items.WITCH_SPAWN_EGG);
		}
		
		@Override
		public ResourceLocation getBackgroundImage() 
		{
			return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/gui/container/creative_inventory/tab_elementalwitchmod");
		}
	};
	
	public ElementalWitchesLegacy() 
	{
		
	}
}
