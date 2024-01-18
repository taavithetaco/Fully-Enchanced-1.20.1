package net.taavi.fullyenchanced.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;

public class MilkBottleItem extends PotionItem {
    public MilkBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && user instanceof PlayerEntity player) {
            Map<StatusEffect, StatusEffectInstance> effects = player.getActiveStatusEffects();

            if (!effects.isEmpty()) {
                int index = player.getRandom().nextInt(effects.size());
                Iterator<Map.Entry<StatusEffect, StatusEffectInstance>> iterator = effects.entrySet().iterator();

                for (int i = 0; i <= index; i++) {
                    Map.Entry<StatusEffect, StatusEffectInstance> entry = iterator.next();

                    if (i == index) {
                        player.removeStatusEffect(entry.getKey());
                        break;
                    }
                }
            }
        }
        return super.finishUsing(stack, world, user);
    }
}

