package com.github.multilink.server.module;

import java.net.InetAddress;

public class Attribute {

	private InetAddress ip;
	private int port;
	
	private String name;
	private int attributeint; // 0
	private double attributedouble; // 1
	private String attributestring; // 2
	private int type;
	
	public Attribute(InetAddress ip, int port){
		this.ip = ip; this.port = port;
	}
	
	public Attribute (String name, int attint){
		this.name = name;
		attributeint = attint;
		type = 0;
	}
	
	public Attribute (String name, double attdbl){
		this.name = name;
		attributedouble = attdbl;
		type = 1;
	}
	
	public Attribute (String name, String attstr){
		this.name = name;
		attributestring = attstr;
		type = 2;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInt() {
		if (type == 0) {
			return attributeint;
		} else {
			return 0;
		}
	}
	public void setInt(int attributeint) {
		this.attributeint = attributeint;
	}
	public double getDouble() {
		if (type == 1) {
			return attributedouble;
		} else {
			return 0;
		}
	}
	public void setDouble(double attributedouble) {
		this.attributedouble = attributedouble;
	}
	public String getString() {
		if (type == 0) {
			return attributestring;
		} else {
			return "";
		}
	}
	public void setString(String attributestring) {
		this.attributestring = attributestring;
	}
	
	
	
	
}
