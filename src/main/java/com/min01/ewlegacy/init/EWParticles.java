package com.min01.ewlegacy.init;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EWParticles 
{
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ElementalWitchesLegacy.MODID);

	public static final RegistryObject<SimpleParticleType> DARK_CIRCLE = PARTICLES.register("dark_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DARK = PARTICLES.register("dark", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DARK_PROJECTILE = PARTICLES.register("dark_projectile", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIRE_CIRCLE = PARTICLES.register("fire_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> GREEN_CHRISTMAS = PARTICLES.register("green_christmas", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ICE_CIRCLE = PARTICLES.register("ice_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LEAF_CIRCLE = PARTICLES.register("leaf_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LEAF = PARTICLES.register("leaf", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHT_CIRCLE = PARTICLES.register("light_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHTNING_CIRCLE = PARTICLES.register("lightning_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHTNING = PARTICLES.register("lightning", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHT = PARTICLES.register("light", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHT_PROJECTILE = PARTICLES.register("light_projectile", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> NATURE_PROJECTILE = PARTICLES.register("nature_projectile", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> POISON = PARTICLES.register("poison", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> RED_CHRISTMAS = PARTICLES.register("red_christmas", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SMALL_DARK_CIRCLE = PARTICLES.register("small_dark_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SMALL_SMOKE_CIRCLE = PARTICLES.register("small_smoke_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SMALL_WIND = PARTICLES.register("small_wind", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SNOWFLAKE = PARTICLES.register("snowflake", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SOUL = PARTICLES.register("soul", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> TORNADO = PARTICLES.register("tornado", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WATER_CIRCLE = PARTICLES.register("water_circle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WIND = PARTICLES.register("wind", () -> new SimpleParticleType(false));
}
