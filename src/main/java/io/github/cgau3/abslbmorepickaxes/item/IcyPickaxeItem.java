package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
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

public class IcyPickaxeItem extends Item implements ITooltipItem{
    public IcyPickaxeItem(Properties p_42964_) {
        super(p_42964_);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack toolItem, @NotNull BlockState state) {
        float defaultSpeed = super.getDestroySpeed(toolItem, state);
        if (state.is(ModBlockTags.ICY_BLOCKS) || state.is(BlockTags.ICE)) {
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
                "tooltip.abslb_more_pickaxes.icy_pickaxe"
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
        if (state.is(ModBlockTags.ICY_BLOCKS) || state.is(BlockTags.ICE)) {
            return (tool != null);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, @NotNull BlockState state) {
        if (state.is(ModBlockTags.ICY_BLOCKS) || state.is(BlockTags.ICE))
            return true;
        return super.isCorrectToolForDrops(stack, state);
    }
}
