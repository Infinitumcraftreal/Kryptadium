package net.infinitumcraft.mccourse;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.infinitumcraft.mccourse.block.ModBlocks;
import net.infinitumcraft.mccourse.entity.ModEntities;
import net.infinitumcraft.mccourse.particle.KryptoniteParticle;
import net.infinitumcraft.mccourse.particle.ModParticles;
import net.infinitumcraft.mccourse.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class MCCourseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.KRYPTONITE_PARTICLE, KryptoniteParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.KRYPTONITE_DYNAMITE, FlyingItemEntityRenderer::new);
    }
}
