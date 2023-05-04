package net.wildscapes.fabric;

import net.wildscapes.Wildscapes;
import net.fabricmc.api.ModInitializer;

public class WildscapesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Wildscapes.init();
    }
}
