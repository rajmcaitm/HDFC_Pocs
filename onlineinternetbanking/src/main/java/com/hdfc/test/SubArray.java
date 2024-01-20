package com.hdfc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArray {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 11, 15, -2, -6 };
		int target = 9;
		System.out.println(subArray(arr, target));
		
		System.out.println(Arrays.toString(new SubArray().twoSum(arr, target)));
	}

	public static List<String> subArray(int arr[], int target) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					String s1 = "(" + arr[i] + " , " + arr[j] + ")";
					list.add(s1);
				}
			}

		}
		return list;

	}

	public int[] twoSum(int[] num, int target) {

		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			if (hm.containsKey(target - num[i])) {
				return new int[] { hm.get(target - num[i]), i };

			} else {

				hm.put(num[i], i);
			}
		}
		return null;
	}
}
