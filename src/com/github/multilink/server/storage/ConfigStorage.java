package com.github.multilink.server.storage;

import java.util.List;

import com.github.multilink.server.module.Device;

public class ConfigStorage {

	
	
	
	public static long getMaxSessionTime(){
		//todo check
		return Long.MAX_VALUE;
	}

	public static long getInitSessionTime(Device device) {
		return Long.MAX_VALUE;
	}

	public static List<String> getPermission(Device device) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
