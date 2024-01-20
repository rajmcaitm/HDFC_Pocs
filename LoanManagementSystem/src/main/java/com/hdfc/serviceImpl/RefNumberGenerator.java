package com.hdfc.serviceImpl;

import java.util.Random;

public class RefNumberGenerator {

	    public int generateRefNum() {
	        Random random = new Random();
	        return random.nextInt(50000);
	    }

		public String generateRef() {
			return "REF" + this.generateRefNum();
		}

		
}
