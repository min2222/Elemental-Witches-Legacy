package com.min01.ewlegacy.entity.pet;

import java.util.List;
import java.util.Random;

import com.min01.ewlegacy.ElementalWitchesLegacy;
import com.min01.ewlegacy.entity.egg.EntityFireEgg;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.util.EWUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class EntityFireDragon3 extends TamableAnimal
{    
	public static final float[][] RAINBOW_COLOR_TABLE = new float[][] { { 1.0F, 1.0F, 1.0F }, { 0.85F, 0.5F, 0.2F }, { 0.7F, 0.3F, 0.85F }, { 0.4F, 0.6F, 0.85F }, { 0.9F, 0.9F, 0.2F }, { 0.5F, 0.8F, 0.1F }, { 0.95F, 0.5F, 0.65F }, { 0.3F, 0.3F, 0.3F }, { 0.6F, 0.6F, 0.6F }, { 0.3F, 0.5F, 0.6F }, { 0.5F, 0.25F, 0.7F }, { 0.2F, 0.3F, 0.7F }, { 0.4F, 0.3F, 0.2F }, { 0.4F, 0.5F, 0.2F }, { 0.6F, 0.2F, 0.2F }, { 0.1F, 0.1F, 0.1F } };
    public int deathTicks;
    public int goldenTicks;
    public int skillTimer = 100;
    public int skill2Timer = 300;
    public boolean goldenTicksActivate = false;
    
    public EntityFireDragon3(EntityType<? extends TamableAnimal> type, Level level) 
    {
        super(type, level);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.5, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityFireDragon3.class));
        this.setTame(true);
    }
    
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
    			.add(Attributes.MAX_HEALTH, 100.0)
    			.add(Attributes.FOLLOW_RANGE, 32.0)
    			.add(Attributes.MOVEMENT_SPEED, 0.6);
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
    public void aiStep() 
    {
        if(this.skillTimer != 0 && this.getTarget() != null) 
        {
            --this.skillTimer;
        }
        if(this.skill2Timer != 0 && this.getTarget() != null)
        {
            --this.skill2Timer;
        }
        if(this.getTarget() != null) 
        {
            if(this.skillTimer == 0)
            {
                LargeFireball entitywitherskull1 = new LargeFireball(EntityType.FIREBALL, this.level);
                entitywitherskull1.moveTo(this.getTarget().getX(), this.getTarget().getY() + 20.0, this.getTarget().getZ(), this.getYRot(), 0.0F);
                EWUtil.spawnInWorld(this.level, entitywitherskull1);
                entitywitherskull1.setDeltaMovement(entitywitherskull1.getDeltaMovement().subtract(0, 5.0, 0));
                this.skillTimer = 100;
            }
            BlockPos pos = this.getTarget().blockPosition().below();
            if(this.skill2Timer == 0 && this.level.getBlockState(pos) != Blocks.AIR.defaultBlockState() && this.level.getBlockState(pos) != Blocks.LAVA.defaultBlockState() && !this.getTarget().isInWater())
            {
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX(), (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ()), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() + 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() - 1), Blocks.LAVA.defaultBlockState());
                this.level.setBlockAndUpdate(new BlockPos((int)this.getTarget().getX() - 1, (int)this.getTarget().getY(), (int)this.getTarget().getZ() + 1), Blocks.LAVA.defaultBlockState());
                this.skill2Timer = 300;
            }
        }
        ElementalWitchesLegacy.PROXY.spawnParticles("fire_main", this);
        ElementalWitchesLegacy.PROXY.spawnParticles("lava_main", this);
        if(this.isOrderedToSit()) 
        {
        	ElementalWitchesLegacy.PROXY.spawnParticlesWithMotion("sittingSignal", this.level, this.getX(), this.getY() + 3.5, this.getZ(), 0.0, 0.0, 0.0);
        }
        if(this.tickCount % 20 == 0 && this.getHealth() != this.getMaxHealth() && this.getHealth() >= 1.0F) 
        {
            this.setHealth(this.getHealth() + 1.0F);
        }
        if(this.goldenTicksActivate) 
        {
            ++this.goldenTicks;
            List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
            if(this.goldenTicks >= 0 && this.goldenTicks <= 140) 
            {
                for(int i = 1; i <= 2; ++i) 
                {
                	ElementalWitchesLegacy.PROXY.spawnParticles("fire_tornado_big", this);
                }
                for(Entity entity1 : list)
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityFireDragon3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityFireDragon2) && !(entity1 instanceof EntityFireDragon)) 
                    {
                        if(!(entity1 instanceof EntityFireEgg)) 
                        {
                            entity1.setSecondsOnFire(1000);
                        }
                    }
                }
            }
            if(this.goldenTicks == 140)
            {
                for(Entity entity1 : list)
                {
                    if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityFireDragon3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityFireDragon2) && !(entity1 instanceof EntityFireDragon))
                    {
                        if(!(entity1 instanceof EntityFireEgg)) 
                        {
                            if(!this.level.isClientSide)
                            {
                            	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
                                this.level.explode(this, entity1.getX(), entity1.getY() - 0.5, entity1.getZ(), 2.0F, true, explosion$blockinteraction);
                            }
                        }
                    }
                }
                this.goldenTicksActivate = false;
                this.goldenTicks = 0;
            }
        }
        super.aiStep();
    }
    
    @Override
    protected void tickDeath() 
    {
        ++this.deathTicks;
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(20.0, 10.0, 20.0));
        if(this.deathTicks >= 0 && this.deathTicks <= 140) 
        {
            if(this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
            {
                int i = (int) Math.floor(this.getX());
                int i2 = (int) Math.floor(this.getY());
                int j1 = (int) Math.floor(this.getZ());
                for(int l1 = -5; l1 <= 5; ++l1)
                {
                    for(int i3 = -5; i3 <= 5; ++i3)
                    {
                        for(int k = 0; k <= 5; ++k) 
                        {
                            int j2 = i2 + l1;
                            int m = i + k;
                            int l2 = j1 + i3;
                            BlockPos pos = new BlockPos(j2, m, l2);
                            BlockState block = this.level.getBlockState(pos);
                            if(!this.level.isClientSide && !this.level.isEmptyBlock(pos) && block == Blocks.WATER.defaultBlockState())
                            {
                                this.level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                                this.level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, this.getSoundSource(), 0.1F, 0.9F);
                            }
                        }
                    }
                }
            }
            for(int i = 1; i <= 2; ++i) 
            {
                ElementalWitchesLegacy.PROXY.spawnParticles("fire_tornado_big", this);
            }
            for(Entity entity1 : list) 
            {
                if((!(entity1 instanceof Player) || !((Player)entity1).getAbilities().instabuild) && !(entity1 instanceof EntityFireDragon3) && (!(entity1 instanceof Player) || this.getOwner() == null || entity1 != this.getOwner()) && !(entity1 instanceof EntityFireDragon2) && !(entity1 instanceof EntityFireDragon))
                {
                    if(!(entity1 instanceof EntityFireEgg))
                    {
                        entity1.setSecondsOnFire(1000);
                    }
                }
            }
        }
        if(this.deathTicks == 140) 
        {
            EntityFireEgg mob = new EntityFireEgg(EWEntities.FIRE_EGG.get(), this.level);
            mob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            EWUtil.spawnInWorld(this.level, mob);
            if(this.getOwner() != null)
            {
                mob.setOwnerUUID(this.getOwnerUUID());
            }
            mob.setCustomName(this.getCustomName());
            mob.setCustomNameVisible(true);
            for(Entity entity2 : list)
            {
                if((!(entity2 instanceof Player) || !((Player)entity2).getAbilities().instabuild) && !(entity2 instanceof EntityFireDragon3) && (!(entity2 instanceof Player) || this.getOwner() == null || entity2 != this.getOwner()) && !(entity2 instanceof EntityFireDragon2) && !(entity2 instanceof EntityFireDragon))
                {
                    if(!(entity2 instanceof EntityFireEgg)) 
                    {
                        if(!this.level.isClientSide)
                        {
                        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
                            this.level.explode(this, entity2.getX(), entity2.getY() - 0.5, entity2.getZ(), 2.0F, true, explosion$blockinteraction);
                        }
                    }
                }
            }
            this.discard();
        }
    }
    
    @Override
    public boolean doHurtTarget(Entity target)
    {
        Random rand = new Random();
        int form = rand.nextInt(100);
        if(form <= 18) 
        {
        	Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
        	target.level.explode(this, this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 1.0F, true, explosion$blockinteraction);
        	target.hurt(DamageSource.mobAttack(this), 2.0F);
            return true;
        }
        target.setSecondsOnFire(10);
        return target.hurt(DamageSource.mobAttack(this), 5.0F);
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) 
    {
    	return null;
    }
    
    @Override
    public boolean hurt(DamageSource source, float damage) 
    {
        return !(source.getEntity() instanceof PrimedTnt) && super.hurt(source, damage);
    }
    
    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) 
    {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) 
        {
            if(target instanceof EntityFireDragon3) 
            {
            	EntityFireDragon3 entitywolf = (EntityFireDragon3) target;
                if(entitywolf.isTame() && entitywolf.getOwner() == owner)
                {
                    return false;
                }
            }
            return (target instanceof Player && owner instanceof Player && !((Player)owner).canAttack((Player)target)) ? false : ((!(target instanceof Horse) || !((Horse)target).isTamed()));
        }
        return false;
    }
    
    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_)
    {
        if(p_27584_.isShiftKeyDown())
        {
            if(!this.isOrderedToSit()) 
            {
                this.setTarget(null);
                this.setOrderedToSit(true);
            }
            else if(this.isOrderedToSit()) 
            {
                this.setOrderedToSit(false);
            }
            if(p_27584_.isHolding(Items.GOLDEN_APPLE) && !this.goldenTicksActivate) 
            {
                this.goldenTicksActivate = true;
                if(!p_27584_.getAbilities().instabuild)
                {
                    ItemStack getHeldItem = p_27584_.getItemInHand(p_27585_);
                    getHeldItem.shrink(1);
                }
            }
        }
        else if(this.isTame() && !this.isVehicle()) 
        {
        	p_27584_.startRiding(this);
        }
    	return super.mobInteract(p_27584_, p_27585_);
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) 
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("PetSkillTimerFire", this.skillTimer);
        compound.putInt("PetSkill2TimerFire", this.skill2Timer);
        compound.putInt("PetDeathTicks", this.deathTicks);
        compound.putInt("PetGoldenTick", this.goldenTicks);
        compound.putBoolean("PetGoldenTickBoolean", this.goldenTicksActivate);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) 
    {
        super.readAdditionalSaveData(compound);
        this.skillTimer = compound.getInt("PetSkillTimerFire");
        this.skill2Timer = compound.getInt("PetSkill2TimerFire");
        this.deathTicks = compound.getInt("PetDeathTicks");
        this.goldenTicksActivate = compound.getBoolean("PetGoldenTickBoolean");
        this.goldenTicks = compound.getInt("PetGoldenTick");
    }
}
