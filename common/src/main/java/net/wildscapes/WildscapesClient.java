package net.wildscapes;

import com.google.common.collect.Maps;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.wildscapes.content.Beach;
import party.lemons.taniwha.block.rtype.RType;

import java.util.Map;

public class WildscapesClient {
    public static void init() {
        //WildscapesPlatform.setRenderLayer(Beach.PALM_DOOR.get(), RenderType.cutout());
        //WildscapesPlatform.setRenderLayer(Beach.PALM_TRAPDOOR.get(), RenderType.cutout());
        WildscapesPlatform.setRenderLayer(Beach.PALM_LEAVES.get(), RenderType.cutoutMipped());
        WildscapesPlatform.setRenderLayer(Beach.PALM_SAPLING.get(), RenderType.cutout());
        WildscapesPlatform.setRenderLayer(Beach.POTTED_PALM_SAPLING.get(), RenderType.cutout());

        WildscapesPlatform.registerEntityRenderer(Beach.FALLING_COCONUT.get(), FallingBlockRenderer::new);
    }

    public static void registerBlockColors(BlockColors blockColors) {
        blockColors.register(
                (blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null
                        ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos)
                        : FoliageColor.getDefaultColor(),
                Beach.PALM_LEAVES.get()
        );
    }
    public static void registerItemColors(ItemColors itemColors, BlockColors blockColors) {
        itemColors.register(
                (itemStack, i) -> {
                    BlockState blockState = ((BlockItem)itemStack.getItem()).getBlock().defaultBlockState();
                    return blockColors.getColor(blockState, null, null, i);
                },
                Beach.PALM_LEAVES.get()
        );
    }
}
