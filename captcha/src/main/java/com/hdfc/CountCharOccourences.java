package com.hdfc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountCharOccourences {

	public static void main(String[] args) {

		char arr[] = { 'a', 'b', 'c', 'a', 'd', 'c' }; // o/p{a:2,b:2c:2}
		Map<Character, Integer> countMap = countChar(arr);
		Set<Entry<Character, Integer>> set = countMap.entrySet();
		for (Entry<Character, Integer> entry : set) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("________________________________________________");
		countCharInArray(arr);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}

	public static Map<Character, Integer> countChar(char array[]) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}

		}

		return map;

	}

	public static void countCharInArray(char array[]) {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str = str + array[i];
		}
		Pattern.compile(".").matcher(str).results().map(m -> m.group().toLowerCase())
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " = " + v + " times"));
	}
	
}
