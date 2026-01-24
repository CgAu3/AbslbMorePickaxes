package io.github.cgau3.abslbmorepickaxes.item;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class BedrockPickaxeItem extends PickaxeItem {
    public BedrockPickaxeItem(Tier p_42961_, Properties p_42964_) {
        super(p_42961_, p_42964_);
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> components,
        @NotNull TooltipFlag flag
    ) {
        components.add(Component.translatable("tooltip.abslb_more_pickaxes.bedrock_pickaxe"));
        super.appendHoverText(stack, context, components, flag);
    }

    @SubscribeEvent
    public static void onBlockDrop(BlockDropsEvent event) {
        if (event.getTool().is(ModItems.BEDROCK_PICKAXE)) {
            if (event.getDrops().isEmpty()) {
                ItemStack stack = event.getState().getBlock().asItem().getDefaultInstance();
                ItemEntity entity = new ItemEntity(
                    event.getLevel(),
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    stack
                );
                event.getLevel().addFreshEntity(entity);
                event.setDroppedExperience(0);
            }
        }

    }
}
