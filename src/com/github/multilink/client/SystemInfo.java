package com.github.multilink.client;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Sida
 * ISSUE: Java Runtime Doesn't provide a valid way of access the free memory and file space. We need to find another way.
 * Solution: One solution for this question is to use exec("command") to use system terminal to retrieve required data, but it still gets some other issues.
 */
public class SystemInfo {
	private int deviceId;
	public static void main(String[] args){
		freeMemory();
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
	}
}
