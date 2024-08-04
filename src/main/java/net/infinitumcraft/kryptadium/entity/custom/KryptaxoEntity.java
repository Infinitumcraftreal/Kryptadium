package net.infinitumcraft.kryptadium.entity.custom;

import net.fabricmc.fabric.impl.resource.loader.FabricModResourcePack;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.task.PanicTask;
import net.minecraft.entity.ai.brain.task.WalkTowardsWaterTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class KryptaxoEntity extends AnimalEntity implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public KryptaxoEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3)
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 14)
            .add(EntityAttributes.GENERIC_ARMOR, 0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
            .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1);

    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 3f, false));

        this.goalSelector.add(4, new LookAroundGoal(this));

        this.goalSelector.add(2, new ActiveTargetGoal<>(this, ElderGuardianEntity.class, true));
        this.goalSelector.add(2, new ActiveTargetGoal<>(this, CodEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, GlowSquidEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, GuardianEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, PufferfishEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, SalmonEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, SquidEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, TadpoleEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, TropicalFishEntity.class, true));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, DrownedEntity.class, true));


    }

    @Nullable
    @Override
    public AnimalEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.KRYPTAXO.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }


        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void playSwimSound(float volume) {
        this.playSound(SoundEvents.ENTITY_AXOLOTL_SWIM, 0.2f, 1.0f);
    }


    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.ENTITY_AXOLOTL_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_AXOLOTL_DEATH;
    }
}
