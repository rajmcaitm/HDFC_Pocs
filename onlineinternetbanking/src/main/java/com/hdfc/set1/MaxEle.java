package com.hdfc.set1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxEle {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		System.out.println(getHigestNumber(numbers));
		System.out.println(getMax(numbers));
		System.out.println(getMaxUsingComparator(numbers));
		System.out.println(getMaxUsingMaptoInt(numbers));
	}

	private static int getHigestNumber(List<Integer> numbers) {

		Collections.sort(numbers);
		return numbers.get(numbers.size() - 1);
	}

	private static int getMax(List<Integer> numbers) {

		int max = numbers.stream().max(Integer::compare).get();
		return max;
	}

	private static int getMaxUsingComparator(List<Integer> numbers) {

		int max3 = numbers.stream().max(Comparator.naturalOrder()).get();
		return max3;
	}

	private static int getMaxUsingMaptoInt(List<Integer> numbers) {

		return numbers.stream().mapToInt(Integer::intValue).max().getAsInt();

	}
}
