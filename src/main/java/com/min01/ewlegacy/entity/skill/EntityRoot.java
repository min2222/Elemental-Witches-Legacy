package com.min01.ewlegacy.entity.skill;

import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.witch.EntityNatureWitch;
import com.min01.ewlegacy.init.EWEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityRoot extends AbstractOwnableMonster<EntityNatureWitch>
{
    private boolean setfire = false;
    private int[] AnchoredBlock = new int[] { 0, 0, 0 };
    
    public EntityRoot(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityRoot.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }
    
    public EntityRoot(Level level, int x, int y, int z)
    {
        this(EWEntities.ROOT.get(), level);
        this.AnchoredBlock[0] = x;
        this.AnchoredBlock[1] = y;
        this.AnchoredBlock[2] = z;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 13.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 2.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.0)
    			.add(Attributes.ATTACK_DAMAGE, 2.0);
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
        compound.putIntArray("RootBeer", this.AnchoredBlock);
    }
    
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.AnchoredBlock = compound.getIntArray("RootBeer");
    }
    
    @Override
    public void aiStep()
    {
        super.aiStep();
        if(!this.onGround && (this.getDeltaMovement().y < 0.0 | this.getDeltaMovement().y > 0.0))
        {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.0, 1));
        }
        if(this.isOnFire() && !this.setfire)
        {
            this.setSecondsOnFire(100000000);
            this.setfire = true;
        }
        if(this.level.getBlockState(new BlockPos(this.AnchoredBlock[0], this.AnchoredBlock[1], this.AnchoredBlock[2])).isAir() && !this.level.isClientSide) 
        {
            this.discard();
        }
        //TODO?
        /*List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(2.0, 4.0, 2.0));
        for(Entity entity : list) 
        {
            if(!this.level.isClientSide && entity == this.getTarget()) 
            {
                this.yOffset = 0.0F;
            }
            else if(!this.level.isClientSide)
            {
                this.yOffset = -2.0F;
            }
        }*/
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage)
    {
    	if(source == DamageSource.IN_WALL || source == DamageSource.DROWN || source.getEntity() instanceof EntityNatureWitch || source.getEntity() instanceof EntitySwiftEnt || source.getEntity() instanceof EntityEnt) 
    	{
            return false;
        }
        if(source.getEntity() instanceof Player && ((Player)source.getEntity()).getMainHandItem().getItem() instanceof AxeItem)
        {
            return super.hurt(source, damage);
        }
        return super.hurt(source, 1.0F);
    }
    
    @Override
    public boolean isPushable() 
    {
    	return false;
    }
    
    @Override
    protected void doPush(Entity p_20971_)
    {
    	if(this.isOnFire())
    	{
    		p_20971_.setSecondsOnFire(4);
    	}
    }
    
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_)
    {
    	this.playSound(SoundEvents.WOOD_STEP, 0.15F, 1.0F);
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) 
    {
    	return SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR;
    }
    
    @Override
    protected SoundEvent getDeathSound() 
    {
    	return SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
    }
}
