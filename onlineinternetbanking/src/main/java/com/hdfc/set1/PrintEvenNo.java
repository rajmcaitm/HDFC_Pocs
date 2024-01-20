package com.hdfc.set1;

import java.util.List;

public class PrintEvenNo {

	
	public static void main (String[] args) {
	
	List<Integer> intList = List.of(15,20,48,63,49,27,56,32,9);
	
	
	printEvenNumber(intList);
	}


private static void printEvenNumber(List<Integer> intList){
	
		
		System.out.print("\nEven numbers are : ");
		
		
		intList.stream().filter(
		element -> (element%2==0)
		)
		.forEach(
		element -> System.out.print(element+ " ")
		);
		
	}
}
