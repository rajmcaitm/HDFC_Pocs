package com.hdfc.set4;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Red");
		map.put(103, "Green");
		map.put(102, "Yellow");

		Map<Integer, String> map2 = new HashMap<>();
		map2.put(115, "Brown");
		map2.put(120, "Purple");
		map.putAll(map2);
		System.out.println(map);
	}
}