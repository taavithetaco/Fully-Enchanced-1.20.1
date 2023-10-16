package net.taavi.fullyenchanced;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = FullyEnchanced.MOD_ID)
public class ClothConfig implements ConfigData {


    //server

    public int potion_stack_size = 16;
    public int splash_potion_stack_size = 16;
    public int lingering_potion_stack_size = 16;

    public int potion_throw_cooldown = 30;

}
