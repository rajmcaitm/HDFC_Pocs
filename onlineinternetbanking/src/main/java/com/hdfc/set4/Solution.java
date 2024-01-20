package com.hdfc.set4;

class Solution {

	public boolean judgeCircle(String moves) {

		int x = 0;
		int y = 0;

		for (char ch : moves.toCharArray()) {

			switch (ch) {

			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'L':
				x--;
				break;
			case 'R':
				x++;
				break;
			}
		}
        return x == 0 && y == 0;

	}

	public static void main(String[] args) {
		String moves = "left right UP DOWN	";
		System.out.println(new Solution().judgeCircle(moves.toUpperCase()));
	}

}
