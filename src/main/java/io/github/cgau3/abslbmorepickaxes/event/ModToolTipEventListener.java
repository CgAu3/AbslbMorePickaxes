package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.item.ITooltipItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddAttributeTooltipsEvent;

import java.util.List;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class ModToolTipEventListener {
    @SubscribeEvent
    public static void registerTooltips(AddAttributeTooltipsEvent event) {
        ItemStack itemStack = event.getStack();
        Item item = itemStack.getItem();
        if (item instanceof ITooltipItem tooltipItem) {
            List<Component> tooltips =
                tooltipItem.getTooltips(
                    itemStack,
                    event.getContext()
                );
            if (tooltips != null) {
                tooltips.forEach(event::addTooltipLines);
            }
        }

    }
}
