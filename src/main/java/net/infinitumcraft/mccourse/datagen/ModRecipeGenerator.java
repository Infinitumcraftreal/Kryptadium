package net.infinitumcraft.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.infinitumcraft.mccourse.block.ModBlocks;
import net.infinitumcraft.mccourse.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P', ModItems.PINK_GARNET)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PINK_GARNET) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHOVEL)
                .pattern(" S ")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHOVEL) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SWORD)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SWORD) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_AXE)
                .pattern(" SS")
                .pattern(" PS")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_AXE) ) + "_1");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_AXE)
                .pattern("SS ")
                .pattern("SP ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_AXE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_PICKAXE)
                .pattern("SSS")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_PICKAXE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_HOE)
                .pattern("SS ")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_HOE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_HOE)
                .pattern(" SS")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_HOE) ) + "_2");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_KNIFE)
                .pattern("   ")
                .pattern("  S")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_KNIFE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_HELMET)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_HELMET) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_CHESTPLATE)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_CHESTPLATE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_LEGGINGS)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_LEGGINGS) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_BOOTS)
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_BOOTS) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_APPLE)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.GOLDEN_APPLE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_APPLE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KRYPTONITE_TNT)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.TNT)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KRYPTONITE_TNT) ) + "_");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.KRYPTONITE, RecipeCategory.MISC, ModBlocks.KRYPTONITE_BLOCK);


        offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
                0.25f, 200, "pink_garnet");

        offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
                0.25f, 100, "pink_garnet");

        offerSmelting(exporter, List.of(ModItems.KRYPTONITE, ModBlocks.KRYPTONITE_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE,
                0.25f, 200, "kryptonite");

        offerBlasting(exporter, List.of(ModItems.KRYPTONITE, ModBlocks.KRYPTONITE_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE,
                0.25f, 100, "kryptonite");



    }
}
