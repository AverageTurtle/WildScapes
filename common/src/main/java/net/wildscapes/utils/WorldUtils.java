package net.wildscapes.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.wildscapes.Wildscapes;

public class WorldUtils {
    public static ResourceKey<PlacedFeature> featureKet(String id){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Wildscapes.MOD_ID, id));
    }
}
