package com.hdfc.set2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysStream {
	
  public static void main(String[] args) {
	
	  String arr[] = {"Welcome", "to", "persistent"};
	  int arr1[] = { 1, 2, 3, 4, 5 };
	  
	  Stream<String> strStream =Stream.of(arr);
	  IntStream intStream = IntStream.of(arr1);
	  
	  strStream.forEach(test->System.out.print(test+" "));
	 
}

}