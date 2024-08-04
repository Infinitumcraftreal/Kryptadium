package net.infinitumcraft.kryptadium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.infinitumcraft.kryptadium.entity.ModEntities;
import net.infinitumcraft.kryptadium.entity.client.KryptaxoRenderer;
import net.infinitumcraft.kryptadium.entity.client.KryptoniteBossRenderer;
import net.infinitumcraft.kryptadium.particle.KryptoniteParticle;
import net.infinitumcraft.kryptadium.particle.ModParticles;
import net.infinitumcraft.kryptadium.util.ModModelPredicateProvider;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class KryptadiumModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.KRYPTONITE_PARTICLE, KryptoniteParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.KRYPTONITE_DYNAMITE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.KPYPTONTITE_BOSS, KryptoniteBossRenderer::new);
        EntityRendererRegistry.register(ModEntities.KRYPTAXO, KryptaxoRenderer::new);
    }
}
