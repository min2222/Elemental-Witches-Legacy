package com.min01.ewlegacy.item;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemEmptyEgg extends Item
{
    public ItemEmptyEgg() 
    {
    	super(new Item.Properties().stacksTo(1).tab(ElementalWitchesLegacy.TAB));
    }
    
    @Override
    public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) 
    {
    	p_41423_.add(Component.literal("Right-Click on a ").withStyle(ChatFormatting.ITALIC));
    	p_41423_.add(Component.literal("witch when her health is below 13 ").withStyle(ChatFormatting.ITALIC));
    	p_41423_.add(Component.literal("to capture her power in the egg!").withStyle(ChatFormatting.ITALIC));
    }
}
