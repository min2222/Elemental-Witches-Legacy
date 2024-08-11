package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityEarthEgg;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ItemEarthEgg extends Item
{
    public ItemEarthEgg() 
    {
    	super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(ElementalWitchesLegacy.TAB));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_)
    {
    	ItemStack stack = p_41433_.getItemInHand(p_41434_);
    	EntityEarthEgg mob = new EntityEarthEgg(EWEntities.EARTH_EGG.get(), p_41432_);
    	mob.moveTo(p_41433_.getX(), p_41433_.getY(), p_41433_.getZ(), p_41433_.getYRot(), 0.0F);
    	EWUtil.spawnInWorld(p_41432_, mob);
    	mob.setOwnerUUID(p_41433_.getUUID());
    	mob.setCustomName(Component.literal("Owner: " + p_41433_.getDisplayName().getString()));
    	mob.setCustomNameVisible(true);
    	//TODO
    	//p_41433_.awardStat(MWAWAchievementsRegistry.earthpet1, 1);
    	if(!p_41433_.getAbilities().instabuild)
    	{
    		stack.shrink(1);
    	}
    	return InteractionResultHolder.success(stack);
    }
}
