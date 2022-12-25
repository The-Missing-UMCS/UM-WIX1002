package com.fyiernzy.Lab7;

public class Person implements Comparable<Person> {
	String name;
	int age;
	char gender;
	
	Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public int compareTo(Person another) {
		return this.getName().compareTo(another.getName());
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
}