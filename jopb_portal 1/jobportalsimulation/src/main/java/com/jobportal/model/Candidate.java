package com.jobportal.model;

public class Candidate {
	private int id;
	private String name;
	private String password;
	private String qualifications;
	private String skills;
	private int experienceYears;


	public Candidate() {}


	// getters and setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getQualifications() { return qualifications; }
	public void setQualifications(String qualifications) { this.qualifications = qualifications; }
	public String getSkills() { return skills; }
	public void setSkills(String skills) { this.skills = skills; }
	public int getExperienceYears() { return experienceYears; }
	public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
	}

