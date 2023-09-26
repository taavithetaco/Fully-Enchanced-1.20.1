package net.taavi.fullyenchanced.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;


public class ModBlocks {

    public static final Block CLOUD_BLOCK = registerBlock("cloud_block",
            new CloudBlock(FabricBlockSettings.create().replaceable().dropsNothing().luminance(state -> state.get(CloudBlock.TANGIBLE) ? 10 : 0).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FullyEnchanced.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FullyEnchanced.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }



    public static void registerModBlocks(){
        FullyEnchanced.LOGGER.info("Registering ModBlocks For " + FullyEnchanced.MOD_ID );

    }
}
