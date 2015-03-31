package com.github.multilink.server.module;

public class Attribute {

	private String name;
	private int attributeint; // 0
	private double attributedouble; // 1
	private String attributestring; // 2
	private int type;
	
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
		return attributeint;
	}
	public void setInt(int attributeint) {
		this.attributeint = attributeint;
	}
	public double getDouble() {
		return attributedouble;
	}
	public void setDouble(double attributedouble) {
		this.attributedouble = attributedouble;
	}
	public String getString() {
		return attributestring;
	}
	public void setString(String attributestring) {
		this.attributestring = attributestring;
	}
	
	
	
	
}
