package com.hdfc.program1;

public class CreateThreadUsingLambda {

	public static void main(String[] args) {

		Runnable r = () -> {
			System.out.println("Thread is running");
		};

		Thread obj = new Thread(r);

		obj.start();
	}

}
