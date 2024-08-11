package com.min01.ewlegacy.event;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.model.ModelBigSnowGolem;
import com.min01.ewlegacy.entity.model.ModelCandyCane;
import com.min01.ewlegacy.entity.model.ModelCube;
import com.min01.ewlegacy.entity.model.ModelDarkMark;
import com.min01.ewlegacy.entity.model.ModelEgg;
import com.min01.ewlegacy.entity.model.ModelEnt;
import com.min01.ewlegacy.entity.model.ModelEntGuardian;
import com.min01.ewlegacy.entity.model.ModelFireBat;
import com.min01.ewlegacy.entity.model.ModelIceCrystal;
import com.min01.ewlegacy.entity.model.ModelIcicle;
import com.min01.ewlegacy.entity.model.ModelLightShield;
import com.min01.ewlegacy.entity.model.ModelLightningGolem;
import com.min01.ewlegacy.entity.model.ModelNinjaKhan;
import com.min01.ewlegacy.entity.model.ModelRifle;
import com.min01.ewlegacy.entity.model.ModelRoot;
import com.min01.ewlegacy.entity.model.ModelSwiftEnt;
import com.min01.ewlegacy.entity.model.ModelWaterMinion;
import com.min01.ewlegacy.entity.render.DarkMarkRenderer;
import com.min01.ewlegacy.entity.render.EWCubeRenderer;
import com.min01.ewlegacy.entity.render.EWEggRenderer;
import com.min01.ewlegacy.entity.render.EWMobRenderer;
import com.min01.ewlegacy.entity.render.EWTranslucentMobRenderer;
import com.min01.ewlegacy.entity.render.EWWitchRenderer;
import com.min01.ewlegacy.entity.render.EarthWitchRenderer;
import com.min01.ewlegacy.entity.render.EnderHoleRenderer;
import com.min01.ewlegacy.entity.render.EntGuardianRenderer;
import com.min01.ewlegacy.entity.render.FireBatRenderer;
import com.min01.ewlegacy.entity.render.GiantSquidRenderer;
import com.min01.ewlegacy.entity.render.IceWitchRenderer;
import com.min01.ewlegacy.entity.render.IcicleRenderer;
import com.min01.ewlegacy.entity.render.LightArrowRenderer;
import com.min01.ewlegacy.entity.render.LightHealRenderer;
import com.min01.ewlegacy.entity.render.LightWitchRenderer;
import com.min01.ewlegacy.entity.render.LightningGolemRenderer;
import com.min01.ewlegacy.entity.render.LightningWitchRenderer;
import com.min01.ewlegacy.entity.render.NoneRenderer;
import com.min01.ewlegacy.entity.render.PumpkinSkullRenderer;
import com.min01.ewlegacy.entity.render.SandGolemRenderer;
import com.min01.ewlegacy.entity.render.SmallDarkMarkRenderer;
import com.min01.ewlegacy.entity.render.SwiftEntRenderer;
import com.min01.ewlegacy.entity.skill.EntitySandMark;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWParticles;
import com.min01.ewlegacy.particle.DarkCircleParticle;
import com.min01.ewlegacy.particle.DarkParticle;
import com.min01.ewlegacy.particle.DarkProjectileParticle;
import com.min01.ewlegacy.particle.FireCircleParticle;
import com.min01.ewlegacy.particle.GreenChristmasParticle;
import com.min01.ewlegacy.particle.IceCircleParticle;
import com.min01.ewlegacy.particle.LeafCircleParticle;
import com.min01.ewlegacy.particle.LeafParticle;
import com.min01.ewlegacy.particle.LightCircleParticle;
import com.min01.ewlegacy.particle.LightParticle;
import com.min01.ewlegacy.particle.LightProjectileParticle;
import com.min01.ewlegacy.particle.LightningCircleParticle;
import com.min01.ewlegacy.particle.LightningParticle;
import com.min01.ewlegacy.particle.NatureProjectileParticle;
import com.min01.ewlegacy.particle.PoisonParticle;
import com.min01.ewlegacy.particle.RedChristmasParticle;
import com.min01.ewlegacy.particle.SmallDarkCircleParticle;
import com.min01.ewlegacy.particle.SmallSmokeCircleParticle;
import com.min01.ewlegacy.particle.SmallWindParticle;
import com.min01.ewlegacy.particle.SnowFlakeParticle;
import com.min01.ewlegacy.particle.SoulParticle;
import com.min01.ewlegacy.particle.TornadoParticle;
import com.min01.ewlegacy.particle.WaterCircleParticle;
import com.min01.ewlegacy.particle.WindParticle;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementalWitchesLegacy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
	@SubscribeEvent
	public static void onRegisterParticleProviders(RegisterParticleProvidersEvent event)
	{
		event.register(EWParticles.DARK_CIRCLE.get(), DarkCircleParticle.Provider::new);
		event.register(EWParticles.DARK.get(), DarkParticle.Provider::new);
		event.register(EWParticles.DARK_PROJECTILE.get(), DarkProjectileParticle.Provider::new);
		event.register(EWParticles.FIRE_CIRCLE.get(), FireCircleParticle.Provider::new);
		event.register(EWParticles.GREEN_CHRISTMAS.get(), GreenChristmasParticle.Provider::new);
		event.register(EWParticles.ICE_CIRCLE.get(), IceCircleParticle.Provider::new);
		event.register(EWParticles.LEAF_CIRCLE.get(), LeafCircleParticle.Provider::new);
		event.register(EWParticles.LEAF.get(), LeafParticle.Provider::new);
		event.register(EWParticles.LIGHT_CIRCLE.get(), LightCircleParticle.Provider::new);
		event.register(EWParticles.LIGHTNING_CIRCLE.get(), LightningCircleParticle.Provider::new);
		event.register(EWParticles.LIGHTNING.get(), LightningParticle.Provider::new);
		event.register(EWParticles.LIGHT.get(), LightParticle.Provider::new);
		event.register(EWParticles.LIGHT_PROJECTILE.get(), LightProjectileParticle.Provider::new);
		event.register(EWParticles.NATURE_PROJECTILE.get(), NatureProjectileParticle.Provider::new);
		event.register(EWParticles.POISON.get(), PoisonParticle.Provider::new);
		event.register(EWParticles.RED_CHRISTMAS.get(), RedChristmasParticle.Provider::new);
		event.register(EWParticles.SMALL_DARK_CIRCLE.get(), SmallDarkCircleParticle.Provider::new);
		event.register(EWParticles.SMALL_SMOKE_CIRCLE.get(), SmallSmokeCircleParticle.Provider::new);
		event.register(EWParticles.SMALL_WIND.get(), SmallWindParticle.Provider::new);
		event.register(EWParticles.SNOWFLAKE.get(), SnowFlakeParticle.Provider::new);
		event.register(EWParticles.SOUL.get(), SoulParticle.Provider::new);
		event.register(EWParticles.TORNADO.get(), TornadoParticle.Provider::new);
		event.register(EWParticles.WATER_CIRCLE.get(), WaterCircleParticle.Provider::new);
		event.register(EWParticles.WIND.get(), WindParticle.Provider::new);
	}
	
    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
    	event.registerLayerDefinition(ModelEgg.LAYER_LOCATION, ModelEgg::createBodyLayer);
    	event.registerLayerDefinition(ModelCube.LAYER_LOCATION, ModelCube::createBodyLayer);
    	event.registerLayerDefinition(ModelCandyCane.LAYER_LOCATION, ModelCandyCane::createBodyLayer);
    	event.registerLayerDefinition(ModelFireBat.LAYER_LOCATION, ModelFireBat::createBodyLayer);
    	event.registerLayerDefinition(ModelBigSnowGolem.LAYER_LOCATION, ModelBigSnowGolem::createBodyLayer);
    	event.registerLayerDefinition(ModelDarkMark.LAYER_LOCATION, ModelDarkMark::createBodyLayer);
    	event.registerLayerDefinition(ModelEnt.LAYER_LOCATION, ModelEnt::createBodyLayer);
    	event.registerLayerDefinition(ModelEntGuardian.LAYER_LOCATION, ModelEntGuardian::createBodyLayer);
    	event.registerLayerDefinition(ModelIceCrystal.LAYER_LOCATION, ModelIceCrystal::createBodyLayer);
    	event.registerLayerDefinition(ModelIcicle.LAYER_LOCATION, ModelIcicle::createBodyLayer);
    	event.registerLayerDefinition(ModelSwiftEnt.LAYER_LOCATION, ModelSwiftEnt::createBodyLayer);
    	event.registerLayerDefinition(ModelRoot.LAYER_LOCATION, ModelRoot::createBodyLayer);
    	event.registerLayerDefinition(ModelRifle.LAYER_LOCATION, ModelRifle::createBodyLayer);
    	event.registerLayerDefinition(ModelNinjaKhan.LAYER_LOCATION, ModelNinjaKhan::createBodyLayer);
    	event.registerLayerDefinition(ModelLightShield.LAYER_LOCATION, ModelLightShield::createBodyLayer);
    	event.registerLayerDefinition(ModelLightningGolem.LAYER_LOCATION, ModelLightningGolem::createBodyLayer);
    }
    
    @SubscribeEvent
    public static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
    	event.registerEntityRenderer(EWEntities.AIR_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "air_egg"));
    	event.registerEntityRenderer(EWEntities.DARK_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "dark_egg"));
    	event.registerEntityRenderer(EWEntities.EARTH_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "earth_egg"));
    	event.registerEntityRenderer(EWEntities.FIRE_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "fire_egg"));
    	event.registerEntityRenderer(EWEntities.HALLOWEEN_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "halloween_egg"));
    	event.registerEntityRenderer(EWEntities.ICE_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "ice_egg"));
    	event.registerEntityRenderer(EWEntities.LIGHT_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "light_egg"));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "lightning_egg"));
    	event.registerEntityRenderer(EWEntities.NATURE_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "nature_egg"));
    	event.registerEntityRenderer(EWEntities.WATER_EGG.get(), p_174010_ -> new EWEggRenderer<>(p_174010_, 0.5F, "water_egg"));

    	//TODO
    	event.registerEntityRenderer(EWEntities.AIR_PHOENIX.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.AIR_PHOENIX_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.AIR_PHOENIX_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SPIRIT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SPIRIT_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SPIRIT_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.EARTH_GOLEM.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.EARTH_GOLEM_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.EARTH_GOLEM_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_DRAGON.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_DRAGON_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_DRAGON_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.HALLOWEEN_PUMPKIN.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.HALLOWEEN_PUMPKING.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.ICE_BEAST.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_ANGEL.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_ANGEL_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_ANGEL_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_BEAST.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_BEAST_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_BEAST_3.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.NATURE_GOLEM.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.WATER_NYMPH.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.WATER_NYMPH_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));

    	event.registerEntityRenderer(EWEntities.AIR_CLONE.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "air_witch"));
    	event.registerEntityRenderer(EWEntities.BIG_SNOW_GOLEM.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelBigSnowGolem(p_174010_.bakeLayer(ModelBigSnowGolem.LAYER_LOCATION)), 0.5F, "big_snow_golem"));
    	event.registerEntityRenderer(EWEntities.BLOCK.get(), p_174010_ -> new FallingBlockRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.CANDY_CANE.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelCandyCane(p_174010_.bakeLayer(ModelCandyCane.LAYER_LOCATION)), 0.5F, "candy_cane"));
    	event.registerEntityRenderer(EWEntities.DARK_MARK.get(), p_174010_ -> new DarkMarkRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SUMMONER.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DEATH_CIRCLE.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DEATH_CIRCLE_2.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.ENDER_HOLE.get(), p_174010_ -> new EnderHoleRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.ENT.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelEnt(p_174010_.bakeLayer(ModelEnt.LAYER_LOCATION)), 0.5F, "ent"));
    	event.registerEntityRenderer(EWEntities.ENT_GUARDIAN.get(), p_174010_ -> new EntGuardianRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.EXPLOSIVE_PUMPKIN.get(), p_174010_ -> new EWCubeRenderer<>(p_174010_, "explosive_pumpkin"));
    	event.registerEntityRenderer(EWEntities.FIRE_BAT.get(), p_174010_ -> new FireBatRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_METEORITE.get(), p_174010_ -> new EWCubeRenderer<>(p_174010_, "fire_meteorite"));
    	event.registerEntityRenderer(EWEntities.FROST_NOVA.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.GIANT_SQUID.get(), p_174010_ -> new GiantSquidRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.ICE_CRYSTAL.get(), p_174010_ -> new EWTranslucentMobRenderer<>(p_174010_, new ModelIceCrystal(p_174010_.bakeLayer(ModelIceCrystal.LAYER_LOCATION)), 0.5F, "ice_crystal"));
    	event.registerEntityRenderer(EWEntities.ICICLE.get(), p_174010_ -> new IcicleRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_HEAL.get(), p_174010_ -> new LightHealRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_GOLEM.get(), p_174010_ -> new LightningGolemRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_SHIELD.get(), p_174010_ -> new EWTranslucentMobRenderer<>(p_174010_, new ModelLightShield<>(p_174010_.bakeLayer(ModelLightShield.LAYER_LOCATION)), 0.0F, "light_shield"));
    	event.registerEntityRenderer(EWEntities.LIGHT_SHIELD_BAD.get(), p_174010_ -> new EWTranslucentMobRenderer<>(p_174010_, new ModelLightShield<>(p_174010_.bakeLayer(ModelLightShield.LAYER_LOCATION)), 0.0F, "light_shield"));
    	event.registerEntityRenderer(EWEntities.MINI_TORNADO.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.NINJA_KHAN.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelNinjaKhan(p_174010_.bakeLayer(ModelNinjaKhan.LAYER_LOCATION)), 0.0F, "ninja_khan"));
    	event.registerEntityRenderer(EWEntities.RIFLE.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelRifle(p_174010_.bakeLayer(ModelRifle.LAYER_LOCATION)), 0.5F, "rifle"));
    	event.registerEntityRenderer(EWEntities.ROOT.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelRoot(p_174010_.bakeLayer(ModelRoot.LAYER_LOCATION)), 0.0F, "root"));
    	event.registerEntityRenderer(EWEntities.SAND_GOLEM.get(), p_174010_ -> new SandGolemRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.SAND_MARK.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelDarkMark<EntitySandMark>(p_174010_.bakeLayer(ModelDarkMark.LAYER_LOCATION)), 0.5F, "sand_mark"));
    	event.registerEntityRenderer(EWEntities.SMALL_DARK_MARK.get(), p_174010_ -> new SmallDarkMarkRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.SWIFT_ENT.get(), p_174010_ -> new SwiftEntRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.TORNADO.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.WATER_MINION.get(), p_174010_ -> new EWMobRenderer<>(p_174010_, new ModelWaterMinion(p_174010_.bakeLayer(ModelLayers.ZOMBIE)), 0.5F, "water_minion"));
    	event.registerEntityRenderer(EWEntities.WATER_SPOUT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	
    	event.registerEntityRenderer(EWEntities.AIR_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "air_witch"));
    	event.registerEntityRenderer(EWEntities.CHRISTMAS_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "christmas_witch"));
    	event.registerEntityRenderer(EWEntities.DARK_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "dark_witch"));
    	event.registerEntityRenderer(EWEntities.EARTH_MINION.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "earth_minion"));
    	event.registerEntityRenderer(EWEntities.EARTH_MINION_GOOD.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "earth_minion_good"));
    	event.registerEntityRenderer(EWEntities.EARTH_WITCH.get(), p_174010_ -> new EarthWitchRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "fire_witch"));
    	event.registerEntityRenderer(EWEntities.HALLOWEEN_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "halloween_witch"));
    	event.registerEntityRenderer(EWEntities.ICE_WITCH.get(), p_174010_ -> new IceWitchRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_WITCH.get(), p_174010_ -> new LightningWitchRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_WITCH.get(), p_174010_ -> new LightWitchRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.NATURE_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "nature_witch"));
    	event.registerEntityRenderer(EWEntities.SAND_MINION.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "sand_minion"));
    	event.registerEntityRenderer(EWEntities.SAND_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "sand_witch"));
    	event.registerEntityRenderer(EWEntities.WATER_WITCH.get(), p_174010_ -> new EWWitchRenderer<>(p_174010_, "water_witch"));
    	
    	event.registerEntityRenderer(EWEntities.AIR_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.AIR_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.BIG_ICE_CUBE.get(), p_174010_ -> new EWCubeRenderer<>(p_174010_, "ice_cube"));
    	event.registerEntityRenderer(EWEntities.CHRISTMAS_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.DARK_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.EARTH_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.FIRE_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.ICE_CUBE.get(), p_174010_ -> new EWCubeRenderer<>(p_174010_, "ice_cube"));
    	event.registerEntityRenderer(EWEntities.LIGHT_ARROW.get(), p_174010_ -> new LightArrowRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_BALL.get(), p_174010_ -> new ThrownItemRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHTNING_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.LIGHT_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.NATURE_BALL.get(), p_174010_ -> new ThrownItemRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.NATURE_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.PUMPKIN_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.PUMPKIN_SKULL.get(), p_174010_ -> new PumpkinSkullRenderer(p_174010_));
    	event.registerEntityRenderer(EWEntities.INK_BOMB.get(), p_174010_ -> new ThrownItemRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.WATER_SHOOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    	event.registerEntityRenderer(EWEntities.WATER_SHOT.get(), p_174010_ -> new NoneRenderer<>(p_174010_));
    }
}
