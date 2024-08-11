package com.min01.ewlegacy.item;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.projectile.EntityPumpkinShot;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ItemHalloweenStaff extends Item
{
    public ItemHalloweenStaff() 
    {
    	super(new Item.Properties().durability(500).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.RARE));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) 
    {
    	ItemStack stack = p_41433_.getItemInHand(p_41434_);
        if(p_41433_.getFoodData().getFoodLevel() > 1) 
        {
            Vec3 look = p_41433_.getLookAngle();
            EntityPumpkinShot mwawCheckPumpkin = new EntityPumpkinShot(p_41432_, p_41433_, 1.0, 1.0, 1.0);
            mwawCheckPumpkin.setPos(p_41433_.getX() + look.x * 1.0, p_41433_.getY() + look.y * 1.0 + p_41433_.getEyeHeight(), p_41433_.getZ() + look.z * 1.0);
            mwawCheckPumpkin.xPower = look.x * 0.1;
            mwawCheckPumpkin.yPower = look.y * 0.1;
            mwawCheckPumpkin.zPower = look.z * 0.1;
            EWUtil.spawnInWorld(p_41432_, mwawCheckPumpkin);
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
