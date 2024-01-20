package com.hdfc.set1;
import java.util.List;

class CubeEle {

	public static void findTheCube(List<Integer> intList)
	{

		intList.stream().map(element -> element * element * element).forEach(ele->System.out.print(ele+" "));

		System.out.println(
			"\n\nOutput after distinct() implementation : ");

		intList.stream()
			.distinct()
			.map(element -> element * element * element)
			.forEach(
				element -> System.out.print(element + " "));

		System.out.println(
			"\n\nOutput after sorted() implementation : ");

		intList.stream()
			.distinct()
			.sorted()
			.map(element -> element * element * element)
			.forEach(
				element -> System.out.print(element + " "));

		System.out.println(
			"\n\nOutput after filter() implementation : ");

		intList.stream()
			.distinct()
			.sorted()
			.map(element -> element * element * element)
			.filter(element -> element < 10000)
			.forEach(
				element -> System.out.print(element + " "));
	}

	public static void main(String[] args)
	{

		List<Integer> intList
			= List.of(5, 19, 8, 23, 6, 54, 32, 5, 23);

		findTheCube(intList);
	}
}
