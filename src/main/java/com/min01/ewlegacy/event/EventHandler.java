package com.min01.ewlegacy.event;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityAirEgg;
import com.min01.ewlegacy.entity.egg.EntityDarkEgg;
import com.min01.ewlegacy.entity.egg.EntityEarthEgg;
import com.min01.ewlegacy.entity.egg.EntityFireEgg;
import com.min01.ewlegacy.entity.egg.EntityHalloweenEgg;
import com.min01.ewlegacy.entity.egg.EntityIceEgg;
import com.min01.ewlegacy.entity.egg.EntityLightEgg;
import com.min01.ewlegacy.entity.egg.EntityLightningEgg;
import com.min01.ewlegacy.entity.egg.EntityNatureEgg;
import com.min01.ewlegacy.entity.egg.EntityWaterEgg;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix2;
import com.min01.ewlegacy.entity.pet.EntityAirPhoenix3;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit2;
import com.min01.ewlegacy.entity.pet.EntityDarkSpirit3;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem2;
import com.min01.ewlegacy.entity.pet.EntityEarthGolem3;
import com.min01.ewlegacy.entity.pet.EntityFireDragon;
import com.min01.ewlegacy.entity.pet.EntityFireDragon2;
import com.min01.ewlegacy.entity.pet.EntityFireDragon3;
import com.min01.ewlegacy.entity.pet.EntityHalloweenPumpkin;
import com.min01.ewlegacy.entity.pet.EntityHalloweenPumpking;
import com.min01.ewlegacy.entity.pet.EntityIceBeast;
import com.min01.ewlegacy.entity.pet.EntityLightAngel;
import com.min01.ewlegacy.entity.pet.EntityLightAngel2;
import com.min01.ewlegacy.entity.pet.EntityLightAngel3;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast2;
import com.min01.ewlegacy.entity.pet.EntityLightningBeast3;
import com.min01.ewlegacy.entity.pet.EntityNatureGolem;
import com.min01.ewlegacy.entity.pet.EntityWaterNymph;
import com.min01.ewlegacy.entity.pet.EntityWaterNymph2;
import com.min01.ewlegacy.entity.skill.EntityAirClone;
import com.min01.ewlegacy.entity.skill.EntityBigSnowGolem;
import com.min01.ewlegacy.entity.skill.EntityCandyCane;
import com.min01.ewlegacy.entity.skill.EntityDarkMark;
import com.min01.ewlegacy.entity.skill.EntityDarkSummoner;
import com.min01.ewlegacy.entity.skill.EntityDeathCircle;
import com.min01.ewlegacy.entity.skill.EntityDeathCircle2;
import com.min01.ewlegacy.entity.skill.EntityEnderHole;
import com.min01.ewlegacy.entity.skill.EntityEnt;
import com.min01.ewlegacy.entity.skill.EntityEntGuardian;
import com.min01.ewlegacy.entity.skill.EntityExplosivePumpkin;
import com.min01.ewlegacy.entity.skill.EntityFireBat;
import com.min01.ewlegacy.entity.skill.EntityFireMeteorite;
import com.min01.ewlegacy.entity.skill.EntityFrostNova;
import com.min01.ewlegacy.entity.skill.EntityGiantSquid;
import com.min01.ewlegacy.entity.skill.EntityIceCrystal;
import com.min01.ewlegacy.entity.skill.EntityIcicle;
import com.min01.ewlegacy.entity.skill.EntityLightHeal;
import com.min01.ewlegacy.entity.skill.EntityLightShield;
import com.min01.ewlegacy.entity.skill.EntityLightShieldBad;
import com.min01.ewlegacy.entity.skill.EntityLightningGolem;
import com.min01.ewlegacy.entity.skill.EntityMiniTornado;
import com.min01.ewlegacy.entity.skill.EntityNinjaKhan;
import com.min01.ewlegacy.entity.skill.EntityRifle;
import com.min01.ewlegacy.entity.skill.EntityRoot;
import com.min01.ewlegacy.entity.skill.EntitySandGolem;
import com.min01.ewlegacy.entity.skill.EntitySandMark;
import com.min01.ewlegacy.entity.skill.EntitySmallDarkMark;
import com.min01.ewlegacy.entity.skill.EntitySwiftEnt;
import com.min01.ewlegacy.entity.skill.EntityTornado;
import com.min01.ewlegacy.entity.skill.EntityWaterMinion;
import com.min01.ewlegacy.entity.skill.EntityWaterSpout;
import com.min01.ewlegacy.entity.witch.EntityAirWitch;
import com.min01.ewlegacy.entity.witch.EntityChristmasWitch;
import com.min01.ewlegacy.entity.witch.EntityDarkWitch;
import com.min01.ewlegacy.entity.witch.EntityEarthMinion;
import com.min01.ewlegacy.entity.witch.EntityEarthMinionGood;
import com.min01.ewlegacy.entity.witch.EntityEarthWitch;
import com.min01.ewlegacy.entity.witch.EntityFireWitch;
import com.min01.ewlegacy.entity.witch.EntityHalloweenWitch;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;
import com.min01.ewlegacy.entity.witch.EntityLightningWitch;
import com.min01.ewlegacy.entity.witch.EntityNatureWitch;
import com.min01.ewlegacy.entity.witch.EntitySandMinion;
import com.min01.ewlegacy.entity.witch.EntitySandWitch;
import com.min01.ewlegacy.entity.witch.EntityWaterWitch;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ElementalWitchesLegacy.MODID, bus = Bus.MOD)
public class EventHandler 
{
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) 
    {
    	event.put(EWEntities.AIR_EGG.get(), EntityAirEgg.createAttributes().build());
    	event.put(EWEntities.DARK_EGG.get(), EntityDarkEgg.createAttributes().build());
    	event.put(EWEntities.EARTH_EGG.get(), EntityEarthEgg.createAttributes().build());
    	event.put(EWEntities.FIRE_EGG.get(), EntityFireEgg.createAttributes().build());
    	event.put(EWEntities.HALLOWEEN_EGG.get(), EntityHalloweenEgg.createAttributes().build());
    	event.put(EWEntities.ICE_EGG.get(), EntityIceEgg.createAttributes().build());
    	event.put(EWEntities.LIGHT_EGG.get(), EntityLightEgg.createAttributes().build());
    	event.put(EWEntities.LIGHTNING_EGG.get(), EntityLightningEgg.createAttributes().build());
    	event.put(EWEntities.NATURE_EGG.get(), EntityNatureEgg.createAttributes().build());
    	event.put(EWEntities.WATER_EGG.get(), EntityWaterEgg.createAttributes().build());
    	
    	event.put(EWEntities.AIR_PHOENIX.get(), EntityAirPhoenix.createAttributes().build());
    	event.put(EWEntities.AIR_PHOENIX_2.get(), EntityAirPhoenix2.createAttributes().build());
    	event.put(EWEntities.AIR_PHOENIX_3.get(), EntityAirPhoenix3.createAttributes().build());
    	
    	event.put(EWEntities.DARK_SPIRIT.get(), EntityDarkSpirit.createAttributes().build());
    	event.put(EWEntities.DARK_SPIRIT_2.get(), EntityDarkSpirit2.createAttributes().build());
    	event.put(EWEntities.DARK_SPIRIT_3.get(), EntityDarkSpirit3.createAttributes().build());
    	
    	event.put(EWEntities.EARTH_GOLEM.get(), EntityEarthGolem.createAttributes().build());
    	event.put(EWEntities.EARTH_GOLEM_2.get(), EntityEarthGolem2.createAttributes().build());
    	event.put(EWEntities.EARTH_GOLEM_3.get(), EntityEarthGolem3.createAttributes().build());
    	
    	event.put(EWEntities.FIRE_DRAGON.get(), EntityFireDragon.createAttributes().build());
    	event.put(EWEntities.FIRE_DRAGON_2.get(), EntityFireDragon2.createAttributes().build());
    	event.put(EWEntities.FIRE_DRAGON_3.get(), EntityFireDragon3.createAttributes().build());
    	
    	event.put(EWEntities.HALLOWEEN_PUMPKIN.get(), EntityHalloweenPumpkin.createAttributes().build());
    	event.put(EWEntities.HALLOWEEN_PUMPKING.get(), EntityHalloweenPumpking.createAttributes().build());

    	event.put(EWEntities.ICE_BEAST.get(), EntityIceBeast.createAttributes().build());
    	
    	event.put(EWEntities.LIGHT_ANGEL.get(), EntityLightAngel.createAttributes().build());
    	event.put(EWEntities.LIGHT_ANGEL_2.get(), EntityLightAngel2.createAttributes().build());
    	event.put(EWEntities.LIGHT_ANGEL_3.get(), EntityLightAngel3.createAttributes().build());
    	
    	event.put(EWEntities.LIGHTNING_BEAST.get(), EntityLightningBeast.createAttributes().build());
    	event.put(EWEntities.LIGHTNING_BEAST_2.get(), EntityLightningBeast2.createAttributes().build());
    	event.put(EWEntities.LIGHTNING_BEAST_3.get(), EntityLightningBeast3.createAttributes().build());

    	event.put(EWEntities.NATURE_GOLEM.get(), EntityNatureGolem.createAttributes().build());
    	
    	event.put(EWEntities.WATER_NYMPH.get(), EntityWaterNymph.createAttributes().build());
    	event.put(EWEntities.WATER_NYMPH_2.get(), EntityWaterNymph2.createAttributes().build());
    	
    	event.put(EWEntities.AIR_CLONE.get(), EntityAirClone.createAttributes().build());
    	event.put(EWEntities.BIG_SNOW_GOLEM.get(), EntityBigSnowGolem.createAttributes().build());
    	event.put(EWEntities.CANDY_CANE.get(), EntityCandyCane.createAttributes().build());
    	event.put(EWEntities.DARK_MARK.get(), EntityDarkMark.createAttributes().build());
    	event.put(EWEntities.DARK_SUMMONER.get(), EntityDarkSummoner.createAttributes().build());
    	event.put(EWEntities.DEATH_CIRCLE.get(), EntityDeathCircle.createAttributes().build());
    	event.put(EWEntities.DEATH_CIRCLE_2.get(), EntityDeathCircle2.createAttributes().build());
    	event.put(EWEntities.ENDER_HOLE.get(), EntityEnderHole.createAttributes().build());
    	event.put(EWEntities.ENT.get(), EntityEnt.createAttributes().build());
    	event.put(EWEntities.ENT_GUARDIAN.get(), EntityEntGuardian.createAttributes().build());
    	event.put(EWEntities.EXPLOSIVE_PUMPKIN.get(), EntityExplosivePumpkin.createAttributes().build());
    	event.put(EWEntities.FIRE_BAT.get(), EntityFireBat.createAttributes().build());
    	event.put(EWEntities.FIRE_METEORITE.get(), EntityFireMeteorite.createAttributes().build());
    	event.put(EWEntities.FROST_NOVA.get(), EntityFrostNova.createAttributes().build());
    	event.put(EWEntities.GIANT_SQUID.get(), EntityGiantSquid.createAttributes().build());
    	event.put(EWEntities.ICE_CRYSTAL.get(), EntityIceCrystal.createAttributes().build());
    	event.put(EWEntities.ICICLE.get(), EntityIcicle.createAttributes().build());
    	event.put(EWEntities.LIGHT_HEAL.get(), EntityLightHeal.createAttributes().build());
    	event.put(EWEntities.LIGHTNING_GOLEM.get(), EntityLightningGolem.createAttributes().build());
    	event.put(EWEntities.LIGHT_SHIELD.get(), EntityLightShield.createAttributes().build());
    	event.put(EWEntities.LIGHT_SHIELD_BAD.get(), EntityLightShieldBad.createAttributes().build());
    	event.put(EWEntities.MINI_TORNADO.get(), EntityMiniTornado.createAttributes().build());
    	event.put(EWEntities.NINJA_KHAN.get(), EntityNinjaKhan.createAttributes().build());
    	event.put(EWEntities.RIFLE.get(), EntityRifle.createAttributes().build());
    	event.put(EWEntities.ROOT.get(), EntityRoot.createAttributes().build());
    	event.put(EWEntities.SAND_GOLEM.get(), EntitySandGolem.createAttributes().build());
    	event.put(EWEntities.SAND_MARK.get(), EntitySandMark.createAttributes().build());
    	event.put(EWEntities.SMALL_DARK_MARK.get(), EntitySmallDarkMark.createAttributes().build());
    	event.put(EWEntities.SWIFT_ENT.get(), EntitySwiftEnt.createAttributes().build());
    	event.put(EWEntities.TORNADO.get(), EntityTornado.createAttributes().build());
    	event.put(EWEntities.WATER_MINION.get(), EntityWaterMinion.createAttributes().build());
    	event.put(EWEntities.WATER_SPOUT.get(), EntityWaterSpout.createAttributes().build());

    	event.put(EWEntities.AIR_WITCH.get(), EntityAirWitch.createAttributes().build());
    	event.put(EWEntities.CHRISTMAS_WITCH.get(), EntityChristmasWitch.createAttributes().build());
    	event.put(EWEntities.DARK_WITCH.get(), EntityDarkWitch.createAttributes().build());
    	event.put(EWEntities.EARTH_MINION.get(), EntityEarthMinion.createAttributes().build());
    	event.put(EWEntities.EARTH_MINION_GOOD.get(), EntityEarthMinionGood.createAttributes().build());
    	event.put(EWEntities.EARTH_WITCH.get(), EntityEarthWitch.createAttributes().build());
    	event.put(EWEntities.FIRE_WITCH.get(), EntityFireWitch.createAttributes().build());
    	event.put(EWEntities.HALLOWEEN_WITCH.get(), EntityHalloweenWitch.createAttributes().build());
    	event.put(EWEntities.ICE_WITCH.get(), EntityIceWitch.createAttributes().build());
    	event.put(EWEntities.LIGHTNING_WITCH.get(), EntityLightningWitch.createAttributes().build());
    	event.put(EWEntities.LIGHT_WITCH.get(), EntityLightWitch.createAttributes().build());
    	event.put(EWEntities.NATURE_WITCH.get(), EntityNatureWitch.createAttributes().build());
    	event.put(EWEntities.SAND_MINION.get(), EntitySandMinion.createAttributes().build());
    	event.put(EWEntities.SAND_WITCH.get(), EntitySandWitch.createAttributes().build());
    	event.put(EWEntities.WATER_WITCH.get(), EntityWaterWitch.createAttributes().build());
    }
}
