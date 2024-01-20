package com.hdfc.program1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingArray {

	public static void main(String[] args) {
		
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		List<Integer> streamOfNumbers = Arrays.stream(numbers).sorted().collect(Collectors.toList());
		
		System.err.println(streamOfNumbers);

		
	}
}