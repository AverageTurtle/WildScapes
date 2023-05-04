package net.wildscapes.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.wildscapes.WildscapesClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemColors.class)
public class ItemColorsMixin {
    @Inject(method = "createDefault", at = @At("RETURN"))
    private static void wildscapes$createDefault(BlockColors blockColors, CallbackInfoReturnable<ItemColors> cir) {
        WildscapesClient.registerItemColors(cir.getReturnValue(), blockColors);
    }
}
