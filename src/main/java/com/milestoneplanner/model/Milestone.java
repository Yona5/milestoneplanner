package com.milestoneplanner.model;
import java.util.Date;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Value
public class Milestone {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Milestone.class);

    private String name;
    private String description;
    private Date dueDate;
    private Date completionDate;

    public Milestone(String name, String description, Date dueDdate, Date completionDate){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
    }

    public String getName(){
        return this.name;
    }

//    public void setName(String name) { this.name = name; }

    public String getDescription(){
        return this.description;
    }

//    public void setDescription(String description){
//        this.description = description;
//    }

    public Date getDueDate(){
        return this.dueDate;
    }

//    public void setDueDate(Date dueDate){
//        this.dueDate = dueDate;
//    }

    public Date getCompletionDate(){
        return this.completionDate;
    }
}
