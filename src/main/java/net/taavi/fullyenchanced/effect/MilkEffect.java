package net.taavi.fullyenchanced.effect;

import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.List;
import java.util.Random;

public class MilkEffect extends StatusEffect {
    public MilkEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        removeRandomStatusEffect(entity);
    }
    private void removeRandomStatusEffect(LivingEntity entity) {
        Iterable<StatusEffectInstance> activeEffects = entity.getStatusEffects();
        List<StatusEffectInstance> effectsList = Lists.newArrayList(activeEffects);

        if (!effectsList.isEmpty()) {
            int randomIndex = new Random().nextInt(effectsList.size());
            StatusEffectInstance randomEffect = effectsList.get(randomIndex);
            entity.removeStatusEffect(randomEffect.getEffectType());
        }
    }
}
