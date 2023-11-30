package net.infinitumcraft.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.infinitumcraft.mccourse.MCCourseMod;
import net.infinitumcraft.mccourse.block.ModBlocks;
import net.infinitumcraft.mccourse.item.custom.MetalDetectorItem;
import net.infinitumcraft.mccourse.item.custom.ModArmorItem;
import net.infinitumcraft.mccourse.item.custom.ModPoisonSwordItem;
import net.infinitumcraft.mccourse.item.custom.PaxelItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings()));

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER)));

    public static final Item PEAT_BRICK = registerItem("peat_brick",
            new Item(new FabricItemSettings()));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new ModPoisonSwordItem(ModToolMaterial.PINK_GARNET,2, 2f,new FabricItemSettings()));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterial.PINK_GARNET,1, 1f,new FabricItemSettings()));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterial.PINK_GARNET,0, 0f,new FabricItemSettings()));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterial.PINK_GARNET,6, -2f,new FabricItemSettings()));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterial.PINK_GARNET,0, 0f,new FabricItemSettings()));

    public static final Item PINK_GARNET_PAXEL = registerItem("pink_garnet_paxel",
            new PaxelItem(ModToolMaterial.PINK_GARNET,0, 0f,new FabricItemSettings()));


    // Kryptadium
    public static final Item KRYPTONITE = registerItem("kryptonite",
            new Item(new FabricItemSettings()));

    public static final Item KRYPTONITE_APPLE = registerItem("kryptonite_apple",
            new Item(new FabricItemSettings().food(ModFoodComponents.KRYPTONITE_APPLE)));

    public static final Item KRYPTONITE_SWORD = registerItem("kryptonite_sword",
            new SwordItem(ModToolMaterial.KRYPTONITE,-1, -2.3f,new FabricItemSettings()));
    public static final Item KRYPTONITE_KNIFE = registerItem("kryptonite_knife",
            new SwordItem(ModToolMaterial.KRYPTONITE,-7, 3f,new FabricItemSettings()));
    public static final Item KRYPTONITE_PICKAXE = registerItem("kryptonite_pickaxe",
            new PickaxeItem(ModToolMaterial.KRYPTONITE,-4, -2.7f,new FabricItemSettings()));
    public static final Item KRYPTONITE_SHOVEL = registerItem("kryptonite_shovel",
            new ShovelItem(ModToolMaterial.KRYPTONITE,-6.25f, 1f,new FabricItemSettings()));
    public static final Item KRYPTONITE_AXE = registerItem("kryptonite_axe",
            new AxeItem(ModToolMaterial.KRYPTONITE,1, -3f,new FabricItemSettings()));
    public static final Item KRYPTONITE_HOE = registerItem("kryptonite_hoe",
            new HoeItem(ModToolMaterial.KRYPTONITE,-8, 4f,new FabricItemSettings()));

    public static final Item KRYPTONITE_HELMET = registerItem("kryptonite_helmet",
            new ModArmorItem(ModArmorMaterials.KRYPTONITE, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item KRYPTONITE_CHESTPLATE = registerItem("kryptonite_chestplate",
            new ModArmorItem(ModArmorMaterials.KRYPTONITE, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item KRYPTONITE_LEGGINGS = registerItem("kryptonite_leggings",
            new ModArmorItem(ModArmorMaterials.KRYPTONITE, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item KRYPTONITE_BOOTS = registerItem("kryptonite_boots",
            new ModArmorItem(ModArmorMaterials.KRYPTONITE, ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item KRYPTONITE_HORSE_ARMOR = registerItem("kryptonite_horse_armor",
            new HorseArmorItem(14, "kryptonite", new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {


    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
