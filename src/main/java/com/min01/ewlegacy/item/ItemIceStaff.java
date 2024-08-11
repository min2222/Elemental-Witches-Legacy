package com.min01.ewlegacy.item;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

public class ItemIceStaff extends Item
{
    public ItemIceStaff() 
    {
    	super(new Item.Properties().durability(500).tab(ElementalWitchesLegacy.TAB).rarity(Rarity.RARE));
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) 
    {
        if(p_41406_ instanceof LivingEntity && ((LivingEntity)p_41406_).isHolding(this))
        {
            if(p_41406_ instanceof Player && p_41406_.tickCount % 10 == 0 && !((Player)p_41406_).getAbilities().instabuild) 
            {
                ((Player)p_41406_).causeFoodExhaustion(2.0F);
            }
            ElementalWitchesLegacy.PROXY.spawnParticles("ice_normal", p_41406_);
            int i1 = Mth.floor(p_41406_.getX());
            int j1 = Mth.floor(p_41406_.getZ());
            for(int l1 = -5; l1 <= 5; ++l1)
            {
                for(int i2 = -5; i2 <= 5; ++i2)
                {
                    for(int k = 0; k <= 10; ++k) 
                    {
                        for(int m = -1; m <= 0; ++m)
                        {
                            int j2 = i1 + l1;
                            int k2 = Mth.floor(p_41406_.getY()) + m;
                            int l2 = j1 + i2;
                            BlockPos pos = new BlockPos(j2, k2, l2);
                            if(p_41405_.getBlockState(pos).getMaterial() == Material.AIR && Blocks.SNOW.canSurvive(p_41405_.getBlockState(pos), p_41405_, pos)) 
                            {
                            	p_41405_.setBlockAndUpdate(pos, Blocks.SNOW.defaultBlockState());
                            }
                            if(p_41405_.getBlockState(pos).getMaterial() == Material.WATER)
                            {
                                p_41405_.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
                            }
                        }
                    }
                }
            }
            List<Entity> list = p_41405_.getEntities(p_41406_, p_41406_.getBoundingBox().expandTowards(5.0, 5.0, 5.0));
            for(Entity entity1 : list) 
            {
                if(entity1 instanceof LivingEntity)
                {
                    ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 100, 2));
                }
            }
        }
    }
}
