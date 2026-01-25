package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MagnetPickaxeItem extends PickaxeItem {
    public MagnetPickaxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> components,
        @NotNull TooltipFlag flag
    ) {
        components.add(Component.translatable("tooltip.abslb_more_pickaxes.magnet_pickaxe"));
        super.appendHoverText(stack, context, components, flag);
    }
}
