package net.infinitumcraft.kryptadium.entity.client;

import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class KryptoniteBossModel extends GeoModel<KryptoniteBossEntity> {
    @Override
    public Identifier getModelResource(KryptoniteBossEntity animatable) {
        return new Identifier(KryptadiumMod.MOD_ID, "geo/kryptoniteboss.geo.json");
    }

    @Override
    public Identifier getTextureResource(KryptoniteBossEntity animatable) {
        return new Identifier(KryptadiumMod.MOD_ID, "textures/entities/kryptoniteboss.png");
    }

    @Override
    public Identifier getAnimationResource(KryptoniteBossEntity animatable) {
        return new Identifier(KryptadiumMod.MOD_ID, "animations/kryptoniteboss.animation.json");
    }

}
