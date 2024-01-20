package com.hdfc.set3;

public class UnCommonElement {

	public static void main(String[] args) {

		int[] a = {27,1,3,0,14,50,1,2,4,100};
		int[] b = {14,0,2,50,3,1,4,1,27};
		
		findMissing(a, b);
	}

	static void findMissing(int a[], int b[]) {

		int j;
		for (int i = 0; i < a.length; i++) {
			for (j = 0; j < b.length; j++)
				if (a[i] == b[j])
					break;

			if (j == b.length)
				System.out.print(a[i] + " ");
		}
	}

}
