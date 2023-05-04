package net.wildscapes.mixin_interfaces;

import net.minecraft.world.level.block.state.BlockState;

public interface FallingBlockMixinInterface {
    BlockState getBlock();
    void setBlock(BlockState block);
}
