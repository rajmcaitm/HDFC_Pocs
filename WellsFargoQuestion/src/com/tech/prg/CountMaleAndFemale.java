package com.tech.prg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class CountMaleAndFemale {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Kaushal Jani", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Harshil Nagar", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Raj Darbar", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Sid Barot", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Pruthvi Soni", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Parth Dabgar", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Ashish Patel", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Aaalap Patel", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Divyesh Solanki", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Jay Solanki", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Kishan Panchal", 31, "Male", "Product Development", 2012, 35700.0));

		System.out.println(countMaleFemale(employeeList));
		System.out.println(getAllDeptName(employeeList));
		System.out.println(getAvgAgeOfMaleAndFemale(employeeList));
		System.out.println(highestPaidEmployee(employeeList));
		System.out.println(joinedAfterYear(employeeList));
		Set<Entry<String, Long>> entry = employeeCountByDepartment(employeeList).entrySet();

		for (Entry<String, Long> set : entry) {
			System.out.println(set.getKey() + " - " + set.getValue());
		}

		Set<Entry<String, Double>> avgSal = avgSlaryEachDept(employeeList).entrySet();

		for (Entry<String, Double> set : avgSal) {
			System.out.println(set.getKey() + " - " + set.getValue());
		}
		System.out.println(youngestMaleEmpInDept(employeeList));
		System.out.println(mostWorkingExpInOrg(employeeList));
		

	}

	static Map<String, Long> countMaleFemale(List<Employee> employeeList) {

		Map<String, Long> noOfMaleAndFemaleEmp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		return noOfMaleAndFemaleEmp;

	}

	static List<String> getAllDeptName(List<Employee> employeeList) {
		return employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
	}

	static Map<String, Double> getAvgAgeOfMaleAndFemale(List<Employee> employeeList) {

		return employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

	}

	static Employee highestPaidEmployee(List<Employee> employeeList) {
		return employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
	}

	static List<String> joinedAfterYear(List<Employee> employeeList) {
		return employeeList.stream().filter(year -> year.yearOfJoining > 2015).map(Employee::getName)
				.collect(Collectors.toList());
	}

	static Map<String, Long> employeeCountByDepartment(List<Employee> employeeList) {
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	static Map<String, Double> avgSlaryEachDept(List<Employee> employeeList) {
		return employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}
	
	static Employee youngestMaleEmpInDept(List<Employee> employeeList) {

		return employeeList.stream().filter(gender -> gender.getGender().equals("Male"))
				.filter(dept -> dept.getDepartment().equals("Product Development"))
				.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge))).get();
	}
	static Employee mostWorkingExpInOrg(List<Employee> employeeList) {

		return employeeList.stream().sorted((e1, e2) -> e1.getYearOfJoining() - e2.getYearOfJoining()).findFirst().get();
	}
	
	

}
