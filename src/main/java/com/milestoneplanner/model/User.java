package com.milestoneplanner.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Milestone.class);

    private String fName;
    private String lName;
    private String email;
    private String password;

    public User(String fName, String lName, String email, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public User(String email){
        this.email = email;
    }
    //get first name
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
