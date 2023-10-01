package net.taavi.fullyenchanced;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.taavi.fullyenchanced.block.ModBlocks;

public class FullyEnchancedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFT_CLOUD_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOLID_CLOUD_BLOCK, RenderLayer.getTranslucent());

    }
}
