package MyApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Prac {

	public static void main(String[] args) {
		
		int name1[] = {1,2,3,4,5,6,7,8,9};		
		String one = "hello";
		
		HashMap<String, String> name = new HashMap<>();
		name.put("hello","helllll");
		name.put("hi","ljsbrgjs");
		name.put("home","jbsrgjbse");
		
		int num = new Random().nextInt(name1.length);
		
		System.out.println(name1[num]);

	}

}
