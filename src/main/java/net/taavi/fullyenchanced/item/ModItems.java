package net.taavi.fullyenchanced.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModItems {

    public static final Item WOODEN_SCYTHE = registerItem("wooden_scythe",
            new ScytheItem(ToolMaterials.WOOD, 5, -2.4f, new FabricItemSettings()));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe",
            new ScytheItem(ToolMaterials.STONE, 6, -2.4f, new FabricItemSettings()));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe",
            new ScytheItem(ToolMaterials.IRON, 7, -2.7f, new FabricItemSettings()));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",
            new ScytheItem(ToolMaterials.DIAMOND, 8, -2.8f, new FabricItemSettings()));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",
            new ScytheItem(ToolMaterials.NETHERITE, 9, -2.8f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FullyEnchanced.MOD_ID, name), item);
    }

    public static void  registerModItems() {
        FullyEnchanced.LOGGER.info("Registering Mod Items for " + FullyEnchanced.MOD_ID);
    }
}
