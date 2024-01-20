package com.hdfc.test;

interface Employee {
 int job();
}

public class Test {
	
	public static void main(String[] args) {
		
		Employee emp = (()->{
			return 1;
		});
		
		System.out.println(emp.job());
	}

}
