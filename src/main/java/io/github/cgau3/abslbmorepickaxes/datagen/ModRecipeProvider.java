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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.BEDROCK)
            .define('B', Items.BARRIER)
            .define('C', Items.NETHERITE_PICKAXE)
            .unlockedBy("has_item", RecipeProvider.has(Items.BARRIER))
            .save(output);
    }
}
