package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(
        HolderLookup.Provider registries,
        RecipeOutput output
    ) {
        super(registries, output);
    }

    protected static @NonNull Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(
        ItemPredicate... predicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(
            new InventoryChangeTrigger.TriggerInstance(
                Optional.empty(),
                InventoryChangeTrigger.TriggerInstance.Slots.ANY,
                List.of(predicates)
            )
        );
    }

    protected static @NonNull Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(
        ItemPredicate.Builder... predicates) {
        return inventoryTrigger(
            Arrays.stream(predicates)
                .map(ItemPredicate.Builder::build)
                .toArray(ItemPredicate[]::new)
        );
    }

    protected @NonNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NonNull ItemLike item) {
        return inventoryTrigger(
            ItemPredicate.Builder.item().of(this.items, item)
        );
    }

    protected @NonNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NonNull TagKey<Item> tag) {
        return inventoryTrigger(
            ItemPredicate.Builder.item().of(this.items, tag)
        );
    }

    @Override
    protected void buildRecipes() {
        HolderGetter<Item> items = registries.lookupOrThrow(Registries.ITEM);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.MOSS_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', ItemTags.MOSS_BLOCKS)
            .define('B', Items.IRON_PICKAXE)
            .define('C', Items.BONE)
            .unlockedBy("has_item", has(ItemTags.MOSS_BLOCKS))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.ICY_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.PACKED_ICE)
            .define('B', Items.IRON_PICKAXE)
            .define('C', Items.BREEZE_ROD)
            .unlockedBy("has_item", has(Items.PACKED_ICE))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.ENCUMBERING_PICKAXE)
            .pattern(" B ")
            .pattern("QAQ")
            .pattern("  C")
            .define('B', Items.SADDLE)
            .define('A', Items.IRON_PICKAXE)
            .define('C', Items.ANVIL)
            .define('Q', ItemTags.CHAINS)
            .unlockedBy("has_item", has(Items.ANVIL))
            .unlockedBy("has_item", has(Items.SADDLE))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.CRAB_CLAW_PICKAXE)
            .pattern(" A ")
            .pattern("ROF")
            .pattern("RSF")
            .define('F', Items.COD)
            .define('A', Items.IRON_PICKAXE)
            .define('R', Items.REDSTONE)
            .define('O', Items.ORANGE_DYE)
            .define('S', Items.STICK)
            .unlockedBy("has_item", has(Items.COD))
            .unlockedBy("has_item", has(Items.REDSTONE))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.CROWBAR_PICKAXE)
            .pattern("D C")
            .pattern(" B ")
            .pattern("EAB")
            .define('A', Items.LEAD)
            .define('B', Items.IRON_INGOT)
            .define('C', Items.DIAMOND_PICKAXE)
            .define('D', Items.SMITHING_TABLE)
            .define('E', Items.STICK)
            .unlockedBy("has_item", has(Items.LEAD))
            .unlockedBy("has_item", has(Items.PISTON))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.MAGNET_PICKAXE)
            .pattern("BAB")
            .pattern(" C ")
            .pattern(" B ")
            .define('A', Items.LODESTONE)
            .define('B', Items.IRON_INGOT)
            .define('C', Items.DIAMOND_PICKAXE)
            .unlockedBy("has_item", has(Items.LODESTONE))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.NEGATIVE_MINING_PICKAXE)
            .pattern("DDD")
            .pattern("BCB")
            .pattern("BAB")
            .define('A', Items.END_STONE)
            .define('B', Items.ENDER_PEARL)
            .define('C', Items.DIAMOND_PICKAXE)
            .define('D', Items.OBSIDIAN)
            .unlockedBy("has_item", has(Items.END_STONE))
            .save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, ModItems.BEDROCK_PICKAXE)
            .pattern("AAA")
            .pattern(" C ")
            .pattern(" B ")
            .define('A', Items.BEDROCK)
            .define('B', Items.BARRIER)
            .define('C', Items.NETHERITE_PICKAXE)
            .unlockedBy("has_item", has(Items.BARRIER))
            .save(output);
    }

    public static class Runner extends RecipeProvider.Runner {
        // Get the parameters from the `GatherDataEvent`s.
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected @NonNull RecipeProvider createRecipeProvider(
            HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput output) {
            return new ModRecipeProvider(provider, output);
        }

        @Override
        public @NonNull String getName() {
            return "abslb_more_pickaxes_recipes_runner";
        }
    }
}
