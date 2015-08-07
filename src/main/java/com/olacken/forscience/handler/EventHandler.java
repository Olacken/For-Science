package com.olacken.forscience.handler;

import com.olacken.forscience.api.PlayerSearchProperties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Class designated to receive and compute event
 */
@SuppressWarnings("unused")
public class EventHandler {
    /**
     * Event handle when an Entity is Constructing
     *
     * @param event info
     */
    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            event.entity.registerExtendedProperties(PlayerSearchProperties.NAME, new PlayerSearchProperties());
        }
    }
}
