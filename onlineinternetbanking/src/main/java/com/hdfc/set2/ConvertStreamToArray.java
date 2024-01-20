package com.hdfc.set2;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertStreamToArray {

	public static <T> Object[] convertStreamToArray(Stream<T> stream) {
		return stream.toArray();

	}

	public static <T> Object[] convertStreamToArrayUsingNew(Stream<T> stream) {
		return stream.toArray(Object[]::new);
	}

	private static int[] convertStreamToArrayUsingMapToIntMethod(Stream<Integer> stream3) {

		return stream3.mapToInt(Integer::intValue).toArray();
	}

	public static void main(String args[]) {
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

		Object[] array1 = convertStreamToArray(stream1);
		Object[] array2 = convertStreamToArrayUsingNew(stream2);
		int[] array = convertStreamToArrayUsingMapToIntMethod(stream3);

		System.out.println("Array of Integer from Stream: " + Arrays.toString(array));

		System.out.println("Array from Stream: " + Arrays.toString(array1));
		System.out.println("Array from Stream: " + Arrays.toString(array2));

	}

}
