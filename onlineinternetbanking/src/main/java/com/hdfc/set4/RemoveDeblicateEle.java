package com.hdfc.set4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDeblicateEle {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4, 5, 2, 3, 4 };
		int[] arr2 = { 6, 7, 8, 9, 6, 7 };

		System.out.println(Arrays.toString(getUniqueElement(arr1)));
		System.out.println(getUniqueEle(arr1));
		System.err.println(Arrays.toString(sortedMergeArray(arr1, arr2)));

		System.out.println(secondLargestNumber(arr1));
		System.err.println(secondLargestLogic(arr1));

		checkPolindron("nitin");

	}

	public static int[] getUniqueElement(int arr[]) {

		return Arrays.stream(arr).distinct().toArray();

	}

	public static Set<Integer> getUniqueEle(int arr[]) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set;

	}

	public static int[] sortedMergeArray(int arr1[], int arr2[]) {

		int count = 0;
		int i;

		int[] merge = new int[arr1.length + arr2.length];

		for (i = 0; i < arr1.length; i++) {
			merge[i] = arr1[i];
		}

		count = i;

		for (int j = 0; j < arr2.length; j++) {
			merge[count] = arr2[j];
			count++;
		}

		Arrays.sort(merge);

		return merge;

	}

	public static int secondLargestNumber(int arr[]) {

		return Arrays.stream(arr).sorted().limit(arr.length-2).min().getAsInt();

	}

	public static int secondLargestLogic(int arr[]) {

		int secondMax = 0;
		Arrays.sort(arr);

		secondMax = arr[arr.length - 2];
		return secondMax;

	}

	public static void checkPolindron(String input) {

		String str = "";

		for (char ch : input.toCharArray()) {
			str = str + ch;
		}

		if (input.equals(str)) {
			System.out.println(input + " are palindrom");
		} else {
			System.out.println(input + " are not palindrom");
		}

	}

	static {

		System.out.println("Hello");
	}

}
//get the second highest salary
//select empid from emp order by salary desc limit 1,1; 
