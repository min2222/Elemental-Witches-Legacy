package com.min01.ewlegacy.init;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.block.BlockPresent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//TODO
public class EWBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalWitchesLegacy.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElementalWitchesLegacy.MODID);
    
    public static final RegistryObject<Block> PRESENT = BLOCKS.register("present", () -> new BlockPresent());
}
