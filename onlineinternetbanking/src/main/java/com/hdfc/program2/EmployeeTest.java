package com.hdfc.program2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		System.out.println("no Of Male And Female Employees" + countMaleAndFemale(employeeList));
		System.out.println("print Dept name "+printAllDeptName(employeeList));
		System.out.println("avg age of male and female employee"+averageAgeOfMaleAndFemale(employeeList));
		System.out.println("Highest paid employee list "+highestPaidEmployeeDetails(employeeList));
		System.out.println("Highest paid employee "+highestPaidEmployeeDetails(employeeList));
		System.out.println("Print emp who joined after 2015 "+printAllEmployeeJoinedAfter2015(employeeList));
		System.out.println("Count emp in all dept "+countEmpInAllDept(employeeList));
		System.out.println("avg Sal Each Dept "+avgSalEachDept(employeeList));
		System.out.println("print All Employee Younger Or Equal To 25 Years "+printAllEmployeeYoungerOrEqualTo25Years(employeeList));
        System.out.println("print All Employee Older Than25 Years "+printAllEmployeeOlderThan25Years(employeeList));
        System.out.println("oldest Emp In The Org "+oldestEmpInTheOrg(employeeList));
        
        
        
        
        
	}

	// How many male and female employees are there in the organization?

	public static Map<String, Long> countMaleAndFemale(List<Employee> employeeList) {

		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		return noOfMaleAndFemaleEmployees;

	}

	// Print the name of all departments in the organization?
	public static List<String> printAllDeptName(List<Employee> employeeList) {

		List<String> nameofAllDepartments = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		return nameofAllDepartments;

	}
	// What is the average age of male and female employees?
	public static Map<String, Double> averageAgeOfMaleAndFemale(List<Employee> employeeList) {

		Map<String, Double> avgAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

		return avgAge;
	}
	
	// Get the details of highest paid employee in the organization?
	
	public static Optional<Employee> highestPaidEmployeeDetails(List<Employee> employeeList) {

		Optional<Employee> highestPaidEmp = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		return highestPaidEmp;

	}
	
	// Get the names of all employees who have joined after 2015?
	
	public static List<String> printAllEmployeeJoinedAfter2015(List<Employee> employeeList) {

		List<String> empNamejoinedAfter = employeeList.stream()
				.filter(after -> after.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());
		return empNamejoinedAfter;

	}
	
	// Count the number of employees in each department?
	
	public static Map<String, Long> countEmpInAllDept(List<Employee> employeeList) {

		Map<String, Long> countEmpInAllDept = employeeList.stream().distinct()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		return countEmpInAllDept;

	}
	
	// What is the average salary of each department?
	
	public static Map<String, Double> avgSalEachDept(List<Employee> employeeList) {

		Map<String, Double> avgSalEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		return avgSalEachDept;

	}
	
	// Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
	
	public static List<String> printAllEmployeeYoungerOrEqualTo25Years(List<Employee> employeeList) {

		List<String> youngerOrEqualTo25Years = employeeList.stream()
				.filter(after -> after.getAge()<= 25).map(Employee::getName).collect(Collectors.toList());
		return youngerOrEqualTo25Years;

	}
	
	public static List<String> printAllEmployeeOlderThan25Years(List<Employee> employeeList) {

		List<String> olderThan25Years = employeeList.stream()
				.filter(after -> after.getAge()> 25).map(Employee::getName).collect(Collectors.toList());
		return olderThan25Years;

	}
	
	//  Who is the oldest employee in the organization? What is his age and which department he belongs to?
	
	public static Optional<Employee> oldestEmpInTheOrg(List<Employee> employeeList) {

		Optional<Employee> oldestEmpInThOrg = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
		return oldestEmpInThOrg;

	}
	

}
