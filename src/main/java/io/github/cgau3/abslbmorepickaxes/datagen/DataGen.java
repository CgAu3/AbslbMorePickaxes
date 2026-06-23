package io.github.cgau3.abslbmorepickaxes.datagen;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

        event.createProvider(ModItemTagsProvider::new);
        event.createProvider(ModBlockTagsProvider::new);

        event.createProvider(ModRecipeProvider.Runner::new);

        event.createProvider(ModModelProvider::new);

    }
}
