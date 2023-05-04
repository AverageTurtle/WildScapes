package net.wildscapes.content;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.wildscapes.Wildscapes;
import net.wildscapes.block.CoconutBlock;
import net.wildscapes.block.ExtendedDecayRangeLeavesBlock;
import net.wildscapes.entity.FallingCoconutEntity;

@SuppressWarnings("unused")
public class Beach {
    //BLOCKS
    public static class _Blocks {
        public static final RegistrySupplier<Block> COCONUT = Wildscapes.BLOCKS.register("coconut",
                () -> new CoconutBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(0.2f, 3.0f).noOcclusion()));

        public static final RegistrySupplier<Block> PALM_LEAVES = Wildscapes.BLOCKS.register("palm_leaves",
                () -> new ExtendedDecayRangeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

        public static final RegistrySupplier<Block> PALM_LOG = Wildscapes.BLOCKS.register("palm_log",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
        public static final RegistrySupplier<Block> PALM_WOOD = Wildscapes.BLOCKS.register("palm_wood",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
        public static final RegistrySupplier<Block> STRIPPED_PALM_LOG = Wildscapes.BLOCKS.register("stripped_palm_log",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
        public static final RegistrySupplier<Block> STRIPPED_PALM_WOOD = Wildscapes.BLOCKS.register("stripped_palm_wood",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

        public static final RegistrySupplier<Block> PALM_PLANKS = Wildscapes.BLOCKS.register("palm_planks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
        public static final RegistrySupplier<Block> PALM_STAIRS = Wildscapes.BLOCKS.register("palm_stairs",
                () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
        public static final RegistrySupplier<Block> PALM_SLAB = Wildscapes.BLOCKS.register("palm_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
        public static final RegistrySupplier<Block> PALM_FENCE = Wildscapes.BLOCKS.register("palm_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
        public static final RegistrySupplier<Block> PALM_FENCE_GATE = Wildscapes.BLOCKS.register("palm_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
        public static final RegistrySupplier<Block> PALM_DOOR = Wildscapes.BLOCKS.register("palm_door",
                () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
        public static final RegistrySupplier<Block> PALM_TRAPDOOR = Wildscapes.BLOCKS.register("palm_trapdoor",
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
        public static final RegistrySupplier<Block> PALM_BUTTON = Wildscapes.BLOCKS.register("palm_button",
                () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
        public static final RegistrySupplier<Block> PALM_PRESSURE_PLATE = Wildscapes.BLOCKS.register("palm_pressure_plate",
                () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));


    }
    @SuppressWarnings("UnstableApiUsage")
    public static class _Items {
        public static final RegistrySupplier<Item> COCONUT= Wildscapes.ITEMS.register("coconut",
                () -> new BlockItem(_Blocks.COCONUT.get() , new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> COCONUT_SLICE = Wildscapes.ITEMS.register("coconut_slice",
                () -> new Item(new Item.Properties().food(Foods.MELON_SLICE).arch$tab(Wildscapes.CREATIVE_MODE_TAB)));

//----------------------------------------------------------//
        public static final RegistrySupplier<Item> PALM_LEAVES = Wildscapes.ITEMS.register("palm_leaves",
                () -> new BlockItem(_Blocks.PALM_LEAVES.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));

        public static final RegistrySupplier<Item> PALM_LOG = Wildscapes.ITEMS.register("palm_log",
                () -> new BlockItem(_Blocks.PALM_LOG.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_WOOD = Wildscapes.ITEMS.register("palm_wood",
                () -> new BlockItem(_Blocks.PALM_WOOD.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> STRIPPED_PALM_LOG = Wildscapes.ITEMS.register("stripped_palm_log",
                () -> new BlockItem(_Blocks.STRIPPED_PALM_LOG.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> STRIPPED_PALM_WOOD = Wildscapes.ITEMS.register("stripped_palm_wood",
                () -> new BlockItem(_Blocks.STRIPPED_PALM_WOOD.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));

        public static final RegistrySupplier<Item> PALM_PLANKS = Wildscapes.ITEMS.register("palm_planks",
                () -> new BlockItem(_Blocks.PALM_PLANKS.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_STAIRS = Wildscapes.ITEMS.register("palm_stairs",
                () -> new BlockItem(_Blocks.PALM_STAIRS.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_SLAB = Wildscapes.ITEMS.register("palm_slab",
                () -> new BlockItem(_Blocks.PALM_SLAB.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_FENCE = Wildscapes.ITEMS.register("palm_fence",
                () -> new BlockItem(_Blocks.PALM_FENCE.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_FENCE_GATE = Wildscapes.ITEMS.register("palm_fence_gate",
                () -> new BlockItem(_Blocks.PALM_FENCE_GATE.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_DOOR = Wildscapes.ITEMS.register("palm_door",
                () -> new BlockItem(_Blocks.PALM_DOOR.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_TRAPDOOR = Wildscapes.ITEMS.register("palm_trapdoor",
                () -> new BlockItem(_Blocks.PALM_TRAPDOOR.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_BUTTON = Wildscapes.ITEMS.register("palm_button",
                () -> new BlockItem(_Blocks.PALM_BUTTON.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
        public static final RegistrySupplier<Item> PALM_PRESSURE_PLATE = Wildscapes.ITEMS.register("palm_pressure_plate",
                () -> new BlockItem(_Blocks.PALM_PRESSURE_PLATE.get(),new Item.Properties().arch$tab(Wildscapes.CREATIVE_MODE_TAB)));
    }

    public static final RegistrySupplier<EntityType<FallingCoconutEntity>> FALLING_COCONUT = Wildscapes.ENTITIES.register("falling_coconut",
            () -> EntityType.Builder.of((EntityType<FallingCoconutEntity> entityType, Level level) -> new FallingCoconutEntity(entityType, level), MobCategory.MISC)
                    .sized(0.98F, 0.98F).build(new ResourceLocation(Wildscapes.MOD_ID, "falling_coconut").toString()));
    public static void setup() {
        //TODO register things in a not ugly way
        _Blocks.COCONUT.getId();
        _Blocks.PALM_LEAVES.getId();

        _Blocks.PALM_LOG.getId();
        _Blocks.PALM_WOOD.getId();
        _Blocks.STRIPPED_PALM_LOG.getId();
        _Blocks.STRIPPED_PALM_WOOD.getId();
        _Blocks.PALM_PLANKS.getId();
        _Blocks.PALM_STAIRS.getId();
        _Blocks.PALM_SLAB.getId();
        _Blocks.PALM_FENCE.getId();
        _Blocks.PALM_FENCE_GATE.getId();
        _Blocks.PALM_DOOR.getId();
        _Blocks.PALM_TRAPDOOR.getId();
        _Blocks.PALM_BUTTON.getId();
        _Blocks.PALM_PRESSURE_PLATE.getId();

        _Items.COCONUT.getId();
        _Items.COCONUT_SLICE.getId();

        _Items.PALM_WOOD.getId();
        _Items.STRIPPED_PALM_LOG.getId();
        _Items.STRIPPED_PALM_WOOD.getId();
        _Items.PALM_PLANKS.getId();
        _Items.PALM_STAIRS.getId();
        _Items.PALM_SLAB.getId();
        _Items.PALM_FENCE.getId();
        _Items.PALM_FENCE_GATE.getId();
        _Items.PALM_DOOR.getId();
        _Items.PALM_TRAPDOOR.getId();
        _Items.PALM_BUTTON.getId();
        _Items.PALM_PRESSURE_PLATE.getId();

        FALLING_COCONUT.getId();
    }
}
