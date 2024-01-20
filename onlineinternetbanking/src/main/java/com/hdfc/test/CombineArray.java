package com.hdfc.test;

import java.util.Arrays;

public class CombineArray {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3 };
		int arr2[] = { 4, 5 };
		int arr3[] = { 6, 7 };
		System.out.println(Arrays.toString(combineArrays(arr1, arr2, arr3)));
	}

	private static int[] combineArrays(int[] arr1, int[] arr2, int[] arr3) {

		int i, j = 0, k, x;

		int size = arr1.length + arr2.length + arr3.length;
		int combine[] = new int[size];
		for (i = 0; i < arr1.length; i++) {
			combine[i] = arr1[i];

		}

		j = i;

		for (x = 0; x < arr2.length; x++, j++) {
			combine[j] = arr2[x];
			
		}
		k = x+i;

		for (int y = 0; y < arr3.length; y++, k++) {
			combine[k] = arr3[y];

		}
		return combine;
	}

}
