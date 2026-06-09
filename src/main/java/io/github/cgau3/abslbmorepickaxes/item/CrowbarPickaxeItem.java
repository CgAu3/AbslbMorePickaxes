package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CrowbarPickaxeItem extends PickaxeItem {
    public CrowbarPickaxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack toolItem, @NotNull BlockState state) {
        float defaultSpeed = super.getDestroySpeed(toolItem, state);
        if (state.is(ModBlockTags.CROWBAR_MINABLE)) {
            return defaultSpeed * 3.0F;
        }
        return defaultSpeed;
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> components,
        @NotNull TooltipFlag flag
    ) {
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.crowbar_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        super.appendHoverText(stack, context, components, flag);
    }

    @Override
    public boolean mineBlock(
        @NotNull ItemStack stack,
        @NotNull Level level,
        @NotNull BlockState state,
        @NotNull BlockPos pos,
        @NotNull LivingEntity entity) {
        Tool tool = stack.get(DataComponents.TOOL);
        if (state.is(ModBlockTags.CROWBAR_MINABLE)) {
            return (tool != null);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, @NotNull BlockState state) {
        if (state.is(ModBlockTags.CROWBAR_MINABLE))
            return true;
        return super.isCorrectToolForDrops(stack, state);
    }
}
