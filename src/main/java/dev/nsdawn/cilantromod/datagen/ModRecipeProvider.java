package dev.nsdawn.cilantromod.datagen;

import dev.nsdawn.cilantromod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public static final List<ItemConvertible> SALAD_SHAPELESS_RECIPE = List.of (
            Items.BOWL, ModItems.CILANTRO, Items.CARROT, Items.BEETROOT
    );

    //VanillaRecipeProvider
    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(
                RecipeCategory.FOOD,
                ModItems.SALAD)
                    .input(ModItems.CILANTRO)
                    .input(Items.CARROT)
                    .input(Items.BEETROOT)
                    .input(Items.BOWL)
                    .criterion("has_cilantro",
        VanillaRecipeProvider.conditionsFromItem(ModItems.CILANTRO))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.FOOD,
                ModItems.GOLDEN_CILANTRO)
                .input('#', Items.GOLD_NUGGET)
                .input('X', ModItems.CILANTRO)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .criterion("has_cilantro",
        VanillaRecipeProvider.conditionsFromItem(ModItems.CILANTRO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(
                        RecipeCategory.FOOD,
                        ModItems.GOLDEN_CURRY_INGREDIENTS)
                .input(ModItems.CORIANDER_SEEDS)
                .input(Items.CARROT)
                .input(Items.POTATO)
                .input(Items.BEEF)
                .input(Items.GOLD_INGOT)
                .input(Items.BOWL)
                .criterion("has_coriander_seeds",
                        VanillaRecipeProvider.conditionsFromItem(ModItems.CORIANDER_SEEDS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(
                        RecipeCategory.FOOD,
                        ModItems.GOLDEN_CURRY)
                .input(ModItems.CORIANDER_SEEDS)
                .input(Items.CARROT)
                .input(Items.BAKED_POTATO)
                .input(Items.COOKED_BEEF)
                .input(Items.GOLD_INGOT)
                .input(Items.BOWL)
                .criterion("has_coriander_seeds",
                        VanillaRecipeProvider.conditionsFromItem(ModItems.CORIANDER_SEEDS))
                .offerTo(exporter);


        offerSmelting(
                exporter,
                List.of(ModItems.GOLDEN_CURRY_INGREDIENTS),
                RecipeCategory.FOOD,
                ModItems.GOLDEN_CURRY,
                1.4f,
                300,
                "golden_curry_ingredients"
        );
    }
}
