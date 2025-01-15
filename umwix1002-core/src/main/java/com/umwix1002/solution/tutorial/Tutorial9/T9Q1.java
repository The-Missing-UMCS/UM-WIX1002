package com.umwix1002.solution.tutorial.Tutorial9;

public class T9Q1 {
	public static void main(String[] args) {
		System.out.println("Student and Teacher belongs to same class is : " + compare(new Student(), new Teacher()));
		System.out.println("Student is a descendent class of Person is   : " + isClass(new Student()));
	}
	
	public static boolean compare(Student s, Teacher t) {
		return s.getClass().equals(t.getClass());
	}
	
	public static <T> boolean isClass(T obj) {
		return obj instanceof Person;
	}
}

abstract class Person {}
class Student {}
class Teacher {}