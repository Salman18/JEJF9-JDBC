package com.jspider.metaData;

public class Employee {
	int id;
	String name;
	double Salary;
	
	
	public Employee(int id, String name, double salary) {
		
		this.id = id;
		this.name = name;
		this.Salary = salary;
	}
	@Override
	public int hashCode() {
		
		return this.id;
	}
	@Override
	public boolean equals(Object arg) {
		Employee emp=(Employee) arg;
		if (this.hashCode()==emp.hashCode()) {
			return true;
		}else{
			return false;
					
		}
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	}
	
	
	}


