package com.umwix1002.solution.tutorial.Tutorial10.L10T3;

import java.util.Arrays;

public class Main {
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

