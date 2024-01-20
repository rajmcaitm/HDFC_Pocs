package com.hdfc.program1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortingNameList {
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("zabra");
		al.add("yellow");
		al.add("mango");
		al.add("ball");
		al.add("apple");
		System.out.println("ArrayList " + "before sorting : " + al);

		List<String> sortedList = al.stream().sorted().collect(Collectors.toList());

		System.out.println("ArrayList after" + " sorting : " + sortedList);
	}

}
