package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.config.Config;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class BuildCreativeTabEventListener {
    @SubscribeEvent
    public static void AddItemsToVanilla(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES
            && Config.mergeCreativeTabIntoVanilla) {
            event.accept(ModItems.MOSS_PICKAXE.get());
            event.accept(ModItems.ICY_PICKAXE.get());
            event.accept(ModItems.ENCUMBERING_PICKAXE.get());
            event.accept(ModItems.CRAB_CLAW_PICKAXE.get());
            event.accept(ModItems.CROWBAR_PICKAXE.get());
            event.accept(ModItems.MAGNET_PICKAXE.get());
            event.accept(ModItems.NEGATIVE_MINING_PICKAXE.get());
            event.accept(ModItems.ANGLERFISH_PICKAXE.get());
            event.accept(ModItems.BEDROCK_PICKAXE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS
            && Config.mergeCreativeTabIntoVanilla) {
            event.accept(ModItems.NEGATIVE_EXISTENCE_BLOCK_ITEM.get());
        }
    }
}
