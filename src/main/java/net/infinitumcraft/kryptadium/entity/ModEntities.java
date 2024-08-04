package net.infinitumcraft.kryptadium.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.infinitumcraft.kryptadium.MCCourseMod;
import net.infinitumcraft.kryptadium.entity.custom.DiceProjectileEntity;
import net.infinitumcraft.kryptadium.entity.custom.KryptaxoEntity;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<DiceProjectileEntity> KRYPTONITE_DYNAMITE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MCCourseMod.MOD_ID, "kryptonite_dynamite"),
            FabricEntityTypeBuilder.<DiceProjectileEntity>create(SpawnGroup.CREATURE, DiceProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.50f, 0.50f)).build());

    public static final EntityType<KryptoniteBossEntity> KPYPTONTITE_BOSS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(MCCourseMod.MOD_ID, "kryptonite_boss"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, KryptoniteBossEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 4f)).build());

    public static final EntityType<KryptaxoEntity> KRYPTAXO = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(MCCourseMod.MOD_ID, "kryptaxo"),
            FabricEntityTypeBuilder.create(SpawnGroup.AXOLOTLS, KryptaxoEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.5f)).build());



    public static void registerModEntities() {
        MCCourseMod.LOGGER.info("Registering Mod Entities for " + MCCourseMod.MOD_ID);
    }
}
