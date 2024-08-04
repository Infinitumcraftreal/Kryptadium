package net.infinitumcraft.kryptadium.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.AXOLOTLS,
                ModEntities.KRYPTAXO, 35, 1, 3);

        SpawnRestriction.register(ModEntities.KRYPTAXO, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.OCEAN_FLOOR, AxolotlEntity::isValidNaturalSpawn);
    }
}
