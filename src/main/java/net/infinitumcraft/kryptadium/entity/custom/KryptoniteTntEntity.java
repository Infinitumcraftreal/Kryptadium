package net.infinitumcraft.kryptadium.entity.custom;

import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.mixin.TntEntityAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KryptoniteTntEntity extends TntEntity {

    public KryptoniteTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public KryptoniteTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(ModEntities.KRYPTONITE_TNT_ENTITY, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * 6.283185482025146;
        this.setVelocity(-Math.sin(d) * 0.02, 0.20000000298023224, -Math.cos(d) * 0.02);
        this.setFuse(80);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        ((TntEntityAccessor) this).setCausingEntity(igniter);
    }

    @Override
    public void tick() {
        super.tick();

        // When the fuse runs out on the server side, detonate with custom power!
        if (this.getFuse() <= 0 && !this.getWorld().isClient()) {
            this.discard(); // Remove entity
            this.explodeKryptonite();
        }
    }

    private void explodeKryptonite() {
        LivingEntity igniter = ((TntEntityAccessor) this).getCausingEntity();

        this.getWorld().createExplosion(
                igniter,
                this.getX(),
                this.getBodyY(0.0625),
                this.getZ(),
                8.0F,
                true,
                World.ExplosionSourceType.TNT
        );
    }

    @Override
    public EntityType<?> getType() {
        return ModEntities.KRYPTONITE_TNT_ENTITY;
    }
}
