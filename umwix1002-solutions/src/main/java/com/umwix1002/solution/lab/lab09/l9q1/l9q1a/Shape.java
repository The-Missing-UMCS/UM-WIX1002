package com.umwix1002.solution.lab.lab09.l9q1.l9q1a;

public abstract class Shape {
	protected final String NAME;
	protected double perimeter;
	protected double area;

	Shape(String name) {
		this.NAME = name;
	}

	public void showDetails() {
		System.out.printf("%-10s: Perimeter = %-7.2f, Area = %-7.2f\n", this.NAME, this.perimeter, this.area);
	}

	abstract void computeAreaAndPerimeter();
}