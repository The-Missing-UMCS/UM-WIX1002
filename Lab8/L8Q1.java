package com.fyiernzy.Lab8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class L8Q1 {
	public static void main(String[] args) {
		new Number().display();
	}
}

class Number {
	int[] arr;
	
	Number() {
		arr = new Random().ints(10, 0, 100).toArray();
	}
	
	Number(int size) {
		arr = new Random().ints(size, 0, 100).toArray();
	}
	
	Number(int size, int upper){
		arr = new Random().ints(size, 0, upper).toArray();
	}
	
	public void display() {
		System.out.println("Items  : " + Arrays.toString(arr));
		System.out.println("Max    : " + IntStream.of(arr).max().getAsInt());
		System.out.println("Min    : " + IntStream.of(arr).min().getAsInt());
		System.out.println("Averge : " + IntStream.of(arr).average().getAsDouble());
		
		System.out.print("Even   : ");
		IntStream.of(arr).filter(x -> (x % 2 == 0)).forEach(x -> System.out.print(x + " "));
		System.out.println("");
		
		System.out.print("Odd    : ");
		IntStream.of(arr).filter(x -> (x % 2 == 1)).forEach(x -> System.out.print(x + " "));
		System.out.println("");
		
		System.out.print("Square : " );
		IntStream.of(arr).map(x -> x * x).forEach(x -> System.out.print(x + "  "));
		
	}
}
