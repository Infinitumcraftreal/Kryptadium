package net.infinitumcraft.kryptadium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.infinitumcraft.kryptadium.MCCourseMod;
import net.infinitumcraft.kryptadium.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    // Kryptadium
    public static final Item KRYPTONITE = registerItem("kryptonite",
            new Item(new FabricItemSettings()));

    public static final Item KRYPTONITE_NUGGETS = registerItem("kryptonite_nuggets",
            new Item(new FabricItemSettings()));


    public static final Item KRYPTONITE_APPLE = registerItem("kryptonite_apple",
            new Item(new FabricItemSettings().food(ModFoodComponents.KRYPTONITE_APPLE)));

    public static final Item KRYPTONITE_BOW = registerItem("kryptonite_bow",
            new BowItem(new FabricItemSettings().maxDamage(500)));

    public static final Item KRYPTONITE_SHIELD = registerItem("kryptonite_shield",
            new ShieldItem(new FabricItemSettings().maxDamage(500)));

    public static final Item KRYPTONITE_DYNAMITE = registerItem("kryptonite_dynamite",
            new DynamiteItem(new FabricItemSettings()));

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
    public static final Item KRYPTONITE_HAMMER = registerItem("kryptonite_hammer",
            new PaxelItem(ModToolMaterial.KRYPTONITE,0, 0f,new FabricItemSettings()));

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
