package net.infinitumcraft.kryptadium.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.jetbrains.annotations.Nullable;

@Mixin(TntEntity.class)
public interface TntEntityAccessor {
    @Accessor("causingEntity")
    @Nullable LivingEntity getCausingEntity();

    @Accessor("causingEntity")
    void setCausingEntity(@Nullable LivingEntity causingEntity);
}