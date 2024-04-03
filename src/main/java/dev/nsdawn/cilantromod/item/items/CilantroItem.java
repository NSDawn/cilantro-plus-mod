package dev.nsdawn.cilantromod.item.items;

import dev.nsdawn.cilantromod.CilantroMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CilantroItem extends CilantroFlavoredItem {
    public CilantroItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if (entity instanceof AbstractHorseEntity honse) {
            boolean actionDidSomething = false;
            float healthHealed = 1f;
            int growthSpedUpSeconds = 30;
            int addedTemper = 3;

            if (honse.getHealth() < honse.getMaxHealth()) {
                honse.heal(healthHealed);
                actionDidSomething = true;
            }
            if (honse.isBaby()) {
                honse.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, honse.getParticleX(1.0), honse.getRandomBodyY() + 0.5, honse.getParticleZ(1.0), 0.0, 0.0, 0.0);
                if (!honse.getWorld().isClient) {
                    honse.growUp(growthSpedUpSeconds);
                    actionDidSomething = true;
                }
            }
            if (!( !actionDidSomething && honse.isTame() || honse.getTemper() >= honse.getMaxTemper() || honse.getWorld().isClient)) {
                honse.addTemper(addedTemper);
                actionDidSomething = true;
            }
            if (actionDidSomething) {
                honse.emitGameEvent(GameEvent.EAT);
                return ActionResult.SUCCESS;

            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }
}

