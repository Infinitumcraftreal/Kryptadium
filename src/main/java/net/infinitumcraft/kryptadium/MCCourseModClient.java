package net.infinitumcraft.kryptadium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.particle.KryptoniteParticle;
import net.infinitumcraft.kryptadium.particle.ModParticles;
import net.infinitumcraft.kryptadium.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class MCCourseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.KRYPTONITE_PARTICLE, KryptoniteParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.KRYPTONITE_DYNAMITE, FlyingItemEntityRenderer::new);
    }
}
