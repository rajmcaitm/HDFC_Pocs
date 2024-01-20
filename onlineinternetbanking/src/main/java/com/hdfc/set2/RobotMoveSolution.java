package com.hdfc.set2;

import java.util.stream.Collectors;

public class RobotMoveSolution {

	public static void main(String[] args) {

		String moves = "l";
		if (validateInput(moves)) {
			System.out.println(new RobotMoveSolution().judgeCircle(moves.toUpperCase()));
		}else {
			System.out.println("Invalid String");
		}
		

	}

	public boolean judgeCircle(String moves) {

		int x = 0;
		int y = 0;
		for (char ch : moves.toCharArray()) {
			if (ch == 'U') {
				y++;
			} else if (ch == 'D') {
				y--;
			}
			if (ch == 'L') {
				x--;
			} else if (ch == 'R') {
				x++;
			}
		}
		return x == 0 && y == 0;
	}
	
	public static boolean validateInput(String input) {

		String cons = "UDLR";
		if (uniqueSortedElement(cons.toUpperCase()).contains(uniqueSortedElement(input.toUpperCase()))) {
			return true;
		} else {
			System.out.println("false condition");
			return false;
		}

	}

	public static String uniqueSortedElement(String str) {

		String string = str.chars().sorted().distinct().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());

		return string;
	}

}
