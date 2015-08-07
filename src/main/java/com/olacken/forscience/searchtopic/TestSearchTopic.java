package com.olacken.forscience.searchtopic;

import com.olacken.forscience.api.SearchTopic;

/**
 * Class for test search topic system
 */
public class TestSearchTopic extends SearchTopic {
    /**
     * @param id Id of the topic usual syntax is mod_id:lowered_name
     */
    public TestSearchTopic(String id) {
        super(id);
        this.description = "Topic for test of the search topic system";
        this.name = "Test Search";
    }

    @Override
    protected void unlockTopicDependent(double scienceAmount) {

    }
}
