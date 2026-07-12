package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.CommonColors;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AncientBeastPickaxeItem extends Item implements ITooltipItem {
    public AncientBeastPickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public List<Component> getTooltips(@NotNull ItemStack stack, @NotNull Item.TooltipContext context) {
        List<Component> components = new ArrayList<>();
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.ancient_beast_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        return components;
    }

    @Override
    public boolean mineBlock(
        @NonNull ItemStack stack,
        @NonNull Level level,
        BlockState state,
        @NonNull BlockPos pos,
        @NonNull LivingEntity owner) {
        Tool tool = stack.get(DataComponents.TOOL);
        if (state.is(ModBlockTags.WORLD_BASE_STONE_BLOCKS) && tool != null) {
            Direction d0 = owner.getDirection();
            chain(stack, level, pos, d0, owner, tool);
            return true;
        }
        return super.mineBlock(stack, level, state, pos, owner);
    }

    private static void chain(
        @NonNull ItemStack stack,
        @NonNull Level level,
        @NonNull BlockPos pos,
        Direction originalDirection,
        @NonNull LivingEntity owner,
        @NonNull Tool tool
    ){
        Direction right = originalDirection.getClockWise();
        Direction left = originalDirection.getCounterClockWise();
        BlockPos pos1 = pos;
        RandomSource rand = level.getRandom();
        int i_d0 = 0;
        if (!(level instanceof ServerLevel sl)) return;
        while (i_d0 < 9 && !stack.nextDamageWillBreak()) {
            if (i_d0 != 0 && level.getBlockState(pos1).is(ModBlockTags.WORLD_BASE_STONE_BLOCKS)) {
                sl.destroyBlock(pos1, !((owner instanceof Player p) && p.isCreative()), owner);
                if (rand.nextFloat() < 0.667f)
                    stack.hurtAndBreak(tool.damagePerBlock(), owner, EquipmentSlot.MAINHAND);
            }
            if (i_d0 % 3 == 0) {
                BlockPos pos2 = pos1.relative(right);
                for (int j = 0; j < 4; j++) {
                    if (stack.nextDamageWillBreak()) return;
                    if (level.getBlockState(pos2).is(ModBlockTags.WORLD_BASE_STONE_BLOCKS)) {
                        sl.destroyBlock(pos2, !((owner instanceof Player p) && p.isCreative()), owner);
                        if (rand.nextFloat() < 0.667f)
                            stack.hurtAndBreak(tool.damagePerBlock(), owner, EquipmentSlot.MAINHAND);
                    }
                    pos2 = pos2.relative(right);
                }
                pos2 = pos1.relative(left);
                for (int j = 0; j < 4; j++) {
                    if (stack.nextDamageWillBreak()) return;
                    if (level.getBlockState(pos2).is(ModBlockTags.WORLD_BASE_STONE_BLOCKS)) {
                        sl.destroyBlock(pos2, !((owner instanceof Player p) && p.isCreative()), owner);
                        if (rand.nextFloat() < 0.667f)
                            stack.hurtAndBreak(tool.damagePerBlock(), owner, EquipmentSlot.MAINHAND);
                    }
                    pos2 = pos2.relative(left);
                }
            }
            pos1 = pos1.relative(originalDirection);
            i_d0 += 1;
        }
    }
}
