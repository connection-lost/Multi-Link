package com.github.multilink.server.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


public class UserPref{
	private static final String fileName = "config.properties";
	private Properties prop;
	private static UserPref data;
	private UserPref(){
		// check if file exists; if not, set prop to default values; else load the prop
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
	public static void main(String[] args){
		Properties p = new Properties();
		OutputStream out = null;
		try{
			p = new Properties();
			out = new FileOutputStream("config.properties");
			p.setProperty("port", "9090");
			p.setProperty("poolsize", "10");
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
