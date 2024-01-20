package com.hdfc.set1;

import java.util.stream.Stream;

public class TestFilter {

	public static void main(String[] args) {
		Stream<String> myStream = Stream.of("Like", "and", "Share", "https://www.geeksforgeeks.org/");

		//myStream.filter(start -> start.startsWith("https://")).forEach(System.out::println);
		
		myStream.filter(x -> x.matches("(a|e|i|o|u)\\w*"))
        .forEach(System.out::println);

	}

}
