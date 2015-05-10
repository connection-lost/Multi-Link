package com.github.multilink.client;

import com.github.multilink.client.module.ClientData;

// test test test
public class Main {
	public static void main(String[] args){
		ClientData client = ClientData.getInstance();
		PureTextView viewer = new PureTextView();
		client.addObserver(viewer);
		client.getMemoryInfo();
	}
}
