package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {
    @Shadow protected ServerLevel level;

    @Shadow @Final protected ServerPlayer player;

    @Shadow private GameType gameModeForPlayer;

    @Invoker("removeBlock")
    abstract boolean invokeRemoveBlock(BlockPos pos, BlockState state, boolean canHarvest);

    @Inject(
        method = "destroyBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;getBlockEntity(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"
        ),
        cancellable = true)
    public void onDestroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (player.getMainHandItem().is(ModItems.BEDROCK_PICKAXE)) {
            BlockState blockstate = level.getBlockState(pos);
            BlockEntity blockentity = level.getBlockEntity(pos);
            Block block = blockstate.getBlock();
            if (player.blockActionRestricted(level, pos, gameModeForPlayer)) return;
            BlockState removedBlockState = block.playerWillDestroy(level, pos, blockstate, player);

            if (gameModeForPlayer.isCreative()) {
                invokeRemoveBlock(pos, removedBlockState, false);
                cir.setReturnValue(true);
                cir.cancel();
            } else {
                ItemStack itemstack = player.getMainHandItem();
                ItemStack itemstack1 = itemstack.copy();
                boolean flag1 = removedBlockState.canHarvestBlock(level, pos, player);
                itemstack.mineBlock(level, removedBlockState, pos, player);
                boolean flag = invokeRemoveBlock(pos, removedBlockState, true);

                if (flag1 && flag) {
                    block.playerDestroy(level, player, pos, removedBlockState, blockentity, itemstack1);
                }

                // Neo: Fire the PlayerDestroyItemEvent if the tool was broken at any point during the break process
                if (itemstack.isEmpty() && !itemstack1.isEmpty()) {
                    net.neoforged.neoforge.event.EventHooks.onPlayerDestroyItem(player, itemstack1, InteractionHand.MAIN_HAND);
                }

                cir.setReturnValue(true);
                cir.cancel();
            }
        }

    }
}
