package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModItemTags;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModItemTags.VARIOUS_TOOL_MATERIALS)
            .add(Items.IRON_INGOT)
            .add(Items.GOLD_INGOT)
            .add(Items.BLUE_ICE)
            .add(Items.BREEZE_ROD);
        tag(ModItemTags.POWERFUL_TOOL_MATERIALS)
            .add(Items.DIAMOND)
            .add(Items.WITHER_SKELETON_SKULL);
        tag(ModItemTags.SUPREME_TOOL_MATERIALS)
            .add(Items.NETHER_STAR)
            .add(Items.ENCHANTED_GOLDEN_APPLE);
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
