package net.taavi.fullyenchanced.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.taavi.fullyenchanced.init.ModEnchantments;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    public static boolean hasChamber(LivingEntity entity) {
        return EnchantmentHelper.getEquipmentLevel(ModEnchantments.CHAMBER, entity) > 0;
    }
}
