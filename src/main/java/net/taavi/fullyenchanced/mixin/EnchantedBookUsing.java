//package net.taavi.fullyenchanced.mixin;
//
//import net.minecraft.enchantment.EnchantmentHelper;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.EnchantedBookItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.nbt.NbtList;
//import net.minecraft.text.Text;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//
//@Mixin(net.minecraft.item.EnchantedBookItem.class)
//
//public interface EnchantedBookUsing{
//
//
//    @Override
//    public TypedActionResult<ItemStack> use(PlayerEntity user, ItemStack stack, Hand hand) {
//        stack = user.getStackInHand(hand);
//        if (!user.getAbilities().creativeMode) {
//            stack.decrement(1);
//            if(stack.hasNbt()){
//                user.sendMessage(Text.literal(EnchantedBookItem.getEnchantmentNbt(stack) + "learned!"));
//            }
//        }
//        return TypedActionResult.consume(stack);
//    }
//}
//
//
//
//
//
