package com.hdfc.test;

public class FirstRepeatativeChar {

	public static void main(String[] args) {

		System.out.println(firstRepeatativeChar("abdfghabdgklpuhw"));
	}

	private static char firstRepeatativeChar(String str) {

		int n = str.length();
		char ans = ' ';
		int index = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			char temp = str.charAt(i);

			// Checking that character in temp repeats or not by running a for loop
			for (int j = i + 1; j < n; j++) {
				if (str.charAt(j) == temp) {

					// if the index where it repeated is less than the index of the previously
					// repeated character then store this character in ans variable
					// and its index where it repeated in index variable
					if (j < index) {
						index = j;
						ans = str.charAt(j);
					}
				}
			}
		}
		return ans;
	}
}
