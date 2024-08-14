package com.min01.ewlegacy.block;

import java.awt.Color;

import com.min01.ewlegacy.init.EWBlocks;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.vehicle.MinecartTNT;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BlockPresent extends Block
{
    private ItemStack firework;
    
	public BlockPresent()
	{
		super(BlockBehaviour.Properties.of(Material.WOOL).strength(100.0F).sound(SoundType.SNOW));
	}
	
	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) 
	{
        int random = p_60504_.random.nextInt(50);
        if(!p_60504_.isClientSide) 
        {
            if(random == 17) 
            {
                ZombieVillager zombie = new ZombieVillager(EntityType.ZOMBIE_VILLAGER, p_60504_);
                zombie.setBaby(true);;
                zombie.setCustomNameVisible(true);
                zombie.setCustomName(Component.literal(ChatFormatting.GREEN + "Christmas Thief"));
                zombie.moveTo(p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), 0.0F, 0.0F);
                zombie.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(EWBlocks.PRESENT.get()));
                zombie.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
                zombie.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
                zombie.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
                zombie.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
                EWUtil.spawnInWorld(p_60504_, zombie);
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
            else if(random >= 30 && random <= 36)
            {
                this.getRandomColorFireWork(p_60504_, 2, 0);
                p_60506_.spawnAtLocation(Items.POTATO, p_60504_.random.nextInt(20));
                for(int i = 0; i <= 4; ++i) 
                {
                    FireworkRocketEntity rocket = new FireworkRocketEntity(p_60504_, p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), this.firework.copy());
                    EWUtil.spawnInWorld(p_60504_, rocket);
                }
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
            else if(random >= 20 && random <= 26) 
            {
                this.getRandomColorFireWork(p_60504_, 4, 1);
                FireworkRocketEntity rocket2 = new FireworkRocketEntity(p_60504_, p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), this.firework.copy());
                EWUtil.spawnInWorld(p_60504_, rocket2);
                p_60506_.startRiding(rocket2);
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
            else if(random >= 1 && random <= 6) 
            {
                BlockState block = Blocks.STONE_BRICKS.defaultBlockState();
                BlockState block2 = Blocks.IRON_BARS.defaultBlockState();
                p_60506_.moveTo(Vec3.atCenterOf(p_60505_));
                if(!p_60504_.isClientSide)
                {
                	p_60506_.sendSystemMessage(Component.translatable("chat.ewlegacy.lookup"));
                }
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX(), p_60506_.getY() - 1, p_60506_.getZ()), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX(), p_60506_.getY() - 1, p_60506_.getZ() + 1), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX(), p_60506_.getY() - 1, p_60506_.getZ() - 1), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, p_60506_.getY() - 1, p_60506_.getZ()), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, p_60506_.getY() - 1, p_60506_.getZ()), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, p_60506_.getY() - 1, p_60506_.getZ() + 1), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, p_60506_.getY() - 1, p_60506_.getZ() - 1), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, p_60506_.getY() - 1, p_60506_.getZ() - 1), block);
                p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, p_60506_.getY() - 1, p_60506_.getZ() + 1), block);
                for(int j = (int) p_60506_.getY(); j < p_60506_.getY() + 3.0; ++j)
                {
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX(), j, p_60506_.getZ() + 1), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX(), j, p_60506_.getZ() - 1), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, j, p_60506_.getZ()), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, j, p_60506_.getZ()), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, j, p_60506_.getZ() + 1), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() - 1, j, p_60506_.getZ() - 1), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, j, p_60506_.getZ() - 1), block2);
                    p_60504_.setBlockAndUpdate(new BlockPos(p_60506_.getX() + 1, j, p_60506_.getZ() + 1), block2);
                }
                MinecartTNT tnt = new MinecartTNT(EntityType.TNT_MINECART, p_60504_);
                tnt.setPos(p_60506_.position().add(0, 20, 0));
                EWUtil.spawnInWorld(p_60504_, tnt);
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
            else if(random >= 40)
            {
                PrimedTnt tnt2 = new PrimedTnt(EntityType.TNT, p_60504_);
                tnt2.setFuse(10);
                tnt2.moveTo(p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), 0.0F, 0.0F);
                EWUtil.spawnInWorld(p_60504_, tnt2);
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
            else 
            {
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());
            }
        }
		return InteractionResult.SUCCESS;
	}
	
    public void getRandomColorFireWork(Level world, int type, int flight) 
    {
        this.firework = new ItemStack(Items.FIREWORK_ROCKET, 1);
        this.firework.setTag(new CompoundTag());
        CompoundTag data = new CompoundTag();
        data.putByte("Flight", (byte)flight);
        ListTag list = new ListTag();
        CompoundTag fireworkData = new CompoundTag();
        fireworkData.putByte("Trail", (byte)1);
        fireworkData.putByte("Type", (byte)type);
        fireworkData.putIntArray("Colors", new int[] { new Color(world.random.nextInt(255), world.random.nextInt(255), world.random.nextInt(255)).getRGB() });
        list.add(fireworkData);
        data.put("Explosions", list);
        this.firework.getTag().put("Fireworks", data);
    }
}
