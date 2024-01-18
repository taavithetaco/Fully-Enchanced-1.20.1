package net.taavi.fullyenchanced.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.taavi.fullyenchanced.FullyEnchanced;
import net.taavi.fullyenchanced.item.*;

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
    public static final Item WOODEN_BOOMERANG = registerItem("wooden_boomerang",
            new BoomerangItem(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item STONE_BOOMERANG = registerItem("stone_boomerang",
            new BoomerangItem(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item NEW_ENCHANTED_BOOK = registerItem("new_enchanted_book",
            new NewEnchantedBookItem(new FabricItemSettings().maxCount(1)));
    public static final Item MILK_BOTTLE = registerItem("milk_bottle",
            new MilkBottleItem(new FabricItemSettings()));
    public static final Item SPLASH_MILK_BOTTLE = registerItem("splash_milk_bottle",
            new SplashMilkBottleItem(new FabricItemSettings()));
    public static final Item BUCKLER = registerItem("buckler",
            new BucklerItem(new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FullyEnchanced.MOD_ID, name), item);
    }

    public static void  registerModItems() {
        FullyEnchanced.LOGGER.info("Registering Mod Items for " + FullyEnchanced.MOD_ID);
    }
}
