package com.github.multilink.server;

import com.github.multilink.server.module.Device;
import com.github.multilink.server.worker.SessionManager;

public class Main {

	public static void main(String args[]){
		System.out.println("yoooooooooo");

		System.out.println("Sida is Cute");
		
		test();
		
		
		
		
		
		
	}
	
	public static void test(){
		Device testdevice = new Device(0, "TestPhone");
		testdevice.setBattery(100);
		
		System.out.println(SessionManager.createSession(testdevice).toString());
		System.out.println(SessionManager.endSession(testdevice));
		System.out.println(SessionManager.endSession(testdevice));
		
		
	}
	
}
