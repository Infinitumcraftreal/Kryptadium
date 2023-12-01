package net.infinitumcraft.mccourse.sound;

import net.infinitumcraft.mccourse.MCCourseMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent RADAR_ONUSE = registerSoundEvent("radar_onuse");

    private  static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(MCCourseMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        MCCourseMod.LOGGER.info("Registering Mod Sounds for " + MCCourseMod.MOD_ID);
    }
}
