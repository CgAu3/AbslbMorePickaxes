package io.github.cgau3.abslbmorepickaxes.datagen;

import com.google.common.collect.ImmutableSet;
import io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashSet;
import java.util.Set;

public class ModItemModelProvider extends ItemModelProvider {
    private final Set<Item> skipSet = new HashSet<>();

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AbslbMorePickaxes.MOD_ID, existingFileHelper);
    }

    private static final ImmutableSet<DeferredHolder<Item, Item>> IGNORES =
        ImmutableSet.of();

    @Override
    protected void registerModels() {
        initSkip();

        for (var entry :
            ModItems.ITEMS.getEntries().stream()
                .filter(e -> !(e.get() instanceof BlockItem))
                .toList()) {
            if (!IGNORES.contains(entry)) {
                if (entry.get() instanceof PickaxeItem) {
                    handheldItem(entry.get());
                }
                else {
                    basicItem(entry.get());
                }
            }
        }

    }

    protected Boolean isSkip(Item item) {
        return !skipSet.contains(item);
    }

    protected void skip(Item item) {
        skipSet.add(item);
    }

    protected void initSkip() {

    }



}