package net.taavi.fullyenchanced.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class RuptureEnchantment extends Enchantment{
    public RuptureEnchantment(Enchantment.Rarity rarity, EquipmentSlot... slots) {
        super(rarity, EnchantmentTarget.DIGGER, slots);
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxPower(int level) {
        return 1;
    }

}