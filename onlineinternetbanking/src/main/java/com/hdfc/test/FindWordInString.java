package com.hdfc.test;

import java.util.regex.Pattern;

public class FindWordInString {

	public static void main(String[] args) {

		System.out.println(countWord("abcdedfhabcudabc", "abc"));
		System.out.println(countWords("abcdedfhabcudabc", "abc"));
	}

	private static Long countWord(String source, String find) {

		return Pattern.compile(find).matcher(source).results().count();
	}

	private static int countWords(String source, String find) {
		return source.split(find).length;
	}

}