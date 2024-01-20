package com.hdfc.set2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertStringIntoMap {

	public static void main(String[] args) {
		String message = "welcome to persistent";
		System.out.println(convertStringIntoMap(message));
		System.out.println(convertStringIntoMapWithputJava8(message));

	}

	private static Map<String, Integer> convertStringIntoMap(String message) {

		return Arrays.stream(message.split(" ")).collect(Collectors.toMap(key -> key, value -> value.length()));
	}
	
	private static Map<String, Integer> convertStringIntoMapWithputJava8(String message) {

		Map<String, Integer> result = new LinkedHashMap<>();
		String[] str = message.split(" ");
		for (int i = 0; i < str.length; i++) {
			result.put(str[i], str[i].length());
		}
		return result;
	}

}