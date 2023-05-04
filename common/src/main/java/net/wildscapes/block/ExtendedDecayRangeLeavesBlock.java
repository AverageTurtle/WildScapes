package net.wildscapes.block;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ExtendedDecayRangeLeavesBlock extends LeavesBlock {
    public ExtendedDecayRangeLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean decaying(BlockState blockState) {
        return !blockState.getValue(PERSISTENT) && blockState.getValue(DISTANCE) == 14;
    }
}
