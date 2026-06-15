package net.infinitumcraft.kryptadium.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;

public class ThrowBlockGoal extends Goal {

    private static final int COOLDOWN = 200;
    private static final int THROW_TICK = 10;
    private static final double MIN_RANGE = 5.0;
    private static final double MAX_RANGE = 20.0;

    private final KryptoniteBossEntity boss;
    private int cooldownTimer = 0;
    private int animTimer = 0;
    private boolean throwing = false;
    private LivingEntity cachedTarget = null;

    public ThrowBlockGoal(KryptoniteBossEntity boss) {
        this.boss = boss;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (cooldownTimer > 0) { cooldownTimer--; return false; }
        LivingEntity target = boss.getTarget();
        if (target == null) return false;
        double dist = boss.distanceTo(target);
        return dist >= MIN_RANGE && dist <= MAX_RANGE;
    }

    @Override
    public boolean shouldContinue() {
        return throwing;
    }

    @Override
    public void start() {
        throwing = true;
        animTimer = 0;
        cachedTarget = boss.getTarget();
        boss.setAttackState(KryptoniteBossEntity.AttackState.THROW);
        boss.getNavigation().stop();
        if (cachedTarget != null) {
            boss.getLookControl().lookAt(cachedTarget, 30f, 30f);
        }
    }

    @Override
    public void tick() {
        animTimer++;

        if (animTimer == THROW_TICK && cachedTarget != null) {
            fireBlock();
        }

        if (animTimer >= THROW_TICK + 20) {
            stop();
        }
    }

    @Override
    public void stop() {
        throwing = false;
        animTimer = 0;
        cooldownTimer = COOLDOWN;
        cachedTarget = null;
        boss.setAttackState(KryptoniteBossEntity.AttackState.NONE);
    }

    private void fireBlock() {
        World world = boss.getWorld();
        if (world.isClient) return;

        BlockState state = findNearbyBlock(world);

        ThrownBlockEntity projectile = ThrownBlockEntity.create(world, boss, state, cachedTarget);
        world.spawnEntity(projectile);
    }

    private BlockState findNearbyBlock(World world) {
        BlockPos origin = boss.getBlockPos();
        for (int dx = -3; dx <= 3; dx++) {
            for (int dz = -3; dz <= 3; dz++) {
                BlockPos pos = origin.add(dx, 0, dz);
                BlockState state = world.getBlockState(pos);
                if (!state.isAir() && state.isOpaque()) {
                    world.removeBlock(pos, false); // "pick it up"
                    return state;
                }
            }
        }
        // Fallback if nothing is nearby
        return Blocks.STONE.getDefaultState();
    }
}