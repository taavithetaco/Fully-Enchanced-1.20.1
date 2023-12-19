package net.taavi.fullyenchanced.entity;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModModelLayers {
    public static final EntityModelLayer BOOMERANG =
            new EntityModelLayer(new Identifier(FullyEnchanced.MOD_ID, "boomerang_entity"), "main");
}
