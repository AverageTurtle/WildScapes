package net.wildscapes.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.wildscapes.Wildscapes;
import net.wildscapes.WildscapesClient;

@Mod.EventBusSubscriber(modid = Wildscapes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WildscapesForgeClient {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        WildscapesClient.init();
    }
}
