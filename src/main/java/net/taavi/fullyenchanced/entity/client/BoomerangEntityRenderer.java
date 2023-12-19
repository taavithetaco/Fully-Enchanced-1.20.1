package net.taavi.fullyenchanced.entity.client;


import net.taavi.fullyenchanced.FullyEnchanced;
import net.taavi.fullyenchanced.entity.BoomerangEntity;
import net.taavi.fullyenchanced.entity.ModModelLayers;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class BoomerangEntityRenderer extends EntityRenderer<BoomerangEntity> {
    public static final Identifier TEXTURE = new Identifier(FullyEnchanced.MOD_ID, "textures/entity/wooden_boomerang.png");
    protected BoomerangEntityModel model;


    public BoomerangEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new BoomerangEntityModel(ctx.getPart(ModModelLayers.BOOMERANG));
    }

    @Override
    public void render(BoomerangEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        if (entity.getOwner() != null) { // Check if the boomerang has an owner (player)
            float headPitch = entity.getOwner().getPitch(tickDelta);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) + (entity.age*10)));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch())));
            matrices.translate(0.0f, -1.4f, 0.0f);
            VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
            this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(BoomerangEntity entity) {
        return TEXTURE;
    }
}
