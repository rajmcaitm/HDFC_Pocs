package com.hdfc.program1;

public class FunctionalInterfaceTest {
	
	  FunctioanlInterface test = (a, b)->{
		int c = a+b;
		return c;
	};

	public static void main(String[] args) {
		System.out.println(new FunctionalInterfaceTest().test.add(5, 5));
	}
}
