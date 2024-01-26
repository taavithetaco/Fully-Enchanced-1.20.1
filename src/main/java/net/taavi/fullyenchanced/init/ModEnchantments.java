package net.taavi.fullyenchanced.init;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;
import net.taavi.fullyenchanced.enchantment.ChamberEnchantment;
import net.taavi.fullyenchanced.enchantment.CloudWalkerEnchantment;
import net.taavi.fullyenchanced.enchantment.RuptureEnchantment;


public class ModEnchantments {
    public static final Enchantment CLOUD_WALKER = register("cloud_walker", new CloudWalkerEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.LEGS));
    public static final Enchantment RUPTURE = register("rupture", new RuptureEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
    public static final Enchantment CHAMBER = register("chamber", new ChamberEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND));
    public static final Enchantment SLAP = register("slap", new ChamberEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));


    public static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(FullyEnchanced.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        FullyEnchanced.LOGGER.info("Registering ModEnchantments for " + FullyEnchanced.MOD_ID);

    }

}
