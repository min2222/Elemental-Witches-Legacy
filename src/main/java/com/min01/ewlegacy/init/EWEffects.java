package com.min01.ewlegacy.init;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.effect.EWEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EWEffects
{
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ElementalWitchesLegacy.MODID);
	
	public static final RegistryObject<MobEffect> PARALYZE = EFFECTS.register("paralyze", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -50.0, Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<MobEffect> PARANOID = EFFECTS.register("paranoid", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0));
	public static final RegistryObject<MobEffect> ENDER_SKIN = EFFECTS.register("ender_skin", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0));
	public static final RegistryObject<MobEffect> EARTH_STANCE = EFFECTS.register("earth_stance", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0));
	public static final RegistryObject<MobEffect> AIR_STANCE = EFFECTS.register("air_stance", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", 3.0, Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<MobEffect> FROST_BITE = EFFECTS.register("frost_bite", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<MobEffect> WATER_PULL = EFFECTS.register("water_pull", () -> new EWEffect(MobEffectCategory.NEUTRAL, 0));
}
