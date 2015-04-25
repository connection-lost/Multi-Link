package com.github.multilink.client;
import com.sun.jna.Library;
import com.sun.jna.Native;
// User32: for Windows Client, please write all function called in User32 here.
public interface User32 extends Library {
	public Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
	
}
