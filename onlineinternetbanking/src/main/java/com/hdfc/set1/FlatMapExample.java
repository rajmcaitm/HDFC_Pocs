package com.hdfc.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		List<List<Integer>> element = new ArrayList<>();

		element.add(Arrays.asList(1, 2));
		element.add(Arrays.asList(3, 4));
		element.add(Arrays.asList(5, 6));
		element.add(Arrays.asList(7, 8));
		element.add(Arrays.asList(9, 10));

		System.out.println("List element are " + element);
		List<Integer> combineList = element.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(combineList);

	}

}
