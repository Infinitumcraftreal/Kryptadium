package net.infinitumcraft.kryptadium.block.custom;

import net.infinitumcraft.kryptadium.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RadarBlockEntity extends BlockEntity {
    private long cooldownReadyTicks = 0;

    public RadarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RADAR_BLOCK_ENTITY, pos, state);
    }

    public boolean isCoolingDown(World world) {
        return world.getTime() < this.cooldownReadyTicks;
    }

    public int getRemainingSeconds(World world) {
        if (!isCoolingDown(world)) return 0;
        return (int) Math.ceil((this.cooldownReadyTicks - world.getTime()) / 20.0);
    }

    public void startGlobalCooldown(World world, int ticks) {
        this.cooldownReadyTicks = world.getTime() + ticks;
        this.markDirty();
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("CooldownReadyTicks", this.cooldownReadyTicks);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.cooldownReadyTicks = nbt.getLong("CooldownReadyTicks");
    }
}