package net.taavi.fullyenchanced.mixin;

import net.minecraft.client.sound.SoundEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnchantedBookItem.class)
public class EnchantedBookItemMixin extends Item {
    public EnchantedBookItemMixin(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setStackInHand(hand, Items.BOOK.getDefaultStack());
        user.sendMessage(Text.of("Knowledge has been unsealed."), true);
        user.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN,3,1);
        user.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON,1,1);
        return TypedActionResult.success(itemStack);
    }
}

