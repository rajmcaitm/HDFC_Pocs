package com.hdfc.set2;

import java.util.Arrays;

public class CheckStringsAreAnagram {

	public static void main(String[] args) {

		ifTwoStringsAreAnagram("Race", "CarE");

	}

	public static void ifTwoStringsAreAnagram(String str1, String str2) {

		Arrays.sort(str1.toLowerCase().toCharArray());
		Arrays.sort(str2.toLowerCase().toCharArray());

		if (str1.length() == str2.length()) {
			
			System.out.println("Anagram");

		} else {
			System.out.println("Not Anagram");
		}

	}

}