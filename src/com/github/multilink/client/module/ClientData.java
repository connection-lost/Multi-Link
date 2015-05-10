package com.github.multilink.client.module;

import java.util.Observable;

import com.github.multilink.client.utils.SYSTEM_POWER_STATUS;
import com.sun.jna.platform.win32.WinBase.MEMORYSTATUSEX;

public class ClientData extends Observable{
	public final String SYS_OS = "os.name";
	
	private static ClientData data;
	private Core command;
	private final String OSName;
	private MEMORYSTATUSEX memory; // It's depreciated to write in this way.
	private SYSTEM_POWER_STATUS battery;
	private ClientData(){
		OSName = System.getProperty(SYS_OS);
		command = new Core(OSName);
	}
	public static ClientData getInstance(){
		if (data == null) data = new ClientData();
		return data;
	}
	public void getMemoryInfo(){
		memory = command.getMemoryInfo();
		notifyDataSetChanged();
	}
	public void getBatteryInfo(){
		battery = command.getDeviceInfo();
		notifyDataSetChanged();
	}
	public MEMORYSTATUSEX getMemory(){
		return memory;
	}
	public SYSTEM_POWER_STATUS getBattery(){
		return battery;
	}
	public void notifyDataSetChanged(){
		setChanged();
		notifyObservers();
	}
}
