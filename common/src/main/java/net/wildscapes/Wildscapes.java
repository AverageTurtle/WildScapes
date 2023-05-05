package net.wildscapes;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.wildscapes.content.Beach;
import net.wildscapes.utils.RegistryUtils;

public class Wildscapes {
    public static final String MOD_ID = "wildscapes";

    public static final CreativeTabRegistry.TabSupplier CREATIVE_MODE_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "wildscapes"),
            () -> new ItemStack(Beach._Items.COCONUT_SLICE));

    public static void init() {
        Beach.setup();
        RegistryUtils.BLOCKS.register();
        RegistryUtils.ITEMS.register();
        RegistryUtils.ENTITIES.register();
        RegistryUtils.TRUNK_PLACER_TYPES.register();
        RegistryUtils.FOLIAGE_PLACER_TYPES.register();
    }
}
