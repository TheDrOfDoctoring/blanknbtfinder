package com.doctor.blanknbtfinder;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BlankNBTFinder.MODID)
public class BlankNBTFinder
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "blanknbtfinder";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public BlankNBTFinder() {
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.COMMON_CONFIG);
    }




}
