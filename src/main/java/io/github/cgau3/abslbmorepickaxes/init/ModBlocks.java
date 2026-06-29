package io.github.cgau3.abslbmorepickaxes.init;

import io.github.cgau3.abslbmorepickaxes.item.NegativeExistenceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredBlock<Block> NEGATIVE_EXISTENCE_BLOCK = BLOCKS.registerBlock(
        "negative_existence_block",
        NegativeExistenceBlock::new,
        () -> BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_GRAY)
            .strength(2.5F)
            .sound(SoundType.AMETHYST)
            .instrument(NoteBlockInstrument.BELL)
            .lightLevel(_ -> 5)
            .emissiveRendering((_, _, _)->true)
            .isRedstoneConductor((_, _, _)->false)
    );
}
