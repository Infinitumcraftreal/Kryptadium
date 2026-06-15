package net.infinitumcraft.kryptadium.entity.client;

import net.infinitumcraft.kryptadium.block.ModBlocks;
import net.infinitumcraft.kryptadium.entity.custom.KryptoniteTntEntity;
import net.minecraft.client.MinecraftClient; // ADD THIS IMPORT
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class KryptoniteTntEntityRenderer extends EntityRenderer<KryptoniteTntEntity> {

    public KryptoniteTntEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
    }

    @Override
    public void render(KryptoniteTntEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.translate(0.0D, 0.5D, 0.0D);

        int fuse = entity.getFuse();

        if ((float)fuse - tickDelta + 1.0F < 10.0F) {
            float h = 1.0F - ((float)fuse - tickDelta + 1.0F) / 10.0F;
            h = MathHelper.clamp(h, 0.0F, 1.0F);
            h *= h;
            h *= h;
            float scale = 1.0F + h * 0.3F;
            matrices.scale(scale, scale, scale);
        }

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
        matrices.translate(-0.5D, -0.5D, 0.5D);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));

        var blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();

        TntMinecartEntityRenderer.renderFlashingBlock(
                blockRenderManager,
                ModBlocks.KRYPTONITE_TNT.getDefaultState(),
                matrices,
                vertexConsumers,
                light,
                fuse / 5 % 2 == 0
        );

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(KryptoniteTntEntity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}