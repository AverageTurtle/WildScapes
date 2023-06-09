package net.wildscapes;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.wildscapes.content.Beach;
import net.wildscapes.utils.RegistryUtils;

public class Wildscapes {
    public static final String MOD_ID = "wildscapes";

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> CREATIVE_MODE_TAB = TABS.register(new ResourceLocation(MOD_ID, "wildscapes"), () ->
            CreativeTabRegistry.create(Component.translatable("category.wildscapes"),
                    () -> new ItemStack(Beach.COCONUT.get().asItem())));

    public static void init() {
        Beach.setup();
        RegistryUtils.BLOCKS.register();
        RegistryUtils.ITEMS.register();
        RegistryUtils.ENTITIES.register();
        RegistryUtils.TRUNK_PLACER_TYPES.register();
        RegistryUtils.FOLIAGE_PLACER_TYPES.register();
        RegistryUtils.SOUND_EVENTS.register();
        TABS.register();
    }
}
