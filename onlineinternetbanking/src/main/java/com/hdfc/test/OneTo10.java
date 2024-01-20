package com.hdfc.test;

class OneTo10 extends Thread {

	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		OneTo10 test = new OneTo10();
		test.start();
	}
}