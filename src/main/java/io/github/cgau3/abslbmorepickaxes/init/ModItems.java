package io.github.cgau3.abslbmorepickaxes.init;

import io.github.cgau3.abslbmorepickaxes.item.AnglerfishPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.BedrockPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.CrowbarPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.EncumberingPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.IcyPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.MagnetPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.MossPickaxeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredItem<MossPickaxeItem> MOSS_PICKAXE = ITEMS.registerItem(
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
    public static final DeferredItem<IcyPickaxeItem> ICY_PICKAXE = ITEMS.registerItem(
        "icy_pickaxe",
        p -> new IcyPickaxeItem(ModTiers.VARIOUS, p),
        new Item.Properties()
            .stacksTo(1)
            .attributes(
                IcyPickaxeItem.createAttributes(
                    ModTiers.VARIOUS,
                    4.0F,
                    -2.8F
                )
            )
    );
    public static final DeferredItem<EncumberingPickaxeItem> ENCUMBERING_PICKAXE = ITEMS.registerItem(
        "encumbering_pickaxe",
        p -> new EncumberingPickaxeItem(ModTiers.VARIOUS, p),
        new Item.Properties()
            .stacksTo(1)
            .attributes(
                EncumberingPickaxeItem.createAttributes(
                    ModTiers.VARIOUS,
                    1.0F,
                    -2.8F
                )
            )
    );
    public static final DeferredItem<CrowbarPickaxeItem> CROWBAR_PICKAXE = ITEMS.registerItem(
        "crowbar_pickaxe",
        p -> new CrowbarPickaxeItem(Tiers.DIAMOND, p),
        new Item.Properties()
            .stacksTo(1)
            .attributes(
                CrowbarPickaxeItem.createAttributes(
                    Tiers.DIAMOND,
                    2.0F,
                    -2.8F
                )
            )
    );
    public static final DeferredItem<MagnetPickaxeItem> MAGNET_PICKAXE = ITEMS.registerItem(
        "magnet_pickaxe",
        p -> new MagnetPickaxeItem(Tiers.DIAMOND, p),
        new Item.Properties()
            .stacksTo(1)
            .attributes(
                MagnetPickaxeItem.createAttributes(
                    Tiers.DIAMOND,
                    1.0F,
                    -2.8F
                )
            )
    );
    public static final DeferredItem<AnglerfishPickaxeItem> ANGLERFISH_PICKAXE = ITEMS.registerItem(
        "anglerfish_pickaxe",
        p -> new AnglerfishPickaxeItem(Tiers.DIAMOND, p),
        new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
            .attributes(
                ItemAttributeModifiers.builder()
                    .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_ID,
                            1.0 + Tiers.DIAMOND.getAttackDamageBonus(),
                            AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                    )
                    .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(
                            Item.BASE_ATTACK_SPEED_ID,
                            -2.8F,
                            AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                    )
                    .add(
                        Attributes.SUBMERGED_MINING_SPEED,
                        new AttributeModifier(
                            ResourceLocation.fromNamespaceAndPath(MOD_ID, "anglerfish_pickaxe"),
                            5.0,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                        ),
                        EquipmentSlotGroup.MAINHAND
                    )
                    .build()
            )
    );
    public static final DeferredItem<BedrockPickaxeItem> BEDROCK_PICKAXE = ITEMS.registerItem(
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
                    output.accept(ICY_PICKAXE.get());
                    output.accept(ENCUMBERING_PICKAXE.get());
                    output.accept(CROWBAR_PICKAXE.get());
                    output.accept(MAGNET_PICKAXE.get());
                    output.accept(ANGLERFISH_PICKAXE.get());
                    output.accept(BEDROCK_PICKAXE.get());
                })
                .build()
        );
}
