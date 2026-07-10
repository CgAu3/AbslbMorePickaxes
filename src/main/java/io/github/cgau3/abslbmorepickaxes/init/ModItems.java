package io.github.cgau3.abslbmorepickaxes.init;

import io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes;
import io.github.cgau3.abslbmorepickaxes.item.AnglerfishPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.BedrockPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.CrowbarPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.EncumberingPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.IcyPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.MagnetPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.MossPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.NegativeMiningPickaxeItem;
import io.github.cgau3.abslbmorepickaxes.item.SmelterPickaxeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredItem<MossPickaxeItem> MOSS_PICKAXE = ITEMS.registerItem(
        "moss_pickaxe",
        p -> new MossPickaxeItem(
            ModToolMaterials.VARIOUS.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<IcyPickaxeItem> ICY_PICKAXE = ITEMS.registerItem(
        "icy_pickaxe",
        p -> new IcyPickaxeItem(
            ModToolMaterials.VARIOUS.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<SmelterPickaxeItem> SMELTER_PICKAXE = ITEMS.registerItem(
        "smelter_pickaxe",
        p -> new SmelterPickaxeItem(
            ModToolMaterials.VARIOUS.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<EncumberingPickaxeItem> ENCUMBERING_PICKAXE = ITEMS.registerItem(
        "encumbering_pickaxe",
        p -> new EncumberingPickaxeItem(
            ModToolMaterials.VARIOUS.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<Item> CRAB_CLAW_PICKAXE = ITEMS.registerItem(
        "crab_claw_pickaxe",
        p -> new Item(
            ModToolMaterials.VARIOUS.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            ).attributes(
                ItemAttributeModifiers.builder()
                    .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_ID,
                            1.0 + ModToolMaterials.POWERFUL.attackDamageBonus(),
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
                        Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(
                            Identifier.fromNamespaceAndPath(MOD_ID, "crab_claw_pickaxe"),
                            2.0,
                            AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.HAND
                    )
                    .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(
                            Identifier.fromNamespaceAndPath(MOD_ID, "crab_claw_pickaxe"),
                            2.0,
                            AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.HAND
                    )
                    .build()
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<Item> ROCKY_CANDY = ITEMS.registerItem(
        "rocky_candy",
        Item::new,
        () -> new Item.Properties()
            .food(
                new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.3f)
                    .alwaysEdible()
                    .build(),
                Consumable.builder()
                    .onConsume(
                        new ApplyStatusEffectsConsumeEffect(
                            new MobEffectInstance(MobEffects.HASTE, 200, 1),
                            1f
                        )
                    )
                    .build()
            )
    );
    public static final DeferredItem<CrowbarPickaxeItem> CROWBAR_PICKAXE = ITEMS.registerItem(
        "crowbar_pickaxe",
        p -> new CrowbarPickaxeItem(
            ModToolMaterials.POWERFUL.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                2.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<MagnetPickaxeItem> MAGNET_PICKAXE = ITEMS.registerItem(
        "magnet_pickaxe",
        p -> new MagnetPickaxeItem(
            ModToolMaterials.POWERFUL.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
    private static final int BLUE = 5592575;
    public static final DeferredItem<SmithingTemplateItem> HOLLOW_TEMPLATE = ITEMS.registerItem(
        "hollow_template",
        p -> new SmithingTemplateItem(
            Component.translatable("item.abslb_more_pickaxes.smithing_template.hollow_upgrade.applies_to").withColor(BLUE),
            Component.translatable("item.abslb_more_pickaxes.smithing_template.hollow_upgrade.ingredients").withColor(BLUE),
            Component.translatable("item.abslb_more_pickaxes.smithing_template.hollow_upgrade.base_slot_description"),
            Component.translatable("item.abslb_more_pickaxes.smithing_template.hollow_upgrade.additions_slot_description"),
            List.of(EMPTY_SLOT_PICKAXE),
            List.of(EMPTY_SLOT_INGOT),
            p
        ),
        Item.Properties::new
    );
    public static final DeferredItem<NegativeMiningPickaxeItem> NEGATIVE_MINING_PICKAXE = ITEMS.registerItem(
        "negative_mining_pickaxe",
        p -> new NegativeMiningPickaxeItem(
            ModToolMaterials.POWERFUL.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                -2.8f,
                1.0f,
                0f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
    );
    public static final DeferredItem<BlockItem> NEGATIVE_EXISTENCE_BLOCK_ITEM = ITEMS.registerItem(
        "negative_existence_block",
        p -> new BlockItem(ModBlocks.NEGATIVE_EXISTENCE_BLOCK.get(),
            new Item.Properties().useBlockDescriptionPrefix()
            .setId(
                ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(
                    AbslbMorePickaxes.MOD_ID, "negative_existence_block")
                )
            )
        )
    );
    public static final DeferredItem<AnglerfishPickaxeItem> ANGLERFISH_PICKAXE = ITEMS.registerItem(
        "anglerfish_pickaxe",
        p -> new AnglerfishPickaxeItem(
            ModToolMaterials.POWERFUL.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                1.0f,
                -2.8f,
                0f
            ).attributes(
                ItemAttributeModifiers.builder()
                    .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                            Item.BASE_ATTACK_DAMAGE_ID,
                            1.0 + ModToolMaterials.POWERFUL.attackDamageBonus(),
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
                            Identifier.fromNamespaceAndPath(MOD_ID, "anglerfish_pickaxe"),
                            5.0,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                        ),
                        EquipmentSlotGroup.MAINHAND
                    )
                    .build()
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    );
    public static final DeferredItem<BedrockPickaxeItem> BEDROCK_PICKAXE = ITEMS.registerItem(
        "bedrock_pickaxe",
        p -> new BedrockPickaxeItem(
            ModToolMaterials.SUPREME.applyToolProperties(
                p,
                BlockTags.MINEABLE_WITH_PICKAXE,
                9.0f,
                -2.8f,
                0.5f
            )
        ),
        () -> new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.EPIC)
            .fireResistant()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
        CREATIVE_MODE_TABS.register(
            "abslb_more_pickaxes",
            () -> CreativeModeTab
                .builder()
                .title(Component.translatable("itemGroup.abslb_more_pickaxes"))
                .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .icon(() -> MOSS_PICKAXE.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(MOSS_PICKAXE.get());
                    output.accept(ICY_PICKAXE.get());
                    output.accept(SMELTER_PICKAXE.get());
                    output.accept(ENCUMBERING_PICKAXE.get());
                    output.accept(CRAB_CLAW_PICKAXE.get());
                    output.accept(ROCKY_CANDY.get());
                    output.accept(CROWBAR_PICKAXE.get());
                    output.accept(MAGNET_PICKAXE.get());
                    output.accept(HOLLOW_TEMPLATE.get());
                    output.accept(NEGATIVE_MINING_PICKAXE.get());
                    output.accept(NEGATIVE_EXISTENCE_BLOCK_ITEM.get());
                    output.accept(ANGLERFISH_PICKAXE.get());
                    output.accept(BEDROCK_PICKAXE.get());
                })
                .build()
        );
}
