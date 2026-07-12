package io.github.cgau3.abslbmorepickaxes.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModBlockTags {
    public static final String C = "c";
    @SuppressWarnings("SameParameterValue")
    private static TagKey<Block> instanceTag( String namespace, String id) {
        return TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath(namespace, id)
        );
    }

    public static final TagKey<Block> INCORRECT_FOR_SUPREME_TOOL =
        instanceTag(MOD_ID, "incorrect_for_supreme_tool");

    public static final TagKey<Block> ICY_BLOCKS =
        instanceTag(MOD_ID, "icy_blocks");

    public static final TagKey<Block> CROWBAR_MINABLE =
        instanceTag(MOD_ID, "crowbar_minable");

    public static final TagKey<Block> BASIC_STONE_BLOCKS =
        instanceTag(MOD_ID, "basic_stone_blocks");

    public static final TagKey<Block> BEDROCK_PICKAXE_DROP_BLACKLIST =
        instanceTag(MOD_ID, "bedrock_pickaxe_drop_blacklist");

    public static final TagKey<Block> WORLD_BASE_STONE_BLOCKS =
        instanceTag(MOD_ID, "world_base_stone_blocks");
}
