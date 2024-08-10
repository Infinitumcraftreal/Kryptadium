package net.infinitumcraft.kryptadium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.block.custom.*;
import net.infinitumcraft.kryptadium.block.custom.TorchBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block KRYPTONITE_BLOCK = registerBlock("kryptonite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).hardness(15).resistance(1200)));
    public static final Block KRYPTONITE_ORE = registerBlock("kryptonite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(10).resistance(1200)));

    public static final Block IRIDIUM_BLOCK = registerBlock("iridium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).hardness(20).resistance(1200)));
    public static final Block IRIDIUM_ORE = registerBlock("iridium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).hardness(10).resistance(1200)));

    public static final Block KRYPTONITE_TNT = registerBlock("kryptonite_tnt",
            new KryptoniteTnt(FabricBlockSettings.copyOf(Blocks.TNT)));

    public static final Block RADAR = registerBlock("radar",
            new RadarBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(1).resistance(10).nonOpaque()));

    public static final Block KRYPTONITE_TORCH = registerBlock("kryptonite_torch",
            new TorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH).hardness(0).resistance(0).nonOpaque().noCollision().luminance(15)));

    public static final Block KRYPTONITE_LANTERN = registerBlock("kryptonite_lantern",
            new LanternBlocks(FabricBlockSettings.copyOf(Blocks.LANTERN).hardness(1).resistance(10).nonOpaque().luminance(15)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(KryptadiumMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(KryptadiumMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        KryptadiumMod.LOGGER.info("Registering ModBlocks For " + KryptadiumMod.MOD_ID);
    }
}
