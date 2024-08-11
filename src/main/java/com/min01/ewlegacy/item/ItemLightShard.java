package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

public class ItemLightShard extends Item
{
    public ItemLightShard() 
    {
    	super(new Item.Properties().stacksTo(16).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.EPIC));
    }
    
    @Override
    public InteractionResult useOn(UseOnContext p_41427_)
    {
    	Player player = p_41427_.getPlayer();
    	//Level level = p_41427_.getLevel();
    	//BlockPos pos = p_41427_.getClickedPos();
    	if(player.getAbilities().instabuild)
    	{
    		//TODO
            //StructureLight.getInstance().generate(level, level.random, pos.getX(), pos.getY(), pos.getZ());
            return InteractionResult.SUCCESS;
    	}
    	return InteractionResult.FAIL;
    }
}
