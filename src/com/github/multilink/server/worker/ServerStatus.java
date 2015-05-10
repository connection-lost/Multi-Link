package com.github.multilink.server.worker;

import java.net.InetAddress;
import java.util.Map;

// Server status stores the ip address of the server and available port of the server. 
public class ServerStatus {
	// port can be used as output port, input port or pool port.
	public static final int POOL = 0;
	public static final int OUTPUT = 1;
	public static final int INPUT = 2;
	private InetAddress ip;
	private Map<Integer, Integer> portStatus;
	private static ServerStatus data;
	private ServerStatus(InetAddress ip, int[] ports){
		this.ip = ip; 
		for (int i : ports){
			portStatus.put(i, 0);
		}
	}
	public int getPortType(int i){
		return portStatus.get(i);
	}
	public int getIdlePort(){
		for (int i : portStatus.keySet()){
			if (getPortType(i) == POOL){
				return i;
			}
		}
		return -1;
	}
	
}
