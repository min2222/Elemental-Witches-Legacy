package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.skill.EntityBigSnowGolem;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ItemChristmasStaff extends Item
{
    public ItemChristmasStaff()
    {
    	super(new Item.Properties().durability(500).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.RARE));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) 
    {
    	ItemStack stack = p_41433_.getItemInHand(p_41434_);
    	if(!p_41433_.isPassenger())
    	{
    		if(p_41433_.getName().getString().equals("HoopaWolf") | p_41433_.getName().getString().equals("Nyctodarkmatter") | p_41433_.getName().getString().equals("LuridGlow") | p_41433_.getName().getString().equals("Darkraivoid") | p_41433_.getName().getString().equals("TeoTRM") | p_41433_.getName().getString().equals("SlipperySkater") | p_41433_.getName().getString().equals("Gookuin") | p_41433_.getName().getString().equals("jbyoda") | p_41433_.getName().getString().equals("AlexWei4") | p_41433_.getName().getString().equals("alxndr11") | p_41433_.getName().getString().equals("snowielove2") | p_41433_.getName().getString().equals("Xfur") | p_41433_.getName().getString().equals("XxJuggeRxX"))
    		{
                if(p_41433_.getFoodData().getFoodLevel() > 1)
                {
                    EntityBigSnowGolem golem = new EntityBigSnowGolem(EWEntities.BIG_SNOW_GOLEM.get(), p_41432_);
                    golem.moveTo(p_41433_.position());
                    SnowGolem snowman1 = new SnowGolem(EntityType.SNOW_GOLEM, p_41432_);
                    snowman1.moveTo(p_41433_.position());
                    SnowGolem snowman2 = new SnowGolem(EntityType.SNOW_GOLEM, p_41432_);
                    snowman2.moveTo(p_41433_.position());
                    EWUtil.spawnInWorld(p_41432_, golem);
                    EWUtil.spawnInWorld(p_41432_, snowman1);
                    EWUtil.spawnInWorld(p_41432_, snowman2);
                    p_41433_.startRiding(golem);
                    snowman1.setLeashedTo(golem, true);
                    snowman2.setLeashedTo(golem, true);
                    if(!p_41433_.getAbilities().instabuild)
                    {
                    	p_41433_.getFoodData().addExhaustion(50.0F);
                        stack.hurtAndBreak(1, p_41433_, t -> 
                        {
                        	t.broadcastBreakEvent(p_41434_);
                        });
                    }
                }
    		}
    		else if(!p_41432_.isClientSide)
    		{
    			p_41433_.sendSystemMessage(Component.translatable("chat.ewlegacy.no_power"));
    		}
    	}
    	return InteractionResultHolder.success(stack);
    }
}
