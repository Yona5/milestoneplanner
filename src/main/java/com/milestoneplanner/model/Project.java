package com.milestoneplanner.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Project {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Milestone.class);

    private String name;
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
