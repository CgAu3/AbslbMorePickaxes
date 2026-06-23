package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.util.TriState;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class PlayerEventListener {
    @SubscribeEvent
    public static void onPickUpItem(ItemEntityPickupEvent.Pre event) {
        Player player = event.getPlayer();
        if (
            player.getMainHandItem().is(ModItems.ENCUMBERING_PICKAXE)
                || player.getOffhandItem().is(ModItems.ENCUMBERING_PICKAXE)
        ) {
            event.setCanPickup(TriState.FALSE);
        }
    }
}
