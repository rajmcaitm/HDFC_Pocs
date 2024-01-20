package com.hdfc.program1;

import java.util.TreeSet;

public class TreeSetStringSortingInDecOrder {
	public static void main(String[] args) {
		TreeSet<String> h = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
		h.add("A");
		h.add("X");
		h.add("Y");
		h.add("Z");
		h.add("B");
		System.out.println("TreeSet after" + " sorting are: " + h);
	}
}