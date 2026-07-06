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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SmelterPickaxeItem extends Item implements ITooltipItem{
    public SmelterPickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public List<Component> getTooltips(@NotNull ItemStack stack, @NotNull Item.TooltipContext context) {
        List<Component> components = new ArrayList<>();
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.smelter_pickaxe"
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
        if (state.is(Blocks.STONE) || state.is(Blocks.COBBLESTONE)) {
            return (tool != null);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }
}
