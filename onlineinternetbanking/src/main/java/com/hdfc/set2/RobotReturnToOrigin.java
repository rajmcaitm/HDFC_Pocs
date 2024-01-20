package com.hdfc.set2;

import java.util.stream.Collectors;

public class RobotReturnToOrigin {

	public boolean judgeCircle(String moves) {

		if (moves == null || moves.isEmpty()) {

			return false;

		}

		int x = 0;

		int y = 0;

		for (char move : moves.toCharArray()) {

			if (move == 'U') {

				y++;

			} else if (move == 'D') {

				y--;

			} else if (move == 'L') {

				x--;

			} else if (move == 'R') {

				x++;

			}

		}

		return x == 0 && y == 0;

	}

	public static void main(String[] args) {

		RobotReturnToOrigin solution = new RobotReturnToOrigin();

		String move1 = "left";
		if (validateString(move1)) {
			System.out.println(solution.judgeCircle(move1));
		} else {
			System.out.println("Invalid String");
		}
	}

	public static boolean validateString(String str) {

		String cons = "dlru";

		if (cons.toUpperCase().contains(sortAndRemoveDublicate(str.toUpperCase()))) {
			return true;
		} else {
			return false;

		}

	}

	public static String sortAndRemoveDublicate(String str) {
		str = str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
		return str;
	}
}

 