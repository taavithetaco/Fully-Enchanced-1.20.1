package net.taavi.fullyenchanced.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.entity.BoomerangEntity;

public class BoomerangItem extends ToolItem {
    public BoomerangItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);

        if (!world.isClient()) {
            BoomerangEntity boomerangEntity = new BoomerangEntity(world, user, itemstack);
            boomerangEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2F, 0.0F);
            world.spawnEntity(boomerangEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            user.getInventory().removeOne(itemstack);
        }

        return TypedActionResult.success(itemstack, world.isClient());
    }
}
