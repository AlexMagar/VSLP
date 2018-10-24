package controller;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import MyApp.Main;
import javafx.scene.input.KeyEvent;

public class KeyInputController extends KeyAdapter{
	
	Main main;
	
	ArrayList<String> input = new ArrayList<String>();
	
	
	public void addKey(String key) {
		input.add(key);
	}
	
	public String getKey(int key) {
		return input.get(key);
	}
	
	public boolean removeKey(String key) {
		if(!input.remove(key)) {
			System.out.println("key doesn't exits");
			return false;
		}else {
			System.out.println("key remove");
			return false;
		}
	}

}
