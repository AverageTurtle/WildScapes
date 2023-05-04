package net.wildscapes.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import net.wildscapes.Wildscapes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.wildscapes.WildscapesClient;

@Mod(Wildscapes.MOD_ID)
public class WildscapesForge {
    public WildscapesForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Wildscapes.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Wildscapes.init();
    }
}
