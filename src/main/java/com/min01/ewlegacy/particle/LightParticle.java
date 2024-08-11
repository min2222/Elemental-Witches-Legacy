package com.min01.ewlegacy.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LightParticle extends TextureSheetParticle
{
    public LightParticle(ClientLevel level, double posX, double posY, double posZ, double motionX, double motionY, double motionZ) 
    {
        super(level, posX, posY, posZ, motionX, motionY, motionZ);
        this.alpha = 0.5F;
        this.quadSize = 1.2F;
        this.lifetime = 3;
        this.hasPhysics = false;
    }
    
    @Override
    public float getQuadSize(float p_107681_) 
    {
    	return this.quadSize * 0.1F;
    }
    
    @Override
    public void tick() 
    {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if(this.age++ >= this.lifetime)
        {
            this.remove();
        }
        if(this.age > this.lifetime / 2) 
        {
            this.setAlpha(1.0f - (this.age - (float)(this.lifetime / 2)) / this.lifetime);
        }
    }
    
	@Override
	public ParticleRenderType getRenderType() 
	{
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
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
			LightParticle particle = new LightParticle(p_107422_, p_107423_, p_107424_, p_107425_, p_107426_, p_107427_, p_107428_);
			particle.pickSprite(this.sprites);
			return particle;
		}
	}
}
