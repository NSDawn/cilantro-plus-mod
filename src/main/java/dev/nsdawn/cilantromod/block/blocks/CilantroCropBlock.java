package dev.nsdawn.cilantromod.block.blocks;

import dev.nsdawn.cilantromod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class CilantroCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    // public static final int MIN_AGE_FOR_CORIANDER = 4;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);

    public CilantroCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CORIANDER_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);

    }
}
