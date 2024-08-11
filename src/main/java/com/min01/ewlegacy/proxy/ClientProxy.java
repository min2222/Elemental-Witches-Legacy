package com.min01.ewlegacy.proxy;

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
import com.min01.ewlegacy.particle.SmallWindParticle;
import com.min01.ewlegacy.particle.SnowFlakeParticle;
import com.min01.ewlegacy.particle.SoulParticle;
import com.min01.ewlegacy.particle.TornadoParticle;
import com.min01.ewlegacy.particle.WaterCircleParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ClientProxy extends CommonProxy
{
	public static final Minecraft MC = Minecraft.getInstance();
    
    @Override
    public void spawnParticles(String particles, Entity entity)
    {
        Level level = entity.level;
        if(level.isClientSide)
        {
            if(particles.equals("air_tornado_small")) 
            {
                for(int i = 0; i < 10; ++i)
                {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new TornadoParticle((ClientLevel)level, entity.getX(), entity.getY() - 0.5, entity.getZ(), d, 1.0));
                }
            }
            if(particles.equals("air_tornado_big")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1) 
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new TornadoParticle((ClientLevel)level, entity.getX(), entity.getY() - 2.0 + j, entity.getZ(), d2, j));
                    MC.particleEngine.add(new TornadoParticle((ClientLevel)level, entity.getX(), entity.getY() - 2.0 + j, entity.getZ(), d2, j));
                }
            }
            if(particles.equals("air_normal"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new SmallWindParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("air_main"))
            {
                for(int i = 0; i < 1; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.EXPLOSION, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("christmas_normal"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new GreenChristmasParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                    MC.particleEngine.add(new RedChristmasParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("dark_normal"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new DarkParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("dark_mark"))
            {
                for(int i = 0; i < 5; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    //level.addParticle("depthsuspend", entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("dark_tornado"))
            {
                for(int i = 0; i < 4; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new SmallDarkCircleParticle((ClientLevel)level, entity.getX(), entity.getY(), entity.getZ(), d, 1.0));
                }
            }
            if(particles.equals("dark_circle")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1)
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new DarkCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), d2, j));
                }
            }
            if(particles.equals("dark_circle_2")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1) 
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new DarkCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), d2, 2.0 + j));
                }
            }
            if(particles.equals("halloween_normal"))
            {
                for(int i = 0; i < 10; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new SoulParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("halloween_normal_4")) 
            {
                for(int i = 0; i < 4; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new SoulParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("portal"))
            {
                for(int i = 0; i < 1; ++i) 
                {
                    entity.level.addParticle(ParticleTypes.PORTAL, entity.getX() + (level.random.nextDouble() - 0.5) * entity.getBbWidth(), entity.getY() + level.random.nextDouble() * entity.getBbHeight() - 0.25, entity.getZ() + (level.random.nextDouble() - 0.5) * entity.getBbWidth(), (level.random.nextDouble() - 0.5) * 2.0, -level.random.nextDouble(), (level.random.nextDouble() - 0.5) * 2.0);
                }
            }
            if(particles.equals("light_normal")) 
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new LightParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("lightning_normal"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new LightningParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4));
                }
            }
            if(particles.equals("lightning_shoot")) 
            {
                MC.particleEngine.add(new LightningParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0));
            }
            if(particles.equals("christmas_shoot")) 
            {
                MC.particleEngine.add(new GreenChristmasParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0));
            }
            if(particles.equals("dark_shoot")) 
            {
                for(int i = 0; i < 5; ++i)
                {
                    MC.particleEngine.add(new DarkProjectileParticle((ClientLevel)level, entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z));
                }
            }
            if(particles.equals("light_shoot"))
            {
                for(int i = 0; i < 5; ++i) 
                {
                    MC.particleEngine.add(new LightProjectileParticle((ClientLevel)level, entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z));
                }
            }
            if(particles.equals("lightning_shoot")) 
            {
                MC.particleEngine.add(new LightningParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0));
            }
            if(particles.equals("nature_shoot"))
            {
                for(int i = 0; i < 5; ++i) 
                {
                    MC.particleEngine.add(new NatureProjectileParticle((ClientLevel)level, entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z));
                }
            }
            if(particles.equals("ice_shoot"))
            {
                for(int i = 0; i < 8; ++i) 
                {
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.ICE.defaultBlockState()), entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.0, 0.0);
                }
            }
            if(particles.equals("earth_shoot"))
            {
                for(int i = 0; i < 8; ++i) 
                {
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()), entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.0, 0.0);
                }
            }
            if(particles.equals("waterParticle_base"))
            {
                for(int k = 0; k < 4; ++k) 
                {
                    float f3 = 0.25F;
                    level.addParticle(ParticleTypes.BUBBLE, entity.getX() - entity.getDeltaMovement().x * f3, entity.getY() - entity.getDeltaMovement().y * f3, entity.getZ() - entity.getDeltaMovement().z * f3, entity.getDeltaMovement().x, entity.getDeltaMovement().y, entity.getDeltaMovement().z);
                }
            }
            if(particles.equals("pumpkin_shoot")) 
            {
                level.addParticle(ParticleTypes.FLAME, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("wind_shoot")) 
            {
                level.addParticle(ParticleTypes.EXPLOSION, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("water_shoot"))
            {
                level.addParticle(ParticleTypes.SPLASH, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("fire_tornado_big"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new FireCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), d, 2.5));
                }
            }
            if(particles.equals("fire_tornado_small")) 
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new FireCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), d, 1.0));
                }
            }
            if(particles.equals("fire_main")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.FLAME, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("lava_main"))
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.LAVA, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("earth_big")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()), entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("lightning_circle_small")) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new LightningCircleParticle((ClientLevel)level, entity.getX(), entity.getY() - 0.5, entity.getZ(), d, 1.0));
                }
            }
            if(particles.equals("light_circle_small")) 
            {
                for(int i = 0; i < 1; ++i) {
                    double d = level.random.nextGaussian() * 0.004;
                    MC.particleEngine.add(new LightCircleParticle((ClientLevel)level, entity.getX(), entity.getY() - 0.5, entity.getZ(), d, 1.0));
                }
            }
            if(particles.equals("ice_normal")) 
            {
                for(int i = 0; i < 7; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new SnowFlakeParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, -0.06, d4));
                }
            }
            if(particles.equals("ice_block")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    entity.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.ICE.defaultBlockState()), entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("icefog_normal"))
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new SnowFlakeParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5 * 30.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5 * 30.0, d, -0.06, d4));
                    MC.particleEngine.add(new SnowFlakeParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5 * 30.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5 * 30.0, d, -0.06, d4));
                    MC.particleEngine.add(new SnowFlakeParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5 * 25.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5 * 25.0, d, -0.06, d4));
                    MC.particleEngine.add(new SnowFlakeParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5 * 25.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5 * 25.0, d, -0.06, d4));
                }
            }
            if(particles.equals("ice_circle_small")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    MC.particleEngine.add(new IceCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 2.0));
                }
            }
            if(particles.equals("ender_normal")) 
            {
                for(int i = 0; i < 4; ++i) 
                {
                    level.addParticle(ParticleTypes.PORTAL, entity.getX() + (entity.level.random.nextDouble() - 0.5) * entity.getBbWidth(), entity.getY() + entity.level.random.nextDouble() * entity.getBbHeight() - 0.25, entity.getZ() + (entity.level.random.nextDouble() - 0.5) * entity.getBbWidth(), (entity.level.random.nextDouble() - 0.5) * 2.0, -entity.level.random.nextDouble(), (entity.level.random.nextDouble() - 0.5) * 2.0);
                }
            }
            if(particles.equals("water_circle")) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                    MC.particleEngine.add(new WaterCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.5));
                }
            }
            if(particles.equals("water_normal")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.FISHING, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SPLASH, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("leaf_normal")) 
            {
                for(int i = 0; i < 5; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    MC.particleEngine.add(new LeafParticle((ClientLevel)level, entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, -0.03, d4));
                }
            }
            if(particles.equals("leaf_circle")) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                    MC.particleEngine.add(new LeafCircleParticle((ClientLevel)level, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.5));
                }
            }
            if(particles.equals("meteor"))
            {
                for(int i = 0; i < 10; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.FLAME, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.LAVA, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.ENCHANT, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("ninjakhan"))
            {
                for(int i = 0; i < 5; ++i)
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    //level.addParticle("depthsuspend", entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("toysParticle")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.02;
                    double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = 10.0;
                    level.addParticle(ParticleTypes.ENCHANTED_HIT, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0f - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("water_evaporate"))
            {
                level.addParticle(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
            }
            if(particles.equals("water_sprout")) 
            {
                level.addParticle(ParticleTypes.FISHING, entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.FISHING, entity.getX() + 0.2, entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.FISHING, entity.getX() - 0.2, entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.FISHING, entity.getX(), entity.getY(), entity.getZ() + 0.2, 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.FISHING, entity.getX() + 0.2, entity.getY(), entity.getZ() - 0.2, 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.SPLASH, entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.SPLASH, entity.getX() + 0.2, entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.SPLASH, entity.getX() - 0.2, entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.SPLASH, entity.getX(), entity.getY(), entity.getZ() + 0.2, 0.0, 0.5, 0.0);
                level.addParticle(ParticleTypes.SPLASH, entity.getX() + 0.2, entity.getY(), entity.getZ() - 0.2, 0.0, 0.5, 0.0);
            }
        }
    }
    
    @Override
    public void spawnParticlesWithMotion(String particles, Level level, double posX, double posY, double posZ, double motionX, double motionY, double motionZ) 
    {
        if(level.isClientSide) 
        {
            if(particles.equals("leaf_normal_recover"))
            {
                for(int i = 0; i < 2; ++i) 
                {
                    MC.particleEngine.add(new LeafParticle((ClientLevel)level, posX, posY, posZ, motionX, motionY, motionZ));
                }
            }
            if(particles.equals("poisonplant")) 
            {
                double d = level.random.nextGaussian() * 0.02;
                double d2 = level.random.nextGaussian() * 0.02;
                for(int j = 0; j < 10; ++j) {
                    MC.particleEngine.add(new PoisonParticle((ClientLevel)level, posX, posY, posZ, d, 0.05, d2));
                }
            }
            if(particles.equals("explosiveplant")) 
            {
                for(int i = 0; i < 10; ++i) 
                {
                    level.addParticle(ParticleTypes.SMOKE, posX, posY, posZ, 0.0, 0.05, 0.0);
                }
            }
            if(particles.equals("slownessplant")) 
            {
                for(int i = 0; i < 5; ++i)
                {
                    /*double d3 = level.random.nextGaussian() * 0.02;
                    double d4 = level.random.nextGaussian() * 0.02;
                    double d5 = level.random.nextGaussian() * 0.02;
                    double d6 = 10.0;*/
                    //level.addParticle("depthsuspend", posX + level.random.nextFloat() * 0.5 * 2.0 - 0.5 - d3 * d6, posY + level.random.nextFloat() * 0.5 - d4 * d6, posZ + level.random.nextFloat() * 0.5 * 2.0 - 0.5 - d5 * d6, d3, 0.0, d5);
                }
            }
            if(particles.equals("darknessplant"))
            {
                for(int i = 0; i < 3; ++i) 
                {
                    double d3 = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.SMALL_SMOKE_CIRCLE.get(), posX, posY, posZ, 0.0, d3, 0.0);
                }
            }
            if(particles.equals("sittingSignal"))
            {
                level.addParticle(DustParticleOptions.REDSTONE, posX, posY, posZ, 0.0, 0.0, 0.0);
            }
        }
    }
}
