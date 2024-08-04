package net.infinitumcraft.kryptadium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup KRYPTADIUM = Registry.register(Registries.ITEM_GROUP,
            new Identifier(KryptadiumMod.MOD_ID, "kryptadium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kryptadium"))
                    .icon(() -> new ItemStack(ModItems.KRYPTONITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KRYPTONITE);
                        entries.add(ModItems.KRYPTONITE_NUGGETS);
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
                        entries.add(ModItems.KRYPTONITE_BOSS_SPAWN_EGG);
                        entries.add(ModItems.KRYPTAXO_SPAWN_EGG);

                    }).build());


    public static void registerItemGroups() {

    }
}
