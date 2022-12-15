package com.fyiernzy.Lab8;

public class L8Q3 {
	public static void main(String[] args) {
		new WeightCalculator(170, 19).display();
	}
}

class WeightCalculator {
	double height;
	int age;
	
	WeightCalculator(double height, int age){
		this.height = height;
		this.age = age;
	}
	
	public double getRecWeight() {
		return (height -  100 + age / 10) * 0.9;
	}
	
	public void display() {
		System.out.println("Age                : " + age);
		System.out.println("Height             : " + height);
		System.out.printf("Recommended Weight : " + getRecWeight());
	}
}
