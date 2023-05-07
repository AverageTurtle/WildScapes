package net.wildscapes.world.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.wildscapes.content.Beach;

import java.util.List;
import java.util.function.BiConsumer;

//TODO make it so you can disable coconut gen or maybe even switch out the block for something else
public class SlantedTrunkPlacer extends TrunkPlacer {
    public static final Codec<SlantedTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> trunkPlacerParts(instance)
            .apply(instance, SlantedTrunkPlacer::new));

    public SlantedTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return null;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        int dirInt = random.nextInt(1, 4);
        Direction direction = switch (dirInt) {
            case 2 -> Direction.EAST;
            case 3 -> Direction.WEST;
            case 4 -> Direction.SOUTH;
            default -> Direction.NORTH;
        };
        setDirtAt(world, replacer, random, startPos.below(), config);

        placeLog(world, replacer, random, startPos.offset(direction.getOpposite().getNormal()), config);

        boolean coconutsGenned = false;
        BlockPos.MutableBlockPos currentPos = startPos.mutable();
        for(int i = 0; i < height; ++i) {
            placeLog(world, replacer, random, currentPos, config);
            boolean leavesGen = i > height-3;
            if(leavesGen && !coconutsGenned) {
                attemptPlaceCoconut(world, replacer, currentPos.north(), Direction.NORTH);
                attemptPlaceCoconut(world, replacer, currentPos.south(), Direction.SOUTH);
                attemptPlaceCoconut(world, replacer, currentPos.east(), Direction.EAST);
                attemptPlaceCoconut(world, replacer, currentPos.west(), Direction.WEST);
                coconutsGenned = true;
            }

            if (random.nextFloat() < 0.4F && i > 1 && !leavesGen) {
                currentPos.move(direction);
            }
            currentPos.move(Direction.UP);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(currentPos, 0, false));
    }

    private void attemptPlaceCoconut(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, BlockPos pos, Direction placeDir) {
        if(world.isStateAtPosition(pos, blockState -> blockState == Blocks.AIR.defaultBlockState())) {
            replacer.accept(pos, Beach.COCONUT.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, placeDir).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.WALL));
        }
    }
}
