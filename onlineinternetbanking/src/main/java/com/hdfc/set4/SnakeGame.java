package com.hdfc.set4;

import java.util.Scanner;

public class SnakeGame {
	
	public static void main(String[] args) {
		var num = getSquareNumber();
		System.out.println(num);
	}
	
	

	public static int getSquareNumber() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number");
		int chunk = sc.nextInt();
		
		
		int[] squeare = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		if (chunk ==1 ) {
			return 38;
		}else if (chunk ==10) {
			
		}
		
		return 1;
	
	}

}
