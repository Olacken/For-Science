package com.olacken.forscience.api;

import com.olacken.forscience.ForScience;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Extended Player Properties to store actual Tech Advances of the player
 */
public class PlayerSearchProperties implements IExtendedEntityProperties {

    public static String NAME = ForScience.MOD_ID + ":search_properties";

    private HashMap<String, Double> searchTopic;
    private HashMap<String, Double> experiment;

    /**
     * Called when the entity that this class is attached to is saved.
     * Any custom entity data  that needs saving should be saved here.
     *
     * @param compound The compound to save to.
     */
    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound searchProperties = new NBTTagCompound();

        NBTTagCompound searchTopic = new NBTTagCompound();
        for (Map.Entry<String, Double> entry : this.searchTopic.entrySet())
            searchTopic.setDouble(entry.getKey(), entry.getValue());
        searchProperties.setTag("SearchTopic", searchTopic);

        NBTTagCompound experiment = new NBTTagCompound();
        for (Map.Entry<String, Double> entry : this.experiment.entrySet())
            experiment.setDouble(entry.getKey(), entry.getValue());
        searchProperties.setTag("Experiment", experiment);

        compound.setTag(NAME, searchProperties);
    }

    /**
     * Called when the entity that this class is attached to is loaded.
     * In order to hook into this, you will need to subscribe to the EntityConstructing event.
     * Otherwise, you will need to initialize manually.
     *
     * @param compound The compound to load from.
     */
    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound searchProperties = compound.getCompoundTag(NAME);

        NBTTagCompound searchTopic = searchProperties.getCompoundTag("SearchTopic");
        for (Object key : searchTopic.getKeySet())
            this.searchTopic.put((String) key, searchTopic.getDouble((String) key));

        NBTTagCompound experiment = searchProperties.getCompoundTag("Experiment");
        for (Object key : experiment.getKeySet())
            this.experiment.put((String) key, experiment.getDouble((String) key));

    }

    /**
     * Used to initialize the extended properties with the entity that this is attached to, as well
     * as the world object.
     * Called automatically if you register with the EntityConstructing event.
     * May be called multiple times if the extended properties is moved over to a new entity.
     * Such as when a player switches dimension {Minecraft re-creates the player entity}
     *
     * @param entity The entity that this extended properties is attached to
     * @param world  The world in which the entity exists
     */
    @Override
    public void init(Entity entity, World world) {
        this.searchTopic = new HashMap<String, Double>();
        this.searchTopic.put("init", 1.0d);
        this.experiment = new HashMap<String, Double>();
        this.experiment.put("init", 1.0d);
    }


    public void unlockTopic(String topicId) {
        if (!this.searchTopic.containsKey(topicId))
            this.searchTopic.put(topicId, 0.0d);
    }

    public boolean isTopicUnlocked(String topicId) {
        return this.searchTopic.containsKey(topicId);
    }

    public void search(String topicId, double amount) {
        assert this.searchTopic.containsKey(topicId);
        double oldAmount = this.searchTopic.get(topicId);
        this.searchTopic.put(topicId, (1 - oldAmount) * amount + oldAmount);
    }

    public double getSearchAmount(String topicId) {
        Double amount = this.searchTopic.get(topicId);
        if (amount == null)
            return 0.0d;
        else
            return amount;
    }

    public void experiment(String experimentId, double amount) {
        this.experiment.put(experimentId, amount);
    }

    public double getExperimentAmount(String experimentId) {
        Double amount = this.experiment.get(experimentId);
        if (amount == null)
            return 0.0d;
        else
            return amount;

    }
}
