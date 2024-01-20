package com.hdfc.test;
// Java program with Optional Class

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {

		String[] words = new String[10];
		
		Optional<String> nullCheck = Optional.ofNullable(words[5]);
		if (nullCheck.isPresent()) {
			System.out.println(words[3].toLowerCase());
		}else {
			System.out.println("words is null");
		}

	}
}