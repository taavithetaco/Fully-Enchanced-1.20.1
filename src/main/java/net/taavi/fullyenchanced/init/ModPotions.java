package net.taavi.fullyenchanced.init;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModPotions {

    public static final Potion MILK_BOTTLE = registerPotions("milk_bottle",
            new Potion(new StatusEffectInstance(ModEffects.MILK)));


    public static Potion registerPotions(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(FullyEnchanced.MOD_ID, name), potion);
    }
    public static void registerPotion(){
        FullyEnchanced.LOGGER.info("Registering Potions for " + FullyEnchanced.MOD_ID);
    }
}
