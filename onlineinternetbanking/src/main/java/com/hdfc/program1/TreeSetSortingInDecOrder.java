package com.hdfc.program1;

import java.util.TreeSet;

public class TreeSetSortingInDecOrder {
	public static void main(String[] args) {
		TreeSet<Integer> h = new TreeSet<Integer>((o1, o2) -> o1 > o2 ? -1 : o1 < o2 ? 1 : 0);
		h.add(850);
		h.add(235);
		h.add(1080);
		h.add(15);
		h.add(5);
		System.out.println("TreeSet after" + " sorting are: " + h);
	}
}
