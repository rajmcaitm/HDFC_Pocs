package com.hdfc.set1;
// Java code to demonstrate Iterating in
// the same order via parallelStream

import java.io.*;
import java.util.*;
import java.util.stream.*;

class ParallelStreamWithOrderedIteration {
	
	public static void main(String[] args)
	{
		// create a list
		List<String> list
			= Arrays.asList("Hello ","G", "E", "E", "K", "S!");
		
		// using parallelStream() method for parallel stream
		list.parallelStream().forEachOrdered(System.out::printf);
	}
}
