package com.hdfc.program2;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingBasedOnId {

	public static void main(String[] args) {

		Map<String, Employee> map = new LinkedHashMap<>();

		map.put("java", new Employee(101, "dharm", 25, "male", "it", 2018, 500));
		map.put("pythan", new Employee(105, "dharm", 25, "male", "it", 2018, 500));
		map.put("angular", new Employee(103, "dharm", 25, "male", "it", 2018, 500));
		map.put("react", new Employee(102, "dharm", 25, "male", "it", 2018, 500));
		map.put("css", new Employee(104, "dharm", 25, "male", "it", 2018, 500));

		Collection<Employee> empList = map.values();

		List<Employee> list = empList.stream().sorted(Comparator.comparing(Employee::getId))
				.collect(Collectors.toList());

		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

}
