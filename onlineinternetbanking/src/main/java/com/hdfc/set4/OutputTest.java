package com.hdfc.set4;

import java.util.HashMap;
import java.util.Map;

public class OutputTest {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("A", "Apple");
		map.put("B", "Boy");
		map.put("C", "Cat");
		map.replace("C", "Element");
		
		map.remove("A", "Mango");

		System.out.println(map);
	}
}