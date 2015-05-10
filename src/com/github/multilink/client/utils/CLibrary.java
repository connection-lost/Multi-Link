package com.github.multilink.client.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLibrary extends Library{
	CLibrary INSTANCE = (CLibrary)Native.loadLibrary("c", CLibrary.class);
	int sysconf(int key);
}
