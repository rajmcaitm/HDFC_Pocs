package com.hdfc.set1;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class MapDemo {

	public static void main(String[] args)
	{
		ArrayList<String> fruit = new ArrayList<>();
		fruit.add("Apple");
		fruit.add("mango");
		fruit.add("pineapple");
		fruit.add("kiwi");
		System.out.println("List of fruit-" + fruit);
	
		List list = fruit.stream()
						.map(s -> s.length())
						.collect(Collectors.toList());
		System.out.println("List generated by map-" + list);
	}
}
