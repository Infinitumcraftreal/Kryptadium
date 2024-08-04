package net.infinitumcraft.kryptadium.entity.client;

import net.infinitumcraft.kryptadium.MCCourseMod;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteBossEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class KryptoniteBossModel extends GeoModel<KryptoniteBossEntity> {
    @Override
    public Identifier getModelResource(KryptoniteBossEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "geo/kryptoniteboss.geo.json");
    }

    @Override
    public Identifier getTextureResource(KryptoniteBossEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "textures/entities/kryptoniteboss.png");
    }

    @Override
    public Identifier getAnimationResource(KryptoniteBossEntity animatable) {
        return new Identifier(MCCourseMod.MOD_ID, "animations/kryptoniteboss.animation.json");
    }

}
