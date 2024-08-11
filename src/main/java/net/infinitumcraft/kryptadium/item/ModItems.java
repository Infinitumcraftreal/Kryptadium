package net.infinitumcraft.kryptadium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.entity.ModEntities;
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

    public static final Item KRYPTONITE_BOSS_SPAWN_EGG = registerItem("kryptonite_boss_spawn_egg",
            new SpawnEggItem(ModEntities.KPYPTONTITE_BOSS, 0x80c762, 0x9bd893 , new FabricItemSettings()));

    public static final Item KRYPTAXO_SPAWN_EGG = registerItem("kryptaxo_spawn_egg",
            new SpawnEggItem(ModEntities.KRYPTAXO, 0x80c762, 0x9bd893 , new FabricItemSettings()));

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
            new PaxelItem(ModToolMaterial.KRYPTONITE,0, -1f,new FabricItemSettings()));

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

    public static final Item IRIDIUM = registerItem("iridium",
            new Item(new FabricItemSettings()));

    public static final Item IRIDIUM_NUGGETS = registerItem("iridium_nuggets",
            new Item(new FabricItemSettings()));

    public static final Item IRIDIUM_BOW = registerItem("iridium_bow",
            new BowItem(new FabricItemSettings().maxDamage(650)));

    public static final Item IRIDIUM_SHIELD = registerItem("iridium_shield",
            new ShieldItem(new FabricItemSettings().maxDamage(650)));

    public static final Item IRIDIUM_SWORD = registerItem("iridium_sword",
            new SwordItem(ModToolMaterial.IRIDIUM,0, -2.3f,new FabricItemSettings()));
    public static final Item IRIDIUM_KNIFE = registerItem("iridium_knife",
            new SwordItem(ModToolMaterial.IRIDIUM,-6, 3f,new FabricItemSettings()));
    public static final Item IRIDIUM_PICKAXE = registerItem("iridium_pickaxe",
            new PickaxeItem(ModToolMaterial.IRIDIUM,-4, -2.7f,new FabricItemSettings()));
    public static final Item IRIDIUM_SHOVEL = registerItem("iridium_shovel",
            new ShovelItem(ModToolMaterial.IRIDIUM,-6.25f, 1f,new FabricItemSettings()));
    public static final Item IRIDIUM_AXE = registerItem("iridium_axe",
            new AxeItem(ModToolMaterial.IRIDIUM,1, -3f,new FabricItemSettings()));
    public static final Item IRIDIUM_HOE = registerItem("iridium_hoe",
            new HoeItem(ModToolMaterial.IRIDIUM,-8, 4f,new FabricItemSettings()));
    public static final Item IRIDIUM_HAMMER = registerItem("iridium_hammer",
            new PaxelItem(ModToolMaterial.IRIDIUM,0, -1f,new FabricItemSettings()));

    public static final Item IRIDIUM_HELMET = registerItem("iridium_helmet",
            new ModArmorItem(ModArmorMaterials.IRIDIUM, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item IRIDIUM_CHESTPLATE = registerItem("iridium_chestplate",
            new ModArmorItem(ModArmorMaterials.IRIDIUM, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item IRIDIUM_LEGGINGS = registerItem("iridium_leggings",
            new ModArmorItem(ModArmorMaterials.IRIDIUM, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item IRIDIUM_BOOTS = registerItem("iridium_boots",
            new ModArmorItem(ModArmorMaterials.IRIDIUM, ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item IRIDIUM_HORSE_ARMOR = registerItem("iridium_horse_armor",
            new HorseArmorItem(18, "iridium", new FabricItemSettings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KryptadiumMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {


    }

    public static void registerModItems() {
        KryptadiumMod.LOGGER.info("Registering Mod Items for " + KryptadiumMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
