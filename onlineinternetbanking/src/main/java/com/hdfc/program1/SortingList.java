package com.hdfc.program1;
// Java Program to Illustrate Collection

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortingList {

	
	public static void main(String[] args)
	{
		
		List<String> CompanyList = new ArrayList<>();

		CompanyList.add("Google");
		CompanyList.add("Apple");
		CompanyList.add("Microsoft");

		Comparator<String> com = (str1, str2) ->str1.compareTo(str2);
		Collections.sort(CompanyList, com);

		for (String name : CompanyList) {

			System.out.println(name);
		}
	}
}
