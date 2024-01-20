package com.hdfc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hdfc.set4.RemoveDeblicateEle;

public class RemoveDeblicateEleTest {

	RemoveDeblicateEle ele;
	int[] array;

	@Before
	public void init() {

		ele = new RemoveDeblicateEle();
		array = new int[] { 1, 2, 3, 4, 5, 2, 3, 4 };

	}

	@Test
	public void testGetUniqueElement() {

		// ele.getUniqueEle(array);

		Assert.assertEquals(ele.getUniqueEle(array), ele.getUniqueEle(array));

	}

}
