package net.infinitumcraft.kryptadium.entity.custom;

import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class KryptoniteBossSpawn {
    @Nullable
    private static BlockPattern ironGolemPattern;

    private static final Predicate<BlockState> IS_GOLEM_HEAD =
            state -> state != null && (state.isOf(Blocks.CARVED_PUMPKIN) || state.isOf(Blocks.JACK_O_LANTERN));

    public static BlockPattern getIronGolemPattern() {
        if (ironGolemPattern == null) {
            ironGolemPattern = BlockPatternBuilder.start()
                    .aisle("~^~", "###", "~#~")
                    .where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD::test))
                    .where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.KRYPTONITE_BLOCK)))
                    .where('~', cachedBlockPosition -> cachedBlockPosition.getBlockState().isAir() || true)
                    .build();
        }
        return ironGolemPattern;
    }

    public static void trySpawnGolem(World world, BlockPos pos) {
        if (world.isClient) return;

        BlockState state = world.getBlockState(pos);
        if (!IS_GOLEM_HEAD.test(state)) {
            return;
        }

        BlockPattern.Result result = getIronGolemPattern().searchAround(world, pos);

        if (result != null) {
            for (int width = 0; width < getIronGolemPattern().getWidth(); ++width) {
                for (int height = 0; height < getIronGolemPattern().getHeight(); ++height) {
                    for (int depth = 0; depth < getIronGolemPattern().getDepth(); ++depth) {
                        CachedBlockPosition structuralPos = result.translate(width, height, depth);

                        world.setBlockState(structuralPos.getBlockPos(), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);

                        world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, structuralPos.getBlockPos(), Block.getRawIdFromState(structuralPos.getBlockState()));
                    }
                }
            }

            BlockPos basePos = result.translate(1, 2, 0).getBlockPos();

            KryptoniteBossEntity ironGolem = ModEntities.KPYPTONTITE_BOSS.create(world);
            if (ironGolem != null) {

                ironGolem.refreshPositionAndAngles(
                        (double)basePos.getX() + 0.5,
                        (double)basePos.getY(),
                        (double)basePos.getZ() + 0.5,
                        0.0F, 0.0F
                );

                if (world instanceof ServerWorld serverWorld) {
                    ironGolem.initialize(
                            serverWorld,
                            world.getLocalDifficulty(basePos),
                            SpawnReason.TRIGGERED,
                            null,
                            null
                    );
                }

                world.spawnEntity(ironGolem);

                for (int width = 0; width < getIronGolemPattern().getWidth(); ++width) {
                    for (int height = 0; height < getIronGolemPattern().getHeight(); ++height) {
                        for (int depth = 0; depth < getIronGolemPattern().getDepth(); ++depth) {
                            CachedBlockPosition localPos = result.translate(width, height, depth);
                            world.updateNeighbors(localPos.getBlockPos(), Blocks.AIR);
                        }
                    }
                }
            }
        }
    }
}
