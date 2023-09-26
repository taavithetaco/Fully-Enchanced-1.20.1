package net.taavi.fullyenchanced.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CloudBlock extends Block {
    public static final BooleanProperty TANGIBLE = BooleanProperty.of("permeable");

    public CloudBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(TANGIBLE, false));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if (!world.isClient && entity.isSneaking()) {
            world.setBlockState(pos, (BlockState)state.with(TANGIBLE, true), Block.NOTIFY_ALL);
        }
        if(!entity.isSneaking()){
            world.setBlockState(pos, (BlockState)state.with(TANGIBLE, false), Block.NOTIFY_ALL);
        }
    }



    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TANGIBLE);
    }
}









