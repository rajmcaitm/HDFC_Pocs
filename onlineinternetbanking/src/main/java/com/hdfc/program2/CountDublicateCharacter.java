package com.hdfc.program2;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountDublicateCharacter {

	public static void main(String[] args) {

		String str = "wwellccomeom";
		System.out.println(countDoublicateChar(str));
	}

	public static Map<Character, Integer> countDoublicateChar(String str) {

		Map<Character, Integer> map = new LinkedHashMap<>();
		char ch[] = str.toCharArray();
		for (char key : ch) {

			if (map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		return map;
	}

}
