package com.github.multilink.server.module;

import java.util.*;

/*
 * Each "Device" class will represent a single connected device
 * All devices will be stored in a master list in SessionStorage.java
 */
public class Device {
	
	private int id;
	private String name;
	private String description = "<not set>";
	
	private double battery = -1;
	private double hardDisk_max = -1;
	private double hardDisk_now = -1;
	private double ram_max = -1;
	private double ram_now = -1;
	
	private Map<String, Integer> token = new HashMap<String, Integer>();
	
	public Device(int _id, String _name){
		id = _id;
		name = _name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public double getHard_max() {
		return hardDisk_max;
	}

	public void setHard_max(double hard_max) {
		this.hardDisk_max = hard_max;
	}

	public double getHard_now() {
		return hardDisk_now;
	}

	public void setHard_now(double hard_now) {
		this.hardDisk_now = hard_now;
	}

	public double getRam_max() {
		return ram_max;
	}

	public void setRam_max(double ram_max) {
		this.ram_max = ram_max;
	}

	public double getRam_now() {
		return ram_now;
	}

	public void setRam_now(double ram_now) {
		this.ram_now = ram_now;
	}
	
	
	
	

}
