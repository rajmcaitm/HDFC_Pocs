package com.hdfc.set2;

public class FirstNonRepeatedCharFirst {
	public static void main(String args[]) {

		String input = "teeter";
		System.out.println("First non repeated char : " + firstNonRepeatedChar(input));
		System.out.println("First repeated char : " + firstRepeatedChar(input));
		
	}

	public static char firstNonRepeatedChar(String input) {

		char firstNonRepeatedChar = ' ';
		for (char ch : input.toCharArray()) {
			if (input.indexOf(ch) == input.lastIndexOf(ch)) {
				firstNonRepeatedChar = ch;
				break;
			}
		}
		return firstNonRepeatedChar;
	}
	
	public static char firstRepeatedChar(String input) {

		char firstRepeatedChar = ' ';
		for (char ch : input.toCharArray()) {
			if (input.indexOf(ch) != input.lastIndexOf(ch)) {
				firstRepeatedChar = ch;
				break;
			}
		}
		return firstRepeatedChar;
	}
}
