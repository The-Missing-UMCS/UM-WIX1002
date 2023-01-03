package com.fyiernzy.Lab8;

public class L8Q3 {
	public static void main(String[] args) {
		new WeightCalculator(170, 19).displayAll();
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
		return ((height -  100) + (age / 10)) * 0.9;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void displayAge() {
		System.out.printf("Your age is %d.\n", this.age);
	}
	
	public void displayHeight() {
        System.out.printf("Your height is %.2fcm.\n", this.height);
    }
	
	public void displayRecommendedWeight() {
        System.out.printf("Your recommended weight is %.2fkg.\n", getRecWeight());
    }
	
	public void displayAll() {
		displayAge();
		displayHeight();
		displayRecommendedWeight();
	}
}
