package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

public class EntityIceCrystal extends AbstractOwnableMonster<EntityIceWitch>
{
    public EntityIceCrystal(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 10.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.STONE_BREAK;
    }
    
    @Override
    protected SoundEvent getDeathSound() 
    {
        return SoundEvents.GLASS_BREAK;
    }
    
    @Override
    public boolean isPushable() 
    {
    	return false;
    }
    
    @Override
    protected void doPush(Entity p_20971_) 
    {
    	
    }
    
    @Override
    protected void pushEntities()
    {
    	
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void tick() 
    {
        if(this.getHealth() <= 0.0F) 
        {
            this.discard();
        }
        if(!this.onGround && this.getDeltaMovement().y <= 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.0, 1));
        }
        if(!this.level.isClientSide && this.tickCount >= 400) 
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, explosion$blockinteraction);
            EntityFrostNova entitysnowball = new EntityFrostNova(EWEntities.FROST_NOVA.get(), this.level);
            entitysnowball.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            EWUtil.spawnInWorld(this.level, entitysnowball);
            this.discard();
        }
        int i1 = (int) Math.floor(this.getX());
        int j1 = (int) Math.floor(this.getZ());
        for(int l1 = -5; l1 <= 5; ++l1) 
        {
            for(int i2 = -5; i2 <= 5; ++i2) 
            {
                for(int k = 0; k <= 10; ++k) 
                {
                    for(int m = -1; m <= 0; ++m) 
                    {
                        int j2 = i1 + l1;
                        int k2 = (int) (Math.floor(this.getY()) + m);
                        int l2 = j1 + i2;
                        BlockPos pos = new BlockPos(j2, k2, l2);
                        if(this.level.getBlockState(pos).isAir() && Blocks.SNOW.canSurvive(this.level.getBlockState(pos), this.level, pos))
                        {
                            this.level.setBlockAndUpdate(pos, Blocks.SNOW.defaultBlockState());
                        }
                        if(this.level.getBlockState(pos).getMaterial() == Material.WATER)
                        {
                            this.level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
                        }
                    }
                }
            }
        }
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(1.0, 1.0, 1.0));
        for(Entity entity1 : list) 
        {
            if(!(entity1 instanceof EntityIceWitch) && !(entity1 instanceof EntityIceCube) && !(entity1 instanceof EntityIcicle) && !(entity1 instanceof EntityIceCrystal) && (!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild))
            {
                if(!(entity1 instanceof EntityBigIceCube))
                {
                    if(entity1 instanceof LivingEntity) 
                    {
                        ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 50, 5));
                    }
                }
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("ice_circle_small", this);
        super.tick();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof EntityIceCube) && !(source.getEntity() instanceof EntityIcicle) && !(source.getEntity() instanceof EntityIceCrystal) && !(source.getEntity() instanceof EntityFrostNova) && !(source.getEntity() instanceof EntityBigIceCube) && super.hurt(source, damage);
    }
}
