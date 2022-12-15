package com.fyiernzy.Lab6;

import java.util.stream.IntStream;

public class L6Q1 {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 20).forEach(x -> System.out.print(triangular(x) + " "));
	}
	
	public static int triangular(int n) {
		if (n <= 1)
			return n;
		else
			return n + triangular(n-1);
	}
}
