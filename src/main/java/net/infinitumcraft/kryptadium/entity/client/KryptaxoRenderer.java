package net.infinitumcraft.kryptadium.entity.client;

import net.infinitumcraft.kryptadium.KryptadiumMod;
import net.infinitumcraft.kryptadium.entity.custom.KryptaxoEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KryptaxoRenderer extends GeoEntityRenderer<KryptaxoEntity> {
    public KryptaxoRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new KryptaxoModel());
    }

    @Override
    public Identifier getTextureLocation(KryptaxoEntity animatable) {
        return new Identifier(KryptadiumMod.MOD_ID, "textures/entities/kryptaxotexture.png");
    }

    @Override
    public void render(KryptaxoEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
