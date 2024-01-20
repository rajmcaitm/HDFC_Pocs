package com.tech.prg;

public class CountRepeatedChar {

	public static void main(String[] args) {
		
		String input = "wwwwwwwwww";
		System.out.println(countChar(input));
	}

	static int countChar(String str) {

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'w') {
				count++;
			}
		}

		return count;

	}

}
