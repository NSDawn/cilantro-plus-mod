package dev.nsdawn.cilantromod.item;

import dev.nsdawn.cilantromod.CilantroMod;
import dev.nsdawn.cilantromod.block.ModBlocks;
import dev.nsdawn.cilantromod.item.items.CilantroFlavoredItem;
import dev.nsdawn.cilantromod.item.items.CilantroFlavoredStewItem;
import dev.nsdawn.cilantromod.item.items.CilantroItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CILANTRO = registerItem("cilantro", new CilantroItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3F).build())
    ));

    public static final Item GOLDEN_CILANTRO = registerItem("golden_cilantro", new CilantroFlavoredItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(6)
                    .saturationModifier(1.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 0),1)
                    .alwaysEdible()
                    .build())
    ));


    public static final Item CORIANDER_SEEDS = registerItem("coriander_seeds", new AliasedBlockItem(ModBlocks.CILANTRO_CROP, new FabricItemSettings()));

    public static final Item SALAD = registerItem("salad", new CilantroFlavoredStewItem(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(5)
                    .saturationModifier(0.6F)
                    .build())
    ));

    public static final Item GOLDEN_CURRY = registerItem("golden_curry", new StewItem(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(18)
                    .saturationModifier(1.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 1),1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 1),1)
                    .alwaysEdible().build())
    ));

    public static final Item GOLDEN_CURRY_INGREDIENTS = registerItem("golden_curry_ingredients", new StewItem(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(14)
                    .saturationModifier(1.2F)
                    .build())
    ));

    // Items.GOLDEN_APPLE


    private static void addItemsToItemGroupFoodAndDrink(FabricItemGroupEntries entries) {
        final Item[] items = new Item[] {
                CILANTRO,
                GOLDEN_CILANTRO,
                SALAD,
                GOLDEN_CURRY_INGREDIENTS,
                GOLDEN_CURRY,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }
    private static void addItemsToItemGroupNatural(FabricItemGroupEntries entries) {
        final Item[] items = new Item[] {
                CORIANDER_SEEDS,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CilantroMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CilantroMod.LOGGER.info("Registering Mod Items for " + CilantroMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToItemGroupFoodAndDrink);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToItemGroupNatural);
    }
}
