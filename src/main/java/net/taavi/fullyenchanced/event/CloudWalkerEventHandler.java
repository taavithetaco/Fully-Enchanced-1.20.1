package net.taavi.fullyenchanced.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.taavi.fullyenchanced.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.init.ModEnchantments;


public class CloudWalkerEventHandler {
    public static void registerEvents() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (hasCloudWalkerEnchantment(player)) {
                    handleCloudWalker(player);
                } else {
                    solidToSoft(player);
                }
            }
        });
    }

    private static boolean hasCloudWalkerEnchantment(PlayerEntity player) {
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        return EnchantmentHelper.getLevel(ModEnchantments.CLOUD_WALKER, leggings) > 0;
    }

    private static void handleCloudWalker(PlayerEntity player) {
        World world = player.getWorld();
        BlockPos playerPos = player.getBlockPos().down();

        if (player.isSneaking()) {
            if (world.isAir(playerPos)) {
                world.setBlockState(playerPos, ModBlocks.SOFT_CLOUD_BLOCK.getDefaultState());
            }

            int radius = 1;
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();
            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        mutablePos.set(playerPos).move(x, y, z);
                        if (world.getBlockState(mutablePos).isOf(ModBlocks.SOFT_CLOUD_BLOCK)) {
                            world.setBlockState(mutablePos, ModBlocks.SOLID_CLOUD_BLOCK.getDefaultState());
                        }
                    }
                }
            }
        } else {
            int radius = 3;
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();
            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        mutablePos.set(playerPos).move(x, y, z);
                        if (world.getBlockState(mutablePos).isOf(ModBlocks.SOLID_CLOUD_BLOCK)) {
                            world.setBlockState(mutablePos, ModBlocks.SOFT_CLOUD_BLOCK.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    private static void solidToSoft(PlayerEntity player) {
        World world = player.getWorld();
        BlockPos playerPos = player.getBlockPos().down();

        if (!player.isSneaking()) {
            int radius = 3;
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();
            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        mutablePos.set(playerPos).move(x, y, z);
                        if (world.getBlockState(mutablePos).isOf(ModBlocks.SOLID_CLOUD_BLOCK)) {
                            world.setBlockState(mutablePos, ModBlocks.SOFT_CLOUD_BLOCK.getDefaultState());
                        }
                    }
                }
            }
        }
    }

}