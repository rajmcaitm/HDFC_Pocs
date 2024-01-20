package com.hdfc.set1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class HighestRepeated {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 4, 5, 6, 5, 7, 5);

		System.out.println(highestRepeatedNumberFromList(list));
		System.err.println(highestRepeatedCharFromString("dddddddtesteekkkk"));
		System.out.println(highestRepeatedChar("kkdddtesteekkkk"));
		System.out.println(highestRepeatedCharUsingJava8("kkdddtesteekkkk"));
	}

	private static int highestRepeatedNumberFromList(List<Integer> list) {

		int mostRepeated = list.stream()
				.reduce(BinaryOperator
						.maxBy((o1, o2) -> Collections.frequency(list, o1) - Collections.frequency(list, o2)))
				.orElse(null);
		return mostRepeated;

	}
	
	private static char highestRepeatedCharFromString(String S) {

		char[] array = S.toCharArray();
		int count = 1;
		int max = 0;
		char maxChar = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				count++;
			} else {
				if (count > max) {
					max = count;
					maxChar = array[i - 1];
				}
				count = 1;
			}
		}
		if (count > max) {
			max = count;
			maxChar = array[array.length - 1];
		}

		return maxChar;
	}
	
	private static char highestRepeatedChar(String str) {

		int n = str.length();
        char ans = 0;
        int count = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
         
        for(int i = 0; i < n; i++) {
             
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
             
            if(count < mp.get(str.charAt(i))) {
                ans = str.charAt(i);
                count = mp.get(str.charAt(i));
            }
        }
      return ans;
    }
	
	static Character highestRepeatedCharUsingJava8(String input) {
	    return input.chars()
	      .mapToObj(x -> (char) x)
	      .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
	      .entrySet()
	      .stream()
	      .max(Entry.comparingByValue())
	      .get()
	      .getKey();
	}
}