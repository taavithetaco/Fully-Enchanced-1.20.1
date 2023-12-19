package net.taavi.fullyenchanced.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;
import net.taavi.fullyenchanced.entity.BoomerangEntity;

public class ModEntities {

    public static final EntityType<BoomerangEntity> BOOMERANG = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FullyEnchanced.MOD_ID, "boomerang_entity"),
            FabricEntityTypeBuilder.<BoomerangEntity>create(SpawnGroup.MISC, BoomerangEntity::new)
            .dimensions(EntityDimensions.fixed(0.8f, 0.2f)).build());



    public static void  registerModEntities() {
        FullyEnchanced.LOGGER.info("Registering Mod Entities for " + FullyEnchanced.MOD_ID);
    }
}
