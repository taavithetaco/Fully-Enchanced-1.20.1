package net.taavi.fullyenchanced.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractCloudBlock extends Block {
    public static final int MAX_DISTANCE = 2;

    public AbstractCloudBlock(FabricBlockSettings settings) {
        super(settings);
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (shouldRemove(world, pos)) {
            world.breakBlock(pos, false);
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
            world.scheduleBlockTick(pos, this, 5*20);

    }

    private boolean shouldRemove(ServerWorld serverWorld, BlockPos pos) {
        if (!serverWorld.isClient()) {
            List<? extends PlayerEntity> players = serverWorld.getPlayers();
            for (PlayerEntity player : players) {
                double distanceSquared = pos.getSquaredDistance(player.getX(), player.getY(), player.getZ());
                if (distanceSquared <= MAX_DISTANCE * MAX_DISTANCE) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.getBlock() instanceof AbstractCloudBlock) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}