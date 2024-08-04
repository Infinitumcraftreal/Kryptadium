package net.infinitumcraft.kryptadium.world;

import net.infinitumcraft.kryptadium.MCCourseMod;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;


public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> KRYPTONITE_ORE_KEY = registerKey("kryptonite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldKryptoniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KRYPTONITE_ORE.getDefaultState()));



        register(context, KRYPTONITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldKryptoniteOres, 4));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MCCourseMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}