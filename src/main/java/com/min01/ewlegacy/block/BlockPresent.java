package com.min01.ewlegacy.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

//TODO
public class BlockPresent extends Block
{
	public BlockPresent()
	{
		super(BlockBehaviour.Properties.of(Material.WOOL).strength(100.0F).sound(SoundType.SNOW));
	}
}
