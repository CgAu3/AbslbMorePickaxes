package io.github.cgau3.abslbmorepickaxes.config;

import io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = AbslbMorePickaxes.MOD_ID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ALLOW_ANGLERFISH_PICKAXE_TRANSMUTATION =
        BUILDER
            .translation(
                "config.abslb_more_pickaxes.allow_anglerfish_pickaxe_transmutation"
            )
            .define("allow_anglerfish_pickaxe_transmutation", true)
        ;

    private static final ModConfigSpec.BooleanValue MERGE_CREATIVE_TAB_INTO_VANILLA =
        BUILDER
            .translation(
                "config.abslb_more_pickaxes.merge_creative_tab_into_vanilla"
            )
            .define("merge_creative_tab_into_vanilla", false)
        ;

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean allowAnglerfishPickaxeTransmutation;
    public static boolean mergeCreativeTabIntoVanilla;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        allowAnglerfishPickaxeTransmutation = ALLOW_ANGLERFISH_PICKAXE_TRANSMUTATION.get();
        mergeCreativeTabIntoVanilla = MERGE_CREATIVE_TAB_INTO_VANILLA.get();
    }
}
