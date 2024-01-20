package com.hdfc.set1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddingGraceForEachEle {

	public static void main(String[] args) {

		ArrayList<Integer> marks = new ArrayList<Integer>();

		marks.add(30);
		marks.add(78);
		marks.add(26);
		marks.add(96);
		marks.add(79);

		System.out.println("Marks of students before grace : " + marks);

		List<Integer> updatedMarks = marks.stream().map(ele -> ele + 6).collect(Collectors.toList());

		System.out.println("Marks of students after grace : " + updatedMarks);
		
		List<Integer> doubleMarks = marks.stream().map(ele -> ele*2).collect(Collectors.toList());

		System.out.println("Marks of students after doubling : " + doubleMarks);

	}
}
