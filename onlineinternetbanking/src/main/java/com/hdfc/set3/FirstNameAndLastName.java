package com.hdfc.set3;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class FirstNameAndLastName {

	public static void main(String[] args) {
		System.err.println(mergeFnameAndLnameUsingLambda("Dharm Raj ", "Chaudhary"));
		System.out.println(mergeFnameAndLname("Dharya ", "Patel"));
	}

	private static String mergeFnameAndLnameUsingLambda(String fName, String lName) {

		BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + str2;

		return concatenate.apply(fName, lName);

	}

	private static String mergeFnameAndLname(String fName, String lName) {

		return Arrays.asList(fName, lName).stream().map(s->s.substring(0).toUpperCase()).collect(Collectors.joining());
	}

}
