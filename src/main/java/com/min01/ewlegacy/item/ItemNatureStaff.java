package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityEnt;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ItemNatureStaff extends Item
{
    public ItemNatureStaff() 
    {
    	super(new Item.Properties().durability(500).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.RARE));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) 
    {
    	ItemStack stack = p_41433_.getItemInHand(p_41434_);
        if(p_41433_.getFoodData().getFoodLevel() > 1) 
        {
            EntityEnt golem = new EntityEnt(EWEntities.ENT.get(), p_41432_);
            golem.moveTo(p_41433_.position());
            EWUtil.spawnInWorld(p_41432_, golem);
            p_41433_.startRiding(golem);
            if(!p_41433_.getAbilities().instabuild) 
            {
            	p_41433_.getFoodData().addExhaustion(50.0F);
                stack.hurtAndBreak(1, p_41433_, t -> 
                {
                	t.broadcastBreakEvent(p_41434_);
                });
            }
        }
    	return InteractionResultHolder.success(stack);
    }
}
