package com.hdfc.set2;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlattenStreamTwoListsSameType {

	public static <T> Stream<T> flatten(T[] a, T[] b) {
		Stream<T> stream = Stream.of(a, b).flatMap(Arrays::stream);

		return stream;
	}

	public static void main(String[] args) {

		String[] a = { "A", "B", "C" };

		String[] b = { "i", "J", "K" };

		String[] s = flatten(a, b).toArray(String[]::new);

		System.out.println(Arrays.toString(s));
	}
}
