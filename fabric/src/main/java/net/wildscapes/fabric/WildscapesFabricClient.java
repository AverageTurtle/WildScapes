package net.wildscapes.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.wildscapes.WildscapesClient;

public class WildscapesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WildscapesClient.init();
    }
}
