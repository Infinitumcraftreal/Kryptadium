package net.infinitumcraft.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.infinitumcraft.mccourse.MCCourseMod;
import net.infinitumcraft.mccourse.block.ModBlocks;
import net.minecraft.block.MossBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MCCourseMod.MOD_ID, "pink_garnet_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pink_garnet_group"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET)).entries((displayContext, entries) -> {

                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.PEAT_BRICK);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.PINK_GARNET_PAXEL);

                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.END_STONE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);

                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

                }).build());

    public static final ItemGroup KRYPTADIUM = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MCCourseMod.MOD_ID, "kryptadium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kryptadium"))
                    .icon(() -> new ItemStack(ModItems.KRYPTONITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KRYPTONITE);
                        entries.add(ModBlocks.KRYPTONITE_BLOCK);
                        entries.add(ModBlocks.KRYPTONITE_ORE);

                        entries.add(ModItems.KRYPTONITE_SWORD);
                        entries.add(ModItems.KRYPTONITE_PICKAXE);
                        entries.add(ModItems.KRYPTONITE_AXE);
                        entries.add(ModItems.KRYPTONITE_SHOVEL);
                        entries.add(ModItems.KRYPTONITE_HOE);
                        entries.add(ModItems.KRYPTONITE_KNIFE);
                        entries.add(ModItems.KRYPTONITE_BOW);
                        entries.add(ModItems.KRYPTONITE_SHIELD);
                        entries.add(ModItems.KRYPTONITE_HAMMER);

                        entries.add(ModItems.KRYPTONITE_HELMET);
                        entries.add(ModItems.KRYPTONITE_CHESTPLATE);
                        entries.add(ModItems.KRYPTONITE_LEGGINGS);
                        entries.add(ModItems.KRYPTONITE_BOOTS);

                        entries.add(ModItems.KRYPTONITE_APPLE);
                        entries.add(ModItems.KRYPTONITE_HORSE_ARMOR);
                        entries.add(ModBlocks.KRYPTONITE_TNT);
                        entries.add(ModItems.KRYPTONITE_DYNAMITE);
                        entries.add(ModBlocks.RADAR);
                        entries.add(ModBlocks.KRYPTONITE_TORCH);
                        entries.add(ModBlocks.KRYPTONITE_LANTERN);

                    }).build());


    public static void registerItemGroups() {

    }
}
