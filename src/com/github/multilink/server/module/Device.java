package com.github.multilink.server.module;

import com.github.multilink.server.utils.EtcUtils;

/*
 * Each "Device" class will represent a single connected device
 * All devices will be stored in a master list in SessionStorage.java
 */
public class Device {
	
	private Attribute data;
	private int id;
	private String name;
	private String description = "<not set>";
	
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

	public static Device newDevice(String name){
		Device device = new Device(EtcUtils.random.nextInt(Integer.MAX_VALUE), name);
		return device;
	}

}
