package com.hdfc.entities;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomLeadIdGenerator implements IdentifierGenerator {

	public int generateLeadId() {
		Random random = new Random();
		return random.nextInt(100000);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return "L" + this.generateLeadId();
	}
}