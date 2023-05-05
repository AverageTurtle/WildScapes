package net.wildscapes.utils;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.wildscapes.Wildscapes;

public class RegistryUtils {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Wildscapes.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Wildscapes.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.ENTITY_TYPE);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.FOLIAGE_PLACER_TYPE);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.TRUNK_PLACER_TYPE);

//TODO move to event system similar to fabric for creative tabs
    @SuppressWarnings("UnstableApiUsage")
    public static void register(String id, Block block, CreativeTabRegistry.TabSupplier tab) {
        BLOCKS.register(id, () -> block);
        ITEMS.register(id, () -> new BlockItem(block, new Item.Properties().arch$tab(tab)));
    }
    public static void register(String id, Block block) {
        BLOCKS.register(id, () -> block);
    }

    public static void register(String id, Item item) {
        ITEMS.register(id, () -> item);
    }
}
