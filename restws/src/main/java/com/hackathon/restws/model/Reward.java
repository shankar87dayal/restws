package com.hackathon.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Reward")
public class Reward {
	
	private long id;
	private String name;
	private String reminder;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReminder() {
		return reminder;
	}
	
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
}
