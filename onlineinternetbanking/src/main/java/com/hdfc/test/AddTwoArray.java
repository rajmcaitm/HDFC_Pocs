package com.hdfc.test;

import java.util.Arrays;

public class AddTwoArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 6, 7, 8, 9 };
		//System.out.println(Arrays.toString(addArray(arr1, arr2)));
		
		//infinite for loop
		for (;;) {
			System.out.println("hello");
		}
		
	}

	private static int[] addArray(int[] arr1, int[] arr2) {
		int i, j;
		int size = arr1.length + arr2.length;
		int array[] = new int[size];
		for (i = 0; i < arr1.length; i++) {
			array[i] = arr1[i];
		}

		j = i;

		for (int k = 0; k < arr2.length; k++, j++) {
			array[j] = arr2[k];
		}
		return array;
	}
	
	
}
