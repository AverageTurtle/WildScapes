package net.wildscapes.utils;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.wildscapes.Wildscapes;

import java.util.function.Supplier;

public class RegistryUtils {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Wildscapes.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Wildscapes.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.ENTITY_TYPE);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.FOLIAGE_PLACER_TYPE);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Wildscapes.MOD_ID, Registries.TRUNK_PLACER_TYPE);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Wildscapes.MOD_ID, Registries.SOUND_EVENT);

//TODO move to event system similar to fabric for creative tabs
    @SuppressWarnings("UnstableApiUsage")
    public static RegistrySupplier<Block> registerBlock(String id, Supplier<Block> block, CreativeTabRegistry.TabSupplier tab) {
        RegistrySupplier<Block> supplier = BLOCKS.register(id, block);
        ITEMS.register(id, () -> new BlockItem(supplier.get(), new Item.Properties().arch$tab(tab)));
        return supplier;
    }
    public static RegistrySupplier<Block> registerBlock(String id, Supplier<Block> block) {
        return BLOCKS.register(id, block);
    }

    public static RegistrySupplier<Item> registerItem(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
