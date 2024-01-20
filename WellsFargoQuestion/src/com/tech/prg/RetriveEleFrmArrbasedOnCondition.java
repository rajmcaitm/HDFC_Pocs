package com.tech.prg;

public class RetriveEleFrmArrbasedOnCondition {

	public static void main(String[] args) {
		int arr[] = { 7, 4, 5, 6, 3, 2, 1 };
		System.out.println(checkEle(arr));
		System.out.println(returnIndexPosition(arr));
		
	}

	public static String checkEle(int[] arr) {

		int match = 5;
		String found = null;

		for (int i = 0; i < arr.length; i++) {
			if (match == arr[i]) {
				found = "Match found";
				break;
			} else {
				found = "Match not found";
			}
		}

		return found;

	}

	public static int returnIndexPosition(int[] arr) {
		int match = 7;
		int count = -1;
		for (int i = 0; i < arr.length; i++) {

			if (match == arr[i]) {
				count++;
				break;
			} else {
				count++;

			}
		}

		return count;

	}

}
