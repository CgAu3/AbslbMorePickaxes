package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BedrockPickaxeItem extends Item implements ITooltipItem{
    public BedrockPickaxeItem(Properties p_42964_) {
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
                "tooltip.abslb_more_pickaxes.bedrock_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        return components;
    }

    @Override
    public boolean mineBlock(
        @NotNull ItemStack stack,
        @NotNull Level level,
        @NotNull BlockState state,
        @NotNull BlockPos pos,
        @NotNull LivingEntity entity) {
        Tool tool = stack.get(DataComponents.TOOL);
        return (tool != null);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack p_336002_, @NotNull BlockState p_41450_) {
        return true;
    }
}
