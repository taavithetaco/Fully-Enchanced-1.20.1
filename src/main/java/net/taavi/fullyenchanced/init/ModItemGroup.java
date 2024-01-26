package net.taavi.fullyenchanced.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModItemGroup {
    public static final ItemGroup FULLY_ENCHANCED_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FullyEnchanced.MOD_ID, "fully_enchanced_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fully_enchanced_group"))
                    .icon(()-> new ItemStack(ModItems.NETHERITE_SCYTHE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WOODEN_SCYTHE);
                        entries.add(ModItems.STONE_SCYTHE);
                        entries.add(ModItems.IRON_SCYTHE);
                        entries.add(ModItems.GOLDEN_SCYTHE);
                        entries.add(ModItems.DIAMOND_SCYTHE);
                        entries.add(ModItems.NETHERITE_SCYTHE);

                        entries.add(ModItems.WOODEN_BOOMERANG);
                        entries.add(ModItems.STONE_BOOMERANG);

                        entries.add(ModItems.NEW_ENCHANTED_BOOK);

                        entries.add(ModItems.MILK_BOTTLE);
                        entries.add(ModItems.SPLASH_MILK_BOTTLE);

                        entries.add(ModItems.BUCKLER);
                    }).build());

    public static void registerItemGroup(){

    }
}
