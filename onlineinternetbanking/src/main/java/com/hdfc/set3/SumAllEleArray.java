package com.hdfc.set3;

import java.util.Arrays;

public class SumAllEleArray {
	
	public static void main(String[] args) {
		
		int[] arr1 = { 1, 2, 3, 4, 5 };
		
		System.out.println(summingElement(arr1));
		
	}
	
	public static int summingElement(int[] arr) {
		
		return Arrays.stream(arr).sum();
	}

}
