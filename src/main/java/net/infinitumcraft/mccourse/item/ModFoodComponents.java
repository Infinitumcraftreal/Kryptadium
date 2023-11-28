package net.infinitumcraft.mccourse.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING), 0.25f).build();

    public static final FoodComponent KRYPTONITE_APPLE = new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 2, true, true), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 3, true, true), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3000, 2, true, true), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3, true, true), 1f).build();
}
