package io.github.cgau3.abslbmorepickaxes.event;

import io.github.cgau3.abslbmorepickaxes.init.ModBlockTags;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

import java.util.List;

import static io.github.cgau3.abslbmorepickaxes.AbslbMorePickaxes.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class BlockEventListener {
    @SubscribeEvent
    public static void onBlockDrop(BlockDropsEvent event) {
        Entity breaker = event.getBreaker();
        if (event.getTool().is(ModItems.BEDROCK_PICKAXE)) {
            if (event.getDrops().isEmpty()) {
                ItemStack stack = event.getState().getBlock().asItem().getDefaultInstance();
                ItemEntity entity = new ItemEntity(
                    event.getLevel(),
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    stack
                );
                event.getDrops().add(entity);
                //event.getLevel().addFreshEntity(entity);
                event.setDroppedExperience(0);
            }
        }
        if (event.getTool().is(ModItems.ICY_PICKAXE)) {
            if (event.getState().is(Blocks.SNOW)) {
                event.getDrops().clear();
                ItemStack stack = Items.SNOWBALL.getDefaultInstance();
                ItemEntity entity = new ItemEntity(
                    event.getLevel(),
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    stack
                );
                event.getDrops().add(entity);
                //event.getLevel().addFreshEntity(entity);
                event.setDroppedExperience(0);
            }
            else if (event.getState().is(ModBlockTags.ICY_BLOCKS)){
                event.getDrops().clear();
                ItemStack stack = event.getState().getBlock().asItem().getDefaultInstance();
                ItemEntity entity = new ItemEntity(
                    event.getLevel(),
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    stack
                );
                event.getDrops().add(entity);
                //event.getLevel().addFreshEntity(entity);
                event.setDroppedExperience(0);
            }
        }
        if (event.getTool().is(ModItems.ANGLERFISH_PICKAXE)
            && breaker != null
            && breaker.isEyeInFluidType(Fluids.WATER.getFluidType())
        ) {
            ItemStack stack = event.getTool();
            double chance = 1.0 / 32.0 *  ( 1 + stack.getEnchantmentLevel(
                event.getLevel()
                    .holderLookup(Registries.ENCHANTMENT)
                    .getOrThrow(Enchantments.LURE)
            ));
            if (event.getLevel().getRandom().nextFloat() <= chance) {
                Vec3 pos = new Vec3(
                    event.getPos().getX() + 0.5,
                    event.getPos().getY() + 4.5,
                    event.getPos().getZ() + 0.5
                );
                LootParams lootparams;
                if (breaker instanceof Player player) {
                    lootparams = (new LootParams.Builder(event.getLevel()))
                        .withParameter(LootContextParams.ORIGIN, pos)
                        .withParameter(LootContextParams.TOOL, stack)
                        .withParameter(LootContextParams.THIS_ENTITY, breaker)
                        .withParameter(LootContextParams.ATTACKING_ENTITY, breaker)
                        .withLuck(player.getLuck())
                        .create(LootContextParamSets.FISHING);
                } else {
                    lootparams = (new LootParams.Builder(event.getLevel()))
                        .withParameter(LootContextParams.ORIGIN, pos)
                        .withParameter(LootContextParams.TOOL, stack)
                        .withParameter(LootContextParams.THIS_ENTITY, breaker)
                        .withParameter(LootContextParams.ATTACKING_ENTITY, breaker)
                        .create(LootContextParamSets.FISHING);
                }
                LootTable loottable = event
                    .getLevel()
                    .getServer()
                    .reloadableRegistries()
                    .getLootTable(BuiltInLootTables.FISHING);
                List<ItemStack> list = loottable.getRandomItems(lootparams);
                for (ItemStack itemstack : list) {
                    ItemEntity entity = new ItemEntity(
                        event.getLevel(),
                        event.getPos().getX() + 0.5,
                        event.getPos().getY()+ 0.5,
                        event.getPos().getZ()+ 0.5,
                        itemstack
                    );
                    event.getDrops().add(entity);
                    if (itemstack.is(ItemTags.FISHES) && breaker instanceof Player player) {
                        player.awardStat(Stats.FISH_CAUGHT, 1);
                    }
                }
            }
        }
        boolean isMagnetFlag = false;
        if (breaker instanceof LivingEntity le) {
            isMagnetFlag =
                le.getOffhandItem().is(ModItems.MAGNET_PICKAXE)
                    || le.getMainHandItem().is(ModItems.MAGNET_PICKAXE);
        }
        if (event.getTool().is(ModItems.MAGNET_PICKAXE) || isMagnetFlag) {

            if (breaker == null) return;
            for (ItemEntity entity : event.getDrops()) {
                entity.setPos(breaker.position());
                entity.setDeltaMovement(Vec3.ZERO);
            }
        }
    }
}
