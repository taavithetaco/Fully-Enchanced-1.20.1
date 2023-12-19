package net.taavi.fullyenchanced.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NewEnchantedBookItem
        extends Item {
    public static final String STORED_ENCHANTMENTS_KEY = "StoredEnchantments";

    public NewEnchantedBookItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        ItemStack.appendEnchantments(tooltip, EnchantedBookItem.getEnchantmentNbt(stack));
    }

    public static NbtList getEnchantmentNbt(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound != null) {
            return nbtCompound.getList(STORED_ENCHANTMENTS_KEY, NbtElement.COMPOUND_TYPE);
        }
        return new NbtList();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        String enchantmentId1 = String.valueOf(stack.getEnchantments());
        String enchantmentName = enchantmentId1.replace("[{id:\"minecraft:","")
                .replace("\",lvl:1s}]","")
                .replace("\",lvl:2s}]","")
                .replace("\",lvl:3s}]","")
                .replace("_"," ");
        String newenchantmentName = String.valueOf(NewEnchantedBookItem.getEnchantmentNbt(stack));
        if (!user.hasNoGravity()) {
            stack.decrement(1);
            user.sendMessage(Text.of(newenchantmentName + " learned!"), true);

        }
        return TypedActionResult.consume(stack);
    }
    public static ItemStack forEnchantment(EnchantmentLevelEntry info) {
        ItemStack itemStack = new ItemStack(Items.ENCHANTED_BOOK);
        EnchantedBookItem.addEnchantment(itemStack, info);
        return itemStack;
    }
}
