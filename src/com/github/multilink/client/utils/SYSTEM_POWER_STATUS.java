package com.github.multilink.client.utils;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.BYTE;
import com.sun.jna.platform.win32.WinDef.DWORD;

public class SYSTEM_POWER_STATUS extends Structure{
	public  BYTE  ACLineStatus;
	public  BYTE  BatteryFlag;
	public  BYTE  BatteryLifePercent;
	public  BYTE  SystemStatusFlag;
	public  DWORD BatteryLifeTime;
	public  DWORD BatteryFullLifeTime;
	@Override
	protected List<String> getFieldOrder() {
		// TODO Auto-generated method stub
		return Arrays.asList("ACLineStatus","BatteryFlag","BatteryLifePercent","SystemStatusFlag","BatteryLifeTime","BatteryFullLifeTime");
	}
	
}
