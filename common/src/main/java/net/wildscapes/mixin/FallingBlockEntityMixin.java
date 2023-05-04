package net.wildscapes.mixin;

import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.wildscapes.mixin_interfaces.FallingBlockMixinInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FallingBlockEntity.class)
public class FallingBlockEntityMixin implements FallingBlockMixinInterface {
    @Shadow
    private BlockState blockState;

    @Override
    public BlockState getBlock() {
        return blockState;
    }

    @Override
    public void setBlock(BlockState block) {
        blockState = block;
    }
}
