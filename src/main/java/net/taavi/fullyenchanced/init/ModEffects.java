package net.taavi.fullyenchanced.init;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;
import net.taavi.fullyenchanced.effect.MilkEffect;

public class ModEffects {

    public static final StatusEffect MILK = registerStatusEffect("milk",
            new MilkEffect(StatusEffectCategory.NEUTRAL, 0xffffff));

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FullyEnchanced.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        FullyEnchanced.LOGGER.info("Registering Mod Effects for " + FullyEnchanced.MOD_ID);
    }
}
