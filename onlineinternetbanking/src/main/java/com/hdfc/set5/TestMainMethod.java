package com.hdfc.set5;

public class TestMainMethod {

	

	public static void main(String test[]) {
		
		test  = new String[5];
		
		for (int i = 0; i < test.length; i++) {
			test[i] = "dharya";
		}
		
		System.err.println(test.length);
		System.setProperty("name", "Dharya");
		System.out.println(System.getProperty("name"));
		

		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
			
		}

	}

}
