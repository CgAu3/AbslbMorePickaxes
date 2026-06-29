package io.github.cgau3.abslbmorepickaxes.datagen;

import io.github.cgau3.abslbmorepickaxes.init.ModBlocks;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import io.github.cgau3.abslbmorepickaxes.item.NegativeExistenceBlock;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
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

        Block negativeBlock = ModBlocks.NEGATIVE_EXISTENCE_BLOCK.get();
        Identifier negativeBlockModelLocation = ModelLocationUtils.getModelLocation(negativeBlock);
        MultiVariant negativeBlockAge0 = BlockModelGenerators.plainVariant(negativeBlockModelLocation);
        MultiVariant negativeBlockAge1 = BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(negativeBlock, "_unstable"));
        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(negativeBlock)
                .with(
                    PropertyDispatch.initial(NegativeExistenceBlock.AGE)
                        .select(0, negativeBlockAge0)
                        .select(1, negativeBlockAge1)
                )
        );

        ExtendedModelTemplate blockItemTemplate = ExtendedModelTemplateBuilder.builder()
            .parent(negativeBlockModelLocation)
            .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, transform -> transform.scale(0.4f, 0.4f, 0.4f).rotation(30f, 45f, 0))
            .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, transform -> transform.scale(0.4f, 0.4f, 0.4f).rotation(30f, 45f, 0))
            .transform(ItemDisplayContext.GROUND, transform -> transform.scale(0.25f, 0.25f, 0.25f))
            .transform(ItemDisplayContext.GUI, transform -> transform.scale(0.6f, 0.6f, 0.6f).rotation(30f, 45f, 0))
            .transform(ItemDisplayContext.FIXED, transform -> transform.scale(0.5f, 0.5f, 0.5f))
            .build();
        Identifier negativeBlockItemModel = blockItemTemplate.create(
            ModItems.NEGATIVE_EXISTENCE_BLOCK_ITEM.get(),
            new TextureMapping(),
            itemModels.modelOutput
        );
        blockModels.registerSimpleItemModel(negativeBlock, negativeBlockItemModel);

        ModItemModelProvider.registerModels(itemModels);
    }
}
