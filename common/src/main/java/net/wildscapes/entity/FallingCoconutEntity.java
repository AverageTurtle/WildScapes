package net.wildscapes.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.wildscapes.content.Beach;
import net.wildscapes.mixin_interfaces.FallingBlockMixinInterface;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public class FallingCoconutEntity extends FallingBlockEntity {
    public FallingCoconutEntity(EntityType<? extends FallingCoconutEntity> entityType, Level level) {
        super(entityType, level);
    }

    public FallingCoconutEntity(Level level, double x, double y, double z, BlockState block) {
        this(Beach.FALLING_COCONUT.get(), level);
        ((FallingBlockMixinInterface)this).setBlock(block);
        this.blocksBuilding = true;
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.setStartPos(this.blockPosition());
    }
    @Override
    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        int fall = Mth.ceil(fallDistance - 1.0F);
        if(fall < 0)
            return false;

        Predicate<Entity> predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
        DamageSource damageSource2;
        if (this.getBlockState().getBlock() instanceof Fallable landingBlock) {
            damageSource2 = landingBlock.getFallDamageSource(this);
        } else {
            damageSource2 = this.damageSources().fallingBlock(this);
        }

        float damage = (float)Math.min(Mth.floor((float)fall * 1.0), 10.0);

        AtomicBoolean shouldPlaySound = new AtomicBoolean(false);
        this.level().getEntities(this, this.getBoundingBox(), predicate).forEach((entity) -> {
            if(entity.hurt(damageSource2, damage) && entity instanceof LivingEntity)
                shouldPlaySound.set(true);
        });
        if(shouldPlaySound.get()) {
            level().playSound(this, this.blockPosition(), Beach.COCONUT_HIT_SOUND.get(), SoundSource.BLOCKS, 1f, 1f);
        }

        return false;
    }

    @SuppressWarnings("UnusedReturnValue")
    public static FallingCoconutEntity spawnFromBlock(Level world, BlockPos pos, BlockState state) {
        FallingCoconutEntity fallingCoconutEntity = new FallingCoconutEntity(
                world,
                (double)pos.getX() + 0.5,
                pos.getY(),
                (double)pos.getZ() + 0.5,
                state.hasProperty(BlockStateProperties.WATERLOGGED) ? state.setValue(BlockStateProperties.WATERLOGGED, false) : state
        );
        world.setBlock(pos, state.getFluidState().createLegacyBlock(), 3);
        world.addFreshEntity(fallingCoconutEntity);
        return fallingCoconutEntity;
    }
}
