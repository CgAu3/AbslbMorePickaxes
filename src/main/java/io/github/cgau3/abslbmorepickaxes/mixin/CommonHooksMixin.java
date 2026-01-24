package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.server.level.ServerPlayer;
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
            target = "Lnet/minecraft/server/level/ServerPlayer;canUseGameMasterBlocks()Z"
        )
    )
    private static boolean inFireBlockBreakIsCanUseGameMasterBlocks(ServerPlayer instance) {
        if (instance.getMainHandItem().is(ModItems.BEDROCK_PICKAXE)) return true;
        return instance.canUseGameMasterBlocks();
    }
}
