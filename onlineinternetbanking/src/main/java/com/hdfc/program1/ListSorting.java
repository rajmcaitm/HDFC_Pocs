package com.hdfc.program1;

import java.util.ArrayList;
import java.util.Collections;

public class ListSorting {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(205);
		al.add(102);
		al.add(98);
		al.add(275);
		al.add(203);
		System.out.println("ArrayList " + "before sorting : " + al);

		// using lambda expression in place of comparator object
		Collections.sort(al, (o1, o2) -> (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0);

		System.out.println("ArrayList after" + " sorting : " + al);
	}
}
