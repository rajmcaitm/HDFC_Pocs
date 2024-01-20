package com.hdfc.set2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstCharOfEachString {

	public static void main(String[] test) {

		String str[] = { "dharm", "raj", "chaudhary", "dharya", "patel" };

		firstCharOfEachStringArray(str);
	    System.out.println(firstCharOfEachString(str));
		
	}

	private static void firstCharOfEachStringArray(String[] str) {

		Arrays.stream(str).forEach(ele -> System.out.print(ele.charAt(0)+" "));

	}
	
	private static List<Character> firstCharOfEachString(String[] str) {

		List<Character> charSet = Arrays.stream(str)
				.map(test->test.charAt(0))
				.collect(Collectors.toList());
				
		return charSet;
	}

}