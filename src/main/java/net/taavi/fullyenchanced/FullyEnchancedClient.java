package net.taavi.fullyenchanced;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.taavi.fullyenchanced.entity.ModModelLayers;
import net.taavi.fullyenchanced.entity.client.BoomerangEntityModel;
import net.taavi.fullyenchanced.entity.client.BoomerangEntityRenderer;
import net.taavi.fullyenchanced.init.ModBlocks;
import net.taavi.fullyenchanced.init.ModEntities;
import net.taavi.fullyenchanced.init.ModModelPredicateProvider;
import net.taavi.fullyenchanced.init.ModParticles;
import net.taavi.fullyenchanced.particle.WitherPedalParticles;

public class FullyEnchancedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFT_CLOUD_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOLID_CLOUD_BLOCK, RenderLayer.getTranslucent());

        ParticleFactoryRegistry.getInstance().register(ModParticles.WITHER_PEDAL_PARTICLE, WitherPedalParticles.Factory::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BOOMERANG, BoomerangEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOOMERANG, BoomerangEntityRenderer::new);

        ModModelPredicateProvider.registerModModels();

    }
}
