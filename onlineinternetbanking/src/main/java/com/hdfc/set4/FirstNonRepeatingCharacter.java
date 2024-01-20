package com.hdfc.set4;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {

		System.out.println(firstNonRepetedChar("welcomewlcomd"));
	}

	private static char firstNonRepetedChar(String input) {

		char result = 0;
		for (char ch : input.toCharArray()) {
			if (input.indexOf(ch) == input.lastIndexOf(ch)) {
				result = ch;
				break;
			}

		}
		return result;

	}
}
