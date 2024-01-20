package com.hdfc.set5;

import java.util.Scanner;

public class Sum {

	private int sumOfTwoNo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number");
		int firstNo = sc.nextInt();
		System.out.println("Enter the second number");
		int secondNo = sc.nextInt();
		int result = firstNo + secondNo;
		return result;
	}

	public static void main(String[] args) {
		System.err.println("Sum of two number is :" + new Sum().sumOfTwoNo());
	}

}
