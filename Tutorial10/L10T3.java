package com.fyiernzy.Tutorial10;

import java.util.Arrays;

public class L10T3 {
	public static void main(String[] args) {
		Person[] arr = new Person[5];
		arr[0] = new Person("Ali");
		arr[1] = new Person("Cheng");
		arr[2] = new Person("Elvis");
		arr[3] = new Person("Dusun");
		arr[4] = new Person("Bazil");
		System.out.println("Arrays before: " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Arrays after: " + Arrays.toString(arr));
	}
}

class Person implements Comparable<Person> {
	private final String NAME;
	
	Person(String name) {
		this.NAME = name;
	}
	
	public String getName() {
		return this.NAME;
	}
	
	@Override
	public int compareTo(Person another) {
		return (this.getName().compareTo(another.getName()));
	}
	
	@Override
	public String toString() {
		return this.NAME;
	}
}