package net.taavi.fullyenchanced.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.taavi.fullyenchanced.entity.WoodenBoomerangEntity;
import net.taavi.fullyenchanced.entity.animations.BoomerangAnimations;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BoomerangEntityModel<T extends WoodenBoomerangEntity> extends SinglePartEntityModel<T> {
	private final ModelPart boomerang_entity;
	public BoomerangEntityModel(ModelPart root) {
		this.boomerang_entity = root.getChild("boomerang_entity");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData boomerang_entity = modelPartData.addChild("boomerang_entity", ModelPartBuilder.create()
				.uv(11, 10).cuboid(-7.0F, -1.0F, -6.0F, 9.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -1.0F, -2.0F, 3.0F, 1.0F, 9.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, -1.0F, -5.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(2.0F, -1.0F, -6.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 9.0F, new Dilation(0.0F))
				.uv(11, 14).cuboid(-6.0F, -1.0F, -7.0F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(5, 0).cuboid(2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(15, 0).cuboid(2.0F, -1.0F, -5.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				,ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(WoodenBoomerangEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.updateAnimation(entity.idleAnimationState, BoomerangAnimations.SPINNING, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		boomerang_entity.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return boomerang_entity;
	}
}