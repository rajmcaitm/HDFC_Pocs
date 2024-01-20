package com.hdfc.set2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConvertMapToStream {

	public static void main(String args[]) {

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "Geeks");
		map.put(2, "forGeeks");
		map.put(3, "A computer Portal");

		System.out.println("Map: " + map);

		System.out.println(Arrays.toString(convertMapToStream(map).toArray()));

		Stream<Integer> streamKeys = convertMapToStreamKey(map);

		System.out.println("Keys: " + Arrays.toString(streamKeys.toArray()));

		Stream<String> mapValues = convertMapToStreamValues(map);

		System.out.println("Values: " + Arrays.toString(mapValues.toArray()));
	}

	public static <k, v> Stream<Map.Entry<k, v>> convertMapToStream(Map<k, v> map) {

		Stream<Map.Entry<k, v>> stream = map.entrySet().stream();
		return stream;

	}

	private static Stream<String> convertMapToStreamValues(Map<Integer, String> map) {

		Stream<String> convertMapToStreamValues = map.values().stream();

		return convertMapToStreamValues;
	}

	private static Stream<Integer> convertMapToStreamKey(Map<Integer, String> map) {

		Stream<Integer> convertMapToStreamKey = map.keySet().stream();

		return convertMapToStreamKey;
	}

}
