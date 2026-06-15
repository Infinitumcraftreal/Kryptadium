package net.infinitumcraft.kryptadium.entity.custom;

import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class KryptoniteBossEntity extends AnimalEntity implements GeoEntity {

    public enum AttackState { NONE, SLAM, THROW }

    private static final TrackedData<Integer> ATTACK_STATE =
            DataTracker.registerData(KryptoniteBossEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public KryptoniteBossEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACK_STATE, AttackState.NONE.ordinal());
    }

    public void setAttackState(AttackState state) {
        this.dataTracker.set(ATTACK_STATE, state.ordinal());
    }

    public AttackState getAttackState() {
        return AttackState.values()[this.dataTracker.get(ATTACK_STATE)];
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 300)
                .add(EntityAttributes.GENERIC_ARMOR, 4)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24) // bumped so it notices players sooner
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));

        this.goalSelector.add(2, new SlamAttackGoal(this));
        this.goalSelector.add(2, new ThrowBlockGoal(this));

        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2f, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(5, new LookAroundGoal(this));

        // Target selectors
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
    }

    @Nullable
    @Override
    public AnimalEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.KPYPTONTITE_BOSS.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        AttackState state = getAttackState();

        if (state == AttackState.SLAM) {
            tAnimationState.getController().setAnimation(
                    RawAnimation.begin().then("slam", Animation.LoopType.PLAY_ONCE));
            return PlayState.CONTINUE;
        }

        if (state == AttackState.THROW) {
            tAnimationState.getController().setAnimation(
                    RawAnimation.begin().then("throw", Animation.LoopType.PLAY_ONCE));
            return PlayState.CONTINUE;
        }

        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(
                    RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(
                RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ModSounds.STEP, 0.2f, 1.0f);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ModSounds.HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return ModSounds.DEATH;
    }
}