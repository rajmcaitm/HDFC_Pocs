package com.hdfc.test;

// Java code to illustrate
// Fail Safe Iterator in Java
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class FailSafe {
	public static void main(String args[]) {

		Integer array[] = new Integer[] { 1, 3, 5, 8 };
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>(array);

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Integer no = (Integer) itr.next();
			System.out.println(no);
			if (no == 8)

				// This will not print,
				// hence it has created separate copy
				list.add(14);
		}
		// printing the modified list
		System.err.println(list);
	}
}
