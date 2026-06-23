package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
    @Shadow @Final private Minecraft minecraft;

    @Shadow private GameType localPlayerMode;

    @Inject(method = "destroyBlock", at = @At("HEAD"), cancellable = true)
    public void onDestroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (minecraft.player == null || minecraft.level == null) {
            return;
        }
        ItemStack tool = minecraft.player.getMainHandItem().copy();
        if (tool.is(ModItems.BEDROCK_PICKAXE)) {
            if (minecraft.player.blockActionRestricted(minecraft.level, pos, localPlayerMode)) return;
            Level level = minecraft.level;
            BlockState blockstate = level.getBlockState(pos);
            if (blockstate.isAir()) return;
            Block block = blockstate.getBlock();
            BlockState removedBlockState =
                block.playerWillDestroy(level, pos, blockstate, this.minecraft.player);
            FluidState fluidstate = level.getFluidState(pos);
            boolean flag = blockstate.onDestroyedByPlayer(
                level, pos, minecraft.player, tool, false, fluidstate
            );
            if (flag) {
                block.destroy(level, pos, removedBlockState);
            }
            cir.setReturnValue(flag);
            cir.cancel();
        }

    }

}
