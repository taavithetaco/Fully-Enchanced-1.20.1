package net.taavi.fullyenchanced.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin {

    @Inject(method = "onStoppedUsing", at = @At("HEAD"))
    private void injectMethod(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo info) {
        if (EnchantmentHelper.hasChanneling(stack)){
            int j = 5;
        }

    }
}

