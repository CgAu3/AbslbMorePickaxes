package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

public class NegativeExistenceBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;

    public NegativeExistenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected boolean skipRendering(
        @NonNull BlockState state,
        @NonNull BlockState neighborState,
        @NonNull Direction direction) {
        return neighborState.getBlock() instanceof NegativeExistenceBlock
            || super.skipRendering(state, neighborState, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected @NonNull VoxelShape getBlockSupportShape(
        @NonNull BlockState state,
        @NonNull BlockGetter level,
        @NonNull BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected boolean isRandomlyTicking(@NonNull BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(
        @NonNull BlockState state,
        @NonNull ServerLevel level,
        @NonNull BlockPos pos,
        @NonNull RandomSource random) {
        if (state.getValue(AGE) >= 1) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        } else  {
            level.setBlockAndUpdate(pos, state.setValue(AGE, 1));
        }
    }

    @Override
    public BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AGE, 0);
    }
}
