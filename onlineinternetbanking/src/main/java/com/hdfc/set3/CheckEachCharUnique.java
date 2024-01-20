package com.hdfc.set3;

public class CheckEachCharUnique {

	public static void main(String[] args) {

		System.out.println(isUniqueChars("welcom"));
		System.err.println(isUniqueCharsInString("dharmwfga"));
		System.out.println(uniqueCharacters("tes"));

	}

	public static boolean isUniqueChars(String input) {

		 int checker = 0;
	        for (int i = 0; i < input.length(); i++) {
	            int val = input.charAt(i) - 'a';
	            if ((checker & (1 << val)) > 0) {
	                return false;
	            }
	            checker |= (1 << val);
	        }
	        return true;
	    }
	
	public static String isUniqueCharsInString(String input) {

		String message = "";
		 for(char ch : input.toCharArray()) {
			 
			 if(input.indexOf(ch) == input.lastIndexOf(ch)) {
				 message = "Unique String";
			 }else {
				 message = "Not a Unique String";
			}
			 
		 }
		return message;
	
	}	 
	
	 static boolean uniqueCharacters(String str)
	    {
	       
	        for (int i = 0; i < str.length(); i++)
	            for (int j = i + 1; j < str.length(); j++)
	                if (str.charAt(i) == str.charAt(j)) {
	                    return false;
	                }
	        return true;
	    }
	
	public static boolean isUniqueCharsUsingJava8(String input) {
      
		//input.chars()
	        return true;
	    }
	
}
