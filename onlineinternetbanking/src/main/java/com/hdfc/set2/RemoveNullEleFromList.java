package com.hdfc.set2;

import java.util.ArrayList;
import java.util.List;

public class RemoveNullEleFromList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add(null);
		list.add("hibernate");
		list.add("java");
		list.add(null);
		System.out.println(removeNullElement(list));
	}

	private static List<String> removeNullElement(List<String> list) {

		List<String> result = new ArrayList<String>();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j) != null) {
				result.add(list.get(j));
			}
		}
		return result;
	}

}
