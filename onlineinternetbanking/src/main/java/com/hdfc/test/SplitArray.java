package com.hdfc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SplitArray {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int array[] : splitArray(arr, 3)) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static List<int[]> splitArray(int array[], int splitSize) {

		int quotient = array.length / splitSize;
		int remainder = array.length % splitSize;
		List<int[]> list = new ArrayList<int[]>();

		int start = 0;
		int end = 0;

		for (int i = 1; i < quotient; i++) {
			end += quotient;
			list.add(Arrays.copyOfRange(array, start, end));
			start = end;
		}
		if (remainder > 0) {
			list.add(Arrays.copyOfRange(array, start, (end + remainder)));
		}

		return list;

	}

}