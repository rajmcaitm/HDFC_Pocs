package com.hdfc.program1;

import java.util.TreeSet;

class TreeSetSorting {
	
	public static void main(String args[]) {

		TreeSet<String> ts = new TreeSet<String>((o1, o2)->o2.compareTo(o1));
		
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");
		ts.add("F");
		ts.add("G");

		for (String element : ts)
			System.out.println(element + "");

		System.out.println();
	}
}