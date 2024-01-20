package com.hdfc.set3;

import java.util.Arrays;

public class TwoMainMethod {
	
	public static void main(String... test) {
		
		String s[] = {"Welcome"};
		main(s, 12);
		main(s, "Welcome");
		main("test");
	}
	
	public static void main(String[] args, int num) {
		
		System.out.println(Arrays.toString(args)+" "+num);
		
	}
	
	public static void main(String[] args, String str) {
		System.out.println(Arrays.toString(args)+str);
	}
	
	public static void main(String input) {
		System.out.println(input);
	}

}
