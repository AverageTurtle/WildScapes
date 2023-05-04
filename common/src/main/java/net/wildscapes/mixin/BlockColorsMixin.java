package net.wildscapes.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.wildscapes.WildscapesClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockColors.class)
public class BlockColorsMixin {
    @Inject(method = "createDefault", at = @At("RETURN"))
    private static void wildscapes$createDefault(CallbackInfoReturnable<BlockColors> cir) {
        WildscapesClient.registerBlockColors(cir.getReturnValue());
    }
}
