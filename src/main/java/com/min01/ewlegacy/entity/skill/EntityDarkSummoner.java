package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityDarkWitch;
import com.min01.ewlegacy.entity.witch.EntityLightWitch;
import com.min01.ewlegacy.init.EWSounds;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class EntityDarkSummoner extends AbstractOwnableMonster<EntityDarkWitch>
{
    int timer = 50;
    
    public EntityDarkSummoner(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.noCulling = true;
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityLightWitch.class, true));
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 10.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 100.0);
    }
    
    @Override
    protected SoundEvent getAmbientSound() 
    {
    	return EWSounds.WHISPER.get();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_)
    {
    	return null;
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
    
    @Override
    public boolean isPushedByFluid() 
    {
    	return false;
    }
    
    @Override
    public boolean isPushedByFluid(FluidType type) 
    {
    	return false;
    }
    
    @Override
    public void aiStep()
    {
        if(this.getTarget() instanceof EntityDarkWitch)
        {
            this.setTarget(null);
        }
        if(this.tickCount >= 400)
        {
            this.discard();
        }
        if(this.getDeltaMovement().y <= -0.0)
        {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z);
        }
        if(this.getHealth() <= 0.0F) 
        {
            this.discard();
        }
        if(this.timer != 0 && this.getTarget() != null) 
        {
            --this.timer;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("dark_tornado", this);
        if(this.getTarget() != null && this.timer == 0) 
        {
            int random = this.random.nextInt(5);
            if(random == 1) 
            {
                Zombie entitywitherskull1 = new Zombie(this.level);
                entitywitherskull1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull1.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                entitywitherskull1.setCustomName(Component.literal("Dark Minion").withStyle(ChatFormatting.BLACK));
                entitywitherskull1.setCustomNameVisible(true);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                entitywitherskull1.setTarget(this.getTarget());
                this.timer = 50;
            }
            else if(random == 2) 
            {
                Skeleton entitywitherskull2 = new Skeleton(EntityType.SKELETON, this.level);
                entitywitherskull2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull2.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
                entitywitherskull2.setCustomName(Component.literal("Dark Minion").withStyle(ChatFormatting.BLACK));
                entitywitherskull2.setCustomNameVisible(true);
                EWUtil.spawnInWorld(this.level, entitywitherskull2);
                entitywitherskull2.setTarget(this.getTarget());
                this.timer = 50;
            }
            else if(random == 3) 
            {
                ZombifiedPiglin entitywitherskull3 = new ZombifiedPiglin(EntityType.ZOMBIFIED_PIGLIN, this.level);
                entitywitherskull3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                entitywitherskull3.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
                entitywitherskull3.setCustomName(Component.literal("Dark Minion").withStyle(ChatFormatting.BLACK));
                entitywitherskull3.setCustomNameVisible(true);
                EWUtil.spawnInWorld(this.level, entitywitherskull3);
                entitywitherskull3.setTarget(this.getTarget());
                this.timer = 50;
            }
        }
        super.aiStep();
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_) 
    {
    	return false;
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("SummonerTimer", this.timer);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.timer = compound.getInt("SummonerTimer");
    }
    
    @Override
    public boolean removeWhenFarAway(double p_21542_) 
    {
    	return false;
    }
}
