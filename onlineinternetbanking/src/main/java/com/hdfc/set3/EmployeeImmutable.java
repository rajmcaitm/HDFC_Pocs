package com.hdfc.set3;

public final class EmployeeImmutable {
	private final String empName;
	private final int age;
	private final Address address;

	public EmployeeImmutable(String name, int age, Address address) {
	      super();
	      this.empName = name;
	      this.age = age;
	      this.address = address;
	   }

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	@Override
	public String toString() {
		return "EmployeeImmutable [empName=" + empName + ", age=" + age + ", address=" + address + "]";
	}
	
	
}