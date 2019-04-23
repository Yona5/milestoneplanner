package com.milestoneplanner.model;

import java.util.Date;
import java.time.LocalDate;
import lombok.Data;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Milestone {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Milestone.class);

    private String name;
    private String description;
    private Date dueDate;
    private Date completionDate;
    private int id;

    public Milestone(String name, String description, Date dueDate, Date completionDate){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
    }

    public Milestone(String name, String description, Date dueDate, Date completionDate, int id){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
    }

    public Milestone(int id){
        this.id = id;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getId(){
        return this.id;
    }
}
