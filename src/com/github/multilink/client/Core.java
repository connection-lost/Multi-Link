package com.github.multilink.client;

import com.sun.jna.Library;

// Core class judge the client system type and load the corresponding kernel for that system. One system might have to load multiple libraries.
public class Core {
	public final String SYS_MAC = "mac";
	public final String SYS_WIN = "win";
	private String os;
	Library kernel32;
	Library user32;
	public Core(String os_name){
		os = os_name;
		load();
	}
	private void load(){
		if (os.indexOf(SYS_WIN) >= 0){
			kernel32 = Kernel32.INSTANCE;
			user32 = User32.INSTANCE;
		}else if (os.indexOf(SYS_WIN) >= 0){
			
		}
	}
	
}
