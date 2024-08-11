package com.min01.ewlegacy.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IceCircleParticle extends SnowFlakeParticle
{
    private final double orbitSpeed;
    private final double portalPosX;
    private final double portalPosZ;
    private final float portalParticleScale;
    public double size;
    private byte customAge;
    private byte customMaxAge;
    private double orbitAngle;
    
    public IceCircleParticle(ClientLevel world, double x, double y, double z, double motionY, double angle) 
    {
        super(world, x, y, z, 0.0, motionY, 0.0);
        this.portalPosX = x;
        this.portalPosZ = z;
        this.zd = this.xd = 0.0D;
        this.orbitAngle = 314.1592653589793;
        this.size = angle;
        this.orbitSpeed = (world.random.nextDouble() * 0.3217 + 0.1954) * (this.random.nextBoolean() ? 1 : -1);
        this.customMaxAge = (byte)(this.lifetime = this.age = this.random.nextInt(15) + 10 * 2);
        this.portalParticleScale = this.quadSize = 0.6F;
    }
    
    @Override
    public float getQuadSize(float partialTicks)
    {
        float scale = 1.0F - (this.age + partialTicks) / this.lifetime;
        scale *= scale;
        this.quadSize = this.portalParticleScale * (1.0F - scale);
        return this.quadSize * 0.1F;
    }
    
    @Override
    public void tick() 
    {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.x = this.portalPosX + Math.cos(this.orbitAngle) * this.size;
        this.y += this.yd;
        this.z = this.portalPosZ + Math.sin(this.orbitAngle) * this.size;
        this.orbitAngle += this.orbitSpeed;
        if((this.customAge = (byte)(this.customAge + 1)) > this.customMaxAge)
        {
            this.remove();
        }
        else if(this.customAge >= this.customMaxAge >> 1) 
        {
            --this.age;
        }
    }
    
	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType>
	{
		private final SpriteSet sprites;

		public Provider(SpriteSet p_106555_) 
		{
			this.sprites = p_106555_;
		}
		
		@Override
		public Particle createParticle(SimpleParticleType p_107421_, ClientLevel p_107422_, double p_107423_, double p_107424_, double p_107425_, double p_107426_, double p_107427_, double p_107428_) 
		{
			IceCircleParticle particle = new IceCircleParticle(p_107422_, p_107423_, p_107424_, p_107425_, p_107427_, 0.5D);
			particle.pickSprite(this.sprites);
			return particle;
		}
	}
}
