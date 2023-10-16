package net.taavi.fullyenchanced.util;

import net.minecraft.item.Item;
import net.taavi.fullyenchanced.mixin.ItemStackSize;

public class Util {

    public static void setStackSize(Item item, int count) {
        ((ItemStackSize) item).setMaxCount(count);
    }
}
