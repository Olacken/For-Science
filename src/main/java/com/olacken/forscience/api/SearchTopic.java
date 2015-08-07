package com.olacken.forscience.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Base class that all search topic need to override
 */
public abstract class SearchTopic {
    /**
     * Name of the topic
     */
    protected String name;
    /**
     * Description of the search topic
     */
    protected String description;
    /**
     * Id of the topic usual syntax is mod_id:lowered_name
     */
    private String id;

    /**
     * @param id Id of the topic usual syntax is mod_id:lowered_name
     */
    public SearchTopic(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Unlock this topic for the desgnated player
     *
     * @param player player who perform the action
     * @return false if the topic was already unlocked
     */
    public boolean unlockTopic(EntityPlayer player) {
        PlayerSearchProperties properties = (PlayerSearchProperties) player.getExtendedProperties(PlayerSearchProperties.NAME);
        if (!properties.isTopicUnlocked(this.id)) {
            properties.unlockTopic(this.id);
            return true;
        } else
            return false;
    }

    /**
     * Search this topic for the specified player fo a certain amount
     * And unlock is dependent
     *
     * @param player player who perform the action
     * @param amount amount of search 0.0d - 1.0d
     * @return true if the search is performed false if the topic isn't already unlocked
     */
    public boolean search(EntityPlayer player, double amount) {
        PlayerSearchProperties properties = (PlayerSearchProperties) player.getExtendedProperties(PlayerSearchProperties.NAME);
        if (!properties.isTopicUnlocked(this.id))
            return false;
        else {
            properties.search(this.id, amount);
            this.unlockTopicDependent(properties.getSearchAmount(this.id));
            return true;
        }

    }

    public double getSearchAmount(EntityPlayer player) {
        PlayerSearchProperties properties = (PlayerSearchProperties) player.getExtendedProperties(PlayerSearchProperties.NAME);
        return properties.getSearchAmount(this.id);
    }

    protected abstract void unlockTopicDependent(double scienceAmount);
}
