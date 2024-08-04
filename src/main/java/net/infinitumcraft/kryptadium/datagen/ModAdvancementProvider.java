package net.infinitumcraft.kryptadium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.KRYPTONITE),
                        Text.literal("Kryptadium"), Text.literal("Play With The Mod Kryptadium Installed"),
                        new Identifier(KryptadiumMod.MOD_ID, "textures/block/kryptonite_ore.png"), AdvancementFrame.TASK, true, true ,false))
                .criterion("has_played_with_kryptadium", TickCriterion.Conditions.createTick())
                .build(consumer, KryptadiumMod.MOD_ID + ":mccourse");

        Advancement getakryptonite = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.KRYPTONITE),
                        Text.literal("Get A Kryptonite"), Text.literal("Get one kryptonite"),
                        new Identifier(KryptadiumMod.MOD_ID, "textures/block/kryptonite_ore.png"), AdvancementFrame.TASK, true, true ,false))
                .criterion("has_kryptonite", InventoryChangedCriterion.Conditions.items(ModItems.KRYPTONITE))
                .parent(rootAdvancement)
                .build(consumer, KryptadiumMod.MOD_ID + ":getakryptonite");

        Advancement getfullkryptonitearmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.KRYPTONITE_HELMET),
                        Text.literal("Full Kryptonite Armor"), Text.literal("Get A Full Set Of Kryptonite Armor"),
                        new Identifier(KryptadiumMod.MOD_ID, "textures/block/kryptonite_ore.png"), AdvancementFrame.CHALLENGE, true, true ,false))
                .criterion("has_full_kryptonite_armor", InventoryChangedCriterion.Conditions.items(ModItems.KRYPTONITE_HELMET, ModItems.KRYPTONITE_CHESTPLATE, ModItems.KRYPTONITE_LEGGINGS, ModItems.KRYPTONITE_BOOTS))
                .parent(getakryptonite)
                .build(consumer, KryptadiumMod.MOD_ID + ":getfullkryptonitearmor");

        Advancement getkryptoniteblock = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.KRYPTONITE_BLOCK),
                        Text.literal("Craft A Kryptonite Block"), Text.literal("You Got A Kryptonite Block!"),
                        new Identifier(KryptadiumMod.MOD_ID, "textures/block/kryptonite_ore.png"), AdvancementFrame.TASK, true, true ,false))
                .criterion("has_kryptonite_block", InventoryChangedCriterion.Conditions.items(ModBlocks.KRYPTONITE_BLOCK))
                .parent(getakryptonite)
                .build(consumer, KryptadiumMod.MOD_ID + ":getkryptoniteblock");
    }
}
