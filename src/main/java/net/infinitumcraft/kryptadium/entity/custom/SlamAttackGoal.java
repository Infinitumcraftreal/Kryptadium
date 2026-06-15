package net.infinitumcraft.kryptadium.entity.custom;

import net.infinitumcraft.kryptadium.particle.ModParticles;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;
import java.util.List;

public class SlamAttackGoal extends Goal {

    private static final int COOLDOWN = 120;
    private static final int SLAM_TICK = 33;
    private static final double SLAM_RADIUS = 6.0;
    private static final float SLAM_DAMAGE = 10.0f;

    private final KryptoniteBossEntity boss;
    private int cooldownTimer = 0;
    private int animTimer = 0;
    private boolean slamming = false;

    public SlamAttackGoal(KryptoniteBossEntity boss) {
        this.boss = boss;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (cooldownTimer > 0) { cooldownTimer--; return false; }
        return boss.getTarget() != null && boss.getTarget().distanceTo(boss) <= SLAM_RADIUS + 2;
    }

    @Override
    public boolean shouldContinue() {
        return slamming;
    }

    @Override
    public void start() {
        slamming = true;
        animTimer = 0;
        boss.setAttackState(KryptoniteBossEntity.AttackState.SLAM);
        boss.getNavigation().stop();
    }

    @Override
    public void tick() {
        animTimer++;

        if (animTimer == SLAM_TICK) {
            fireSlam();
        }

        if (animTimer >= SLAM_TICK + 20) {
            stop();
        }
    }

    @Override
    public void stop() {
        slamming = false;
        animTimer = 0;
        cooldownTimer = COOLDOWN;
        boss.setAttackState(KryptoniteBossEntity.AttackState.NONE);
    }

    private void fireSlam() {
        if (boss.getWorld().isClient) return;
        ServerWorld world = (ServerWorld) boss.getWorld();

        Box area = boss.getBoundingBox().expand(SLAM_RADIUS);
        List<PlayerEntity> players = world.getEntitiesByClass(PlayerEntity.class, area, p -> true);
        for (PlayerEntity player : players) {
            player.damage(world.getDamageSources().generic(), SLAM_DAMAGE);
            Vec3d dir = player.getPos().subtract(boss.getPos()).normalize();
            player.setVelocity(dir.x * 1.2, 1.4, dir.z * 1.2);
            player.velocityModified = true;
        }

        for (int i = 0; i < 40; i++) {
            double angle = (2 * Math.PI / 40) * i;
            double px = boss.getX() + Math.cos(angle) * SLAM_RADIUS * 0.6;
            double pz = boss.getZ() + Math.sin(angle) * SLAM_RADIUS * 0.6;
            world.spawnParticles(ModParticles.KRYPTONITE_PARTICLE, px, boss.getY() + 0.1, pz, 3, 0.3, 0.1, 0.3, 0.1);
        }
    }
}