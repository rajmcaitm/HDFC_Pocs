package com.hdfc.set3;

public class A {

	public void m1(String str) {
		System.out.println("String method called");
	}

	public void m1(Object obj) {
		System.out.println("object method called");
	}

	public void m1(Integer i) {
		System.out.println("Integer method called");
	}

	public static void main(String args[]) {

		A obj = new A();
		 //obj.m1(null);
	}

}