package net.infinitumcraft.kryptadium.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGeneration() {
        ModOreGeneration.generateOres();

        ModEntityGeneration.addSpawns();
    }

}
