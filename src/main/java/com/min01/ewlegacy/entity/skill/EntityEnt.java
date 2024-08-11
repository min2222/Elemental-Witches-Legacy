package com.min01.ewlegacy.entity.skill;

import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.AbstractOwnableMonster;
import com.min01.ewlegacy.entity.projectile.EntityNatureBall;
import com.min01.ewlegacy.entity.projectile.EntityNatureShoot;
import com.min01.ewlegacy.entity.witch.EntityNatureWitch;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class EntityEnt extends AbstractOwnableMonster<EntityNatureWitch>
{
    private int attackTimer;
    private boolean setfire = false;
    
    public EntityEnt(EntityType<? extends Monster> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.25));
        this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.25));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 0.25, 32.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityEnt.class));
    }
    
    @Override
    public float getStepHeight() 
    {
    	return 2.0F;
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 20.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.KNOCKBACK_RESISTANCE, 2.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.25)
    			.add(Attributes.ATTACK_DAMAGE, 3.0);
    }
    
    @Override
    public boolean addEffect(MobEffectInstance p_147208_, Entity p_147209_)
    {
    	return false;
    }
    
    @Override
    public void travel(Vec3 vec3) 
    {
        if(this.getFirstPassenger() != null && this.getFirstPassenger() instanceof Player)
        {
        	LivingEntity livingentity = (LivingEntity) this.getFirstPassenger();
            this.setYRot(livingentity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(livingentity.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.yBodyRot;
            float f = livingentity.xxa * 0.5F;
            float f1 = livingentity.zza;
            if(f1 <= 0.0F)
            {
            	f1 *= 0.25F;
            }
            if(!this.level.isClientSide) 
            {
                this.setSpeed((float)this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                super.travel(new Vec3((double)f, vec3.y, (double)f1));
            }
            this.calculateEntityAnimation(this, false);
        }
        else
        {
            this.flyingSpeed = 0.02F;
            super.travel(vec3);
        }
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        this.attackTimer = 10;
        this.level.broadcastEntityEvent(this, (byte)4);
        boolean flag = target.hurt(DamageSource.mobAttack(this), 2.0F);
        if(flag)
        {
            target.setDeltaMovement(target.getDeltaMovement().add(0, 0.4000000059604645, 0));
        }
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }
    
    @Override
    public void aiStep()
    {
        super.aiStep();
        if(this.attackTimer > 0)
        {
            --this.attackTimer;
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("leaf_normal", this);
        if(this.isOnFire() && !this.setfire) 
        {
            this.setSecondsOnFire(100000000);
            this.setfire = true;
        }
    }
    
    @Override
    public void handleEntityEvent(byte p_28844_)
    {
        if(p_28844_ == 4) 
        {
        	this.attackTimer = 10;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        }
        else
        {
            super.handleEntityEvent(p_28844_);
        }
    }
    
    public int getAttackTimer() 
    {
        return this.attackTimer;
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
    
    @Override
    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_)
    {
    	super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        if(randomNumber == 1)
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 4), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 4);
            }
        }
        else if(randomNumber == 2) 
        {
            if(this.isOnFire() || this.setfire) 
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 6), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 9);
            }
        }
        else if(randomNumber == 3)
        {
            if(this.isOnFire() || this.setfire)
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 7), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 11);
            }
        }
        else if(randomNumber == 4)
        {
            if(this.isOnFire() || this.setfire)
            {
                this.spawnAtLocation(new ItemStack(Items.CHARCOAL, 8), 0.0F);
            }
            else 
            {
                this.spawnAtLocation(new ItemStack(Blocks.OAK_LOG).getItem(), 6);
            }
        }
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("EntSetFire", this.setfire);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.setfire = compound.getBoolean("EntSetFire");
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        if(source == DamageSource.IN_WALL || source == DamageSource.DROWN || source.getEntity() instanceof EntityNatureWitch || source.getEntity() instanceof EntityRoot || source.getEntity() instanceof EntitySwiftEnt || source.getEntity() instanceof EntityEnt || source.getEntity() instanceof EntityNatureBall || source.getEntity() instanceof EntityEntGuardian || source.getEntity() instanceof EntityNatureShoot)
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
    protected void doPush(Entity p_28839_) 
    {
        if(this.getFirstPassenger() instanceof Player && p_28839_ instanceof Enemy && this.getRandom().nextInt(20) == 0)
        {
        	this.setTarget((LivingEntity)p_28839_);
        }

        super.doPush(p_28839_);
    }
}
