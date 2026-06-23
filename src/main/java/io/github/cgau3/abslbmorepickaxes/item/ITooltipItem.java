package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ITooltipItem {
    List<Component> getTooltips(
        @NotNull ItemStack stack,
        @NotNull Item.TooltipContext context
    );
}
