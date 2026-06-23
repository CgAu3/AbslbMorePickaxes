package io.github.cgau3.abslbmorepickaxes.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import org.jspecify.annotations.NonNull;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void registerModels(
        @NonNull BlockModelGenerators blockModels,
        @NonNull ItemModelGenerators itemModels) {
        ModItemModelProvider.registerModels(itemModels);
    }
}
