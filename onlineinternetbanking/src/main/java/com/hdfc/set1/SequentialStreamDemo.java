package com.hdfc.set1;
// Java program to understand execution

// of sequential streams

import java.util.Arrays;
import java.util.List;

class SequentialStreamDemo {

	public static void main(String[] args) {
		// create a list
		List<String> list = Arrays.asList("Hello ", "D", "h", "a", "r", "m!");

		// we are using stream() method
		// for sequential stream
		// Iterate and print each element
		// of the stream
		list.stream().forEach(System.out::print);
	}
}
