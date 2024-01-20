package com.hdfc.set1;

import java.util.stream.IntStream;

public class CountNoDivisibleByTwo {

	public static void main(String[] args) {
		
		var stream = IntStream.range(1, 10);
		var max = stream.filter(number -> number % 2 == 0).filter(no -> no > 4).count();

		System.out.println(max);
	}
}
