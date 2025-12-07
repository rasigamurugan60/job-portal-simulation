package com.jobportal.model;


import java.sql.Timestamp;


public class Job {
private int id;
private int companyId;
private String title;
private String description;
private String requirements;
private Timestamp postedOn;


public Job() {}
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public int getCompanyId() { return companyId; }
public void setCompanyId(int companyId) { this.companyId = companyId; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public String getRequirements() { return requirements; }
public void setRequirements(String requirements) { this.requirements = requirements; }
public Timestamp getPostedOn() { return postedOn; }
public void setPostedOn(Timestamp postedOn) { this.postedOn = postedOn; }
}

