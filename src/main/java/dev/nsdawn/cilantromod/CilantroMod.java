package dev.nsdawn.cilantromod;

import dev.nsdawn.cilantromod.block.ModBlocks;
import dev.nsdawn.cilantromod.datagen.ModModelProvider;
import dev.nsdawn.cilantromod.item.ModItems;
import dev.nsdawn.cilantromod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CilantroMod implements ModInitializer {
	public static final String MOD_ID = "cilantro-mod";
	// java's just dumb i don't know what to tell you
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		LOGGER.info("Hello Fabric world!");
	}
}