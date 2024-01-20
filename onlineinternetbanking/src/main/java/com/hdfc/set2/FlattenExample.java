package com.hdfc.set2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenExample {

	public static void main(String[] args) {
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(6,7,8,9);
		List<Integer> list3 = Arrays.asList(10,11,12,13,14,15);
		map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
		
		List<Integer> list = flatten(map.values()).collect(Collectors.toList());
		System.out.println(list);

	}

	public static <T> Stream<T> flatten(Collection<List<T>> list) {

		return list.stream().flatMap(x->x.stream());

	}

}
