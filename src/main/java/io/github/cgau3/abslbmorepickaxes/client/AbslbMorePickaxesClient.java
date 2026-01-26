package io.github.cgau3.abslbmorepickaxes.client;

import io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = AbslbMorePickaxes.MOD_ID, dist = Dist.CLIENT)
public class AbslbMorePickaxesClient {
    public AbslbMorePickaxesClient(ModContainer container) {
        container.registerExtensionPoint(
            IConfigScreenFactory.class,
            (mc, parent) -> new ConfigurationScreen(container, parent)
        );
    }
}
