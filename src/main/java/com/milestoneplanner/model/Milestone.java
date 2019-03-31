package com.milestoneplanner.model;

import lombok.Data;
import lombok.NonNull;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Value
public class Milestone {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Milestone.class);

    private final String milestone;

    public Milestone(String milestone) {
        this.milestone = milestone;
    }
}
