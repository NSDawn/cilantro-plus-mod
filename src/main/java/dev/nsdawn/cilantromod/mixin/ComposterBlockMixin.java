package dev.nsdawn.cilantromod.mixin;

import dev.nsdawn.cilantromod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.InventoryProvider;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin extends Block implements InventoryProvider {
    public ComposterBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("TAIL"), method = "registerDefaultCompostableItems()V")
    private static void registerDefaultCompostableItems(CallbackInfo ci) {
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CILANTRO, 0.65F);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CORIANDER_SEEDS, 0.3F);
    }

}
