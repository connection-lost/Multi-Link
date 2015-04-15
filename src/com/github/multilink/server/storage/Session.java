package com.github.multilink.server.storage;

import java.util.ArrayList;
import java.util.List;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.utils.EtcUtils;
import com.github.multilink.server.utils.TimeUtils;

public class Session {
		
	private int sid; //unique id for session
	private long expire;
	private List<String> permission = new ArrayList<String>();
	
	private Device device;
	private int did; // unique id for device attached to this session.
	
	protected Session(int sid_, long validfor, List<String> permission_, Device device_){
		sid = sid_;
		did = device_.getId();
		//validfor sanity check
		if (validfor > ConfigStorage.getMaxSessionTime()){
			validfor = ConfigStorage.getMaxSessionTime();
		}
		expire = TimeUtils.getCurrentUnix() + validfor;
		permission = permission_;
		device = device_;
	}
	public int getDeviceId(){
		return did;
	}
	public int getId() {
		return sid;
	}

	public long getExpire() {
		return expire;
	}

	public List<String> getPermission() {
		return permission;
	}

	public Device getDevice() {
		return device;
	}
	
	/**
	 * kill(): kill the current session.
	 * 
	 * @returns: true if this session is killed or removed from GeneralStorage, false otherwise
	 * 
	 */
	public boolean kill(){
		return GeneralStorage.removeSession(this);
	}
	
	/**
	 * renew(long): extend expire time for current session.
	 * @param: long validfor, the time length to be extended.
	 * @returns: True if the session is renewable, false otherwise.
	 */
	
	public boolean renew(long validfor){
		//if (permission.contains("multilink.renew")){
			if (validfor > ConfigStorage.getMaxSessionTime()){
				validfor = ConfigStorage.getMaxSessionTime();
			}
			if (validfor > expire - TimeUtils.getCurrentUnix()){
				expire = TimeUtils.getCurrentUnix() + validfor;
			}
			return true;
		//} else {
		//	return false;
		//}
	}

	public static Session newSession(Device device){
		int sid = EtcUtils.random.nextInt(Integer.MAX_VALUE); // Might want to change because 
		long validfor = ConfigStorage.getInitSessionTime(device);
		List<String> permission = ConfigStorage.getPermission(device);
		Session session = new Session(sid, validfor, permission, device);
		return session;
	}
	
	public static boolean hasSession(int deviceId){
		Session s = GeneralStorage.getSessionByDeviceId(deviceId);
		if (s != null) return true;
		return false;
	}
	
}
