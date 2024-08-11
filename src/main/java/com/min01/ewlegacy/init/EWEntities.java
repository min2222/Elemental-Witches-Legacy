package com.min01.ewlegacy.init;

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
import com.min01.ewlegacy.entity.projectile.EntityAirShoot;
import com.min01.ewlegacy.entity.projectile.EntityAirShot;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityChristmasShoot;
import com.min01.ewlegacy.entity.projectile.EntityDarkShoot;
import com.min01.ewlegacy.entity.projectile.EntityDarkShot;
import com.min01.ewlegacy.entity.projectile.EntityEarthShoot;
import com.min01.ewlegacy.entity.projectile.EntityFireShot;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.projectile.EntityLightArrow;
import com.min01.ewlegacy.entity.projectile.EntityLightShoot;
import com.min01.ewlegacy.entity.projectile.EntityLightShot;
import com.min01.ewlegacy.entity.projectile.EntityLightningBall;
import com.min01.ewlegacy.entity.projectile.EntityLightningShoot;
import com.min01.ewlegacy.entity.projectile.EntityNatureBall;
import com.min01.ewlegacy.entity.projectile.EntityNatureShoot;
import com.min01.ewlegacy.entity.projectile.EntityPumpkinShot;
import com.min01.ewlegacy.entity.projectile.EntityPumpkinSkull;
import com.min01.ewlegacy.entity.projectile.EntitySquidInkBomb;
import com.min01.ewlegacy.entity.projectile.EntityWaterShoot;
import com.min01.ewlegacy.entity.projectile.EntityWaterShot;
import com.min01.ewlegacy.entity.skill.EntityAirClone;
import com.min01.ewlegacy.entity.skill.EntityBigSnowGolem;
import com.min01.ewlegacy.entity.skill.EntityBlock;
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

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EWEntities
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementalWitchesLegacy.MODID);
	
	public static final RegistryObject<EntityType<EntityAirEgg>> AIR_EGG = registerEntity("air_egg", createBuilder(EntityAirEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkEgg>> DARK_EGG = registerEntity("dark_egg", createBuilder(EntityDarkEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthEgg>> EARTH_EGG = registerEntity("earth_egg", createBuilder(EntityEarthEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireEgg>> FIRE_EGG = registerEntity("fire_egg", createBuilder(EntityFireEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityHalloweenEgg>> HALLOWEEN_EGG = registerEntity("halloween_egg", createBuilder(EntityHalloweenEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityIceEgg>> ICE_EGG = registerEntity("ice_egg", createBuilder(EntityIceEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightEgg>> LIGHT_EGG = registerEntity("light_egg", createBuilder(EntityLightEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningEgg>> LIGHTNING_EGG = registerEntity("lightning_egg", createBuilder(EntityLightningEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityNatureEgg>> NATURE_EGG = registerEntity("nature_egg", createBuilder(EntityNatureEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterEgg>> WATER_EGG = registerEntity("water_egg", createBuilder(EntityWaterEgg::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityAirPhoenix>> AIR_PHOENIX = registerEntity("air_phoenix", createBuilder(EntityAirPhoenix::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityAirPhoenix2>> AIR_PHOENIX_2 = registerEntity("air_phoenix_2", createBuilder(EntityAirPhoenix2::new, MobCategory.MONSTER).sized(1.7F, 2.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityAirPhoenix3>> AIR_PHOENIX_3 = registerEntity("air_phoenix_3", createBuilder(EntityAirPhoenix3::new, MobCategory.MONSTER).sized(2.4F, 3.4F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityDarkSpirit>> DARK_SPIRIT = registerEntity("dark_spirit", createBuilder(EntityDarkSpirit::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkSpirit2>> DARK_SPIRIT_2 = registerEntity("dark_spirit_2", createBuilder(EntityDarkSpirit2::new, MobCategory.MONSTER).sized(1.7F, 2.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkSpirit3>> DARK_SPIRIT_3 = registerEntity("dark_spirit_3", createBuilder(EntityDarkSpirit3::new, MobCategory.MONSTER).sized(3.7F, 3.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityEarthGolem>> EARTH_GOLEM = registerEntity("earth_golem", createBuilder(EntityEarthGolem::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthGolem2>> EARTH_GOLEM_2 = registerEntity("earth_golem_2", createBuilder(EntityEarthGolem2::new, MobCategory.MONSTER).sized(1.6F, 2.6F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthGolem3>> EARTH_GOLEM_3 = registerEntity("earth_golem_3", createBuilder(EntityEarthGolem3::new, MobCategory.MONSTER).sized(2.6F, 3.6F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityFireDragon>> FIRE_DRAGON = registerEntity("fire_dragon", createBuilder(EntityFireDragon::new, MobCategory.MONSTER).sized(1.0F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireDragon2>> FIRE_DRAGON_2 = registerEntity("fire_dragon_2", createBuilder(EntityFireDragon2::new, MobCategory.MONSTER).sized(1.7F, 2.4F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireDragon3>> FIRE_DRAGON_3 = registerEntity("fire_dragon_3", createBuilder(EntityFireDragon3::new, MobCategory.MONSTER).sized(3.7F, 3.4F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityHalloweenPumpkin>> HALLOWEEN_PUMPKIN = registerEntity("halloween_pumpkin", createBuilder(EntityHalloweenPumpkin::new, MobCategory.MONSTER).sized(0.7F, 1.4F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityHalloweenPumpking>> HALLOWEEN_PUMPKING = registerEntity("halloween_pumpking", createBuilder(EntityHalloweenPumpking::new, MobCategory.MONSTER).sized(0.7F, 2.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityIceBeast>> ICE_BEAST = registerEntity("ice_beast", createBuilder(EntityIceBeast::new, MobCategory.MONSTER).sized(1.2F, 1.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityLightAngel>> LIGHT_ANGEL = registerEntity("light_angel", createBuilder(EntityLightAngel::new, MobCategory.MONSTER).sized(0.7F, 1.0F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightAngel2>> LIGHT_ANGEL_2 = registerEntity("light_angel_2", createBuilder(EntityLightAngel2::new, MobCategory.MONSTER).sized(1.7F, 2.8F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightAngel3>> LIGHT_ANGEL_3 = registerEntity("light_angel_3", createBuilder(EntityLightAngel3::new, MobCategory.MONSTER).sized(2.5F, 4.2F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));

	public static final RegistryObject<EntityType<EntityLightningBeast>> LIGHTNING_BEAST = registerEntity("lightning_beast", createBuilder(EntityLightningBeast::new, MobCategory.MONSTER).sized(0.7F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningBeast2>> LIGHTNING_BEAST_2 = registerEntity("lightning_beast_2", createBuilder(EntityLightningBeast2::new, MobCategory.MONSTER).sized(1.7F, 2.4F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningBeast3>> LIGHTNING_BEAST_3 = registerEntity("lightning_beast_3", createBuilder(EntityLightningBeast3::new, MobCategory.MONSTER).sized(3.7F, 3.4F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	
	public static final RegistryObject<EntityType<EntityNatureGolem>> NATURE_GOLEM = registerEntity("nature_golem", createBuilder(EntityNatureGolem::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));

	public static final RegistryObject<EntityType<EntityWaterNymph>> WATER_NYMPH = registerEntity("water_nymph", createBuilder(EntityWaterNymph::new, MobCategory.MONSTER).sized(0.7F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterNymph2>> WATER_NYMPH_2 = registerEntity("water_nymph2", createBuilder(EntityWaterNymph2::new, MobCategory.MONSTER).sized(1.3F, 2.3F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));

	public static final RegistryObject<EntityType<EntityAirClone>> AIR_CLONE = registerEntity("air_clone", createBuilder(EntityAirClone::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityBigSnowGolem>> BIG_SNOW_GOLEM = registerEntity("big_snow_golem", createBuilder(EntityBigSnowGolem::new, MobCategory.MONSTER).sized(1.4F, 2.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityBlock>> BLOCK = registerEntity("block", EntityType.Builder.<EntityBlock>of(EntityBlock::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityCandyCane>> CANDY_CANE = registerEntity("candy_cane", createBuilder(EntityCandyCane::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkMark>> DARK_MARK = registerEntity("dark_mark", createBuilder(EntityDarkMark::new, MobCategory.MONSTER).sized(2.0F, 2.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkSummoner>> DARK_SUMMONER = registerEntity("dark_summoner", createBuilder(EntityDarkSummoner::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDeathCircle>> DEATH_CIRCLE = registerEntity("death_circle", createBuilder(EntityDeathCircle::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDeathCircle2>> DEATH_CIRCLE_2 = registerEntity("death_circle2", createBuilder(EntityDeathCircle2::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEnderHole>> ENDER_HOLE = registerEntity("ender_hole", createBuilder(EntityEnderHole::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEnt>> ENT = registerEntity("ent", createBuilder(EntityEnt::new, MobCategory.MONSTER).sized(1.0F, 2.5F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEntGuardian>> ENT_GUARDIAN = registerEntity("ent_guardian", createBuilder(EntityEntGuardian::new, MobCategory.MONSTER).sized(3.0F, 4.5F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityExplosivePumpkin>> EXPLOSIVE_PUMPKIN = registerEntity("explosive_pumpkin", createBuilder(EntityExplosivePumpkin::new, MobCategory.MONSTER).sized(0.5F, 0.5F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireBat>> FIRE_BAT = registerEntity("fire_bat", createBuilder(EntityFireBat::new, MobCategory.MONSTER).sized(0.5F, 0.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireMeteorite>> FIRE_METEORITE = registerEntity("fire_meteorite", createBuilder(EntityFireMeteorite::new, MobCategory.MONSTER).sized(3.0F, 3.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFrostNova>> FROST_NOVA = registerEntity("frost_nova", createBuilder(EntityFrostNova::new, MobCategory.MONSTER).sized(0.0F, 0.0F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityGiantSquid>> GIANT_SQUID = registerEntity("giant_squid", createBuilder(EntityGiantSquid::new, MobCategory.MONSTER).sized(8.95F, 19.95F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityIceCrystal>> ICE_CRYSTAL = registerEntity("ice_crystal", createBuilder(EntityIceCrystal::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityIcicle>> ICICLE = registerEntity("icicle", createBuilder(EntityIcicle::new, MobCategory.MONSTER).sized(0.5F, 1.5F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightHeal>> LIGHT_HEAL = registerEntity("light_heal", createBuilder(EntityLightHeal::new, MobCategory.MONSTER).sized(2.0F, 2.0F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningGolem>> LIGHTNING_GOLEM = registerEntity("lightning_golem", createBuilder(EntityLightningGolem::new, MobCategory.MONSTER).sized(1.1F, 2.9F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightShield>> LIGHT_SHIELD = registerEntity("light_shield", createBuilder(EntityLightShield::new, MobCategory.MONSTER).sized(3.0F, 3.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightShieldBad>> LIGHT_SHIELD_BAD = registerEntity("light_shield_bad", createBuilder(EntityLightShieldBad::new, MobCategory.MONSTER).sized(3.0F, 3.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityMiniTornado>> MINI_TORNADO = registerEntity("mini_tornado", createBuilder(EntityMiniTornado::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityNinjaKhan>> NINJA_KHAN = registerEntity("ninja_khan", createBuilder(EntityNinjaKhan::new, MobCategory.MONSTER).sized(0.7F, 1.3F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityRifle>> RIFLE = registerEntity("rifle", createBuilder(EntityRifle::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityRoot>> ROOT = registerEntity("root", EntityType.Builder.<EntityRoot>of(EntityRoot::new, MobCategory.MONSTER).sized(0.5F, 0.9F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySandGolem>> SAND_GOLEM = registerEntity("sand_golem", createBuilder(EntitySandGolem::new, MobCategory.MONSTER).sized(2.95F, 5.45F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySandMark>> SAND_MARK = registerEntity("sand_mark", createBuilder(EntitySandMark::new, MobCategory.MONSTER).sized(2.0F, 2.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySmallDarkMark>> SMALL_DARK_MARK = registerEntity("small_dark_mark", createBuilder(EntitySmallDarkMark::new, MobCategory.MONSTER).sized(0.5F, 0.5F).fireImmune().clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySwiftEnt>> SWIFT_ENT = registerEntity("swift_ent", createBuilder(EntitySwiftEnt::new, MobCategory.MONSTER).sized(0.6F, 1.1F).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityTornado>> TORNADO = registerEntity("tornado", createBuilder(EntityTornado::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterMinion>> WATER_MINION = registerEntity("water_mininon", createBuilder(EntityWaterMinion::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterSpout>> WATER_SPOUT = registerEntity("water_spout", createBuilder(EntityWaterSpout::new, MobCategory.MONSTER).sized(0.0F, 0.0F).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));

	public static final RegistryObject<EntityType<EntityAirWitch>> AIR_WITCH = registerEntity("air_witch", createBuilder(EntityAirWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityChristmasWitch>> CHRISTMAS_WITCH = registerEntity("christmas_witch", createBuilder(EntityChristmasWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkWitch>> DARK_WITCH = registerEntity("dark_witch", createBuilder(EntityDarkWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthMinion>> EARTH_MINION = registerEntity("earth_minion", createBuilder(EntityEarthMinion::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthMinionGood>> EARTH_MINION_GOOD = registerEntity("earth_minion_good", createBuilder(EntityEarthMinionGood::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthWitch>> EARTH_WITCH = registerEntity("earth_witch", createBuilder(EntityEarthWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireWitch>> FIRE_WITCH = registerEntity("fire_witch", createBuilder(EntityFireWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityHalloweenWitch>> HALLOWEEN_WITCH = registerEntity("halloween_witch", createBuilder(EntityHalloweenWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityIceWitch>> ICE_WITCH = registerEntity("ice_witch", createBuilder(EntityIceWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningWitch>> LIGHTNING_WITCH = registerEntity("lightning_witch", createBuilder(EntityLightningWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightWitch>> LIGHT_WITCH = registerEntity("light_witch", createBuilder(EntityLightWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityNatureWitch>> NATURE_WITCH = registerEntity("nature_witch", createBuilder(EntityNatureWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySandMinion>> SAND_MINION = registerEntity("sand_minion", createBuilder(EntitySandMinion::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySandWitch>> SAND_WITCH = registerEntity("sand_witch", createBuilder(EntitySandWitch::new, MobCategory.MONSTER).fireImmune().clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterWitch>> WATER_WITCH = registerEntity("water_witch", createBuilder(EntityWaterWitch::new, MobCategory.MONSTER).clientTrackingRange(80).updateInterval(3).setShouldReceiveVelocityUpdates(true));

	public static final RegistryObject<EntityType<EntityAirShoot>> AIR_SHOOT = registerEntity("air_shoot", EntityType.Builder.<EntityAirShoot>of(EntityAirShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityAirShot>> AIR_SHOT = registerEntity("air_shot", EntityType.Builder.<EntityAirShot>of(EntityAirShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityBigIceCube>> BIG_ICE_CUBE = registerEntity("big_ice_cube", EntityType.Builder.<EntityBigIceCube>of(EntityBigIceCube::new, MobCategory.MISC).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityChristmasShoot>> CHRISTMAS_SHOOT = registerEntity("christmas_shoot", EntityType.Builder.<EntityChristmasShoot>of(EntityChristmasShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkShoot>> DARK_SHOOT = registerEntity("dark_shoot", EntityType.Builder.<EntityDarkShoot>of(EntityDarkShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityDarkShot>> DARK_SHOT = registerEntity("dark_shot", EntityType.Builder.<EntityDarkShot>of(EntityDarkShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityEarthShoot>> EARTH_SHOOT = registerEntity("earth_shoot", EntityType.Builder.<EntityEarthShoot>of(EntityEarthShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityFireShot>> FIRE_SHOT = registerEntity("fire_shot", EntityType.Builder.<EntityFireShot>of(EntityFireShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityIceCube>> ICE_CUBE = registerEntity("ice_cube", EntityType.Builder.<EntityIceCube>of(EntityIceCube::new, MobCategory.MISC).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightArrow>> LIGHT_ARROW = registerEntity("light_arrow", EntityType.Builder.<EntityLightArrow>of(EntityLightArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningBall>> LIGHTNING_BALL = registerEntity("lightning_ball", EntityType.Builder.<EntityLightningBall>of(EntityLightningBall::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightningShoot>> LIGHTNING_SHOOT = registerEntity("lightning_shoot", EntityType.Builder.<EntityLightningShoot>of(EntityLightningShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightShoot>> LIGHT_SHOOT = registerEntity("light_shoot", EntityType.Builder.<EntityLightShoot>of(EntityLightShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityLightShot>> LIGHT_SHOT = registerEntity("light_shot", EntityType.Builder.<EntityLightShot>of(EntityLightShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityNatureBall>> NATURE_BALL = registerEntity("nature_ball", EntityType.Builder.<EntityNatureBall>of(EntityNatureBall::new, MobCategory.MISC).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityNatureShoot>> NATURE_SHOOT = registerEntity("nature_shoot", EntityType.Builder.<EntityNatureShoot>of(EntityNatureShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityPumpkinShot>> PUMPKIN_SHOT = registerEntity("pumpkin_shot", EntityType.Builder.<EntityPumpkinShot>of(EntityPumpkinShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityPumpkinSkull>> PUMPKIN_SKULL = registerEntity("pumpkin_skull", EntityType.Builder.<EntityPumpkinSkull>of(EntityPumpkinSkull::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntitySquidInkBomb>> INK_BOMB = registerEntity("ink_bomb", EntityType.Builder.<EntitySquidInkBomb>of(EntitySquidInkBomb::new, MobCategory.MISC).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterShoot>> WATER_SHOOT = registerEntity("water_shoot", EntityType.Builder.<EntityWaterShoot>of(EntityWaterShoot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static final RegistryObject<EntityType<EntityWaterShot>> WATER_SHOT = registerEntity("water_shot", EntityType.Builder.<EntityWaterShot>of(EntityWaterShot::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(64).updateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static <T extends Entity> EntityType.Builder<T> createBuilder(EntityType.EntityFactory<T> factory, MobCategory category)
	{
		return EntityType.Builder.<T>of(factory, category);
	}
	
	public static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) 
	{
		return ENTITY_TYPES.register(name, () -> builder.build(new ResourceLocation(ElementalWitchesLegacy.MODID, name).toString()));
	}
}
