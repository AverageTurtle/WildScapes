package net.wildscapes.content;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.material.MapColor;
import net.wildscapes.Wildscapes;
import net.wildscapes.block.CoconutBlock;
import net.wildscapes.block.ExtendedDecayRangeLeavesBlock;
import net.wildscapes.block.PalmSaplingBlock;
import net.wildscapes.entity.FallingCoconutEntity;
import net.wildscapes.utils.RegistryUtils;
import net.wildscapes.utils.WorldUtils;
import net.wildscapes.world.PalmTreeGrower;
import net.wildscapes.world.tree.PalmFoliagePlacer;
import net.wildscapes.world.tree.SlantedTrunkPlacer;
import party.lemons.taniwha.block.WoodBlockFactory;

@SuppressWarnings({"unused", "UnstableApiUsage"})
public class Beach {
    public static final RegistrySupplier<Block>  COCONUT = RegistryUtils.registerBlock("coconut", () -> new CoconutBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.2f, 3.0f).noOcclusion()), Wildscapes.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<Item> COCONUT_SLICE = RegistryUtils.registerItem("coconut_slice", () -> new Item(new Item.Properties().food(Foods.MELON_SLICE).arch$tab(Wildscapes.CREATIVE_MODE_TAB)));

    public static final RegistrySupplier<Block>   PALM_LEAVES = RegistryUtils.registerBlock("palm_leaves", () -> new ExtendedDecayRangeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), Wildscapes.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<Block>   PALM_SAPLING = RegistryUtils.registerBlock("palm_sapling", () -> new PalmSaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), Wildscapes.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<Block>   POTTED_PALM_SAPLING = RegistryUtils.registerBlock("potted_palm_sapling", () -> new FlowerPotBlock(PALM_SAPLING.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final WoodBlockFactory PALM_WOOD_INFO = new WoodBlockFactory(Wildscapes.MOD_ID, "palm", Wildscapes.CREATIVE_MODE_TAB).all(()->Boats.PALM_BOAT).register(RegistryUtils.BLOCKS, RegistryUtils.ITEMS);
    public static final RegistrySupplier<SoundEvent>   COCONUT_HIT_SOUND = RegistryUtils.SOUND_EVENTS.register("palm_button", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Wildscapes.MOD_ID, "coconut_hit")));

    public static final RegistrySupplier<EntityType<FallingCoconutEntity>> FALLING_COCONUT = RegistryUtils.ENTITIES.register("falling_coconut",
            () -> EntityType.Builder.of((EntityType<FallingCoconutEntity> entityType, Level level) -> new FallingCoconutEntity(entityType, level), MobCategory.MISC)
                    .sized(0.98F, 0.98F).build(new ResourceLocation(Wildscapes.MOD_ID, "falling_coconut").toString()));

     public static final RegistrySupplier<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = RegistryUtils.FOLIAGE_PLACER_TYPES.register("palm_foliage_placer",
            () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));
    public static final RegistrySupplier<TrunkPlacerType<SlantedTrunkPlacer>> SLANTED_TRUNK_PLACER = RegistryUtils.TRUNK_PLACER_TYPES.register("slanted_trunk_placer",
            () -> new TrunkPlacerType<>(SlantedTrunkPlacer.CODEC));

    public static final TagKey<Biome> HAS_PALM_TREES = TagKey.create(Registries.BIOME, new ResourceLocation(Wildscapes.MOD_ID, "has_palm_trees"));

    public static void setup() {
        ResourceLocation id = Boats.PALM_BOAT.id;
        //Force early initialization of certain problem static variables for forge
        PALM_SAPLING.getId();
        PALM_LEAVES.getId();
        FALLING_COCONUT.getId();

        BiomeModifications.addProperties(biomeContext -> biomeContext.hasTag(HAS_PALM_TREES), (biomeContext, mutable) -> {
            mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WorldUtils.featureKet("palm_trees"));
        });
        //RegistryUtils.register("coconut", _Blocks.COCONUT, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("coconut_slice", _Items.COCONUT_SLICE);

        //RegistryUtils.register("palm_leaves", _Blocks.PALM_LEAVES, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_sapling", _Blocks.PALM_SAPLING, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("potted_palm_sapling", _Blocks.POTTED_PALM_SAPLING);

        //RegistryUtils.register("palm_wood", _Blocks.PALM_WOOD, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_log", _Blocks.PALM_LOG, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("stripped_palm_wood", _Blocks.STRIPPED_PALM_WOOD, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("stripped_palm_log", _Blocks.STRIPPED_PALM_LOG, Wildscapes.CREATIVE_MODE_TAB);

        //RegistryUtils.register("palm_planks", _Blocks.PALM_PLANKS, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_stairs", _Blocks.PALM_STAIRS, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_slab", _Blocks.PALM_SLAB, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_fence", _Blocks.PALM_FENCE, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_fence_gate", _Blocks.PALM_FENCE_GATE, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_door", _Blocks.PALM_DOOR, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_trapdoor", _Blocks.PALM_TRAPDOOR, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_pressure_plate", _Blocks.PALM_PRESSURE_PLATE, Wildscapes.CREATIVE_MODE_TAB);
        //RegistryUtils.register("palm_button", _Blocks.PALM_BUTTON, Wildscapes.CREATIVE_MODE_TAB);
    }
}
