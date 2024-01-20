package com.hdfc.set3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BreakImmutabality {

	private final int id;

	private final List<String> name;
	
	private BreakImmutabality(int id, List<String> name) {

		
		this.id = id;
		this.name = Collections.unmodifiableList(name);
	}

	public int getId() {
		return id;
	}

	public List<String> getName() {
		return name;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("dharm");

		BreakImmutabality obj = new BreakImmutabality(10, list);
		
		List<String> list1 = obj.getName();
		System.err.println(list1);
		list1.add(0, "Dharm Raj");
		
		System.out.println(list1);

	}
}
