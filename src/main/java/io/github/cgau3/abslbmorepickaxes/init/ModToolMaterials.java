package io.github.cgau3.abslbmorepickaxes.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial VARIOUS =
        new ToolMaterial(
        BlockTags.INCORRECT_FOR_IRON_TOOL,
            199,
            6.0F,
            2.0F,
            18,
            ModItemTags.VARIOUS_TOOL_MATERIALS
        );
    public static final ToolMaterial POWERFUL =
        new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1999,
            8.0F,
            3.0F,
            15,
            ModItemTags.POWERFUL_TOOL_MATERIALS
        );
    public static final ToolMaterial SUPREME =
        new ToolMaterial(
            ModBlockTags.INCORRECT_FOR_SUPREME_TOOL,
            5999,
            22.0f,
            9.0f,
            35,
            ModItemTags.SUPREME_TOOL_MATERIALS
        );

}

