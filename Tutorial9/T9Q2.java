package com.fyiernzy.Tutorial9;

public class T9Q2 {
	public static void main(String[] args) {
		new Animal(5.2, 2.3, 200).showDetails();
	}
}

class Organism {
	double initialSize;
	double growthRate;
	
	Organism(double initialSize, double growthRate) {
		this.initialSize = initialSize;
		this.growthRate = growthRate;
	}
}

class Animal extends Organism {
	double foodAmount;
	
	Animal(double initialSize, double growthRate, double foodAmount) {
		super(initialSize, growthRate);
		this.foodAmount = foodAmount;
	}
	
	public void showDetails() {
		System.out.printf("Initial Size: %.2f\nGrowth Rate: %.2f\nAmount of food needed: %.2f", 
				this.initialSize, this.growthRate, this.foodAmount);
	}
}