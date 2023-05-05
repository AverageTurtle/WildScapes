package net.wildscapes.world;

import net.minecraft.resources.ResourceLocation;
import net.wildscapes.Wildscapes;

public class PalmTreeGrower extends WildScapesTreeGrower {
    public PalmTreeGrower() {}
    @Override
    protected ResourceLocation getConfiguredFeatureLocation() {
        return new ResourceLocation(Wildscapes.MOD_ID, "palm");
    }
}
