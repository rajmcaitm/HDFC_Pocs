package com.hdfc.program1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		Integer arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int splitSize = 3;
		List<Integer[]> arrayParts = splitArray(arr, splitSize);

		for (Integer[] o : arrayParts) {
			System.out.println(Arrays.toString(o));
		}

	}

	public static List<Integer[]> splitArray(Integer array[], int splitSize) {

		int numberOfArrays = array.length / splitSize;
		int remainder = array.length % splitSize;

		int start = 0;
		int end = 0;

		List<Integer[]> list = new ArrayList<Integer[]>();

		for (int i = 0; i < numberOfArrays; i++) {
			end += splitSize;
			list.add(Arrays.copyOfRange(array, start, end));
			start = end;
		}

		if (remainder > 0) {
			list.add(Arrays.copyOfRange(array, start, (start + remainder)));
		}
		return list;
	}

}
