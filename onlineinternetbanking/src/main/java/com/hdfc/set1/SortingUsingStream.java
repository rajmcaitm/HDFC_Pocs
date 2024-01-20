package com.hdfc.set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingUsingStream {

	public static void main(String[] args) {
		List<String> CompanyList = new ArrayList<>();

		CompanyList.add("Google");
		CompanyList.add("Apple");
		CompanyList.add("Microsoft");

		Comparator<String> com = (String o1, String o2) -> o1.compareTo(o2);

		Collections.sort(CompanyList, com);

		for (String name : CompanyList) {

			System.out.println(name);
		}
		
		System.out.println(SortingUsingStream(CompanyList));
	}

	private static List<String> SortingUsingStream(List<String> companyList) {
		
		return companyList.stream().sorted().collect(Collectors.toList());
	}
	
	
}
