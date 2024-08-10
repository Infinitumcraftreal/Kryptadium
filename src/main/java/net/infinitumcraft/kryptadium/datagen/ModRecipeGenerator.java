package net.infinitumcraft.kryptadium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_HAMMER)
                .pattern("SSS")
                .pattern("SPS")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_HAMMER) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KRYPTONITE_TORCH)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KRYPTONITE_TORCH) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KRYPTONITE_LANTERN)
                .pattern("PPP")
                .pattern("PSP")
                .pattern("PPP")
                .input('S', Items.TORCH)
                .input('P', ModItems.KRYPTONITE_NUGGETS)
                .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                .criterion(hasItem(ModItems.KRYPTONITE_NUGGETS), conditionsFromItem(ModItems.KRYPTONITE_NUGGETS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KRYPTONITE_LANTERN) ) + "_");

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_DYNAMITE)
                .pattern("PGP")
                .pattern("GSG")
                .pattern("PGP")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.TNT)
                .input('G', Items.GUNPOWDER)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_DYNAMITE) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_HORSE_ARMOR)
                .pattern("S S")
                .pattern("SSS")
                .pattern("S S")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_HORSE_ARMOR) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.OAK_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.OAK_WOOD), conditionsFromItem(Items.OAK_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RADAR)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.COMPASS)
                .input('P', Items.CLOCK)
                .criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
                .criterion(hasItem(Items.CLOCK), conditionsFromItem(Items.CLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RADAR) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.ACACIA_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.ACACIA_WOOD), conditionsFromItem(Items.ACACIA_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_1");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.BIRCH_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.BIRCH_WOOD), conditionsFromItem(Items.BIRCH_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_2");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.CHERRY_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.CHERRY_WOOD), conditionsFromItem(Items.CHERRY_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_3");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.DARK_OAK_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.DARK_OAK_WOOD), conditionsFromItem(Items.DARK_OAK_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_4");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.JUNGLE_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.JUNGLE_WOOD), conditionsFromItem(Items.JUNGLE_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_5");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.MANGROVE_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.MANGROVE_WOOD), conditionsFromItem(Items.MANGROVE_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_6");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_SHIELD)
                .pattern("PSP")
                .pattern("PPP")
                .pattern(" P ")
                .input('S', ModItems.KRYPTONITE)
                .input('P', Items.SPRUCE_WOOD)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .criterion(hasItem(Items.SPRUCE_WOOD), conditionsFromItem(Items.SPRUCE_WOOD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_SHIELD) ) + "_7");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE_NUGGETS, 9)
                .pattern("   ")
                .pattern(" S ")
                .pattern("   ")
                .input('S', ModItems.KRYPTONITE)
                .criterion(hasItem(ModItems.KRYPTONITE), conditionsFromItem(ModItems.KRYPTONITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE_NUGGETS) ) + "_");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KRYPTONITE)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.KRYPTONITE_NUGGETS)
                .criterion(hasItem(ModItems.KRYPTONITE_NUGGETS), conditionsFromItem(ModItems.KRYPTONITE_NUGGETS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KRYPTONITE) ) + "_2");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.KRYPTONITE, RecipeCategory.MISC, ModBlocks.KRYPTONITE_BLOCK);



        offerSmelting(exporter, List.of(ModItems.KRYPTONITE, ModBlocks.KRYPTONITE_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE,
                0.25f, 200, "kryptonite");

        offerBlasting(exporter, List.of(ModItems.KRYPTONITE, ModBlocks.KRYPTONITE_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE,
                0.25f, 100, "kryptonite");

        offerSmelting(exporter, List.of(ModItems.KRYPTONITE_APPLE, ModBlocks.IRIDIUM_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE_APPLE,
                0.25f, 200, "kryptonite");

        offerBlasting(exporter, List.of(ModItems.KRYPTONITE_APPLE, ModBlocks.IRIDIUM_ORE), RecipeCategory.MISC, ModItems.KRYPTONITE_APPLE,
                0.25f, 100, "kryptonite");

    }
}
