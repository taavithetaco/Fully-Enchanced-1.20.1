package net.taavi.fullyenchanced.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModParticles {
    public static final DefaultParticleType WITHER_PEDAL_PARTICLE =
            registerParticle("wither_pedal_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(FullyEnchanced.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        FullyEnchanced.LOGGER.info("Registering Particles for "+ FullyEnchanced.MOD_ID);

    }
}
