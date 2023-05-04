package net.wildscapes.forge;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

public class WildscapesPlatformImpl {
    public static void setRenderLayer(Block block, RenderType type) {
    }

    public static <T extends Entity> void registerEntityRenderer(EntityType<? extends T>  type, EntityRendererProvider<T> renderProvider) {
        EntityRenderers.register(type, renderProvider);
    }
}
