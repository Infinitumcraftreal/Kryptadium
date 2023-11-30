package net.infinitumcraft.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class KryptoniteTnt extends Block {
    public KryptoniteTnt(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int X = pos.getX();
        int Y = pos.getY();
        int Z = pos.getZ();

        if(!world.isClient()) {
            if(player.getMainHandStack().getItem() == Items.FLINT_AND_STEEL) {
                world.createExplosion(null, X, Y, Z, 8, true, World.ExplosionSourceType.TNT);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        int X = pos.getX();
        int Y = pos.getY();
        int Z = pos.getZ();

        if(!world.isClient()) {
                world.createExplosion(null, X, Y, Z, 8, true, World.ExplosionSourceType.TNT);
        }

        super.onDestroyedByExplosion(world, pos, explosion);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        int X = pos.getX();
        int Y = pos.getY();
        int Z = pos.getZ();

        if(world.getReceivedRedstonePower(pos) > 0) {
            world.createExplosion(null, X, Y, Z, 8, true, World.ExplosionSourceType.TNT);
        }

        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
}
