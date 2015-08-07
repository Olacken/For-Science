package com.olacken.forscience.core;

import com.olacken.forscience.ForScience;
import com.olacken.forscience.api.SearchTopic;
import com.olacken.forscience.searchtopic.TestSearchTopic;

public class ModSearchTopic {

    public static SearchTopic testTopic;

    public static void init() {
        testTopic = new TestSearchTopic(ForScience.MOD_ID + ":test");
    }
}
