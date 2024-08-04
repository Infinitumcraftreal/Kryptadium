package net.infinitumcraft.kryptadium.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType KRYPTONITE_PARTICLE =
            registerParticle("kryptonite_particle", FabricParticleTypes.simple());


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(KryptadiumMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        KryptadiumMod.LOGGER.info("Registering Particles for " + KryptadiumMod.MOD_ID);
    }
}

