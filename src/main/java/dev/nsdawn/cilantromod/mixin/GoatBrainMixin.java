package dev.nsdawn.cilantromod.mixin;

import dev.nsdawn.cilantromod.item.ModItems;
import net.minecraft.entity.passive.GoatBrain;
import net.minecraft.entity.passive.SnifferBrain;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (GoatBrain.class)
public class GoatBrainMixin {

    @Inject(at = @At("HEAD"), method = "getTemptItems()V", cancellable = true)
    private static void getTemptItems(CallbackInfoReturnable<Ingredient> cir) {
        cir.setReturnValue(
                Ingredient.ofItems(Items.WHEAT, ModItems.CILANTRO)
        );
    }


}
