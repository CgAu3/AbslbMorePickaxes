package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.config.Config;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.List;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class EntityEventListener {
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof GlowSquid squid) {
            if (squid.level().isClientSide()) return;
            if (!Config.allowAnglerfishPickaxeTransmutation) return;
            AABB box = squid.getBoundingBox().inflate(0.3);

            List<ItemEntity> list = squid.level().getEntitiesOfClass(
                ItemEntity.class,
                box,
                e -> e.getItem().is(Items.DIAMOND_PICKAXE)
            );

            if (!list.isEmpty()) {
                ItemEntity target = list.getFirst();
                ItemStack base = target.getItem();
                ItemStack stack = base.transmuteCopy(ModItems.ANGLERFISH_PICKAXE.get(), 1);
                stack.applyComponents(ModItems.ANGLERFISH_PICKAXE.get().getDefaultInstance().getComponentsPatch());
                ItemEntity entity = new ItemEntity(
                    squid.level(),
                    squid.getX(),
                    squid.getY(),
                    squid.getZ(),
                    stack
                );
                squid.level().addFreshEntity(entity);
                target.discard();
                squid.discard();
            }
        }
    }
}
