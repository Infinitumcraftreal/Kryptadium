package net.infinitumcraft.kryptadium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KRYPTONITE_BLOCK,
                        ModBlocks.KRYPTONITE_ORE,
                        ModBlocks.IRIDIUM_ORE,
                        ModBlocks.IRIDIUM_BLOCK,
                        ModBlocks.RADAR,
                        ModBlocks.KRYPTONITE_LANTERN);



        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.KRYPTONITE_BLOCK,
                        ModBlocks.IRIDIUM_ORE,
                        ModBlocks.IRIDIUM_BLOCK,
                    ModBlocks.KRYPTONITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KRYPTONITE_LANTERN);







        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
        .forceAddTag(BlockTags.PICKAXE_MINEABLE)
        .forceAddTag(BlockTags.AXE_MINEABLE)
        .forceAddTag(BlockTags.SHOVEL_MINEABLE);
    }
}
