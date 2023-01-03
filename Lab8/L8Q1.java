package com.fyiernzy.Lab8;

import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;

public class L8Q1 {
	public static void main(String[] args) {
		new Number(10, 100, false).displayAll();
	}
}

class Number {
	int[] arr;
	
	Number() {
		this(10, 100, false);
	}
	
	Number(int size) {
		this(size, 100, false);
	}
	
	Number(int size, int upper){
		this(size, upper, false);
	}
	
	Number(int size, int upper, boolean isDuplicate){
		if (!isDuplicate) {
			var set = new HashSet<Integer>();
			while(set.size() < size) {
				set.add((int)(Math.random() * (upper + 1)));
			}
			arr = set.stream().mapToInt(Integer::intValue).toArray();
		} else {
			arr = new Random().ints(size, 0, upper).toArray();
		}
		Arrays.sort(arr);
	}
	
	Number(int[] arr) {
		this.arr = arr;
		Arrays.sort(arr);
	}
	
	public void displayAll() {
		System.out.println("Items  : " + this);
		System.out.println("Max    : " + getMax());
		System.out.println("Min    : " + getMin());
		System.out.println("Average: " + getAverage());
		
		System.out.print("Even   : ");
		displayEven();
		System.out.println("");
		
		System.out.print("Odd    : ");
		displayOdd();
		System.out.println("");
		
		System.out.print("Square : " );
		displaySquare();
		System.out.println("");
		
		System.out.print("Prime  : " );
		displayPrime();
		System.out.println("");
		
	}
	
	public boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		
		for(int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public boolean isOdd(int n) {
		return (n % 2 == 1);
	}
	
	public boolean isEven(int n) {
		return (n % 2 == 0);
	}
	
	public int getMax() {
		return IntStream.of(arr).max().getAsInt();
	}
	
	public int getMin() {
		return IntStream.of(arr).min().getAsInt();
	}
	
	public double getAverage() {
		return IntStream.of(arr).average().getAsDouble();
	}
	
	public int calcSquare(int n) {
		return n * n;
	}
	
	public void displayArray() {
		System.out.println(Arrays.toString(this.arr));
	}
	
	public void displayPrime() {
		IntStream.of(arr).filter(x -> isPrime(x)).forEach(x -> System.out.print(x + " "));
	}
	
	public void displayOdd() {
		IntStream.of(arr).filter(x -> isOdd(x)).forEach(x -> System.out.print(x + " "));
	}
	
	public void displayEven() {
		IntStream.of(arr).filter(x -> isEven(x)).forEach(x -> System.out.print(x + " "));
	}
	
	public void displaySquare() {
		IntStream.of(arr).map(x -> calcSquare(x)).forEach(x -> System.out.print(x + " "));
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
