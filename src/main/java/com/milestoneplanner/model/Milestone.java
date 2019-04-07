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

//    private String name;
//    private String description;
//    private Date dueDate;
//    private final Date completionDate;

    //remove this once  the rest of the code is updated
    private final String milestone;

    // remove this constructor once the rest of the code is updated
    public Milestone(String milestone){this.milestone = milestone;}

//    public Milestone(String name, String description, Date dueDate, Date completionDate) {
//        this.name = name;
//        this.description = description;
//        this.dueDate = dueDate;
//        this.completionDate = completionDate;
//    }
//
//    public String getMilestone() {
//        return milestone;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(Date dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public Date getCompletionDate() {
//        return completionDate;
//    }

}
