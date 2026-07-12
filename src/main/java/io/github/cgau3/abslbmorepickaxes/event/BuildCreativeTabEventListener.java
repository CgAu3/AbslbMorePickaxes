package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.config.Config;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class BuildCreativeTabEventListener {
    @SubscribeEvent
    public static void AddItemsToVanilla(BuildCreativeModeTabContentsEvent event) {
        if (!Config.mergeCreativeTabIntoVanilla) return;
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MOSS_PICKAXE.get());
            event.accept(ModItems.ICY_PICKAXE.get());
            event.accept(ModItems.SMELTER_PICKAXE.get());
            event.accept(ModItems.ENCUMBERING_PICKAXE.get());
            event.accept(ModItems.CRAB_CLAW_PICKAXE.get());
            event.accept(ModItems.CROWBAR_PICKAXE.get());
            event.accept(ModItems.MAGNET_PICKAXE.get());
            event.accept(ModItems.NEGATIVE_MINING_PICKAXE.get());
            event.accept(ModItems.ANGLERFISH_PICKAXE.get());
            event.accept(ModItems.ANCIENT_BEAST_PICKAXE.get());
            event.accept(ModItems.BEDROCK_PICKAXE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            Collection<ItemStack> c = event.getTab().getDisplayItems();
            boolean s = false;
            for (ItemStack i : c) {
                if (i.is(Items.SCULK)) {
                    event.insertBefore(
                        i,
                        ModItems.NEGATIVE_EXISTENCE_BLOCK_ITEM.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                    );
                    s = true;
                    break;
                }
            }
            if (!s) event.accept(ModItems.NEGATIVE_EXISTENCE_BLOCK_ITEM.get());
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            Collection<ItemStack> c = event.getTab().getDisplayItems();
            boolean s = false;
            for (ItemStack i : c) {
                if (i.is(Items.PUMPKIN_PIE)) {
                    event.insertAfter(
                        i,
                        ModItems.ROCKY_CANDY.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                    );
                    s = true;
                    break;
                }
            }
            if (!s) event.accept(ModItems.ROCKY_CANDY.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            Collection<ItemStack> c = event.getTab().getDisplayItems();
            boolean s = false;
            for (ItemStack i : c) {
                if (i.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)) {
                    event.insertAfter(
                        i,
                        ModItems.HOLLOW_TEMPLATE.get().getDefaultInstance(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                    );
                    s = true;
                    break;
                }
            }
            if (!s) event.accept(ModItems.HOLLOW_TEMPLATE.get());
        }
    }
}
