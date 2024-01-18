package net.taavi.fullyenchanced.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantedBookItem.class)
public abstract class EnchantedBookItemMixin {

//    @Inject(method = "finishUsing", at = @At("HEAD"))
//    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
//        if (user instanceof PlayerEntity) {
//            stack.decrement(1);
//        }
//        return stack;
//    }
//    @Inject(method = "getMaxUseTime", at = @At("HEAD"))
//    public int getMaxUseTime(ItemStack stack) {
//        return 20;
//    }
}

