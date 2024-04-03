package dev.nsdawn.cilantromod.block;

import dev.nsdawn.cilantromod.CilantroMod;
import dev.nsdawn.cilantromod.block.blocks.CilantroCropBlock;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CilantroMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
         return Registry.register(Registries.ITEM, new Identifier(CilantroMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static final Block CILANTRO_CROP = Registry.register(Registries.BLOCK, new Identifier(CilantroMod.MOD_ID, "cilantro_crop"),
            new CilantroCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static void registerModBlocks() {
        CilantroMod.LOGGER.info("Registering ModBlocks for " + CilantroMod.MOD_ID);
    }
}
