package com.github.multilink.server.worker;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.storage.GeneralStorage;
import com.github.multilink.server.storage.Session;

public class SessionManager {

	public static boolean isActive(int deviceid){
		if (Session.hasSession(deviceid)) return true;
		else return false;
	}
	
	public static Session createSession(Device device){
		Session session = Session.newSession(device);
		GeneralStorage.sessions.add(session);
		return session;
	}
	
	public static boolean endSession(Device device){
		for (Session session : GeneralStorage.sessions){
			if (session.getDevice() == device){
				session.kill();
				return true;
			}
		}
		return false;
	}
	
}
