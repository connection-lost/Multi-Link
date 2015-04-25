package com.github.multilink.client;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinBase.MEMORYSTATUSEX;

// Kernel32: Please Write all Kernel32 functions used in Windows client HERE
public interface Kernel32 extends Library {
	public Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
	public boolean GlobalMemoryStatusEx(MEMORYSTATUSEX result);
}