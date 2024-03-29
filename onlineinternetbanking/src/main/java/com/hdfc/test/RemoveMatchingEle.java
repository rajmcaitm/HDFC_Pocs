package com.hdfc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveMatchingEle {

	public static void main(String[] args) {
		int arr1[] = { 5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 5, 4, 1, 2, 3 };
		int match = 5;
		System.out.println(ifElementFound(arr1, match));
		System.out.println(countMatchingEle(arr1, match));
		System.out.println(Arrays.toString(removeMatchingEle(arr1, match)));

	}

	private static boolean ifElementFound(int[] arr1, int match) {

		boolean flag = false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == match) {
				flag = true;
			}
		}
		return flag;
	}

	private static int countMatchingEle(int[] arr1, int match) {
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == match) {
				count++;
			}
		}
		return count;
	}
	
	private static Integer[] removeMatchingEle(int[] arr1, int match) {
		
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != match) {
				set.add(arr1[i]);
			}
		}
		Integer[] array = new Integer[set.size()];
	return set.toArray(array);
	}
	 
}
