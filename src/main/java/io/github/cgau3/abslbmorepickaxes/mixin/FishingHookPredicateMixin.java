package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.advancements.critereon.FishingHookPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingHookPredicate.class)
public class FishingHookPredicateMixin {
    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    public void onMatches(
        Entity entity,
        ServerLevel level,
        Vec3 pos,
        CallbackInfoReturnable<Boolean> cir
    ){
        if (
            entity instanceof LivingEntity livingEntity
                && livingEntity.getMainHandItem().is(ModItems.ANGLERFISH_PICKAXE)
        ) {
            cir.setReturnValue(
                abslbMorePickaxes$calculateOpenWater(
                    entity,
                    BlockPos.containing(pos)
                )
            );
            cir.cancel();
        }
    }

    @Unique
    private static boolean abslbMorePickaxes$calculateOpenWater(Entity entity, BlockPos pos) {
        int last = -1;

        for (int i = -1; i <= 2; i++) {
            int current = abslbMorePickaxes$getAreaTypeInt(
                entity,
                pos.offset(-2, i, -2),
                pos.offset( 2, i,  2)
            );

            if (current == -1) return false;

            if (current == 0 && last == -1) return false;
            if (current == 1 && last == 0) return false;

            last = current;
        }
        return true;
    }

    @Unique
    private static int abslbMorePickaxes$getAreaTypeInt(Entity entity, BlockPos from, BlockPos to) {
        Integer type = null;

        for (BlockPos p : BlockPos.betweenClosed(from, to)) {
            int t = abslbMorePickaxes$getBlockTypeInt(entity, p);
            if (type == null) type = t;
            else if (type != t) return -1;
        }

        return type == null ? -1 : type;
    }

    @Unique
    private static int abslbMorePickaxes$getBlockTypeInt(Entity entity, BlockPos pos) {
        BlockState state = entity.level().getBlockState(pos);

        if (!state.isAir() && !state.is(Blocks.LILY_PAD)) {
            FluidState fluid = state.getFluidState();
            if (fluid.is(FluidTags.WATER)
                && fluid.isSource()
                && state.getCollisionShape(entity.level(), pos).isEmpty()) {
                return 1; // 如果是含水无碰撞箱或者水源，INSIDE_WATER
            }
            return -1;
        }

        return 0; // 如果是空气或莲叶，则ABOVE_WATER
    }

}
