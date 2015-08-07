package com.olacken.forscience;

import com.olacken.forscience.core.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Base file of the For Science mod
 */
@Mod(modid = ForScience.MOD_ID)
public class ForScience {

    public static final String MOD_ID = "forscience";

    @Instance
    public static ForScience instance = new ForScience();

    @SidedProxy(clientSide = "com.olacken.forscience.core.ClientProxy", serverSide = "com.olacken.forscience.core.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
