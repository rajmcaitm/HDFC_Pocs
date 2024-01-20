package com.hdfc.set1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateSize {
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"test"));
		list.add(new Employee(1,"test"));
		System.out.println("List size : "+list.size());
		 
		Set<Employee> set = new HashSet<>();
		set.add(new Employee(1,"test"));
		set.add(new Employee(1,"test"));
		System.out.println("Set size : "+set.size());
				
	}

}
