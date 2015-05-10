package com.github.multilink.server.worker;

import java.net.InetAddress;

import com.github.multilink.server.utils.PKey;
import com.github.multilink.server.utils.UserPref;

// one running server/client has only one accept service.
public class AcceptService {
	private UserPref preference;
	private static AcceptService service;
	private AcceptService(int port){
		preference = UserPref.getInstance(); 
		preference.set(PKey.PORT, String.valueOf(port));
		
	}
}
