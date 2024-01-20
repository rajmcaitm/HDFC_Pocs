package com.hdfc.set2;

import java.util.Arrays;
import java.util.stream.Stream;

public class BoxedArrayToStream {

	public static void main(String args[]) {

		String array[] = { "Geeks", "forGeeks", "A Computer Portal" };
		
		
		System.out.println("Array: " + Arrays.toString(array));

		Stream<String> stream1 = convertArrayToStream(array);
		Stream<String> stream2 = convertArrayToStreamUsingOfMethod(array);
		Stream<String> stream3  = convertArrayToStreamUsingAsListMethod(array);

		System.out.println("Stream using stream method: " + Arrays.toString(stream1.toArray()));
		System.out.println("Stream using stream of method " + Arrays.toString(stream2.toArray()));
		System.out.println("Stream using asList method " + Arrays.toString(stream3.toArray()));
		
	}

	//Generic method, we can pass anytype of array
	private static <T> Stream<T> convertArrayToStream(T[] array) {

		return Arrays.stream(array);
	}
	
	private static <T> Stream<T> convertArrayToStreamUsingOfMethod(T array[]) {
		return Stream.of(array);
	}
	
	private static <T> Stream<T> convertArrayToStreamUsingAsListMethod(T array[]) {
		return Arrays.asList(array).stream();
	}
}
