package net.infinitumcraft.kryptadium.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.infinitumcraft.kryptadium.mixin.FallingBlockEntityMixin;

public class ThrownBlockEntity extends FallingBlockEntity {

    private static final float DAMAGE = 6.0f;
    private static final double HIT_RADIUS = 0.5;

    public ThrownBlockEntity(EntityType<? extends FallingBlockEntity> type, World world) {
        super(type, world);
    }

    public static ThrownBlockEntity create(World world, LivingEntity thrower, BlockState state, Entity target) {
        ThrownBlockEntity e = new ThrownBlockEntity(EntityType.FALLING_BLOCK, world);
        e.setPosition(thrower.getX(), thrower.getY() + thrower.getHeight() + 1, thrower.getZ());
        e.dropItem = false;
        FallingBlockEntityMixin accessor = (FallingBlockEntityMixin) e;
        accessor.setDestroyedOnLanding(true);
        accessor.setBlockState(state);

        Vec3d dir = target.getPos().add(0, target.getHeight() * 0.5, 0)
                .subtract(e.getPos()).normalize();
        e.setVelocity(dir.x * 1.6, dir.y * 1.6 + 0.5, dir.z * 1.6);
        return e;
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        ServerWorld sw = (ServerWorld) getWorld();
        sw.getEntitiesByClass(LivingEntity.class, getBoundingBox().expand(HIT_RADIUS), e -> e != null)
                .forEach(entity -> {
                    entity.damage(getWorld().getDamageSources().generic(), DAMAGE);
                    Vec3d knockback = entity.getPos().subtract(getPos()).normalize().multiply(0.8).add(0, 0.5, 0);
                    entity.addVelocity(knockback.x, knockback.y, knockback.z);
                    entity.velocityModified = true;
                    discard();
                });
    }
}