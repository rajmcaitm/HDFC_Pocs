package com.hdfc.test;

import java.util.Arrays;

public class RemoveDeblicate {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(removeDublicateEle(arr)));
		
	}

	private static int[] removeDublicateEle(int[] arr) {

		return Arrays.stream(arr).distinct().toArray();
	}
}
