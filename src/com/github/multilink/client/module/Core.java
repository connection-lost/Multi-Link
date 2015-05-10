package com.github.multilink.client.module;

import com.github.multilink.client.utils.Kernel32;
import com.github.multilink.client.utils.SYSTEM_POWER_STATUS;
import com.github.multilink.client.utils.User32;
import com.sun.jna.Library;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.WinBase.MEMORYSTATUSEX;

// Core class judge the client system type and load the corresponding kernel for that system. One system might have to load multiple libraries.
public class Core {
	public final int MEMORY_INFO = 0;
	public final int BATTERY_INFO = 1;
	private final String os;
	Library kernel32;
	Library user32;
	public Core(String os_name){
		os = os_name;
		load();
	}
	private void load(){
		if (Platform.isWindows()){
			kernel32 = Kernel32.INSTANCE;
			user32 = User32.INSTANCE;
		}else if (Platform.isMac()){
			
		}
	}
	private Library getLib(int type){
		if (Platform.isWindows()){
			switch(type){
			case MEMORY_INFO:
				return kernel32;
			case BATTERY_INFO:
				return kernel32;
			default:
				return null;
			}
		}else{
			return null;
		}
	}
	public String getOS(){
		return os;
	}

	public MEMORYSTATUSEX getMemoryInfo(){
		Kernel32 lib = (Kernel32)getLib(MEMORY_INFO);
		if (lib == null) throw new CoreException(CoreException.NO_LIB, "");
		MEMORYSTATUSEX result = new MEMORYSTATUSEX();
		lib.GlobalMemoryStatusEx(result);
		return result;
	}
	
	public SYSTEM_POWER_STATUS getDeviceInfo(){
		Kernel32 lib = (Kernel32)getLib(BATTERY_INFO);
		if (lib == null) throw new CoreException(CoreException.NO_LIB, "");
		SYSTEM_POWER_STATUS result = new SYSTEM_POWER_STATUS();
		lib.GetSystemPowerStatus(result);
		return result;
	}
	public class CoreException extends RuntimeException{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5361418726107655842L;
		public final static String NO_LIB = "Library not found or unsupported System";
		public CoreException(String arg, String arg2){
			super(arg + ":" + arg2);
		}
		
	}
}
