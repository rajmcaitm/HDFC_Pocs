package com.hdfc.program1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

	public static void main(String[] args) {

		ArrayList<String> fruit = new ArrayList<>();
		fruit.add("Apple");
		fruit.add("mango");
		fruit.add("pineapple");
		fruit.add("kiwi");
		
		List list = fruit.stream().map(s -> s.concat("_test")).collect(Collectors.toList());
		
		System.out.println(list);
		
		List<Character> fruitList = fruit.stream().map(f -> f.charAt(0)).collect(Collectors.toList());
		
		System.err.println(fruitList);
		
		List<String> removeLastChar = fruit.stream().map(f -> f.substring(0, f.length()-1)).collect(Collectors.toList());
		
		System.out.println(removeLastChar);
		
        List<String> removeFirstChar = fruit.stream().map(f -> f.substring(f.length()-1)).collect(Collectors.toList());
		
		System.out.println(removeFirstChar);
	}
}
