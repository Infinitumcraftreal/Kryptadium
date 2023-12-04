package net.infinitumcraft.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.infinitumcraft.mccourse.block.ModBlocks;
import net.infinitumcraft.mccourse.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.text.Text;

import java.util.function.BiFunction;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KRYPTONITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KRYPTONITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RADAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KRYPTONITE_TORCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KRYPTONITE_LANTERN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEAT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PAXEL, Models.HANDHELD);


        itemModelGenerator.register(ModItems.KRYPTONITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KRYPTONITE_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.KRYPTONITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KRYPTONITE_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KRYPTONITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KRYPTONITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KRYPTONITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KRYPTONITE_BOOTS));
        itemModelGenerator.register(ModItems.KRYPTONITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.KRYPTONITE_DYNAMITE, Models.GENERATED);
    }
}
