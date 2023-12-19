package net.taavi.fullyenchanced.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.init.ModEnchantments;

public class RuptureEventHandler {

    public static void registerEvents() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            int ruptureLevel = EnchantmentHelper.getLevel(ModEnchantments.RUPTURE, player.getEquippedStack(EquipmentSlot.MAINHAND));
            if (ruptureLevel > 0) {
                handleRupture(world, player, pos);
            }
        });
    }

    private static void handleRupture(World world, PlayerEntity player, BlockPos pos) {
        if (world instanceof ServerWorld) {
            Direction direction;
            double reach = 6.0;
            Vec3d playerPos = player.getEyePos();
            Vec3d endPos = playerPos.add(player.getRotationVector().multiply(reach));
            HitResult result = world.raycast(new RaycastContext(playerPos, endPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));

            if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockResult = (BlockHitResult) result;
                direction = blockResult.getSide();

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        BlockPos targetPos = calculateTargetPos(pos, direction, i, j);
                        BlockState targetState = world.getBlockState(targetPos);
                        if (targetState.isIn(BlockTags.PICKAXE_MINEABLE)) {
                            world.breakBlock(targetPos, true, player);
                        }
                    }
                }
            }
        }
    }



    private static BlockPos calculateTargetPos(BlockPos pos, Direction sideHit, int offsetX, int offsetY) {
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();

        switch (sideHit) {
            case NORTH, SOUTH -> {return new BlockPos(x + offsetX, y + offsetY, z);}
            case EAST, WEST -> {return new BlockPos(x, y + offsetX, z + offsetY);}
            case UP, DOWN -> {return new BlockPos(x + offsetX, y, z + offsetY);}
            default -> {return new BlockPos(x, y, z);}
        }
    }
}
