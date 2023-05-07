package net.wildscapes.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.wildscapes.content.Beach;
import net.wildscapes.entity.FallingCoconutEntity;

@SuppressWarnings("deprecation")
public class CoconutBlock extends FaceAttachedHorizontalDirectionalBlock implements BonemealableBlock {
    protected static final VoxelShape FLOOR_SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    protected static final VoxelShape CEILING_SHAPE = Block.box(2.0, 4.0, 2.0, 14.0, 16.0, 14.0);

    protected static final VoxelShape NORTH_SHAPE = Block.box(2.0, 2.0, 4.0, 14.0, 14.0, 16.0);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(2.0, 2.0, 0.0, 14.0, 14.0, 12.0);
    protected static final VoxelShape WEST_SHAPE = Block.box(4.0, 2.0, 2.0, 16.0, 14.0, 14.0);
    protected static final VoxelShape EAST_SHAPE = Block.box(0.0, 2.0, 2.0, 12.0, 14.0, 14.0);

    public CoconutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.FLOOR));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);

        return switch (blockState.getValue(FACE)) {
            case FLOOR -> FLOOR_SHAPE;
            case CEILING -> CEILING_SHAPE;
            case WALL -> switch (direction) {
                case EAST -> EAST_SHAPE;
                case WEST -> WEST_SHAPE;
                case SOUTH -> SOUTH_SHAPE;
                case NORTH, UP, DOWN -> NORTH_SHAPE;
            };
        };
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        levelAccessor.scheduleTick(blockPos, this, this.getDelayAfterPlace());
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        level.scheduleTick(blockPos, this, this.getDelayAfterPlace());
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        Direction direction = getConnectedDirection(blockState).getOpposite();
        BlockPos supportPos = blockPos.offset(direction.getNormal());
        BlockState supportedState = serverLevel.getBlockState(supportPos);

        if (isFree(supportedState)) {
            FallingCoconutEntity.spawnFromBlock(serverLevel, blockPos, blockState.getBlock().defaultBlockState());
        }
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return true;
    }

    protected int getDelayAfterPlace() {
        return 2;
    }
    public static boolean isFree(BlockState blockState) {
        Material material = blockState.getMaterial();
        return blockState.isAir() || blockState.is(BlockTags.FIRE) || material.isLiquid() || blockState.canBeReplaced();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        level.setBlock(blockPos, Beach.PALM_SAPLING.get().defaultBlockState(), 0);
    }
}
