package net.infinitumcraft.kryptadium.datagen;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KRYPTONITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KRYPTONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRIDIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRIDIUM_ORE);



        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RADAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KRYPTONITE_TORCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KRYPTONITE_LANTERN);

        blockStateModelGenerator.registerParentedItemModel(ModItems.KRYPTONITE_BOSS_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.KRYPTAXO_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {



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
        itemModelGenerator.register(ModItems.KRYPTONITE_NUGGETS, Models.GENERATED);
    }
}
