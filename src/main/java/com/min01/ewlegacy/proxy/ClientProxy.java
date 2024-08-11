package com.min01.ewlegacy.proxy;

import com.min01.ewlegacy.init.EWParticles;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ClientProxy extends CommonProxy
{
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
                    level.addParticle(EWParticles.TORNADO.get(), entity.getX(), entity.getY() - 0.5, entity.getZ(), 0.0D, d, 1.0);
                }
            }
            if(particles.equals("air_tornado_big")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1) 
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.TORNADO.get(), entity.getX(), entity.getY() - 2.0 + j, entity.getZ(), 0.0D, d2, j);
                    level.addParticle(EWParticles.TORNADO.get(), entity.getX(), entity.getY() - 2.0 + j, entity.getZ(), 0.0D, d2, j);
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
                    level.addParticle(EWParticles.SMALL_WIND.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(ParticleTypes.CLOUD, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.GREEN_CHRISTMAS.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(EWParticles.RED_CHRISTMAS.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.DARK.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    //level.addParticle("depthsuspend", entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("dark_tornado"))
            {
                for(int i = 0; i < 4; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.SMALL_DARK_CIRCLE.get(), entity.getX(), entity.getY(), entity.getZ(), 0.0, d, 1.0);
                }
            }
            if(particles.equals("dark_circle")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1)
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.DARK_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, d2, j);
                }
            }
            if(particles.equals("dark_circle_2")) 
            {
                for(double j = 0.0; j < 11.0; j += 0.1) 
                {
                    double d2 = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.DARK_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, d2, 2.0 + j);
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
                    level.addParticle(EWParticles.SOUL.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.SOUL.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.LIGHT.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.LIGHTNING.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("lightning_shoot")) 
            {
            	level.addParticle(EWParticles.LIGHTNING.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("christmas_shoot")) 
            {
                level.addParticle(EWParticles.GREEN_CHRISTMAS.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("dark_shoot")) 
            {
                for(int i = 0; i < 5; ++i)
                {
                	level.addParticle(EWParticles.DARK_PROJECTILE.get(), entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z);
                }
            }
            if(particles.equals("light_shoot"))
            {
                for(int i = 0; i < 5; ++i) 
                {
                	level.addParticle(EWParticles.LIGHT_PROJECTILE.get(), entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z);
                }
            }
            if(particles.equals("lightning_shoot")) 
            {
            	level.addParticle(EWParticles.LIGHTNING.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
            }
            if(particles.equals("nature_shoot"))
            {
                for(int i = 0; i < 5; ++i) 
                {
                	level.addParticle(EWParticles.NATURE_PROJECTILE.get(), entity.getX() + entity.getDeltaMovement().x * i / 4.0, entity.getY() + entity.getDeltaMovement().y * i / 4.0, entity.getZ() + entity.getDeltaMovement().z * i / 4.0, -entity.getDeltaMovement().x, -entity.getDeltaMovement().y + 0.2, -entity.getDeltaMovement().z);
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
                level.addParticle(ParticleTypes.CLOUD, entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
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
                    level.addParticle(EWParticles.FIRE_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, d, 2.5);
                }
            }
            if(particles.equals("fire_tornado_small")) 
            {
                for(int i = 0; i < 10; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.FIRE_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, d, 1.0);
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
                    level.addParticle(ParticleTypes.FLAME, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(ParticleTypes.LAVA, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()), entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("lightning_circle_small")) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                    double d = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.LIGHTNING_CIRCLE.get(), entity.getX(), entity.getY() - 0.5, entity.getZ(), 0.0, d, 0.0);
                }
            }
            if(particles.equals("light_circle_small")) 
            {
                for(int i = 0; i < 1; ++i)
                {
                    double d = level.random.nextGaussian() * 0.004;
                    level.addParticle(EWParticles.LIGHT_CIRCLE.get(), entity.getX(), entity.getY() - 0.5, entity.getZ(), 0.0, d, 0.0);
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
                    level.addParticle(EWParticles.SNOWFLAKE.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, -0.06, d4);
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
                    entity.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.ICE.defaultBlockState()), entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.SNOWFLAKE.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5 * 30.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5 * 30.0, d, -0.06, d4);
                    level.addParticle(EWParticles.SNOWFLAKE.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5 * 30.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5 * 30.0, d, -0.06, d4);
                    level.addParticle(EWParticles.SNOWFLAKE.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5 * 25.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5 * 25.0, d, -0.06, d4);
                    level.addParticle(EWParticles.SNOWFLAKE.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5 * 25.0, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5 * 10.0, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5 * 25.0, d, -0.06, d4);
                }
            }
            if(particles.equals("ice_circle_small")) 
            {
                for(int i = 0; i < 1; ++i) 
                {
                	level.addParticle(EWParticles.ICE_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
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
                	level.addParticle(EWParticles.WATER_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
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
                    level.addParticle(ParticleTypes.FISHING, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SPLASH, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(EWParticles.LEAF.get(), entity.getX() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + entity.level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, -0.03, d4);
                }
            }
            if(particles.equals("leaf_circle")) 
            {
                for(int i = 0; i < 5; ++i) 
                {
                	level.addParticle(EWParticles.LEAF_CIRCLE.get(), entity.getX(), entity.getY() + 0.5, entity.getZ(), 0.0, 0.0, 0.0);
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
                    level.addParticle(ParticleTypes.FLAME, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.LAVA, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.ENCHANT, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(ParticleTypes.LARGE_SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    level.addParticle(ParticleTypes.SMOKE, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                    //level.addParticle("depthsuspend", entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
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
                    level.addParticle(ParticleTypes.ENCHANTED_HIT, entity.getX() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d * d5, entity.getY() + level.random.nextFloat() * entity.getBbHeight() - d3 * d5, entity.getZ() + level.random.nextFloat() * entity.getBbWidth() * 2.0F - entity.getBbWidth() - d4 * d5, d, d3, d4);
                }
            }
            if(particles.equals("water_evaporate"))
            {
                level.addParticle(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.5, 0.0);
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
                	level.addParticle(EWParticles.LEAF.get(), posX, posY, posZ, motionX, motionY, motionZ);
                }
            }
            if(particles.equals("poisonplant")) 
            {
                double d = level.random.nextGaussian() * 0.02;
                double d2 = level.random.nextGaussian() * 0.02;
                for(int j = 0; j < 10; ++j) 
                {
                    level.addParticle(EWParticles.POISON.get(), posX, posY, posZ, d, 0.05, d2);
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
