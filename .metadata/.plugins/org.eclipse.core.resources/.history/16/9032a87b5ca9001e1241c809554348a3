package com.hdfc.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Delhi", "India");
		map.put("Moscow", "Russia");
		map.put("New York", "USA");

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(map.get(iterator.next()));

			// adding an element to Map exception will be thrown on next call of next()
			// method.
			map.put("Istanbul", "Turkey");
		}
	}
}
