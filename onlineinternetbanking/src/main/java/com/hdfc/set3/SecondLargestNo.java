package com.hdfc.set3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SecondLargestNo {

	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("secondLargest :" + secondLargest(array));
		System.err.println("findFirstElement :" + findFirstElement(array));
		System.out.println("findAnyElement :" + findAnyElement(array));
		System.err.println("secondMaxEle :" + secondMaxEle(array));

		Object objArray[] = reverseArray(array);
		int length = objArray.length;
		int intArray[] = new int[length];
		for (int i = 0; i < length; i++) {
			intArray[i] = (int) objArray[i];
		}
		System.out.println("reversed array: " + Arrays.toString(intArray));
	}

	public static int secondLargest(int[] arr) {

		return Arrays.stream(arr).sorted().skip(6).min().getAsInt();
	}

	public static int findFirstElement(int[] arr) {

		return Arrays.stream(arr).findFirst().getAsInt();
	}

	public static int findAnyElement(int[] arr) {

		return Arrays.stream(arr).findAny().getAsInt();
	}

	public static int secondMaxEle(int[] arr) {

		return Arrays.stream(arr).sorted().limit(arr.length -1).max().getAsInt();
	}

	public static Object[] reverseArray(int[] array) {

		Object[] objArray = new Object[array.length];

		for (int i = 0; i < array.length; i++) {
			objArray[i] = (Object) array[i];
		}

		return IntStream.rangeClosed(1, objArray.length).mapToObj(i -> array[objArray.length - i]).toArray();

	}
}