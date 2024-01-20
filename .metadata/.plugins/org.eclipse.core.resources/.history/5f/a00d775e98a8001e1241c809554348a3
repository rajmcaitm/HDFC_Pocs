package com.hdfc.set3;

import java.util.HashSet;
import java.util.Set;

public class CountRepeatedChar {

	public static void main(String[] args) {
		System.out.println(countRepeatedChar("aabcdB"));// 2
		System.err.println(countRepeatedCharUsing8("aabcdB"));
	}

	private static int countRepeatedChar(String string) {

		int count = 0;
		char ch[] = string.toLowerCase().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					count++;
				}
			}
		}
		return count;
	}

	private static int countRepeatedCharUsing8(String input) {

		Set setDuplicated = new HashSet<>();
		Set distinctChars = new HashSet<>();

		for (char ch : input.toLowerCase().toCharArray()) {
			if (distinctChars.add(ch) == false)
				setDuplicated.add(ch);

		}
		return setDuplicated.size();
	}

}
