package net.taavi.fullyenchanced.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModItems {


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FullyEnchanced.MOD_ID, name), item);
    }

    public static void  registerModItems() {
        FullyEnchanced.LOGGER.info("Registering Mod Items for " + FullyEnchanced.MOD_ID);
    }
}
