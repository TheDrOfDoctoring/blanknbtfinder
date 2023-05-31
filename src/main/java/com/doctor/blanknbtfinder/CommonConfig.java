package com.doctor.blanknbtfinder;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final ForgeConfigSpec.ConfigValue<String> itemId;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        itemId = COMMON_BUILDER.comment("Set this to the item ID of an item that has this issue, allow the issue to occur and then check the latest.log to see what shows up").define("itemID", "");

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
