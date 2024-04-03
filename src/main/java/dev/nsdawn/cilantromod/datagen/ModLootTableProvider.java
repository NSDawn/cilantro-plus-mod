package dev.nsdawn.cilantromod.datagen;

import dev.nsdawn.cilantromod.block.ModBlocks;
import dev.nsdawn.cilantromod.block.blocks.CilantroCropBlock;
import dev.nsdawn.cilantromod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;


public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        //VanillaBlockLootTableGenerator
        BlockStatePropertyLootCondition.Builder cilantroBuilderState6 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 6));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState5 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 5));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState4 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 4));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState3 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 3));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState2 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState1 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 1));
        BlockStatePropertyLootCondition.Builder cilantroBuilderState0 = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP).properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, 0));

        addDrop(ModBlocks.CILANTRO_CROP, LootTable.builder()
                .pool(LootPool.builder().conditionally(cilantroBuilderState6).with(ItemEntry.builder(Items.STICK)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState5).with((ItemEntry.builder(Items.STICK).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 1)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState6).with(ItemEntry.builder(ModItems.CORIANDER_SEEDS)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState6).with((ItemEntry.builder(ModItems.CORIANDER_SEEDS).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState5).with(ItemEntry.builder(Items.STICK)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState5).with((ItemEntry.builder(ModItems.CILANTRO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 1)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState4).with((ItemEntry.builder(ModItems.CILANTRO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 4)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState4).with(ItemEntry.builder(ModItems.CILANTRO)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState3).with((ItemEntry.builder(ModItems.CILANTRO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState3).with(ItemEntry.builder(ModItems.CILANTRO)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState2).with((ItemEntry.builder(ModItems.CILANTRO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 1)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState2).with(ItemEntry.builder(ModItems.CILANTRO)))
                .pool(LootPool.builder().conditionally(cilantroBuilderState1).with((ItemEntry.builder(ModItems.CILANTRO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 1)))))
                .pool(LootPool.builder().conditionally(cilantroBuilderState0).with(ItemEntry.builder(ModItems.CORIANDER_SEEDS)))
        );

    }
}
