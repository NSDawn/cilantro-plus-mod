package dev.nsdawn.cilantromod.datagen;

import dev.nsdawn.cilantromod.block.ModBlocks;
import dev.nsdawn.cilantromod.block.blocks.CilantroCropBlock;
import dev.nsdawn.cilantromod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.impl.renderer.VanillaModelEncoder;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.CILANTRO_CROP, CilantroCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CILANTRO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_CILANTRO, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CORIANDER_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_CURRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_CURRY_INGREDIENTS, Models.GENERATED);
    }


}
