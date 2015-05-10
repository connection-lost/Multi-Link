package com.github.multilink.server.worker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class Message {
	private InetAddress sender;
	private int senderPort;
	private InetAddress reciever;
	private int recieverPort;
	private byte[] data;
	private InputStream input;
	private boolean file;
	public Message(InetAddress senderIP, int senderPort, InetAddress recieverIP, int recieverPort){
		this.sender = senderIP; this.reciever = recieverIP; this.senderPort = senderPort; this.recieverPort = recieverPort;
	}
	public void setInputStream(InputStream input){
		this.input = input;
		file = true;
	}
	public void setText(byte[] data){
		this.data = data.clone();
		file = false;
	}
	public void send(OutputStream output){
		if (file){
			sendWithBuffer(output);
		}else{
			sendNoBuffer(output);
		}
	}
	// for sending small bytes
	public void sendNoBuffer(OutputStream output){
		try{
			output.write(data);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	// for sending files
	public void sendWithBuffer(OutputStream output){
		if (input == null) return;
		byte[] buffer = new byte[1024]; // hard coding warning!;
		int i = 0;
		try {
			while ((i = input.read(buffer, 0, 1024)) >= 0){
				output.write(buffer, 0, i);
			}
			output.close();
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getRecieverPort(){
		return recieverPort;
	}
	public InetAddress getRecieverIP(){
		return reciever;
	}
}
