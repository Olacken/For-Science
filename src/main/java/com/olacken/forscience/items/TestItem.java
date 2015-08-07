package com.olacken.forscience.items;

import com.olacken.forscience.api.PlayerSearchProperties;
import com.olacken.forscience.core.ModSearchTopic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * An Item test for developer
 */
public class TestItem extends BaseItem {
    public TestItem(String name, CreativeTabs tab) {
        super(name, tab);
    }

    public TestItem(String name) {
        super(name);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     *
     * @param itemStack reference to the itemStack
     * @param world     reference to the world
     * @param player    reference to the player
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            PlayerSearchProperties properties = (PlayerSearchProperties) player.getExtendedProperties(PlayerSearchProperties.NAME);
            if (properties.getExperimentAmount("test") < 1.0d) {
                ModSearchTopic.testTopic.unlockTopic(player);
                ModSearchTopic.testTopic.search(player, 0.5d);
                player.addChatMessage(new ChatComponentText("Research Completed"));
                properties.experiment("test", 1.0d);
            } else {
                player.addChatMessage(new ChatComponentText("Research Already Completed for this experiment the actual value of science for " + ModSearchTopic.testTopic.getName() + " : " + (new Double(ModSearchTopic.testTopic.getSearchAmount(player))).toString()));
            }
        }

        return super.onItemRightClick(itemStack, world, player);
    }


}
