package com.hdfc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeList {

	public static void main(String[] args) {
		List<Employees> emp = new ArrayList<>();
		emp.add(new Employees(1, "ram"));
		emp.add(new Employees(2, "shyam"));
		emp.add(new Employees(1, "ram"));
		emp.add(new Employees(2, "shyam"));
		emp.add(new Employees(1, "ram"));

		System.out.println(getEempList(emp));

	}

	public static Set<String> getEempList(List<Employees> empList) {

		Set<String> newList = empList
				.stream()
				.map(Employees::getFirstName)
				.collect(Collectors.toSet());

		return newList;

	}

}
