package net.infinitumcraft.kryptadium;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.enchantment.ModEnchantments;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.entity.custom.KryptaxoEntity;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossEntity;
import net.infinitumcraft.kryptadium.item.ModItemGroup;
import net.infinitumcraft.kryptadium.item.ModItems;
import net.infinitumcraft.kryptadium.sound.ModSounds;
import net.infinitumcraft.kryptadium.util.ModRegistries;
import net.infinitumcraft.kryptadium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KryptadiumMod implements ModInitializer {
	public static final String MOD_ID = "kryptadium";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
		ModEnchantments.registerModEnchantments();

		ModSounds.registerSounds();
		ModWorldGeneration.generateModWorldGeneration();

		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.KPYPTONTITE_BOSS, KryptoniteBossEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.KRYPTAXO, KryptaxoEntity.setAttributes());

	}
}