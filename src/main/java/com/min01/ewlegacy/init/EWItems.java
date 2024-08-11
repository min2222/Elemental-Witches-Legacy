package com.min01.ewlegacy.init;

import java.util.function.Supplier;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.item.ItemAirEgg;
import com.min01.ewlegacy.item.ItemAirShard;
import com.min01.ewlegacy.item.ItemChristmasStaff;
import com.min01.ewlegacy.item.ItemDarkEgg;
import com.min01.ewlegacy.item.ItemDarkShard;
import com.min01.ewlegacy.item.ItemDarkStaff;
import com.min01.ewlegacy.item.ItemEarthEgg;
import com.min01.ewlegacy.item.ItemEarthShard;
import com.min01.ewlegacy.item.ItemEarthStaff;
import com.min01.ewlegacy.item.ItemEmptyEgg;
import com.min01.ewlegacy.item.ItemFireEgg;
import com.min01.ewlegacy.item.ItemFireShard;
import com.min01.ewlegacy.item.ItemFireStaff;
import com.min01.ewlegacy.item.ItemHalloweenStaff;
import com.min01.ewlegacy.item.ItemIceEgg;
import com.min01.ewlegacy.item.ItemIceShard;
import com.min01.ewlegacy.item.ItemIceStaff;
import com.min01.ewlegacy.item.ItemLightEgg;
import com.min01.ewlegacy.item.ItemLightShard;
import com.min01.ewlegacy.item.ItemLightStaff;
import com.min01.ewlegacy.item.ItemLightningEgg;
import com.min01.ewlegacy.item.ItemLightningShard;
import com.min01.ewlegacy.item.ItemLightningStaff;
import com.min01.ewlegacy.item.ItemMagicalSeed;
import com.min01.ewlegacy.item.ItemNatureEgg;
import com.min01.ewlegacy.item.ItemNatureShard;
import com.min01.ewlegacy.item.ItemNatureStaff;
import com.min01.ewlegacy.item.ItemSandShard;
import com.min01.ewlegacy.item.ItemWaterEgg;
import com.min01.ewlegacy.item.ItemWaterShard;
import com.min01.ewlegacy.item.ItemWaterStaff;
import com.min01.ewlegacy.item.ItemAirStaff;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EWItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalWitchesLegacy.MODID);
	
	public static final RegistryObject<Item> LIGHTNING_BALL = ITEMS.register("lightning_ball", () -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> FIRE_SHARD = ITEMS.register("fire_shard", () -> new ItemFireShard());
	public static final RegistryObject<Item> LIGHTNING_SHARD = ITEMS.register("lightning_shard", () -> new ItemLightningShard());
	public static final RegistryObject<Item> AIR_SHARD = ITEMS.register("air_shard", () -> new ItemAirShard());
	public static final RegistryObject<Item> EARTH_SHARD = ITEMS.register("earth_shard", () -> new ItemEarthShard());
	public static final RegistryObject<Item> DARK_SHARD = ITEMS.register("dark_shard", () -> new ItemDarkShard());
	public static final RegistryObject<Item> LIGHT_SHARD = ITEMS.register("light_shard", () -> new ItemLightShard());
	public static final RegistryObject<Item> WATER_SHARD = ITEMS.register("water_shard", () -> new ItemWaterShard());
	public static final RegistryObject<Item> ICE_SHARD = ITEMS.register("ice_shard", () -> new ItemIceShard());
	public static final RegistryObject<Item> NATURE_SHARD = ITEMS.register("nature_shard", () -> new ItemNatureShard());
	public static final RegistryObject<Item> SAND_SHARD = ITEMS.register("sand_shard", () -> new ItemSandShard());
	public static final RegistryObject<Item> FIRE_STAFF = ITEMS.register("fire_staff", () -> new ItemFireStaff());
	public static final RegistryObject<Item> AIR_STAFF = ITEMS.register("air_staff", () -> new ItemAirStaff());
	public static final RegistryObject<Item> EARTH_STAFF = ITEMS.register("earth_staff", () -> new ItemEarthStaff());
	public static final RegistryObject<Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff", () -> new ItemLightningStaff());
	public static final RegistryObject<Item> HALLOWEEN_STAFF = ITEMS.register("halloween_staff", () -> new ItemHalloweenStaff());
	public static final RegistryObject<Item> LIGHT_STAFF = ITEMS.register("light_staff", () -> new ItemLightStaff());
	public static final RegistryObject<Item> DARK_STAFF = ITEMS.register("dark_staff", () -> new ItemDarkStaff());
	public static final RegistryObject<Item> WATER_STAFF = ITEMS.register("water_staff", () -> new ItemWaterStaff());
	public static final RegistryObject<Item> ICE_STAFF = ITEMS.register("ice_staff", () -> new ItemIceStaff());
	public static final RegistryObject<Item> NATURE_STAFF = ITEMS.register("nature_staff", () -> new ItemNatureStaff());
	public static final RegistryObject<Item> CHRISTMAS_STAFF = ITEMS.register("christmas_staff", () -> new ItemChristmasStaff());
	public static final RegistryObject<Item> EMPTY_EGG = ITEMS.register("empty_egg", () -> new ItemEmptyEgg());
	public static final RegistryObject<Item> AIR_EGG = ITEMS.register("air_egg", () -> new ItemAirEgg());
	public static final RegistryObject<Item> LIGHTNING_EGG = ITEMS.register("lightning_egg", () -> new ItemLightningEgg());
	public static final RegistryObject<Item> FIRE_EGG = ITEMS.register("fire_egg", () -> new ItemFireEgg());
	public static final RegistryObject<Item> EARTH_EGG = ITEMS.register("earth_egg", () -> new ItemEarthEgg());
	public static final RegistryObject<Item> WATER_EGG = ITEMS.register("water_egg", () -> new ItemWaterEgg());
	public static final RegistryObject<Item> DARK_EGG = ITEMS.register("dark_egg", () -> new ItemDarkEgg());
	public static final RegistryObject<Item> LIGHT_EGG = ITEMS.register("light_egg", () -> new ItemLightEgg());
	public static final RegistryObject<Item> ICE_EGG = ITEMS.register("ice_egg", () -> new ItemIceEgg());
	public static final RegistryObject<Item> NATURE_EGG = ITEMS.register("nature_egg", () -> new ItemNatureEgg());
	public static final RegistryObject<Item> MAGICAL_SEED = ITEMS.register("magical_seed", () -> new ItemMagicalSeed());

	public static final RegistryObject<Item> FIRE_WITCH_SPAWN_EGG = registerSpawnEgg("fire_witch_spawn_egg", () -> EWEntities.FIRE_WITCH.get(), 14614785, 9054472);
	public static final RegistryObject<Item> LIGHTNING_WITCH_SPAWN_EGG = registerSpawnEgg("lightning_witch_spawn_egg", () -> EWEntities.LIGHTNING_WITCH.get(), 13695576, 16252462);
	public static final RegistryObject<Item> AIR_WITCH_SPAWN_EGG = registerSpawnEgg("air_witch_spawn_egg", () -> EWEntities.AIR_WITCH.get(), 14211288, 12434877);
	public static final RegistryObject<Item> EARTH_WITCH_SPAWN_EGG = registerSpawnEgg("earth_witch_spawn_egg", () -> EWEntities.EARTH_WITCH.get(), 2757130, 3875851);
	public static final RegistryObject<Item> WATER_WITCH_SPAWN_EGG = registerSpawnEgg("water_witch_spawn_egg", () -> EWEntities.WATER_WITCH.get(), 3801567, 16639);
	public static final RegistryObject<Item> LIGHT_WITCH_SPAWN_EGG = registerSpawnEgg("light_witch_spawn_egg", () -> EWEntities.LIGHT_WITCH.get(), 16776960, 16054872);
	public static final RegistryObject<Item> DARK_WITCH_SPAWN_EGG = registerSpawnEgg("dark_witch_spawn_egg", () -> EWEntities.DARK_WITCH.get(), 1640199, 2755082);
	public static final RegistryObject<Item> ICE_WITCH_SPAWN_EGG = registerSpawnEgg("ice_witch_spawn_egg", () -> EWEntities.ICE_WITCH.get(), 8510197, 3054334);
	public static final RegistryObject<Item> NATURE_WITCH_SPAWN_EGG = registerSpawnEgg("nature_witch_spawn_egg", () -> EWEntities.NATURE_WITCH.get(), 3368448, 3355392);
	public static final RegistryObject<Item> HALLOWEEN_WITCH_SPAWN_EGG = registerSpawnEgg("halloween_witch_spawn_egg", () -> EWEntities.HALLOWEEN_WITCH.get(), 1640199, 3872523);
	public static final RegistryObject<Item> CHRISTMAS_WITCH_SPAWN_EGG = registerSpawnEgg("christmas_witch_spawn_egg", () -> EWEntities.CHRISTMAS_WITCH.get(), 745761, 14614785);
	
	public static <T extends Mob> RegistryObject<Item> registerSpawnEgg(String name, Supplier<EntityType<T>> entity, int color1, int color2) 
	{
		return ITEMS.register(name, () -> new ForgeSpawnEggItem(entity, color1, color2, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	}
}
