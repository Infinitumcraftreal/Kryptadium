package net.infinitumcraft.kryptadium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.KRYPTONITE_ORE, oreDrops(ModBlocks.KRYPTONITE_ORE, ModItems.KRYPTONITE));
        addDrop(ModBlocks.IRIDIUM_ORE, oreDrops(ModBlocks.IRIDIUM_ORE, ModItems.IRIDIUM));
        addDrop(ModBlocks.KRYPTONITE_BLOCK);
        addDrop(ModBlocks.IRIDIUM_BLOCK);
        addDrop(ModBlocks.KRYPTONITE_TNT);
        addDrop(ModBlocks.KRYPTONITE_TORCH);
        addDrop(ModBlocks.KRYPTONITE_LANTERN);

    }
}
