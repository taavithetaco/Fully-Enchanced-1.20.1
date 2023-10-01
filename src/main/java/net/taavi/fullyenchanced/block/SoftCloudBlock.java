package net.taavi.fullyenchanced.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.List;

public class SoftCloudBlock extends Block {
    public static final int MAX_DISTANCE = 5;
    public SoftCloudBlock(Settings settings) {
        super(settings);
    }
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.9f, 0.9, 0.9f));
    }
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (shouldRemove(world, pos)) {
            world.removeBlock(pos, true);
        } else {
            super.scheduledTick(state, world, pos, random);
        }
    }

    private boolean shouldRemove(ServerWorld world, BlockPos pos) {
        List<? extends PlayerEntity> players = world.getPlayers();

        for (PlayerEntity player : players) {
            double distanceSquared = pos.getSquaredDistance(new Vec3d(player.getX(), player.getY(), player.getZ()));
            if (distanceSquared > MAX_DISTANCE * MAX_DISTANCE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(ModBlocks.SOFT_CLOUD_BLOCK)) {
            return true;
        } else if (stateFrom.isOf(ModBlocks.SOLID_CLOUD_BLOCK)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}