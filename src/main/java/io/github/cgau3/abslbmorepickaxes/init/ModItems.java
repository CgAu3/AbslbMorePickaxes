package io.github.cgau3.abslbmorepickaxes.init;

import io.github.cgau3.abslbmorepickaxes.item.BedrockPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.MossPickaxeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredItem<Item> MOSS_PICKAXE = ITEMS.registerItem(
        "moss_pickaxe",
        p -> new MossPickaxeItem(ModTiers.VARIOUS, p),
        new Item.Properties()
            .stacksTo(1)
            .attributes(
                MossPickaxeItem.createAttributes(
                    ModTiers.VARIOUS,
                    1.0F,
                    -2.8F
                )
            )
    );
    public static final DeferredItem<Item> BEDROCK_PICKAXE = ITEMS.registerItem(
        "bedrock_pickaxe",
        p -> new BedrockPickaxeItem(ModTiers.SUPREME, p),
        new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.EPIC)
            .attributes(
                BedrockPickaxeItem.createAttributes(
                    ModTiers.SUPREME,
                    9.0F,
                    -2.8F
                )
            )
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
        CREATIVE_MODE_TABS.register(
            "abslb_more_pickaxes",
            () -> CreativeModeTab
                .builder()
                .title(Component.translatable("itemGroup.abslb_more_pickaxes"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> MOSS_PICKAXE.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(MOSS_PICKAXE.get());
                    output.accept(BEDROCK_PICKAXE.get());
                })
                .build()
        );
}
