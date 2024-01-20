package com.hdfc.program1;
// Java program to demonstrate functional interface

public class FunctionalInterface {
	public static void main(String args[])
	{
		// create anonymous inner class object
		new Thread(()->{
			System.out.println("New Thread Created");
		}).start();
	}
}
