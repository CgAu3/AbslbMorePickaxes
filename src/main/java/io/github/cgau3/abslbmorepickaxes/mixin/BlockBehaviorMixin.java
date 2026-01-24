package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviorMixin {
    @Inject(method = "getDestroyProgress", at = @At("HEAD"), cancellable = true)
    public void onGetDestroyProgress(
        BlockState state,
        Player player,
        BlockGetter blockGetter,
        BlockPos pos,
        CallbackInfoReturnable<Float> cir) {
        ItemStack toolItem = player.getMainHandItem();
        if (toolItem.is(ModItems.BEDROCK_PICKAXE)) {
            int i = net.neoforged.neoforge.event.EventHooks.doPlayerHarvestCheck(player, state, blockGetter, pos) ? 30 : 100;
            cir.setReturnValue(player.getDigSpeed(state, pos) / i);
            cir.cancel();
        }
    }
}
