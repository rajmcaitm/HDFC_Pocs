package com.hdfc.test;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
		System.out.println("Interface1 ");
	}

	@Override
	public void method1(String str) {
		System.out.println("Interface2");
	}

	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
	}
	
	public static void main(String[] args) {
		
	}
	
}