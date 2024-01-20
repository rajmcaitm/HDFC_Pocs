package com.tech.prg;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class IncreaseSalary {
	
	final static double INCREMENT_SALARY = 100;

	public static void main(String[] args) {
	
		Employee emp1 = new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);
		Employee emp2 =new Employee(122, "Kaushal Jani", 25, "Male", "Sales And Marketing", 2015, 13500.0);
		Employee emp3 = new Employee(133, "Harshil Nagar", 29, "Male", "Infrastructure", 2012, 18000.0);
		Employee emp4 = new Employee(144, "Raj Darbar", 28, "Male", "Product Development", 2014, 32500.0);
		Employee emp5 = new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0);
		
		Employee emp[] = { emp1, emp2, emp3, emp4, emp5 };
		System.out.println(incrementSalary(emp));
		
	}

	public static Map<String, Double> incrementSalary(Employee emp[]) {
		
		Map<String, Double> incrementSalary = Arrays.stream(emp).map(e -> 
	    {
	        e.setSalary(e.getSalary()+INCREMENT_SALARY);
	          return e;
	      }).collect(Collectors.toMap(Employee::getName, Employee::getSalary));
	
		return incrementSalary;
		
	}

}
