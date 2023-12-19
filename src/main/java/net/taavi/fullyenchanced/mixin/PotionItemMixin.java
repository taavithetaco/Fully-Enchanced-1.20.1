package net.taavi.fullyenchanced.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.FullyEnchanced;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ThrowablePotionItem.class)
public class PotionItemMixin {

    /**
     * @author taavi
     * @reason to modify throw distance and add a cooldown to throwable potions
     * @return
     */

    @Overwrite
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            PotionEntity potionEntity = new PotionEntity(world, user);
            potionEntity.setItem(itemStack);
            potionEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, FullyEnchanced.CONFIG.potion_throw_velocity, 1.0f);
            world.spawnEntity(potionEntity);
            user.getItemCooldownManager().set(itemStack.getItem(), FullyEnchanced.CONFIG.potion_throw_cooldown);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

}
