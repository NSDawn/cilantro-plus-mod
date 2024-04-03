package dev.nsdawn.cilantromod.mixin;

import dev.nsdawn.cilantromod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (ChickenEntity.class)
public abstract class ChickenEntityMixin extends AnimalEntity {
    protected ChickenEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "isBreedingItem", cancellable = true)
    private void isBreedingItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == ModItems.CORIANDER_SEEDS) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("TAIL"), method = "initGoals()V")
    private void initGoals(CallbackInfo ci) {
        this.goalSelector.add(3, new TemptGoal(this, 1.0D, Ingredient.ofItems(ModItems.CORIANDER_SEEDS), false));
    }
}
