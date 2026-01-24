package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(
        PackOutput output,
        CompletableFuture<HolderLookup.Provider> lookupProvider,
        @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModBlockTags.ICY_BLOCKS)
            .add(Blocks.SNOW)
            .add(Blocks.SNOW_BLOCK)
            .addTags(BlockTags.ICE);
        tag(ModBlockTags.CROWBAR_MINABLE)
            .addTags(BlockTags.BEACON_BASE_BLOCKS)
            .add(Blocks.BEACON)
            .addTags(BlockTags.DOORS)
            .addTags(BlockTags.TRAPDOORS)
            .addTags(BlockTags.ANVIL)
            .addTags(BlockTags.CAULDRONS)
            .addTags(BlockTags.BUTTONS)
            .addTags(BlockTags.PRESSURE_PLATES)
            .add(Blocks.REDSTONE_BLOCK)
            .add(Blocks.REDSTONE_LAMP)
            .add(Blocks.REPEATER)
            .add(Blocks.COMPARATOR)
            .add(Blocks.DISPENSER)
            .add(Blocks.DROPPER)
            .add(Blocks.HOPPER)
            .add(Blocks.OBSERVER)
            .add(Blocks.CRAFTER)
            .add(Blocks.COMPOSTER)
            .add(Blocks.FURNACE)
            .add(Blocks.SMOKER)
            .add(Blocks.BLAST_FURNACE)
            .add(Blocks.FLETCHING_TABLE)
            .add(Blocks.STONECUTTER)
            .add(Blocks.LOOM)
            .add(Blocks.LECTERN)
            .add(Blocks.BOOKSHELF)
            .add(Blocks.ENCHANTING_TABLE)
            .add(Blocks.SMITHING_TABLE)
            .add(Blocks.GRINDSTONE)
            .add(Blocks.PISTON)
            .add(Blocks.STICKY_PISTON)
            .add(Blocks.PISTON_HEAD)
            .add(Blocks.ENDER_CHEST)
            .add(Blocks.RAIL)
            .add(Blocks.ACTIVATOR_RAIL)
            .add(Blocks.DETECTOR_RAIL)
            .add(Blocks.POWERED_RAIL)
            .add(Blocks.BELL)
            .add(Blocks.NOTE_BLOCK)
            .add(Blocks.JUKEBOX)
            .add(Blocks.TARGET)
            .add(Blocks.COPPER_BULB)
            .add(Blocks.EXPOSED_COPPER_BULB)
            .add(Blocks.OXIDIZED_COPPER_BULB)
            .add(Blocks.WAXED_COPPER_BULB)
            .add(Blocks.WEATHERED_COPPER_BULB)
            .add(Blocks.WAXED_EXPOSED_COPPER_BULB)
            .add(Blocks.WAXED_OXIDIZED_COPPER_BULB)
            .add(Blocks.WAXED_WEATHERED_COPPER_BULB);
    }
}