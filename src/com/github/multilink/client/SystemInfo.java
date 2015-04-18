package com.github.multilink.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Sida
 * ISSUE: Java Runtime Doesn't provide a valid way of access the free memory and file space. We need to find another way.
 * Solution: One solution for this question is to use exec("command") to use system terminal to retrieve required data, but it still gets some other issues.
 */
public class SystemInfo {
	private int deviceId;
	
	public static final String openiphoto = "pmset -g batt";
	
	public static void main(String[] args){
		
		if (System.getProperty("os.name").equals("Mac OS X")){
			System.out.println(exec(openiphoto)); // use command line to get battery status. 
		}else{
			// For windows
			Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS(); // use kernel to get battery status (windows)
			Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
			System.out.println(batteryStatus); // Shows result of toString() method.
		}
	}
	// temporarily designed as this
	public static void freeMemory(){
		long availablememory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		// available memory = max memory - allocated memory
		System.out.println("CPU CORES: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Free memory: " + (float)availablememory/1024/1024/1024);
		System.out.println("Free memory2: " + (float)Runtime.getRuntime().freeMemory()/1024/1024/1024);
		System.out.println("Total Memory: " + (float)Runtime.getRuntime().totalMemory()/1024/1024/1024);
		System.out.println("Maximum mem:" + (float)Runtime.getRuntime().maxMemory()/1024/1024/1024);

		   /* Get a list of all filesystem roots on this system */
	    File[] roots = File.listRoots();

	    /* For each filesystem root, print some info */
	    for (File root : roots) {
	      System.out.println("File system root: " + root.getAbsolutePath());
	      System.out.println("Total space (GB): " + (float)root.getTotalSpace()/1024/1024/1024);
	      System.out.println("Free space (GB): " + (float)root.getFreeSpace()/1024/1024/1024);
	      System.out.println("Usable space (GB): " + (float)root.getUsableSpace()/1024/1024/1024);
	    }
	    exec(openiphoto);
	    getSysInfo();
	}
	/**
	 * System.getProperties don't provide battery life or more...
	 */
	public static void getSysInfo(){
		System.out.println(System.getProperties().toString());
	}
	
	/**
	 * execute a command from java ( For Mac OSX, Linux and Windows) try this method to get system information. 
	 * @param command
	 * @return
	 */

	public static String exec(String command) {
		StringBuffer output = new StringBuffer();
 
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return output.toString();
	}
	
	/**
	 * I find that the only way to communicate with system is by JNA or JNI Library. But any way it's non-general solution.
	 * Support Mac OSX, Linux, Windows, requires different codes.
	 */
}
