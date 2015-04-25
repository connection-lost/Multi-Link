package com.github.multilink.client;

import java.util.Observable;

public class ClientData extends Observable{
	public final String SYS_OS = "os.name";
	
	private ClientData data;
	private Core command;
	private final String OSName;
	
	private ClientData(){
		OSName = System.getProperty(SYS_OS);
		command = new Core(OSName);
	}
	public ClientData getInstance(){
		if (data == null) data = new ClientData();
		return data;
	}
	public void update(){
		setChanged();
		notifyObservers();
	}
}
