package net.taavi.fullyenchanced.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.nbt.NbtCompound;
import net.taavi.fullyenchanced.FullyEnchanced;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

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
        ItemStack projectile = Items.ARROW.getDefaultStack();
        if (!(user instanceof PlayerEntity player)) {
            return;
        }
        ItemStack crossbow = player.getMainHandStack();

        // Check if the item is a crossbow
        if (crossbow.getItem() instanceof CrossbowItem) {
            ItemStack newCrossbow = getNewCrossbow(crossbow);

            // Replace the old crossbow in the player's main hand with the new one
            player.setStackInHand(Hand.MAIN_HAND, newCrossbow);
            player.getItemCooldownManager().set(newCrossbow.getItem(), 0);
        }
    }

    @NotNull
    private static ItemStack getNewCrossbow(ItemStack crossbow) {
        NbtCompound nbt = crossbow.getOrCreateNbt();

        // Remove any existing arrows
        NbtList projectiles = nbt.getList("ChargedProjectiles", 10);
        projectiles.clear();

        NbtCompound arrowNbt = new NbtCompound();
        arrowNbt.putString("id", "minecraft:arrow");
        arrowNbt.putInt("Count", 1);
        projectiles.add(arrowNbt);

        nbt.putBoolean("Charged", true);

        // Create a new crossbow item stack
        ItemStack newCrossbow = new ItemStack(crossbow.getItem());
        newCrossbow.setNbt(nbt);
        return newCrossbow;
    }
}

