package com.github.multilink.server.worker;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.multilink.server.utils.PKey;
import com.github.multilink.server.utils.UserPref;

/**
 * <b> AcceptService </b> is a service running on server to listen incoming connection
 * , and deal with the connection using ExecutorService.
 * @author KeyboardNerd
 * 
 */
public class AcceptService {
	private UserPref preference;
	private boolean running;
	private static AcceptService service;
	private AcceptService(){
		preference = UserPref.getInstance(); 
	}
	public static AcceptService getInstance(){
		if (service == null) service = new AcceptService();
		return service;
	}
	public InetAddress getIP(){
		return preference.getIP();
	}
	public int getPort(){
		return Integer.getInteger(preference.get(PKey.RECIEVE_PORT));
	}
	public int getPoolSize(){
		return Integer.getInteger(preference.get(PKey.POOLSIZE));
	}
	public void close(){ running = false; }
	public boolean isRunning(){ return running; }
	public void listen(){
		running = true;
		InetAddress ip = preference.getIP();
		System.out.println("Start Listening:\n current IP is - " + ip.toString()
				+ "\n current server is on port - "
				+ preference.get(PKey.RECIEVE_PORT)
				+ "\n number of threads in pool - "
				+ preference.get(PKey.POOLSIZE));
		final ExecutorService acceptThread = Executors.newFixedThreadPool(getPort());
		Runnable listenTask = new Runnable(){
			@Override
			public void run() {
				ServerSocket server;
				try{
					server = new ServerSocket(getPort());
					do{
						Socket connection = server.accept();
						System.out.println("Get a client with IP: " + connection.getInetAddress().toString());
						acceptThread.submit(new AcceptServiceTask(connection));
					}while(isRunning());
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
			
		};
		Thread listenThread = new Thread(listenTask);
		listenThread.start();
	}
}
