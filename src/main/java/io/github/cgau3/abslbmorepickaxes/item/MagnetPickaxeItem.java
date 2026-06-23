package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MagnetPickaxeItem extends Item implements ITooltipItem{
    public MagnetPickaxeItem(Properties p_42964_) {
        super(p_42964_);
    }

    @Override
    public List<Component> getTooltips(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context
    ) {
        List<Component> components = new ArrayList<>();
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.magnet_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        return components;
    }
}
