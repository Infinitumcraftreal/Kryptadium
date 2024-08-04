package net.infinitumcraft.kryptadium.entity.client;

import net.infinitumcraft.kryptadium.MCCourseMod;
import net.infinitumcraft.kryptadium.entity.custom.KryptaxoEntity;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class KryptaxoModel extends GeoModel<KryptaxoEntity> {
    @Override
    public Identifier getModelResource(KryptaxoEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "geo/kryptaxo.geo.json");
    }

    @Override
    public Identifier getTextureResource(KryptaxoEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "textures/entities/kryptaxotexture.png");
    }

    @Override
    public Identifier getAnimationResource(KryptaxoEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "animations/kryptaxo.animation.json");
    }

}
