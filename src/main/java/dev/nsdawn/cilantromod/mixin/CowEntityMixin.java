package dev.nsdawn.cilantromod.mixin;

import dev.nsdawn.cilantromod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends AnimalEntity {
    protected CowEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "initGoals()V")
    private void initGoals(CallbackInfo ci) {
        this.goalSelector.add(3, new TemptGoal(this, 1.35D, Ingredient.ofItems(ModItems.CILANTRO), false));
    }

}
