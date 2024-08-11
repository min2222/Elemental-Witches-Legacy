package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ItemMagicalSeed extends Item
{
    public ItemMagicalSeed() 
    {
    	super(new Item.Properties().stacksTo(16).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.EPIC));
    }
    
    @Override
    public InteractionResult useOn(UseOnContext p_41427_) 
    {
    	Player player = p_41427_.getPlayer();
    	ItemStack stack = p_41427_.getItemInHand();
    	BlockPos pos = p_41427_.getClickedPos();
    	Level level = p_41427_.getLevel();
    	if(level.getBlockState(pos.offset(0, 1, 0)) == Blocks.AIR.defaultBlockState() && (level.getBlockState(pos) == Blocks.DIRT.defaultBlockState() | level.getBlockState(pos) == Blocks.GRAVEL.defaultBlockState() | level.getBlockState(pos) == Blocks.GRASS_BLOCK.defaultBlockState() | level.getBlockState(pos) == Blocks.STONE.defaultBlockState() | level.getBlockState(pos) == Blocks.COBBLESTONE.defaultBlockState() | level.getBlockState(pos) == Blocks.SOUL_SAND.defaultBlockState()))
    	{
    		//TODO
    		//level.setBlockAndUpdate(pos.offset(0, 1, 0), EWBlocks.MAGICAL_SEED.get());
    		if(!player.getAbilities().instabuild)
    		{
    			stack.shrink(1);
    		}
    		return InteractionResult.SUCCESS;
    	}
    	return InteractionResult.FAIL;
    }
}
