package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.CommonHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommonHooks.class)
public class CommonHooksMixin {
    @Redirect(
        method = "fireBlockBreak",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/player/Player;canUseGameMasterBlocks()Z"
        )
    )
    private static boolean inFireBlockBreakIsCanUseGameMasterBlocks(Player instance) {
        if (instance.getMainHandItem().is(ModItems.BEDROCK_PICKAXE)) return true;
        return instance.canUseGameMasterBlocks();
    }
}
