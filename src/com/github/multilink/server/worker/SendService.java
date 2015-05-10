package com.github.multilink.server.worker;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.github.multilink.server.utils.PKey;
import com.github.multilink.server.utils.UserPref;

public class SendService {
	private static SendService data;
	private UserPref preference;
	private SendService(){
		preference = UserPref.getInstance();
	}
	public InetAddress getIP(){
		return preference.getIP();
	}
	public int getPort(){
		return Integer.getInteger(preference.get(PKey.RECIEVE_PORT));
	}
	public static SendService getInstance(){
		if (data == null) data = new SendService();
		return data;
	}
	public void send(Message message) throws IOException{
			Socket connection = new Socket(message.getRecieverIP(), message.getRecieverPort());
			OutputStream out = connection.getOutputStream();
			message.send(out);
			out.close();
			connection.close();
	}
	
}
