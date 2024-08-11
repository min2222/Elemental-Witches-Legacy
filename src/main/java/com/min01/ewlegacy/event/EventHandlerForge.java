package com.min01.ewlegacy.event;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityHalloweenEgg;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix3;
import com.min01.ewlegacy.entity.projectile.EntityAirShoot;
import com.min01.ewlegacy.entity.skill.EntityAirClone;
import com.min01.ewlegacy.entity.witch.EntityAirWitch;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.init.EWSounds;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ElementalWitchesLegacy.MODID, bus = Bus.FORGE)
public class EventHandlerForge
{
    public static int TIMER = 18;
    
    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) 
    {
        String NBT_KEY_PET = "firstjoinpet";
        String NBT_KEY_ITEM = "firstjoinitem";
        String NBT_KEY_SANDSHARD = "firstjoinsandshard";
        if(event.getEntity() instanceof Player) 
        {
            Player player = (Player) event.getEntity();
            CompoundTag data = event.getEntity().getPersistentData();
            CompoundTag persistent;
            if(!data.contains("PlayerPersisted"))
            {
                data.put("PlayerPersisted", persistent = new CompoundTag());
            }
            else 
            {
                persistent = data.getCompound("PlayerPersisted");
            }
            if(!persistent.contains(NBT_KEY_PET) && (player.getName().getString().equals("HoopaWolf") | player.getName().getString().equals("DarkSoul260") | player.getName().getString().equals("AlexWei4") | player.getName().getString().equals("CruaverVoidDrake") | player.getName().getString().equals("TOMMYZILLA2003") | player.getName().getString().equals("SlipperySkater") | player.getName().getString().equals("jbyoda") | player.getName().getString().equals("Soul_Mask_Master") | player.getName().getString().equals("Dragonlord7479") | player.getName().getString().equals("aydanprice") | player.getName().getString().equals("Darkraivoid") | player.getName().getString().equals("Noremac_TC")))
            {
                persistent.putBoolean(NBT_KEY_PET, true);
                EntityHalloweenEgg mob = new EntityHalloweenEgg(EWEntities.HALLOWEEN_EGG.get(), event.getLevel());
                mob.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), 0.0F);
                EWUtil.spawnInWorld(event.getLevel(), mob);
                mob.setOwnerUUID(player.getUUID());
                mob.setCustomName(Component.literal("Owner: " + player.getName().getString()));
                mob.setCustomNameVisible(true);
            }
            if(!persistent.contains(NBT_KEY_ITEM) && (player.getName().getString().equals("HoopaWolf") | player.getName().getString().equals("Nyctodarkmatter") | player.getName().getString().equals("LuridGlow") | player.getName().getString().equals("Darkraivoid") | player.getName().getString().equals("TeoTRM") | player.getName().getString().equals("SlipperySkater") | player.getName().getString().equals("Gookuin") | player.getName().getString().equals("jbyoda") | player.getName().getString().equals("AlexWei4") | player.getName().getString().equals("alxndr11") | player.getName().getString().equals("snowielove2") | player.getName().getString().equals("Xfur") | player.getName().getString().equals("XxJuggeRxX"))) 
            {
                persistent.putBoolean(NBT_KEY_ITEM, true);
                player.getInventory().add(new ItemStack(EWItems.CHRISTMAS_STAFF.get()));
            }
            if(!persistent.contains(NBT_KEY_SANDSHARD) && event.getLevel().random.nextInt(100) == 42) 
            {
                persistent.putBoolean(NBT_KEY_SANDSHARD, true);
                player.getInventory().add(new ItemStack(EWItems.SAND_SHARD.get()));
            }
        }
    }
    
    @SubscribeEvent
    public static void onLivingTick(LivingTickEvent event) 
    {
        int x = (int) Math.floor(event.getEntity().getX());
        int y = (int) Math.floor(event.getEntity().getY());
        int z = (int) Math.floor(event.getEntity().getZ());
        CompoundTag compound = new CompoundTag();
        compound.putInt("EventTimer", TIMER);
        if(event.getEntity().hasEffect(EWEffects.PARALYZE.get()))
        {
            ElementalWitchesLegacy.PROXY.spawnParticles("lightning_normal", event.getEntity());
            if(event.getEntity() instanceof Mob) 
            {
                ((Mob)event.getEntity()).setTarget(null);
            }
            if(event.getEntity() instanceof LivingEntity) 
            {
                if(event.getEntity().getDeltaMovement().y >= 0.0) 
                {
                    LivingEntity entityLiving = event.getEntity();
                    entityLiving.setDeltaMovement(entityLiving.getDeltaMovement().multiply(1, 0.0, 1));
                }
                event.getEntity().setYHeadRot(0.0F);
                event.getEntity().moveTo(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 0.0F, 0.0F);
            }
        }
        if(event.getEntity().hasEffect(EWEffects.ENDER_SKIN.get()))
        {
            ElementalWitchesLegacy.PROXY.spawnParticles("ender_normal", event.getEntity());
            if(event.getEntity().isInWaterRainOrBubble() && event.getEntity().tickCount % 10 == 0) 
            {
                event.getEntity().hurt(DamageSource.MAGIC, 1.0F);
            }
        }
        if(event.getEntity().hasEffect(EWEffects.WATER_PULL.get()) && event.getEntity().isInWater())
        {
            LivingEntity entityLiving2 = event.getEntity();
            entityLiving2.setDeltaMovement(entityLiving2.getDeltaMovement().subtract(0, 0.5, 0));
        }
        if(event.getEntity().hasEffect(EWEffects.FROST_BITE.get()))
        {
            ElementalWitchesLegacy.PROXY.spawnParticles("ice_normal", event.getEntity());
            if(event.getEntity().level.getBrightness(LightLayer.BLOCK, new BlockPos(x, y, z)) <= 11) 
            {
                if(!(event.getEntity() instanceof Player) || !isWearingLeather((Player)event.getEntity()))
                {
                    if(event.getEntity().tickCount % 20 == 0)
                    {
                        event.getEntity().hurt(DamageSource.MAGIC, 1.0F);
                    }
                }
            }
        }
        if(event.getEntity().hasEffect(EWEffects.EARTH_STANCE.get()))
        {
            ElementalWitchesLegacy.PROXY.spawnParticles("earth_big", event.getEntity());
            BlockPos pos = new BlockPos(x, y - 1, z);
            if((event.getEntity().level.getBlockState(pos) == Blocks.DIRT.defaultBlockState() || event.getEntity().level.getBlockState(pos) == Blocks.STONE.defaultBlockState() || event.getEntity().level.getBlockState(pos) == Blocks.GRASS_BLOCK.defaultBlockState()) && event.getEntity().tickCount % 10 == 0 && event.getEntity().getHealth() != event.getEntity().getMaxHealth()) 
            {
                event.getEntity().heal(1.0F);
            }
        }
        if(event.getEntity().hasEffect(EWEffects.AIR_STANCE.get()))
        {
            ElementalWitchesLegacy.PROXY.spawnParticles("air_normal", event.getEntity());
            if(event.getEntity().getHealth() <= 3.0F)
            {
                List<Entity> list = event.getEntity().level.getEntities(event.getEntity(), event.getEntity().getBoundingBox().expandTowards(5.0, 5.0, 5.0));
                for(Entity entity1 : list)
                {
                    if(!(entity1 instanceof EntityAirWitch) && !(entity1 instanceof EntityAirShoot) && !(entity1 instanceof EntityAirClone) && (!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild)) 
                    {
                        if(!(entity1 instanceof EntityAirPhoenix3)) 
                        {
                            double xx = entity1.getX() - event.getEntity().getX();
                            double zz = entity1.getZ() - event.getEntity().getZ();
                            entity1.setDeltaMovement(xx / (9.0f * entity1.distanceTo(event.getEntity())), entity1.getDeltaMovement().y, zz / (9.0f * entity1.distanceTo(event.getEntity())));
                        }
                    }
                }
            }
            event.getEntity().fallDistance = 0.0F;
            if(!event.getEntity().isOnGround() && event.getEntity().getDeltaMovement().y < 0.0) 
            {
                LivingEntity entityLiving3 = event.getEntity();
                entityLiving3.setDeltaMovement(entityLiving3.getDeltaMovement().multiply(1, 0.6, 1));
            }
            if(event.getEntity().isOnFire())
            {
                event.getEntity().clearFire();
            }
        }
        if(event.getEntity().hasEffect(EWEffects.PARANOID.get()) && event.getEntity() instanceof Player)
        {
            TIMER = compound.getInt("EventTimer");
            ElementalWitchesLegacy.PROXY.spawnParticles("dark_normal", event.getEntity());
            if(TIMER != 0) 
            {
                --TIMER;
            }
            if(TIMER <= 0)
            {
                SoundEvent sound = null;
                switch (((Player)event.getEntity()).level.random.nextInt(5))
                {
                    case 0: {
                        sound = ((event.getEntity().level.dimension().equals(Level.NETHER)) ? SoundEvents.GHAST_AMBIENT : SoundEvents.ZOMBIE_AMBIENT);
                        break;
                    }
                    case 1: {
                        sound = SoundEvents.CREEPER_PRIMED;
                        break;
                    }
                    case 2: {
                        sound = SoundEvents.SPIDER_AMBIENT;
                        break;
                    }
                    case 3: {
                        sound = SoundEvents.ENDERMAN_SCREAM;
                        break;
                    }
                    case 4: {
                        sound = EWSounds.WHISPER.get();
                        break;
                    }
                    default: {
                        sound = SoundEvents.ENDERMAN_STARE;
                        break;
                    }
                }
                event.getEntity().level.playSound(null, event.getEntity(), sound, event.getEntity().getSoundSource(), 2.0F, 0.6F);
                TIMER = 18;
            }
        }
    }
    
    public static boolean isWearingLeather(Player entity) 
    {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Items.LEATHER_HELMET && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Items.LEATHER_CHESTPLATE && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Items.LEATHER_LEGGINGS && entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Items.LEATHER_BOOTS;
    }
}
