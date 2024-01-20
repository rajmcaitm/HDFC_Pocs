package com.hdfc.set2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConvertPrimitiveArrayToStream {

	public static void main(String args[]) {

		// Create an Array
		int[] array = new int[] { 3, 2, 5, 4, 1 };

		// Print the Array
		System.out.println("Array: " + Arrays.toString(array));

		// convert the Array to Stream
		IntStream stream = convertArrayToStream(array);

		// Print the Stream
		System.out.println("Stream: " + Arrays.toString(stream.toArray()));
		
		System.out.println(Arrays.toString(convertArrayToStreamUsingOfMethod(array).toArray()));
	}

	private static IntStream convertArrayToStream(int[] array) {

		return Arrays.stream(array);
	}

	public static IntStream convertArrayToStreamUsingOfMethod(int array[]) {

		return IntStream.of(array);
	}
}
