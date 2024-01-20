package com.hdfc.set4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharOccourences {

	public static void main(String[] args) {

		System.out.println(countChar("welcome"));
		System.out.println(countCharUsingStream("welcome"));
		System.err.println(countCharUsingjava8("wwellccomeom"));
	}

	public static Map<Character, Integer> countChar(String str) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}

		return map;

	}

	public static Map<String, Long> countCharUsingStream(String str) {

		Map<String, Long> charCount = str.codePoints().mapToObj(Character::toString)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return charCount;
	}
	
	public static Map<Character, Long> countCharUsingjava8(String str) {
		return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
	}
	
}