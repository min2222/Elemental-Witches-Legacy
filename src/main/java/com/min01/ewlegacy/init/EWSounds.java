package com.min01.ewlegacy.init;

import com.min01.ewlegacy.ElementalWitchesLegacy;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EWSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElementalWitchesLegacy.MODID);

	public static final RegistryObject<SoundEvent> LAUGH = registerSound("laugh");
	public static final RegistryObject<SoundEvent> WHISPER = registerSound("whisper");
	public static final RegistryObject<SoundEvent> LIGHTNING = registerSound("lightning");
	
	private static RegistryObject<SoundEvent> registerSound(String name) 
	{
		return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(ElementalWitchesLegacy.MODID, name)));
    }
}
