package io.github.cgau3.abslbmorepickaxes.datagen;

import com.google.common.collect.ImmutableSet;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;


public class ModItemModelProvider {
    private static final ImmutableSet<DeferredHolder<Item, Item>> IGNORES =
        ImmutableSet.of();
    private static final ImmutableSet<DeferredHolder<Item, Item>> FLAT_ITEMS =
        ImmutableSet.of();

    protected static void registerModels(ItemModelGenerators itemModels) {
        for (var entry :
            ModItems.ITEMS.getEntries().stream()
                .filter(e -> !(e.get() instanceof BlockItem))
                .toList()) {
            if (!IGNORES.contains(entry)) {
                if (!FLAT_ITEMS.contains(entry)) {
                    itemModels.generateFlatItem(entry.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
                }
                else {
                    itemModels.generateFlatItem(entry.get(), ModelTemplates.FLAT_ITEM);
                }
            }
        }

    }

}