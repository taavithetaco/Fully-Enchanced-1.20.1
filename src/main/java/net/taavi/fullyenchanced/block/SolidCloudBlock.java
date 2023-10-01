package net.taavi.fullyenchanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

import java.util.List;

public class SolidCloudBlock extends Block {
    public static final int MAX_DISTANCE = 5;
    public SolidCloudBlock(Settings settings) {
        super(settings);
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

