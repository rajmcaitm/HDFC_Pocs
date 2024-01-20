package com.hdfc.program2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateCharacters {

	public static final String duplicateChars(String input) {
		Set<Character> set = new HashSet<>();
		String str = "";
		for (int i = 0; i < input.length(); i++) {
			if (set.add(input.charAt(i)) == false) {
				str += input.charAt(i);
			}
		}
		return str;
	}

	public static final String duplicateCharsUsingJava8(String input) {
		String str = "";
		Set<Character> set = new LinkedHashSet<>();
		char ch[] = input.toCharArray();
		for (char key : ch) {

			if (set.add(key)) {

			} else {
				str += "" + key;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String input = "testes";
		System.out.println(duplicateChars(input));
		System.out.println(duplicateCharsUsingJava8(input));

	}
}