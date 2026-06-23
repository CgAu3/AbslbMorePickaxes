package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EncumberingPickaxeItem extends Item implements ITooltipItem{
    public EncumberingPickaxeItem(Properties p_42964_) {
        super(p_42964_);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack toolItem, @NotNull BlockState state) {
        float defaultSpeed = super.getDestroySpeed(toolItem, state);
        if (state.is(ModBlockTags.BASIC_STONE_BLOCKS)) {
            return defaultSpeed * 2.0F;
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
                "tooltip.abslb_more_pickaxes.encumbering_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        return components;
    }
}
