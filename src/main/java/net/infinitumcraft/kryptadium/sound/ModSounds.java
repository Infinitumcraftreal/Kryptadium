package net.infinitumcraft.kryptadium.sound;

import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent RADAR_ONUSE = registerSoundEvent("radar_onuse");
    public static final SoundEvent STEP = registerSoundEvent("step");
    public static final SoundEvent DEATH = registerSoundEvent("dead");
    public static final SoundEvent HURT = registerSoundEvent("hurt");

    private  static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(KryptadiumMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        KryptadiumMod.LOGGER.info("Registering Mod Sounds for " + KryptadiumMod.MOD_ID);
    }
}
