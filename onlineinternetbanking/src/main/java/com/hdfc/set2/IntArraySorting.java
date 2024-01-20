package com.hdfc.set2;

import java.util.Arrays;

public class IntArraySorting {

	public static void main(String[] args) {

		int array[] = { 1, 3, 4, 7, 3, 2 };
		System.out.println(Arrays.toString(intArraySorting(array)));
		System.err.println(Arrays.toString(sort(array)));

	}

	public static int[] intArraySorting(int arr[]) {

		return Arrays.stream(arr).sorted().toArray();

	}

	public static int[] sort(int[] arr) {
		java.util.Arrays.sort(arr);
		return arr;
	}

}
