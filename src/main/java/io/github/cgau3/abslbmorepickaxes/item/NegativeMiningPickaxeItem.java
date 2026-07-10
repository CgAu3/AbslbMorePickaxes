package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.CommonColors;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NegativeMiningPickaxeItem extends Item implements ITooltipItem{
    public NegativeMiningPickaxeItem(Properties properties) {
        super(properties);
    }

    public static int roundToMultiple(double value, int divisor) {
        return Math.toIntExact(Math.round(value / divisor) * divisor);
    }

    private static int getEndStoneMiningTicks(Player player) {
        float speed =  8f + (float)player.getAttributeValue(Attributes.MINING_EFFICIENCY);
        if (MobEffectUtil.hasDigSpeed(player)) {
            speed *= 1.0F + (float) (MobEffectUtil.getDigSpeedAmplification(player) + 1) * 0.2F;
        }
        MobEffectInstance fatigue = player.getEffect(MobEffects.MINING_FATIGUE);
        if (fatigue != null) {
            float var10000;
            switch (fatigue.getAmplifier()) {
                case 0 -> var10000 = 0.3F;
                case 1 -> var10000 = 0.09F;
                case 2 -> var10000 = 0.0027F;
                default -> var10000 = 8.1E-4F;
            }
            speed *= var10000;
        }
        speed *= (float) player.getAttributeValue(Attributes.BLOCK_BREAK_SPEED);
        if (player.isEyeInFluid(FluidTags.WATER)) {
            speed *= (float) player.getAttributeValue(Attributes.SUBMERGED_MINING_SPEED);
        }
        float timeTicks = (2.08f * 30) / speed * 2f;
        return Math.min((int) Math.ceil(timeTicks), 2400);
    }

    @Override
    public @NonNull InteractionResult use(
        @NonNull Level level,
        @NonNull Player player,
        @NonNull InteractionHand hand) {
        Vec3 angle = player.getLookAngle();
        float pitch = angle.rotation().x;
        float yaw = angle.rotation().y;
        pitch = Math.clamp(pitch, -45f, 45f);
        pitch = roundToMultiple(pitch, 45);
        yaw = roundToMultiple(yaw, 15);
        Vec3 a1 = Vec3.directionFromRotation(pitch, yaw).normalize();
        AttributeInstance a = player.getAttribute(Attributes.BLOCK_INTERACTION_RANGE);
        double len = a == null ? 4.5 : a.getValue();
        Vec3 p = player.position().subtract(0,1,0);
        BlockPos.MutableBlockPos pos;
        for (double i = 0; i < len; i += 0.1) {
            pos = BlockPos.containing(p).mutable();
            if (level.getBlockState(pos).isAir()) {
                if (!level.isClientSide()) {
                    ItemStack itemstack = player.getItemInHand(hand);
                    Tool tool = itemstack.get(DataComponents.TOOL);
                    if (tool != null && !player.isCreative()) {
                        itemstack.hurtAndBreak(tool.damagePerBlock(), player, hand);
                    }
                    int t = getEndStoneMiningTicks(player);
                    player.getCooldowns().addCooldown(itemstack, t);
                    level.setBlockAndUpdate(
                        pos,
                        ModBlocks.NEGATIVE_EXISTENCE_BLOCK.get().defaultBlockState()
                    );
                    //level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
                }
                player.swing(hand);
                level.playSound(player, pos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.CONSUME;
            }
            p = p.add(a1.scale(0.1));
        }

        return InteractionResult.PASS;
    }

    @Override
    public List<Component> getTooltips(@NotNull ItemStack stack, @NotNull Item.TooltipContext context) {
        List<Component> components = new ArrayList<>();
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.negative_mining_pickaxe"
            ).withColor(CommonColors.GRAY)
        );
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.negative_mining_pickaxe_rightclick"
            ).withColor(TextColor.fromRgb(0x6b508f).getValue())
        );
        components.add(
            Component.translatable(
                "tooltip.abslb_more_pickaxes.negative_mining_pickaxe_rightclick2"
            ).withColor(CommonColors.GRAY)
        );
        return components;
    }
}
