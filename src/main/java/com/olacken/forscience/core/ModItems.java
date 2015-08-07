package com.olacken.forscience.core;

import com.olacken.forscience.items.BaseItem;
import com.olacken.forscience.items.TestItem;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Store all the item's mod
 */
public final class ModItems {
    public static BaseItem itemTest;

    public static void init() {
        GameRegistry.registerItem(itemTest = new TestItem("test"), "test");
    }
}
