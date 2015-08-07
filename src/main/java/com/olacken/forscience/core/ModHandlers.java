package com.olacken.forscience.core;

import com.olacken.forscience.handler.EventHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * Class for register off all mod handler
 */
public class ModHandlers {
    public static EventHandler handler;

    public void init() {
        MinecraftForge.EVENT_BUS.register(handler = new EventHandler());
    }
}
