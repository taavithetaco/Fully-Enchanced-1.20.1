package net.taavi.fullyenchanced.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.taavi.fullyenchanced.init.ModEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin{

    @Overwrite
    public static int getPullTime(ItemStack stack) {
        int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
        int j = EnchantmentHelper.getLevel(ModEnchantments.CHAMBER, stack);
        if (i >= 1){return 25 - 5 * i;} else if (j>=1) {return 100;} else { return 25;}
    }
}
