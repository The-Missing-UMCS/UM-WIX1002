package com.umwix1002.solution.lab.lab09.l9q1.l9q1a;

public class Rectangle extends Shape {
	private double length;
	private double height;

	Rectangle(double length, double height) {
		super("Rectangle");
		this.length = length;
		this.height = height;
	}

	@Override
	public void computeAreaAndPerimeter() {
		this.area = length * height;
		this.perimeter = 2 * (length + height);
	}

	public void setLengthAndHeight(double length, double height) {
		this.length = length;
		this.height = height;
        computeAreaAndPerimeter();
	}
}
