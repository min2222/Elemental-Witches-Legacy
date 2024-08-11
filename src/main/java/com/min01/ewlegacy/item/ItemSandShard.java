package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.witch.EntitySandWitch;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ItemSandShard extends Item
{
    public ItemSandShard()
    {
    	super(new Item.Properties().stacksTo(16).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.EPIC));
    }
    
    @Override
    public InteractionResult useOn(UseOnContext p_41427_) 
    {
    	Level level = p_41427_.getLevel();
    	BlockPos pos = p_41427_.getClickedPos();
    	if((level.getBlockState(pos) == Blocks.SAND.defaultBlockState() && level.getBlockState(pos.offset(0, -1, 0)) == Blocks.SAND.defaultBlockState()) || (level.getBlockState(pos) == Blocks.SAND.defaultBlockState() && level.getBlockState(pos.offset(0, 1, 0)) == Blocks.SAND.defaultBlockState()))
    	{
            EntitySandWitch entity = new EntitySandWitch(EWEntities.SAND_WITCH.get(), level);
            entity.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
            EWUtil.spawnInWorld(level, entity);
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            level.setBlockAndUpdate(pos.offset(0, -1, 0), Blocks.AIR.defaultBlockState());
            level.setBlockAndUpdate(pos.offset(0, 1, 0), Blocks.AIR.defaultBlockState());
    		return InteractionResult.SUCCESS;
    	}
    	return InteractionResult.FAIL;
    }
}
