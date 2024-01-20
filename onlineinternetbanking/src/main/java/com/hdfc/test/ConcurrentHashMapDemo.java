package com.hdfc.test;

//Java Program to illustrate HashMap behaviour
import java.util.concurrent.*;

class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentHashMap m = new ConcurrentHashMap();
		m.put(100, "Hello");
		m.put(101, "Geeks");
		m.put(102, "Geeks");
		m.put(103, null);
		System.out.println(m);
	}
}
