package net.infinitumcraft.mccourse;

import net.fabricmc.api.ModInitializer;

import net.infinitumcraft.mccourse.block.ModBlocks;
import net.infinitumcraft.mccourse.enchantment.ModEnchantments;
import net.infinitumcraft.mccourse.entity.ModEntities;
import net.infinitumcraft.mccourse.item.ModItemGroup;
import net.infinitumcraft.mccourse.item.ModItems;
import net.infinitumcraft.mccourse.sound.ModSounds;
import net.infinitumcraft.mccourse.util.ModRegistries;
import net.infinitumcraft.mccourse.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
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

	}
}