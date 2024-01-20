package com.hdfc.program1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayWithTargetSize {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int traget = 3;
		for (int[] subArray : splitArray(arr, traget)) {
			System.out.println(Arrays.toString(subArray));
		}

	}

	public static List<int[]> splitArray(int array[], int target) {

		int chank = array.length / target;
		int remainder = array.length % target;
		int end = 0;
		int start = 0;
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < chank; i++) {
			end += target;
			list.add(Arrays.copyOfRange(array, start, end));
			start = end;

			if (remainder > 0) {
				list.add(Arrays.copyOfRange(array, start, (end + remainder)));
			}
		}

		return list;

	}

}
