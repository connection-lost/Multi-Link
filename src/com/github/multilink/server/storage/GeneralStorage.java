package com.github.multilink.server.storage;

import java.util.ArrayList;
import java.util.List;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.utils.EtcUtils;

public class GeneralStorage {

	public static List<Device> devices = new ArrayList<Device>();
	public static List<Session> sessions = new ArrayList<Session>();
	
	
	
	public static Device newDevice(String name){
		Device device = new Device(EtcUtils.random.nextInt(Integer.MAX_VALUE), name);
		return device;
	}
	
}
