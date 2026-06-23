package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.config.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.CommonColors;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AnglerfishPickaxeItem extends Item implements ITooltipItem{
    public AnglerfishPickaxeItem(Properties p_42964_) {
        super(p_42964_);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack toolItem, @NotNull BlockState state) {
        float defaultSpeed = super.getDestroySpeed(toolItem, state);
        if (state.is(Blocks.SAND) || state.is(Blocks.CLAY)) {
            return defaultSpeed * 6.0F;
        }
        return defaultSpeed;
    }

    @Override
    public List<Component> getTooltips(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context
    ) {
        List<Component> components = new ArrayList<>();
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.anglerfish_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        if (Config.allowAnglerfishPickaxeTransmutation) {
            components.add(
                Component.translatable(
                    "tooltip.abslb_more_pickaxes.anglerfish_pickaxe_transmutation"
                ).withColor(TextColor.fromRgb(0x507090).getValue())
            );
        }
        return components;
    }
}
