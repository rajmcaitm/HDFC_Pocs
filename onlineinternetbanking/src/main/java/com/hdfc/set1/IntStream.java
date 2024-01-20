package com.hdfc.set1;
import java.util.Arrays;

class IntStream {

	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 5 };

		java.util.stream.IntStream stm =Arrays.stream(arr);

		stm.forEach(ele ->System.out.print(ele+" "));
}
}
