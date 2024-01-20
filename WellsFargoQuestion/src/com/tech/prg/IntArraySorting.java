package com.tech.prg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntArraySorting {

	public static void main(String[] args) {

		int arr[] = { 7, 4, 5, 6, 3, 2, 1 };
		System.out.println(Arrays.toString(arraySortingASC(arr)));
		System.out.println(Arrays.toString(arraySortingDSC(arr)));
		System.out.println(uniqueCharInString("caudhryzk"));

	}

	public static int[] arraySortingASC(int[] arr) {

		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;

	}

	public static int[] arraySortingDSC(int[] arr) {

		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

				}
			}
		}

		return arr;

	}

	public static boolean uniqueCharInString(String str) {

		boolean flag = false;
		char ch[] = str.toCharArray();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < ch.length; i++) {

			if (set.add(ch[i])) {
				flag = true;
			} else {
				flag = false;
				break;
			}

		}
		return flag;

	}
}
