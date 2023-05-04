package net.wildscapes;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.wildscapes.content.Beach;

public class Wildscapes {
    public static final String MOD_ID = "wildscapes";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(MOD_ID, Registries.ENTITY_TYPE);

    public static final CreativeTabRegistry.TabSupplier CREATIVE_MODE_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "wildscapes"),
            () -> new ItemStack(Beach._Items.COCONUT_SLICE.get()));

    public static void init() {
        Beach.setup();
        BLOCKS.register();
        ITEMS.register();
        ENTITIES.register();
    }
}
