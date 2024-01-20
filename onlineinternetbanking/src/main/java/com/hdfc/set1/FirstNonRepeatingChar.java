package com.hdfc.set1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		System.out.println(firstRepeatingChar("abcdab"));
		System.out.println(firstNonRepeatingChar("hellohe"));
		System.out.println(firstNonRepeatingCharUsingjava8("abcc"));

	}

	private static char firstRepeatingChar(String string) {
		char ch = 0;
		Set<Character> set = new HashSet<>();
		for (int j = 0; j < string.length(); j++) {
			boolean flag = set.add(string.charAt(j));
			if (flag) {
				ch = string.charAt(j);
				break;
			}
		}

		return ch;
	}
	
	private static char firstNonRepeatingChar(String s) {

		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1) {
		        ch =  s.charAt(i);
		        break;
		      }
		    }		return ch;

	}
	
	private static char firstNonRepeatingCharUsingjava8(String s) {

		Map<Character, Integer> map = new HashMap<>();
		for(Character ch : s.toCharArray()) {
			
			map.put(ch,  (map.containsKey(ch) ? map.get(ch)+1 : 1));
		}
		
		return map.entrySet().stream().filter(k -> k.getValue() > 1).findFirst().get().getKey();
	}
}
