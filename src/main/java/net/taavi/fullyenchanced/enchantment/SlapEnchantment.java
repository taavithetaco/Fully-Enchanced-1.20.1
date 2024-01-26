package net.taavi.fullyenchanced.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class SlapEnchantment extends Enchantment{
    public SlapEnchantment(Enchantment.Rarity rarity, EquipmentSlot... slots) {
    super(rarity, EnchantmentTarget.DIGGER, slots);
}

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxPower(int level) {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        target.addVelocity(10,0,0);
        super.onTargetDamaged(user, target, level);
    }
}
