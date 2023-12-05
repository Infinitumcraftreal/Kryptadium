package net.infinitumcraft.kryptadium.block.custom;

import net.infinitumcraft.kryptadium.particle.ModParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class TorchBlock  extends Block {
    public  static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TorchBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.spawnParticles(ModParticles.KRYPTONITE_PARTICLE, pos.getX() + 0.5d, pos.getY() + 1, pos.getZ() + 0.5d, 2,
                Math.cos(18) * 0.25d, 0.15d, Math.sin(18) * 0.25d, 5f);
        super.randomTick(state, world, pos, random);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

