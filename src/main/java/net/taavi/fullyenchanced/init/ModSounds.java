package net.taavi.fullyenchanced.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModSounds {

    public static final SoundEvent BOOMERANG_FLYING = registerSoundEvent("boomerang_flying");

    private static SoundEvent registerSoundEvent(String name){
        Identifier identifier = new Identifier(FullyEnchanced.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds(){
        FullyEnchanced.LOGGER.info("Registering Mod Sounds for " + FullyEnchanced.MOD_ID);
    }
}
