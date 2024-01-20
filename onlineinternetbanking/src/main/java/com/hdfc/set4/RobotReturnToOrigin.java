package com.hdfc.set4;

public class RobotReturnToOrigin {

	public static boolean isRobotReturnToOrigin(String moves) {

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

	public static void main(String[] args) {
		String moves = "UDDULRLR";
		System.out.println(isRobotReturnToOrigin(moves));
	}
}
