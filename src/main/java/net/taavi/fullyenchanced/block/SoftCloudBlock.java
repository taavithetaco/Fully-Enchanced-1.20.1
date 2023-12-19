package net.taavi.fullyenchanced.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class SoftCloudBlock extends AbstractCloudBlock {
    public SoftCloudBlock(FabricBlockSettings settings) {
        super(settings);
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.98f, 0.98f, 0.98f));
    }
}
