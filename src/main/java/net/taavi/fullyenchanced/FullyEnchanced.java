package net.taavi.fullyenchanced;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.taavi.fullyenchanced.init.*;
import net.taavi.fullyenchanced.event.CloudWalkerEventHandler;
import net.taavi.fullyenchanced.event.RuptureEventHandler;
import net.taavi.fullyenchanced.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullyEnchanced implements ModInitializer {
	public static final String MOD_ID = "fullyenchanced";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ClothConfig CONFIG;



	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		CloudWalkerEventHandler.registerEvents();
		RuptureEventHandler.registerEvents();

		ModEnchantments.registerModEnchantments();

		ModParticles.registerParticles();
		ModSounds.registerSounds();





		AutoConfig.register(ClothConfig.class, JanksonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(ClothConfig.class).getConfig();

		Util.setStackSize(Items.POTION,FullyEnchanced.CONFIG.potion_stack_size);
		Util.setStackSize(Items.SPLASH_POTION,FullyEnchanced.CONFIG.splash_potion_stack_size);
		Util.setStackSize(Items.LINGERING_POTION,FullyEnchanced.CONFIG.lingering_potion_stack_size);

	}
}
