package net.wildscapes.world.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.wildscapes.content.Beach;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance)->foliagePlacerParts(instance).apply(instance, PalmFoliagePlacer::new));


    public PalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return Beach.PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliageAttachment foliageAttachment, int j, int k, int l) {
        BlockPos blockPos = foliageAttachment.pos();

        tryPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos);
        tryPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, blockPos.above());

        genCardinalSection(Direction.NORTH, Direction.EAST, blockPos, levelSimulatedReader, foliageSetter, randomSource, treeConfiguration);
        genCardinalSection(Direction.EAST, Direction.SOUTH, blockPos, levelSimulatedReader, foliageSetter, randomSource, treeConfiguration);
        genCardinalSection(Direction.SOUTH, Direction.WEST, blockPos, levelSimulatedReader, foliageSetter, randomSource, treeConfiguration);
        genCardinalSection(Direction.WEST, Direction.NORTH, blockPos, levelSimulatedReader, foliageSetter, randomSource, treeConfiguration);
    }

    public void genCardinalSection(Direction direction, Direction direction2, BlockPos startPos, LevelSimulatedReader world, FoliageSetter placer, RandomSource random , TreeConfiguration config) {
        BlockPos.MutableBlockPos pos = startPos.mutable();

        pos.move(direction);
        tryPlaceLeaf(world, placer, random, config, pos);

        tryPlaceLeaf(world, placer, random, config, pos.below());
        tryPlaceLeaf(world, placer, random, config, pos.above());

        pos.move(direction);
        tryPlaceLeaf(world, placer, random, config, pos);

        for(int i = 0; i < 2; i++) {
            pos.move(direction);
            tryPlaceLeaf(world, placer, random, config, pos);
            pos.move(Direction.DOWN);
            tryPlaceLeaf(world, placer, random, config, pos);
        }

        pos.set(startPos);

        for(int i = 0; i < 2; i++) {
            tryPlaceLeaf(world, placer, random, config, pos);
            tryPlaceLeaf(world, placer, random, config, pos.offset(direction2.getNormal()));
            pos.move(direction);
            tryPlaceLeaf(world, placer, random, config, pos);
            pos.move(direction2);
            tryPlaceLeaf(world, placer, random, config, pos);
            pos.move(Direction.DOWN);
            tryPlaceLeaf(world, placer, random, config, pos);
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int j, int k, int l, boolean bl) {
        return false;
    }
}
