package com.hdfc.test;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap m = new HashMap();
		m.put(100, "Hello");
		m.put(null, "World");
		m.put(101, null);
		m.put(102, null);
		m.put(null, "test");
		System.out.println(m);
	}
}
