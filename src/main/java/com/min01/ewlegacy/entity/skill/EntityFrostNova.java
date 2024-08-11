package com.min01.ewlegacy.entity.skill;

import java.util.List;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityBigIceCube;
import com.min01.ewlegacy.entity.projectile.EntityIceCube;
import com.min01.ewlegacy.entity.witch.EntityIceWitch;
import com.min01.ewlegacy.init.EWEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

public class EntityFrostNova extends AbstractOwnableMonster<EntityIceWitch>
{
    public EntityFrostNova(EntityType<? extends Monster> type, Level level) 
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
        if(!this.onGround && this.getDeltaMovement().y <= 0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.0, 1));
        }
        int i1 = Mth.floor(this.getX());
        int j1 = Mth.floor(this.getZ());
        for(int l1 = -5; l1 <= 5; ++l1)
        {
            for(int i2 = -5; i2 <= 5; ++i2) 
            {
                for(int k = 0; k <= 10; ++k) 
                {
                    for(int m = -1; m <= 0; ++m)
                    {
                        int j2 = i1 + l1;
                        int k2 = Mth.floor(this.getY()) + m;
                        int l2 = j1 + i2;
                        BlockPos pos = new BlockPos(j2, k2, l2);
                        if(this.level.getBlockState(pos).getMaterial() == Material.AIR && Blocks.SNOW.canSurvive(this.level.getBlockState(pos), this.level, pos))
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
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(10.0, 10.0, 10.0));
        for(Entity entity1 : list)
        {
            if(entity1 instanceof EntityIceWitch || entity1 instanceof EntityIceCube || entity1 instanceof EntityIceCrystal || entity1 instanceof EntityIcicle || (entity1 instanceof Player && ((Player)entity1).getAbilities().instabuild) || entity1 instanceof EntityBigIceCube)
            {
            	if(this.getOwner() != null)
            	{
                    if(entity1 instanceof EntityIceWitch && entity1.tickCount % 20 == 0 && ((EntityIceWitch)entity1).getHealth() > 20.0F && entity1 == this.getOwner())
                    {
                    	((EntityIceWitch)entity1).heal(2.0F);
                    }
            	}
            }
            else if(entity1 instanceof LivingEntity)
            {
                ((LivingEntity)entity1).addEffect(new MobEffectInstance(EWEffects.FROST_BITE.get(), 100, 3));
            }
        }
        if(this.tickCount >= 300) 
        {
            this.discard();
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("icefog_normal", (Entity)this);
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
    public boolean hurt(DamageSource p_21016_, float p_21017_) 
    {
    	return p_21016_.isBypassInvul();
    }
}
