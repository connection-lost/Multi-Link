package com.github.multilink.server.viewer;

import java.util.Observable;
import java.util.Observer;

import com.github.multilink.server.observable.TextObservable;
import com.github.multilink.server.utils.ConsoleCode;

public class ConsoleObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof TextObservable && arg instanceof ConsoleCode){
			TextObservable m = (TextObservable) o;
			updateThis(m, (ConsoleCode)arg);
		}
	}
	private void updateThis(TextObservable o, ConsoleCode arg){
		
	}
}
