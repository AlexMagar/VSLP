package controller;

import java.util.ArrayList;

import MyApp.Main;

public class VoiceInputController {
	
	Main main;
	
	ArrayList<String> voice = new ArrayList<String>();
	
	public void addVoice(String key) {
		voice.add(key);
	}
	
	public String getVoice(int key) {
		return voice.get(key);
	}
	
	public boolean removeVoice(String key) {
		if(!voice.remove(key)) {
			System.out.println("voice does not exits");
			return false;
		}else {
			System.out.println("key remove");
			return true;
		}
	}

}
