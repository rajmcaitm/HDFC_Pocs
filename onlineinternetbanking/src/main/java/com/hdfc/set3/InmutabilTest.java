package com.hdfc.set3;

public class InmutabilTest {

	public static void main(String[] args) throws Exception {
		
		EmployeeImmutable emp = new EmployeeImmutable("Adithya", 34, new Address("Home", "Madhapur", "Hyderabad"));
		
		Address address = emp.getAddress();
		System.out.println(address);
		address.setAddress("Hi-tech City");
		address.setAddressType("Office");
		address.setCity("Hyderabad");
		
		System.err.println(emp.getAddress());
	}
}