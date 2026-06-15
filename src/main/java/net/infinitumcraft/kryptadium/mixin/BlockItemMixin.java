package net.infinitumcraft.kryptadium.mixin;

import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossSpawn;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {

    @Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemPlacementContext;getWorld()Lnet/minecraft/world/World;"))
    private void onAnyBlockPlaced(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();

        if (!world.isClient()) {
            BlockPos placedPos = context.getBlockPos();

            KryptoniteBossSpawn.trySpawnGolem(world, placedPos);
        }
    }
}
