package com.olacken.forscience.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Basic class for item
 */
public abstract class BaseItem extends Item {
    public BaseItem(String name) {
        this(name, CreativeTabs.tabMisc);
    }

    public BaseItem(String name, CreativeTabs tab) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(tab);
    }


}
