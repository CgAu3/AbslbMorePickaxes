package io.github.cgau3.abslbmorepickaxes.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.cgau3.abslbmorepickaxes.init.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class SmelterLootModifier extends LootModifier {

    public static final MapCodec<SmelterLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
        LootModifier.codecStart(inst).apply(inst, SmelterLootModifier::new)
    );

    public SmelterLootModifier(LootItemCondition[] conditions, int priority) {
        super(conditions, priority);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(
        @NotNull ObjectArrayList<ItemStack> objectArrayList,
        @NotNull LootContext lootContext) {
        if (!lootContext.hasParameter(LootContextParams.BLOCK_STATE)) return objectArrayList;
        if (!lootContext.hasParameter(LootContextParams.ORIGIN)) return objectArrayList;
        ServerLevel level = lootContext.getLevel();
        ItemInstance tool = lootContext.getOptionalParameter(LootContextParams.TOOL);
        if (tool == null || !tool.is(ModItems.SMELTER_PICKAXE.get())) return objectArrayList;
        ObjectArrayList<ItemStack> smeltList = new ObjectArrayList<>();
        for (ItemStack item : objectArrayList) {
            SingleRecipeInput input = new SingleRecipeInput(item);
            RecipeHolder<SmeltingRecipe> h = level.recipeAccess().getRecipeFor(RecipeType.SMELTING, input, level).orElse(null);
            if (h == null) {
                smeltList.add(item);
                continue;
            }
            ItemStack stack;
            if (item.is(Items.COBBLESTONE)) {
                stack = Items.SMOOTH_STONE.getDefaultInstance();
            }
            else {
                stack = h.value().assemble(input);
            }
            int count = item.getCount();
            int maxStack = stack.getItem().getMaxStackSize(stack);
            while (count > maxStack) {
                ItemStack stack1 = stack.copy();
                stack1.setCount(maxStack);
                smeltList.add(stack1);
                count -= maxStack;
            }
            stack.setCount(count);
            smeltList.add(stack);
        }
        return smeltList;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}

