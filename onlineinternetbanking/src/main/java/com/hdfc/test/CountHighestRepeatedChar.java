package com.hdfc.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountHighestRepeatedChar {

	public static void main(String[] args) {
		System.out.println(countHigestRepeatedChar("welcomeolwewl"));

	}

	private static Set<Character> countHigestRepeatedChar(String input) {

		Map<Character, Integer> map = new HashMap<>();

		char ch[] = input.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (map.containsKey(ch[i])) {
				map.put(ch[i], map.get(ch[i]) + 1);
			} else {
				map.put(ch[i], 1);
			}
		}

		int maxCount = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
		System.out.println("max char count : " + maxCount);

		return map.keySet().stream().filter(k -> map.get(k) == maxCount).collect(Collectors.toSet());

	}

}
