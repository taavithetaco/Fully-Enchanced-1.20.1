package net.taavi.fullyenchanced.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class ChamberEnchantment extends Enchantment {
    public ChamberEnchantment(Enchantment.Rarity rarity, EquipmentSlot... slots) {
        super(rarity, EnchantmentTarget.CROSSBOW, slots);
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
        super.onTargetDamaged(user, target, level);
        if (target instanceof LivingEntity) {
            ItemStack crossbowStack = user.getStackInHand(Hand.MAIN_HAND);
            if (crossbowStack.getItem() instanceof CrossbowItem) {
                CrossbowItem.setCharged(user.getMainHandStack(), true);
                CrossbowItem.isCharged(user.getMainHandStack());
            }
        }
    }

}

