package com.hdfc.set3;

import java.util.Arrays;

public class Merge2IntegersArraysAndSort {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 6, 7, 8, 9, 10 };

		System.out.println(Arrays.toString(mergeArray(arr1, arr2)));

	}

	private static int[] mergeArray(int[] arr1, int[] arr2) {

		int i = 0;
		int[] result = new int[arr1.length + arr2.length];
		for (i = 0; i < arr1.length; i++) {
			result[i] = arr1[i];

		}

		for (int j = 0; j < arr2.length; j++) {

			result[i] = arr2[j];
			i++;
		}
		return result;

	}

}
