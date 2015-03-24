package com.github.multilink.server.worker;

import com.github.multilink.server.storage.Session;

public class SessionManager {

	public boolean isActive(int deviceid){
		if (Session.hasSession(deviceid)) return true;
		else return false;
	}
	
	
	
	
	
}
