package io.github.cgau3.abslbmorepickaxes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AnglerfishPickaxeItem extends PickaxeItem {
    public AnglerfishPickaxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
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
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> components,
        @NotNull TooltipFlag flag
    ) {
        components.add(Component.translatable("tooltip.abslb_more_pickaxes.anglerfish_pickaxe"));
        super.appendHoverText(stack, context, components, flag);
    }
}
