package io.github.cgau3.abslbmorepickaxes.mixin;

import io.github.cgau3.abslbmorepickaxes.item.IcyPickaxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.IceBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IceBlock.class)
public class IceBlockMixin {
    @Redirect(
        method = "playerDestroy",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;hasTag(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/tags/TagKey;)Z"
        )
    )
    boolean inPlayerDestroyIsHasTag(ItemStack stack, TagKey<Enchantment> tag) {
        if (stack.getItem() instanceof IcyPickaxeItem) return true;
        return EnchantmentHelper.hasTag(stack, tag);
    }
}
