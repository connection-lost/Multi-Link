package com.github.multilink.server;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.storage.GeneralStorage;
import com.github.multilink.server.storage.Session;
import com.github.multilink.server.worker.SessionManager;

public class Main {

	public static void main(String args[]){
		System.out.println("yoooooooooo");

		System.out.println("Sida is Cute");
		
		test();
		
		
		
		
		
		
	}
	
	public static void test(){
		Device testdevice = Device.newDevice("test");
		Session s = SessionManager.createSession(testdevice);
		System.out.println(SessionManager.endSession(testdevice));
		System.out.println(SessionManager.endSession(testdevice));
		
		
	}
	
}
