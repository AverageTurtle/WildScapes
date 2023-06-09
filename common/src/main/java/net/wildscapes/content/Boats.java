package net.wildscapes.content;

import net.minecraft.resources.ResourceLocation;
import net.wildscapes.Wildscapes;
import party.lemons.taniwha.block.WoodBlockFactory;
import party.lemons.taniwha.entity.boat.BoatType;
import party.lemons.taniwha.entity.boat.BoatTypes;

public class Boats {
    public static final BoatType PALM_BOAT = new BoatType(new ResourceLocation(Wildscapes.MOD_ID, "palm"),
            BoatTypes.REGULAR_SHAPE,
            ()->Beach.PALM_WOOD_INFO.getItem(WoodBlockFactory.Type.BOAT).get(),
            ()->Beach.PALM_WOOD_INFO.getItem(WoodBlockFactory.Type.CHEST_BOAT).get());
}
