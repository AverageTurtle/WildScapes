package net.wildscapes.content;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.wildscapes.Wildscapes;
import net.wildscapes.block.CoconutBlock;
import net.wildscapes.block.ExtendedDecayRangeLeavesBlock;
import net.wildscapes.entity.FallingCoconutEntity;
import net.wildscapes.utils.RegistryUtils;
import net.wildscapes.world.PalmTreeGrower;
import net.wildscapes.world.tree.PalmFoliagePlacer;
import net.wildscapes.world.tree.SlantedTrunkPlacer;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Beach {
    //BLOCKS
    public static class _Blocks {
        public static final Block COCONUT = new CoconutBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(0.2f, 3.0f).noOcclusion());

        public static final Block  PALM_LEAVES = new ExtendedDecayRangeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
        public static final Block  PALM_SAPLING = new SaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
        public static final Block  POTTED_PALM_SAPLING = new FlowerPotBlock(PALM_SAPLING ,BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion());

        public static final Block  PALM_WOOD = new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD));
        public static final Block  PALM_LOG = new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
        public static final Block  STRIPPED_PALM_WOOD = new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD));
        public static final Block  STRIPPED_PALM_LOG = new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG));

        public static final Block  PALM_PLANKS = new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
        public static final Block  PALM_STAIRS = new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS));
        public static final Block  PALM_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
        public static final Block  PALM_FENCE = new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE));
        public static final Block  PALM_FENCE_GATE = new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
        public static final Block  PALM_DOOR = new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK);
        public static final Block  PALM_TRAPDOOR = new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK);
        public static final Block  PALM_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK);
        public static final Block  PALM_BUTTON = new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true);
    }
    @SuppressWarnings("UnstableApiUsage")
    public static class _Items {
        public static final Item COCONUT_SLICE = new Item(new Item.Properties().food(Foods.MELON_SLICE).arch$tab(Wildscapes.CREATIVE_MODE_TAB));
    }

    public static final RegistrySupplier<EntityType<FallingCoconutEntity>> FALLING_COCONUT = RegistryUtils.ENTITIES.register("falling_coconut",
            () -> EntityType.Builder.of((EntityType<FallingCoconutEntity> entityType, Level level) -> new FallingCoconutEntity(entityType, level), MobCategory.MISC)
                    .sized(0.98F, 0.98F).build(new ResourceLocation(Wildscapes.MOD_ID, "falling_coconut").toString()));

     public static final RegistrySupplier<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = RegistryUtils.FOLIAGE_PLACER_TYPES.register("palm_foliage_placer",
            () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));
    public static final RegistrySupplier<TrunkPlacerType<SlantedTrunkPlacer>> SLANTED_TRUNK_PLACER = RegistryUtils.TRUNK_PLACER_TYPES.register("slanted_trunk_placer",
            () -> new TrunkPlacerType<>(SlantedTrunkPlacer.CODEC));

    public static void setup() {
        RegistryUtils.register("coconut", _Blocks.COCONUT, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("coconut_slice", _Items.COCONUT_SLICE);

        RegistryUtils.register("palm_leaves", _Blocks.PALM_LEAVES, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_sapling", _Blocks.PALM_SAPLING, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("potted_palm_sapling", _Blocks.POTTED_PALM_SAPLING);

        RegistryUtils.register("palm_wood", _Blocks.PALM_WOOD, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_log", _Blocks.PALM_LOG, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("stripped_palm_wood", _Blocks.STRIPPED_PALM_WOOD, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("stripped_palm_log", _Blocks.STRIPPED_PALM_LOG, Wildscapes.CREATIVE_MODE_TAB);

        RegistryUtils.register("palm_planks", _Blocks.PALM_PLANKS, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_stairs", _Blocks.PALM_STAIRS, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_slab", _Blocks.PALM_SLAB, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_fence", _Blocks.PALM_FENCE, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_fence_gate", _Blocks.PALM_FENCE_GATE, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_door", _Blocks.PALM_DOOR, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_trapdoor", _Blocks.PALM_TRAPDOOR, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_pressure_plate", _Blocks.PALM_PRESSURE_PLATE, Wildscapes.CREATIVE_MODE_TAB);
        RegistryUtils.register("palm_button", _Blocks.PALM_BUTTON, Wildscapes.CREATIVE_MODE_TAB);

        FALLING_COCONUT.getId();
    }
}
