package net.infinitumcraft.mccourse.entity.custom;

import net.infinitumcraft.mccourse.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class DiceProjectileEntity extends ThrownItemEntity {

    public DiceProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DiceProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.KRYPTONITE_DYNAMITE, livingEntity, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        int X = blockHitResult.getBlockPos().getX();
        int Y = blockHitResult.getBlockPos().getY();
        int Z = blockHitResult.getBlockPos().getZ();

        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().createExplosion(null, X, Y, Z, 6, true, World.ExplosionSourceType.TNT);
        }


        this.discard();
        super.onBlockHit(blockHitResult);
    }
}
