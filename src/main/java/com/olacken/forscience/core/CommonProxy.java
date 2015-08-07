package com.olacken.forscience.core;

import com.olacken.forscience.handler.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Proxy class used by both size
 */
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModSearchTopic.init();
    }

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public abstract void postInit(FMLPostInitializationEvent event);
}
