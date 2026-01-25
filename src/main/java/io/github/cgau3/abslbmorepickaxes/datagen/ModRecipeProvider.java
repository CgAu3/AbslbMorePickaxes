package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookup
    ) {
        super(output, lookup);

    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MOSS_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.MOSS_BLOCK)
            .define('B', Items.IRON_PICKAXE)
            .define('C', Items.BONE)
            .unlockedBy("has_item", RecipeProvider.has(Items.MOSS_BLOCK))
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICY_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.PACKED_ICE)
            .define('B', Items.IRON_PICKAXE)
            .define('C', Items.BREEZE_ROD)
            .unlockedBy("has_item", RecipeProvider.has(Items.PACKED_ICE))
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENCUMBERING_PICKAXE)
            .pattern("QAQ")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.SADDLE)
            .define('B', Items.IRON_PICKAXE)
            .define('C', Items.ANVIL)
            .define('Q', Items.CHAIN)
            .unlockedBy("has_item", RecipeProvider.has(Items.ANVIL))
            .unlockedBy("has_item", RecipeProvider.has(Items.SADDLE))
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CROWBAR_PICKAXE)
            .pattern("D C")
            .pattern(" B ")
            .pattern("EAB")
            .define('A', Items.LEAD)
            .define('B', Items.IRON_INGOT)
            .define('C', Items.DIAMOND_PICKAXE)
            .define('D', Items.SMITHING_TABLE)
            .define('E', Items.STICK)
            .unlockedBy("has_item", RecipeProvider.has(Items.LEAD))
            .unlockedBy("has_item", RecipeProvider.has(Items.PISTON))
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MAGNET_PICKAXE)
            .pattern("BAB")
            .pattern(" C ")
            .pattern(" B ")
            .define('A', Items.LODESTONE)
            .define('B', Items.IRON_INGOT)
            .define('C', Items.DIAMOND_PICKAXE)
            .unlockedBy("has_item", RecipeProvider.has(Items.LODESTONE))
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_PICKAXE)
            .pattern("AAA")
            .pattern(" C ")
            .pattern(" B ")
            .define('A', Items.BEDROCK)
            .define('B', Items.BARRIER)
            .define('C', Items.NETHERITE_PICKAXE)
            .unlockedBy("has_item", RecipeProvider.has(Items.BARRIER))
            .save(output);
    }
}
