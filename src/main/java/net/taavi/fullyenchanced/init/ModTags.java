package net.taavi.fullyenchanced.init;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.taavi.fullyenchanced.FullyEnchanced;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SCYTHE_BREAKABLE = createBlockTag("scythe_breakable");

        public static final TagKey<Block> SCYTHE_HARVESTABLE = createBlockTag("scythe_harvestable");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(FullyEnchanced.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }
}
