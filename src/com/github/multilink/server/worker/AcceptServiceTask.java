package com.github.multilink.server.worker;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class AcceptServiceTask implements Runnable{
	private final Socket connection;
	public AcceptServiceTask(Socket connection){
		this.connection = connection;
	}
	@Override
	public void run() {
		try {
			InputStream in = connection.getInputStream();
			byte[] section = IOUtils.toByteArray(in);
			JSONObject json = new JSONObject(section);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try{
			connection.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
