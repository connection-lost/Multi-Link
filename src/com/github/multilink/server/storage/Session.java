package com.github.multilink.server.storage;

import java.util.ArrayList;
import java.util.List;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.utils.TimeUtils;

public class Session {
	
	private static List<Session> sessions = new ArrayList<Session>();
	
	private int sid;
	private long expire;
	private List<String> permission = new ArrayList<String>();
	
	private Device device;
	
	public Session(int sid_, long validfor, List<String> permission_, Device device_){
		sid = sid_;
		//validfor sanity check
		if (validfor > ConfigStorage.getMaxSessionTime()){
			validfor = ConfigStorage.getMaxSessionTime();
		}
		expire = TimeUtils.getCurrentUnix() + validfor;
		permission = permission_;
		device = device_;
	}

	public int getSid() {
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
	
	/**Kill the current session
	 * requires: none
	 * returns: killed or not
	 * 
	 */
	public boolean kill(){
		return sessions.remove(this);
	}
	
	/**renew the current session
	*  requires: How long to renew
	*  returns: If the session is renewable
	*/
	public boolean renew(long validfor){
		if (permission.contains("multilink.renew")){
			if (validfor > ConfigStorage.getMaxSessionTime()){
				validfor = ConfigStorage.getMaxSessionTime();
			}
			if (validfor > expire - TimeUtils.getCurrentUnix()){
				expire = TimeUtils.getCurrentUnix() + validfor;
			}
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean hasSession(int id){
		for (Session session : sessions){
			if (session.device.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	
	
}
