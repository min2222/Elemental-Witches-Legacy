package com.min01.ewlegacy.effect;

import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EWEffect extends MobEffect
{
	public EWEffect(MobEffectCategory p_19451_, int p_19452_)
	{
		super(p_19451_, p_19452_);
	}
	
	@Override
	public Component getDisplayName() 
	{
		if(this == EWEffects.PARANOID.get())
		{
			return Component.literal(ChatFormatting.OBFUSCATED + "Paranoid");
		}
		return super.getDisplayName();
	}
}
