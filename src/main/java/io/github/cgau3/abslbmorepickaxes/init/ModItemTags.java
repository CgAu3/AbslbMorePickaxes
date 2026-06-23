package io.github.cgau3.abslbmorepickaxes.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItemTags {
    public static final String C = "c";
    @SuppressWarnings("SameParameterValue")
    private static TagKey<Item> instanceTag(String namespace, String id) {
        return TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(namespace, id)
        );
    }

    public static final TagKey<Item> VARIOUS_TOOL_MATERIALS =
        instanceTag(MOD_ID, "various_tool_materials");

    public static final TagKey<Item> POWERFUL_TOOL_MATERIALS =
        instanceTag(MOD_ID, "powerful_tool_materials");

    public static final TagKey<Item> SUPREME_TOOL_MATERIALS =
        instanceTag(MOD_ID, "supreme_tool_materials");

}
