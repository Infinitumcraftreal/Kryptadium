package net.infinitumcraft.kryptadium.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FallingBlockEntity.class)
public interface FallingBlockEntityMixin {

    @Accessor("block")
    void setBlockState(BlockState state);

    @Accessor("destroyedOnLanding")
    void setDestroyedOnLanding(boolean destroyedOnLanding);

}
