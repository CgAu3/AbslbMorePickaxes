package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookupProvider,
        CompletableFuture<TagLookup<Block>> blockTags,
        @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.DURABILITY_ENCHANTABLE)
            .add(ModItems.MOSS_PICKAXE.get())
            .add(ModItems.ICY_PICKAXE.get())
            .add(ModItems.ENCUMBERING_PICKAXE.get())
            .add(ModItems.CROWBAR_PICKAXE.get())
            .add(ModItems.MAGNET_PICKAXE.get())
            .add(ModItems.ANGLERFISH_PICKAXE.get())
            .add(ModItems.BEDROCK_PICKAXE.get());
        tag(ItemTags.MINING_ENCHANTABLE)
            .add(ModItems.MOSS_PICKAXE.get())
            .add(ModItems.ICY_PICKAXE.get())
            .add(ModItems.ENCUMBERING_PICKAXE.get())
            .add(ModItems.CROWBAR_PICKAXE.get())
            .add(ModItems.MAGNET_PICKAXE.get())
            .add(ModItems.ANGLERFISH_PICKAXE.get())
            .add(ModItems.BEDROCK_PICKAXE.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
            .add(ModItems.MOSS_PICKAXE.get())
            .add(ModItems.ICY_PICKAXE.get())
            .add(ModItems.ENCUMBERING_PICKAXE.get())
            .add(ModItems.CROWBAR_PICKAXE.get())
            .add(ModItems.MAGNET_PICKAXE.get())
            .add(ModItems.ANGLERFISH_PICKAXE.get())
            .add(ModItems.BEDROCK_PICKAXE.get());
        tag(ItemTags.PICKAXES)
            .add(ModItems.MOSS_PICKAXE.get())
            .add(ModItems.ICY_PICKAXE.get())
            .add(ModItems.ENCUMBERING_PICKAXE.get())
            .add(ModItems.CROWBAR_PICKAXE.get())
            .add(ModItems.MAGNET_PICKAXE.get())
            .add(ModItems.ANGLERFISH_PICKAXE.get())
            .add(ModItems.BEDROCK_PICKAXE.get());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
            .add(ModItems.MOSS_PICKAXE.get())
            .add(ModItems.ICY_PICKAXE.get())
            .add(ModItems.ENCUMBERING_PICKAXE.get())
            .add(ModItems.CROWBAR_PICKAXE.get())
            .add(ModItems.MAGNET_PICKAXE.get())
            .add(ModItems.ANGLERFISH_PICKAXE.get())
            .add(ModItems.BEDROCK_PICKAXE.get());
        tag(ItemTags.FISHING_ENCHANTABLE)
            .add(ModItems.ANGLERFISH_PICKAXE.get());
        tag(ItemTags.FISHES)
            .add(ModItems.ANGLERFISH_PICKAXE.get());
    }
}
