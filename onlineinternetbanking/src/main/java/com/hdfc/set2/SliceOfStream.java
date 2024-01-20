package com.hdfc.set2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SliceOfStream {

	public static <T> Stream<T> getSliceOfStream(Stream<T> stream, int startIndex, int endIndex) {
		
		return stream.skip(startIndex).limit(endIndex);
	}
	
	public static <T> Stream<T>
    getSliceOfStreamUsingUsingSubList(Stream<T> stream, int startIndex, int endIndex)
    {
        return stream.collect(Collectors.toList()).subList(startIndex, endIndex+1).stream();
            
    }

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i = 11; i <= 20; i++)
			list.add(i);

		Stream<Integer> intStream = list.stream();
		
		List<Integer> list1 = new ArrayList<>();
		for (int i = 11; i <= 20; i++)
			list1.add(i);

		Stream<Integer> intStream1 = list1.stream();

		System.out.println("List: " + list);

		Stream<Integer> sliceOfIntStream = getSliceOfStream(intStream, 1, 8);

		System.out.println("\nSlice of Stream:");
		sliceOfIntStream.forEach(System.out::println);
		System.out.println("\nSlice of Stream using subList method:");
		getSliceOfStreamUsingUsingSubList(intStream1, 1, 8).forEach(System.out::println);
	}
}
