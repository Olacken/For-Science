package com.olacken.forscience.client;

import com.olacken.forscience.ForScience;
import com.olacken.forscience.core.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Class designed to register item model
 */
public class ItemsRenderRegister {
    private static RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    public static void init() {
        register(ModItems.itemTest, "test");
    }

    private static void register(Item item, String itemName) {
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(ForScience.MOD_ID + ":" + itemName, "inventory"));
    }
}
