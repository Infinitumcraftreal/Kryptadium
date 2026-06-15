package net.infinitumcraft.kryptadium.entity;

import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.block.ModBlocks; // Your block registry class
import net.infinitumcraft.kryptadium.block.custom.RadarBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static BlockEntityType<RadarBlockEntity> RADAR_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        RADAR_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(KryptadiumMod.MOD_ID, "radar_block_entity"),
                BlockEntityType.Builder.create(RadarBlockEntity::new, ModBlocks.RADAR).build(null)
        );
    }
}
