package com.github.multilink.server.storage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.github.multilink.server.module.Device;

public class GeneralStorage {
	/**
	 *  Map<id, item>.
	 */
	private static Map<Integer, Device> devices; // Use map to retrieve item for performance 
	private static Map<Integer, Session> sessions;
	/**
	 * init: prevent NullPointerException when using add or remove
	 */
	private static void init(){
		if (devices == null) devices  = new HashMap<Integer, Device>();
		if (sessions == null) sessions = new HashMap<Integer, Session>();
	}
	// TO be revised for performance reason
	public static Session getSessionByDeviceId(int deviceId){
		init();
		try{
		if (!devices.containsKey(deviceId)){
			throw new GeneralStorageException(GeneralStorageException.DEVICE_MISSING);
		}
		}catch(GeneralStorageException e){
			e.printStackTrace();
			return null;
		}
		for (Session s: sessions.values()){
			if (s.getDeviceId() == deviceId){
				return s;
			}
		}
		return null;
	}
	/*
	private static boolean addToReference(int deviceId, int sessionId){
		if (!reference.containsKey(deviceId)){
			reference.put(deviceId, new HashSet<Integer>(Arrays.asList(sessionId)));
			return true;
		}
		else{
			Set<Integer> s = reference.get(deviceId);
			try{
				if (s == null){
					throw new GeneralStorageException(GeneralStorageException.REFERENCE_NULL);
				}
			}catch(GeneralStorageException e){
				e.printStackTrace();
				return false;
			}
			s.add(sessionId);
			return true;
		}
	}
	*/
	static public class GeneralStorageException extends RuntimeException{
		/**
		 * 
		 */
		private static final long serialVersionUID = 4194477461792773350L;
		public static final String DEVICE_MISSING = "Miss device";
		public static final String REFERENCE_NULL = "Item in Reference is NULL";
		public GeneralStorageException(String args){
			super(args);
		}
	}
	/*
	public static Session getSessionByDevice(int deviceId){
		init();
		return sessions.get(reference.get(deviceId));
	}*/
	public static Device getDevice(int deviceId){
		init();
		return devices.get(deviceId);
	}
	public static Session getSession(int sessionId){
		init();
		return sessions.get(sessionId);
	}
	// add device or remove device
	public static boolean addDevice(Device device){
		init();
		if (device == null || devices.containsKey(device.getId())) return false;
		devices.put(device.getId(), device);
		return true;
	}
	public static boolean removeDevice(Device device){
		init();
		if (device == null) return false;
		Device d = devices.remove(device.getId());
		return (d != null);
	}
	public static boolean removeDevice(int deviceId){
		init();
		Device d = devices.remove(deviceId);
		return (d != null);
	}
	public static boolean addSession(Session session){
		init();
		if (session == null || sessions.containsKey(session.getId())) return false;
		sessions.put(session.getId(), session);
		//addToReference(session.getDeviceId(), session.getId());
		return true;
	}
	public static boolean removeSession(Session session){
		init();
		if (session == null) return false;
		Session s = sessions.remove(session.getId());
		return (s != null);
	}
	public static boolean removeSession(int sessionId){
		init();
		Session s = sessions.remove(sessionId);
		return (s != null);
	}
}
