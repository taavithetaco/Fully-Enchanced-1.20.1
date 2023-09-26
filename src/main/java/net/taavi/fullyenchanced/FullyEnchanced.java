package net.taavi.fullyenchanced;

import net.fabricmc.api.ModInitializer;

import net.taavi.fullyenchanced.block.ModBlocks;
import net.taavi.fullyenchanced.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullyEnchanced implements ModInitializer {
	public static final String MOD_ID = "fullyenchanced";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}