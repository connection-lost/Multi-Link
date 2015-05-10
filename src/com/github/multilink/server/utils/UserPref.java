package com.github.multilink.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;


public class UserPref{
	private static final String DEFAULT_FILE = "default.properties";
	private static final String FILENAME = "config.properties";
	private InetAddress ip;
	private Properties prop;
	private static UserPref data;
	private UserPref(){
		prop = new Properties();
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String loadingFile = null;
		if (!isFileExists(FILENAME)){
			if (!isFileExists(DEFAULT_FILE)){
				setInit();
			}
			loadingFile = DEFAULT_FILE;
		}else{
			loadingFile = FILENAME;
		}
		try {
			prop.load(new FileInputStream(DEFAULT_FILE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static UserPref getInstance(){
		if (data == null) data = new UserPref();
		return data;
	}
	public Object set(String key, String value){
		return prop.setProperty(key, value);
	}
	public String get(String key){
		return prop.getProperty(key);
	}
	public boolean store(){
		OutputStream out = null;
		boolean pass = true;
		try{
			out = new FileOutputStream(FILENAME);
			prop.store(out, null);
		}catch(IOException e){
			e.printStackTrace();
			pass = false;
		}finally{
			if (out != null){
				try{
				out.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return pass;
	}
	public InetAddress getIP(){ return ip; }
	public static boolean isFileExists(String fileName){
		File f = new File(fileName);
		return f.exists() && !f.isDirectory();
	}
	public static void setInit(){
		if (isFileExists(DEFAULT_FILE)) return;
		Properties p = new Properties();
		OutputStream out = null;
		try{
			p = new Properties();
			out = new FileOutputStream(DEFAULT_FILE);
			p.setProperty(PKey.POOLSIZE, String.valueOf(PValue.POOL_SIZE));
			p.setProperty(PKey.RECIEVE_PORT, String.valueOf(PValue.RECIEVE_PORT));
			p.store(out, null);
		}catch(Exception io){
			io.printStackTrace();
		}finally{
			if (out != null){
				try{
					out.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
				
		}
		System.out.print("finished");
	}
}
