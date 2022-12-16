package com.fyiernzy.Tutorial8;

public class T8Q1 {
	public static void main(String[] args) {
		Student student = new Student();
		student.setContact("012-345 6789");
		Animal animal = new Animal();
		Animal cat = new Animal();
		Number num_one = new Number(20);
		Number num_two = new Number(40);
	}
}

class Student {
	private String contact;
	
	Student() {
		contact = null;
	}
	
	Student(String contact) {
		this.contact = contact;
	}
	
	public String getContact() {
		return this.contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void showContact() {
		System.out.println("Contact: " + contact);
	}
}

class Animal {
	
}

class Number {
	private final int value;
	
	Number(int value) {
		this.value = value;
	}
}
